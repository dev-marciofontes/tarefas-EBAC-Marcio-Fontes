package projeto_SimulaVendaJPA;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.Random;

import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import br.com.marciofontes.dao.ClienteDAO;
import br.com.marciofontes.dao.IClienteDAO;
import br.com.marciofontes.domain.Cliente;
import br.com.marciofontes.exception.DAOException;
import br.com.marciofontes.exception.MaisDeUmRegistroException;
import br.com.marciofontes.exception.TableException;
import br.com.marciofontes.exception.TipoChaveNaoEncontradaException;

public class ClienteDAOTest {
	
private IClienteDAO clienteDao;
	
	private Random rd;
	
	public ClienteDAOTest() {
		this.clienteDao = new ClienteDAO();
		rd = new Random();
	}
	
	@After
	public void end() throws DAOException {
		Collection<Cliente> list = clienteDao.buscarTodos();
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli);
			} catch (DAOException e) {
				e.printStackTrace();
			}
		});
	}
	
	@Test
	public void pesquisarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
	    Cliente cliente = criarCliente();
	    clienteDao.cadastrar(cliente);

	    Cliente clienteConsultado = clienteDao.consultar(cliente.getId());
	    Assertions.assertNotNull(clienteConsultado);
	}

	public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
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
	public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
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
	public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = criarCliente();
		Cliente retorno = clienteDao.cadastrar(cliente);
		Assertions.assertNotNull(retorno);
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getId());
		Assertions.assertNotNull(clienteConsultado);
		
		clienteConsultado.setNome("Ricardo Fontes Pereira");
		clienteDao.alterar(clienteConsultado);
		
		Cliente clienteAlterado = clienteDao.consultar(clienteConsultado.getId());
		Assertions.assertNotNull(clienteAlterado);
		Assertions.assertEquals("Ricardo Fontes Pereira", clienteAlterado.getNome());
		
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
		cliente.setNome("Ricardo Fontes");
		cliente.setCidade("Minas Gerais");
		cliente.setEnd("End");
		cliente.setEstado("MG");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		return cliente;
	}

}
