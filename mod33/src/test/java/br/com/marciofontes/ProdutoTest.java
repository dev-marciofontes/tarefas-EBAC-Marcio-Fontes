package br.com.marciofontes;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.marciofontes.dao.ProdutoDAO;

public class ProdutoTest {
	
	private ProdutoDAO dao = new ProdutoDAO();

	@Test
	public void cadastrar() {

		Produto produto = new Produto();
		produto.setCodigo("A");
		produto.setNome("Televisão");
		produto.setDescricao("52 polegadas - 4K Ultra HD ");
		produto.setPreco(3500D);

		dao.abritTransacao();
		dao.incluir(produto);
		dao.fecharTransacao();

		assertNotNull(produto);
		assertNotNull(produto.getId());

		dao.excluir(produto);
		dao.fechar();

	}

	@Test
	public void consultarTodosProdutos() {

		Produto produto = new Produto();
		produto.setCodigo("A1");
		produto.setNome("Televisão");
		produto.setDescricao("52 polegadas - 4K Ultra HD ");
		produto.setPreco(3500D);

		Produto produto2 = new Produto();
		produto2.setCodigo("A2");
		produto2.setNome("Celular");
		produto2.setDescricao("250 GB de ROM, 8 GB de Ram");
		produto2.setPreco(5500D);

		List<Produto> listaProdutos = new ArrayList<>();
		listaProdutos.add(produto);
		listaProdutos.add(produto2);

		dao.abritTransacao();
		dao.incluir(produto);
		dao.incluir(produto2);
		dao.fecharTransacao();

		List<Produto> produtosBanco = dao.obterTodos();

		Assert.assertTrue(listaProdutos.containsAll(produtosBanco) && produtosBanco.containsAll(listaProdutos));

		dao.excluir(produto);
		dao.excluir(produto2);
		dao.fechar();

	}
	
	@Test
	public void altararProduto() {
		
		Produto produto = new Produto();
		produto.setCodigo("A3");
		produto.setNome("Televisão");
		produto.setDescricao("52 polegadas - 4K Ultra HD ");
		produto.setPreco(3500D);

		dao.abritTransacao();
		dao.incluir(produto);
		dao.fecharTransacao();

		assertNotNull(produto);
		assertNotNull(produto.getId());
		
		produto.setPreco(4200D);
		dao.alterar(produto);
		
		assertEquals(produto.getPreco(),4200D);
		
		dao.excluir(produto);
		dao.fechar();
					
	}

}
