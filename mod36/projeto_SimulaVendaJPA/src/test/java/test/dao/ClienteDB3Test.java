package test.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.Random;

import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import br.com.marciofontes.dao.ClienteDAO;
import br.com.marciofontes.dao.ClienteDB2DAO;
import br.com.marciofontes.dao.ClienteDB3DAO;
import br.com.marciofontes.dao.IClienteDAO;
import br.com.marciofontes.domain.Cliente;
import br.com.marciofontes.domain.Cliente2;
import br.com.marciofontes.exception.DAOException;
import br.com.marciofontes.exception.MaisDeUmRegistroException;
import br.com.marciofontes.exception.TableException;
import br.com.marciofontes.exception.TipoChaveNaoEncontradaException;

public class ClienteDB3Test {

	private IClienteDAO<Cliente> clienteDao;

	private IClienteDAO<Cliente> clienteDB2Dao;

	private IClienteDAO<Cliente2> clienteDB3Dao;

	private Random rd;

	public ClienteDB3Test() {
		this.clienteDao = new ClienteDAO();
		this.clienteDB2Dao = new ClienteDB2DAO();
		this.clienteDB3Dao = new ClienteDB3DAO();
		rd = new Random();
	}

	@After
	public void end() throws DAOException {
		Collection<Cliente> list = clienteDao.buscarTodos();
		excluir(list, clienteDao);

		Collection<Cliente> list2 = clienteDB2Dao.buscarTodos();
		excluir(list2, clienteDB2Dao);

		Collection<Cliente2> list3 = clienteDB3Dao.buscarTodos();
		excluir3(list3);
	}

	private void excluir(Collection<Cliente> list, IClienteDAO<Cliente> clienteDao) {
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	private void excluir3(Collection<Cliente2> list) {
		list.forEach(cli -> {
			try {
				clienteDB3Dao.excluir(cli);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	@Test
	public void pesquisarCliente()
			throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		Cliente cliente = criarCliente();
		clienteDao.cadastrar(cliente);

		Cliente clienteConsultado = clienteDao.consultar(cliente.getId());
		Assertions.assertNotNull(clienteConsultado);

		cliente.setId(null);
		clienteDB2Dao.cadastrar(cliente);

		Cliente clienteConsultado2 = clienteDB2Dao.consultar(cliente.getId());
		Assertions.assertNotNull(clienteConsultado2);

		Cliente2 cliente2 = criarCliente2();
		clienteDB3Dao.cadastrar(cliente2);

		Cliente2 clienteConsultado3 = clienteDB3Dao.consultar(cliente2.getId());
		Assertions.assertNotNull(clienteConsultado3);

	}

	@Test
	public void salvarCliente()
			throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = criarCliente();
		Cliente retorno = clienteDao.cadastrar(cliente);
		Assertions.assertNotNull(retorno);

		Cliente clienteConsultado = clienteDao.consultar(retorno.getId());
		Assertions.assertNotNull(clienteConsultado);

		clienteDao.excluir(cliente);

		Cliente clienteConsultado1 = clienteDao.consultar(retorno.getId());
		Assertions.assertNull(clienteConsultado1);
	}

	@Test
	public void excluirCliente()
			throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = criarCliente();
		Cliente retorno = clienteDao.cadastrar(cliente);
		Assertions.assertNotNull(retorno);

		Cliente clienteConsultado = clienteDao.consultar(cliente.getId());
		Assertions.assertNotNull(clienteConsultado);

		clienteDao.excluir(cliente);
		clienteConsultado = clienteDao.consultar(cliente.getId());
		Assertions.assertNull(clienteConsultado);
	}

	@Test
	public void alterarCliente()
			throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = criarCliente();
		Cliente retorno = clienteDao.cadastrar(cliente);
		Assertions.assertNotNull(retorno);

		Cliente clienteConsultado = clienteDao.consultar(cliente.getId());
		Assertions.assertNotNull(clienteConsultado);

		clienteConsultado.setNome("Rodrigo Pereira Roger");
		clienteDao.alterar(clienteConsultado);

		Cliente clienteAlterado = clienteDao.consultar(clienteConsultado.getId());
		Assertions.assertNotNull(clienteAlterado);
		Assertions.assertEquals("Rodrigo Pereira Roger", clienteAlterado.getNome());

		clienteDao.excluir(cliente);
		clienteConsultado = clienteDao.consultar(clienteAlterado.getId());
		Assertions.assertNull(clienteConsultado);
	}

	@Test
	public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
		Cliente cliente = criarCliente();
		Cliente retorno = clienteDao.cadastrar(cliente);
		Assertions.assertNotNull(retorno);

		Cliente cliente1 = criarCliente();
		Cliente retorno1 = clienteDao.cadastrar(cliente1);
		Assertions.assertNotNull(retorno1);

		Collection<Cliente> list = clienteDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);

		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		Collection<Cliente> list1 = clienteDao.buscarTodos();
		assertTrue(list1 != null);
		assertTrue(list1.size() == 0);
	}

	private Cliente criarCliente() {
		Cliente cliente = new Cliente();
		cliente.setCpf(rd.nextLong());
		cliente.setNome("Rodrigo Pereira");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		return cliente;
	}

	private Cliente2 criarCliente2() {
		Cliente2 cliente = new Cliente2();
		cliente.setCpf(rd.nextLong());
		cliente.setNome("Rafael Almeida");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		return cliente;
	}

}
