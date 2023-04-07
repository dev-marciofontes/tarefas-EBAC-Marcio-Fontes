package br.com.marciofontes.dao;

import br.com.marciofontes.dao.generic.GenericJPADB1DAO;
import br.com.marciofontes.domain.Cliente;

public class ClienteDAO extends GenericJPADB1DAO<Cliente, Long> implements IClienteDAO<Cliente> {

	public ClienteDAO() {
		super(Cliente.class);
	}

}
