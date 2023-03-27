package br.com.marciofontes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Order;

import br.com.marciofontes.dao.ClienteDAO;
import br.com.marciofontes.dao.IClienteDAO;
import br.com.marciofontes.domain.Cliente;

public class ClienteTest {

	@Test
	@Order(1)
	public void cadastrarTeste() throws Exception {
		IClienteDAO dao = new ClienteDAO();

		Cliente cliente = new Cliente();
		cliente.setCodigo("01");
		cliente.setNome("Roberto Bono");

		Integer qtd = dao.cadastrar(cliente);
		assertTrue(qtd == 1);

		Cliente clienteBD = dao.consultar(cliente.getCodigo());
		assertNotNull(clienteBD);
		assertNotNull(clienteBD.getId());
		assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		assertEquals(cliente.getNome(), clienteBD.getNome());

		Integer qtdDel = dao.excluir(clienteBD);
		assertNotNull(qtdDel);

	}

	@Test
	@Order(2)
	public void buscarTodosTeste() throws Exception {
		IClienteDAO dao = new ClienteDAO();

		Cliente cliente = new Cliente();
		cliente.setCodigo("02");
		cliente.setNome("Renata Oliveira");

		Cliente cliente2 = new Cliente();
		cliente2.setCodigo("03");
		cliente2.setNome("Jucelina Passa Cheque");

		Integer qtd = dao.cadastrar(cliente);
		Integer qtd2 = dao.cadastrar(cliente2);
		assertTrue(qtd == 1);
		assertTrue(qtd2 == 1);

		List<Cliente> clientes = dao.buscarTodos();
		assertNotNull(clientes);
		assertFalse(clientes.isEmpty());
		assertEquals(2, clientes.size());

		Integer qtdDel = dao.excluir(cliente);
		Integer qtdDel2 = dao.excluir(cliente2);
		assertNotNull(qtdDel);
		assertNotNull(qtdDel2);
	}

	@Test
	@Order(3)
	public void alterarClienteTeste() throws Exception {
		IClienteDAO dao = new ClienteDAO();

		Cliente cliente = new Cliente();
		cliente.setCodigo("04");
		cliente.setNome("Robert Almeida");

		Integer qtd = dao.cadastrar(cliente);
		assertTrue(qtd == 1);
		
		Cliente clienteBD = dao.consultar(cliente.getCodigo());
	    assertNotNull(clienteBD);
	    assertNotNull(clienteBD.getId());
	    assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
	    assertEquals(cliente.getNome(), clienteBD.getNome());

	    cliente.setNome("Roberto Almeida");
	    
	    Integer qtdAlt = dao.alterar(cliente);
	    assertNotNull(qtdAlt);    

		Cliente clienteBD2 = dao.consultar(cliente.getCodigo());
		assertNotNull(clienteBD2);
		assertNotNull(clienteBD2.getId());
		assertEquals(cliente.getCodigo(), clienteBD2.getCodigo());
		assertEquals(cliente.getNome(), clienteBD2.getNome());

		Integer qtdDel = dao.excluir(clienteBD);
		assertNotNull(qtdDel);

	}

}
