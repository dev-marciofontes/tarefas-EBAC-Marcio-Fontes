package br.com.marciofontes.services;

import java.io.Serializable;
import java.util.Collection;

import br.com.marciofontes.dao.Persistente;
import br.com.marciofontes.exception.DAOException;
import br.com.marciofontes.exception.MaisDeUmRegistroException;
import br.com.marciofontes.exception.TableException;
import br.com.marciofontes.exception.TipoChaveNaoEncontradaException;

public interface IGenericService<T extends Persistente, E extends Serializable> {

	public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

	public void excluir(T entity) throws DAOException;

	public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

	public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException;

	public Collection<T> buscarTodos() throws DAOException;

}
