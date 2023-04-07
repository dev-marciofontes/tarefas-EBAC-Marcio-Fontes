package projeto_SimulaVendaJPA;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import br.com.marciofontes.dao.IProdutoDAO;
import br.com.marciofontes.dao.ProdutoDAO;
import br.com.marciofontes.domain.Produto;
import br.com.marciofontes.exception.DAOException;
import br.com.marciofontes.exception.MaisDeUmRegistroException;
import br.com.marciofontes.exception.TableException;
import br.com.marciofontes.exception.TipoChaveNaoEncontradaException;

public class ProdutoDAOTest {

	private IProdutoDAO produtoDao;

	public ProdutoDAOTest() {
		this.produtoDao = new ProdutoDAO();
	}

	@After
	public void end() throws DAOException {
		Collection<Produto> list = produtoDao.buscarTodos();
		list.forEach(cli -> {
			try {
				produtoDao.excluir(cli);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	@Test
	public void pesquisar()
			throws MaisDeUmRegistroException, TableException, DAOException, TipoChaveNaoEncontradaException {
		Produto produto = criarProduto("A1");
		Assertions.assertNotNull(produto);
		Produto produtoDB = this.produtoDao.consultar(produto.getId());
		Assertions.assertNotNull(produtoDB);
	}

	@Test
	public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
		Produto produto = criarProduto("A2");
		Assertions.assertNotNull(produto);
	}

	@Test
	public void excluir()
			throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
		Produto produto = criarProduto("A3");
		Assertions.assertNotNull(produto);
		this.produtoDao.excluir(produto);
		Produto produtoBD = this.produtoDao.consultar(produto.getId());
		assertNull(produtoBD);
	}

	@Test
	public void alterarCliente()
			throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		Produto produto = criarProduto("A4");
		produto.setNome("Ricardo Fontes");
		produtoDao.alterar(produto);
		Produto produtoBD = this.produtoDao.consultar(produto.getId());
		assertNotNull(produtoBD);
		Assertions.assertEquals("Ricardo Fontes", produtoBD.getNome());
	}

	@Test
	public void buscarTodos() throws DAOException, TipoChaveNaoEncontradaException {
		criarProduto("A5");
		criarProduto("A6");
		Collection<Produto> list = produtoDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);

		for (Produto prod : list) {
			this.produtoDao.excluir(prod);
		}

		list = produtoDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 0);

	}

	private Produto criarProduto(String codigo) throws TipoChaveNaoEncontradaException, DAOException {
		Produto produto = new Produto();
		produto.setCodigo(codigo);
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(BigDecimal.TEN);
		produtoDao.cadastrar(produto);
		return produto;
	}

}
