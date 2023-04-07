package br.com.marciofontes.dao;

import br.com.marciofontes.dao.generic.GenericJPADB2DAO;
import br.com.marciofontes.domain.Cliente;

public class ClienteDB2DAO extends GenericJPADB2DAO<Cliente, Long> implements IClienteDAO<Cliente> {

	public ClienteDB2DAO() {
		super(Cliente.class);
	}

}
