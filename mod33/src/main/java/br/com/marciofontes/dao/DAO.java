/**
 * 
 */
package br.com.marciofontes.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * @author Márcio Fontes
 *
 */
public class DAO<E> {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("Projeto_Mod32");
		} catch (Exception e) {

		}
	}

	public DAO() {
		this(null);
	}

	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}

	public DAO<E> abritTransacao() {
		em.getTransaction().begin();
		return this;
	}

	public DAO<E> fecharTransacao() {
		em.getTransaction().commit();
		return this;
	}

	public DAO<E> incluir(E entidade) {
		em.persist(entidade);
		return this;
	}

	public void excluir(E entidade) {
		if (entidade == null) {
			throw new IllegalArgumentException("Entidade nula");
		}

		em.getTransaction().begin();
		em.remove(em.contains(entidade) ? entidade : em.merge(entidade));
		em.getTransaction().commit();
	}

	public List<E> obterTodos() {
		return this.obterTodos(10, 0);
	}

	public List<E> obterTodos(int qtde, int deslocamento) {
		if (classe == null) {
			throw new UnsupportedOperationException("Classe nula");
		}

		String jpql = "select e from " + classe.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, classe);
		query.setMaxResults(qtde);
		query.setFirstResult(deslocamento);

		return query.getResultList();
	}

	public E obterPorID(Object id) {
		return em.find(classe, id);
	}
	
	public DAO<E> alterar(E entidade) {
		if (entidade == null) {
			throw new IllegalArgumentException("Entidade nula");
		}

		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
		
		return this;
	}

	public void fechar() {
		em.close();
	}

}