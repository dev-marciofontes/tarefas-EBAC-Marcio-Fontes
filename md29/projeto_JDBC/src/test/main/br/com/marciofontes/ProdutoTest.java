package br.com.marciofontes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Order;

import br.com.marciofontes.dao.IProdutoDAO;
import br.com.marciofontes.dao.ProdutoDAO;
import br.com.marciofontes.domain.Produto;

public class ProdutoTest {

	@Test
	@Order(1)
	public void cadastrarProduto() throws Exception {
		IProdutoDAO dao = new ProdutoDAO();

		Produto produto = new Produto();
		produto.setCodigoProd("01");
		produto.setNomeProd("Caneta PIC");
		produto.setPreco(4.90);

		Integer qtd = dao.cadastrar(produto);
		assertTrue(qtd == 1);

		Produto produtoBD = dao.consultar(produto.getCodigoProd());
		assertNotNull(produtoBD);
		assertNotNull(produtoBD.getId());
		assertEquals(produto.getCodigoProd(), produtoBD.getCodigoProd());
		assertEquals(produto.getNomeProd(), produtoBD.getNomeProd());

		Integer qtdDel = dao.excluir(produtoBD);
		assertNotNull(qtdDel);

	}

	@Test
	@Order(2)
	public void buscarTodosProdutosTeste() throws Exception {
		IProdutoDAO dao = new ProdutoDAO();

		Produto produto = new Produto();
		produto.setCodigoProd("01");
		produto.setNomeProd("Caneta PIC");
		produto.setPreco(4.90);

		Produto produto2 = new Produto();
		produto2.setCodigoProd("02");
		produto2.setNomeProd("Notebook");
		produto2.setPreco(4980.90);

		Integer qtd = dao.cadastrar(produto);
		assertTrue(qtd == 1);

		Integer qtd2 = dao.cadastrar(produto2);
		assertTrue(qtd2 == 1);

		List<Produto> produtos = dao.buscarTodos();
		assertNotNull(produtos);
		assertFalse(produtos.isEmpty());
		assertEquals(2, produtos.size());

		Integer qtdDel = dao.excluir(produto);
		Integer qtdDel2 = dao.excluir(produto2);
		assertNotNull(qtdDel);
		assertNotNull(qtdDel2);
	}

	@Test
	@Order(3)
	public void alterarClienteTeste() throws Exception {
		IProdutoDAO dao = new ProdutoDAO();

		Produto produto = new Produto();
		produto.setCodigoProd("01");
		produto.setNomeProd("Caneta PIC");
		produto.setPreco(4.90);

		Integer qtd = dao.cadastrar(produto);
		assertTrue(qtd == 1);

		Produto produtoBD = dao.consultar(produto.getCodigoProd());
		assertNotNull(produtoBD);
		assertNotNull(produtoBD.getId());
		assertEquals(produto.getCodigoProd(), produtoBD.getCodigoProd());
		assertEquals(produto.getNomeProd(), produtoBD.getNomeProd());

		produto.setNomeProd("Caneta Pic Preta");

		Integer qtdAlt = dao.alterar(produto);
		assertNotNull(qtdAlt);

		Produto produtoBD2 = dao.consultar(produto.getCodigoProd());
		assertNotNull(produtoBD2);
		assertNotNull(produtoBD2.getId());
		assertEquals(produto.getCodigoProd(), produtoBD2.getCodigoProd());
		assertEquals(produto.getNomeProd(), produtoBD2.getNomeProd());

		Integer qtdDel = dao.excluir(produtoBD2);
		assertNotNull(qtdDel);

	}

}
