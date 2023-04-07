package br.com.marciofontes.dao;

import br.com.marciofontes.dao.generic.GenericJPADB3DAO;
import br.com.marciofontes.domain.Cliente2;

public class ClienteDB3DAO extends GenericJPADB3DAO<Cliente2, Long> implements IClienteDAO<Cliente2> {

	public ClienteDB3DAO() {
		super(Cliente2.class);
	}

}
