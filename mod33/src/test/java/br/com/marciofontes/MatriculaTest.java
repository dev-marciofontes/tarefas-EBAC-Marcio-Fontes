package br.com.marciofontes;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.marciofontes.dao.AlunoDAO;
import br.com.marciofontes.dao.ComputadorDAO;
import br.com.marciofontes.dao.CursoDAO;
import br.com.marciofontes.dao.MatriculaDAO;

/**
 * @author Márcio Fontes
 *
 */
public class MatriculaTest {

	private MatriculaDAO daoMatricula = new MatriculaDAO();
	private CursoDAO daoCurso = new CursoDAO();
	private AlunoDAO daoAluno = new AlunoDAO();
	private ComputadorDAO daoComputador = new ComputadorDAO();

	@Test
	public void cadastrar() {

		Curso curso = new Curso();
		curso.setCodigo("A1");
		curso.setDescricao("Curso teste");
		curso.setNome("Curso de Java");

		daoCurso.abritTransacao();
		daoCurso.incluir(curso);
		daoCurso.fecharTransacao();
		
		Computador computador = new Computador();
		computador.setCodigo("PC1");
		computador.setDescricao("Notebook Intel - N1");
		
		Computador computador2 = new Computador();
		computador2.setCodigo("PC2");
		computador2.setDescricao("Notebook Intel - N2");

		Aluno aluno = new Aluno();
		aluno.setCodigo("AL1");
		aluno.setNome("Alfredo Henrique");
		aluno.add(computador);
		aluno.add(computador2);

		daoAluno.abritTransacao();
		daoAluno.incluir(aluno);
		daoAluno.fecharTransacao();
		

		Matricula matricula = new Matricula();
		matricula.setCodigo("A!");
		matricula.setDataMatricula(Instant.now());
		matricula.setStatus("Ativa");
		matricula.setValor(2000D);
		matricula.setCurso(curso);
		matricula.setAluno(aluno);

		daoMatricula.abritTransacao();
		daoMatricula.incluir(matricula);
		daoMatricula.fecharTransacao();

		assertNotNull(matricula);
		assertNotNull(matricula.getId());
		
		Matricula matBD = daoMatricula.obterPorID(matricula.getId());
		assertNotNull(matBD);
		assertEquals(matricula.getId(), matBD.getId());

		daoMatricula.excluir(matricula);
		daoAluno.excluir(aluno);
		daoComputador.excluir(computador);
		daoCurso.excluir(curso);
		daoMatricula.fechar();
		daoAluno.fechar();
		daoCurso.fechar();

	}

	@Test
	public void consultarTodasMatriculas() {

		Curso curso = new Curso();
		curso.setCodigo("A2");
		curso.setDescricao("Curso teste");
		curso.setNome("Curso de Java");

		Curso curso2 = new Curso();
		curso2.setCodigo("A3");
		curso2.setDescricao("Curso teste");
		curso2.setNome("Curso de PHP");

		daoCurso.abritTransacao();
		daoCurso.incluir(curso);
		daoCurso.incluir(curso2);
		daoCurso.fecharTransacao();

		Aluno aluno = new Aluno();
		aluno.setCodigo("AL2");
		aluno.setNome("Pedro Henrique");

		Aluno aluno2 = new Aluno();
		aluno2.setCodigo("AL3");
		aluno2.setNome("Maria marte");

		daoAluno.abritTransacao();
		daoAluno.incluir(aluno);
		daoAluno.incluir(aluno2);
		daoAluno.fecharTransacao();

		Matricula matricula = new Matricula();
		matricula.setCodigo("A2");
		matricula.setDataMatricula(Instant.now());
		matricula.setStatus("Ativa");
		matricula.setValor(2000D);
		matricula.setCurso(curso);
		matricula.setAluno(aluno);

		Matricula matricula2 = new Matricula();
		matricula2.setCodigo("A3");
		matricula2.setDataMatricula(Instant.now());
		matricula2.setStatus("Ativa");
		matricula2.setValor(2500D);
		matricula2.setCurso(curso2);
		matricula2.setAluno(aluno2);

		List<Matricula> listaMatricula = new ArrayList<>();
		listaMatricula.add(matricula);
		listaMatricula.add(matricula2);

		daoMatricula.abritTransacao();
		daoMatricula.incluir(matricula);
		daoMatricula.incluir(matricula2);
		daoMatricula.fecharTransacao();
		
		Matricula matBD = daoMatricula.obterPorID(matricula.getId());
		assertNotNull(matBD);
		assertEquals(matricula.getId(), matBD.getId());
		
		Matricula matBD2 = daoMatricula.obterPorID(matricula2.getId());
		assertNotNull(matBD2);
		assertEquals(matricula2.getId(), matBD2.getId());

		List<Matricula> matriculasBanco = daoMatricula.obterTodos();

		Assert.assertTrue(listaMatricula.containsAll(matriculasBanco) && matriculasBanco.containsAll(listaMatricula));

		daoMatricula.excluir(matricula);
		daoMatricula.excluir(matricula2);
		daoAluno.excluir(aluno);
		daoAluno.excluir(aluno2);
		daoCurso.excluir(curso);
		daoCurso.excluir(curso2);
		daoMatricula.fechar();
		daoAluno.fechar();
		daoCurso.fechar();
		

	}

	@Test
	public void alterarMatricula() {

		Curso curso = new Curso();
		curso.setCodigo("A4");
		curso.setDescricao("Curso teste");
		curso.setNome("Curso de Java");

		daoCurso.abritTransacao();
		daoCurso.incluir(curso);
		daoCurso.fecharTransacao();
		
		Aluno aluno = new Aluno();
		aluno.setCodigo("AL4");
		aluno.setNome("Márcio Henrique");

		daoAluno.abritTransacao();
		daoAluno.incluir(aluno);
		daoAluno.fecharTransacao();

		Matricula matricula = new Matricula();
		matricula.setCodigo("A4");
		matricula.setDataMatricula(Instant.now());
		matricula.setStatus("Ativa");
		matricula.setValor(2000D);
		matricula.setCurso(curso);
		matricula.setAluno(aluno);

		daoMatricula.abritTransacao();
		daoMatricula.incluir(matricula);
		daoMatricula.fecharTransacao();

		assertNotNull(matricula);
		assertNotNull(matricula.getId());
		
		Matricula matBD = daoMatricula.obterPorID(matricula.getId());
		assertNotNull(matBD);
		assertEquals(matricula.getId(), matBD.getId());

		matricula.setValor(3200D);
		daoMatricula.alterar(matricula);

		assertEquals(matricula.getValor(), 3200D);

		daoMatricula.excluir(matricula);
		daoAluno.excluir(aluno);
		daoCurso.excluir(curso);
		daoMatricula.fechar();
		daoAluno.fechar();
		daoCurso.fechar();

	}

}
