package br.com.marciofontes;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.marciofontes.dao.MatriculaDAO;

/**
 * @author Márcio Fontes
 *
 */
public class MatriculaTest {

	private MatriculaDAO dao = new MatriculaDAO();

	@Test
	public void cadastrar() {

		Matricula matricula = new Matricula();
		matricula.setCodigo("A!");
		matricula.setDataMatricula(Instant.now());
		matricula.setStatus("Ativa");
		matricula.setValor(2000D);

		dao.abritTransacao();
		dao.incluir(matricula);
		dao.fecharTransacao();

		assertNotNull(matricula);
		assertNotNull(matricula.getId());

		dao.excluir(matricula);
		dao.fechar();

	}

	@Test
	public void consultarTodasMatriculas() {

		Matricula matricula = new Matricula();
		matricula.setCodigo("A2");
		matricula.setDataMatricula(Instant.now());
		matricula.setStatus("Ativa");
		matricula.setValor(2000D);

		Matricula matricula2 = new Matricula();
		matricula2.setCodigo("A3");
		matricula2.setDataMatricula(Instant.now());
		matricula2.setStatus("Ativa");
		matricula2.setValor(2500D);

		List<Matricula> listaMatricula = new ArrayList<>();
		listaMatricula.add(matricula);
		listaMatricula.add(matricula2);

		dao.abritTransacao();
		dao.incluir(matricula);
		dao.incluir(matricula2);
		dao.fecharTransacao();

		List<Matricula> matriculasBanco = dao.obterTodos();

		Assert.assertTrue(listaMatricula.containsAll(matriculasBanco) && matriculasBanco.containsAll(listaMatricula));

		dao.excluir(matricula);
		dao.excluir(matricula2);
		dao.fechar();

	}
	
	@Test
	public void altararMatricula() {
		
		Matricula matricula = new Matricula();
		matricula.setCodigo("A4");
		matricula.setDataMatricula(Instant.now());
		matricula.setStatus("Ativa");
		matricula.setValor(2000D);

		dao.abritTransacao();
		dao.incluir(matricula);
		dao.fecharTransacao();

		assertNotNull(matricula);
		assertNotNull(matricula.getId());
		
		matricula.setValor(3200D);
		dao.alterar(matricula);
		
		assertEquals(matricula.getValor(),3200D);
		
		dao.excluir(matricula);
		dao.fechar();
					
	}

}
