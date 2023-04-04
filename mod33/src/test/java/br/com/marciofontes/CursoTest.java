package br.com.marciofontes;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.marciofontes.dao.CursoDAO;

/**
 * @author Márcio Fontes
 *
 */
public class CursoTest {

	private CursoDAO dao = new CursoDAO();

	@Test
	public void cadastrar() {

		Curso curso = new Curso();
		curso.setCodigo("A1");
		curso.setDescricao("Curso teste");
		curso.setNome("Curso de Java");

		dao.abritTransacao();
		dao.incluir(curso);
		dao.fecharTransacao();

		assertNotNull(curso);
		assertNotNull(curso.getId());

		dao.excluir(curso);
		dao.fechar();

	}

	@Test
	public void consultarTodosCursos() {

		Curso curso = new Curso();
		curso.setCodigo("A2");
		curso.setDescricao("Curso teste");
		curso.setNome("Curso de Java");

		Curso curso2 = new Curso();
		curso2.setCodigo("A3");
		curso2.setDescricao("Curso teste");
		curso2.setNome("Curso de PHP");
		
		List<Curso> lista = new ArrayList<>();
		lista.add(curso);
		lista.add(curso2);
		
		dao.abritTransacao();
		dao.incluir(curso);
		dao.incluir(curso2);
		dao.fecharTransacao();

		List<Curso> cursosBanco = dao.obterTodos();

		Assert.assertTrue(lista.containsAll(cursosBanco) && cursosBanco.containsAll(lista));
		
		dao.excluir(curso);
		dao.excluir(curso2);
		dao.fechar();

	}
	
	@Test
	public void altararCurso() {
		
		Curso curso = new Curso();
		curso.setCodigo("A4");
		curso.setDescricao("Curso teste");
		curso.setNome("Curso de Java");
		
		dao.abritTransacao();
		dao.incluir(curso);
		dao.fecharTransacao();
		
		assertNotNull(curso);
		assertNotNull(curso.getId());
		
		curso.setNome("Curso de Rubi");
		dao.alterar(curso);
		
		assertEquals(curso.getNome(),"Curso de Rubi");
		
		dao.excluir(curso);
		dao.fechar();
					
	}

}
