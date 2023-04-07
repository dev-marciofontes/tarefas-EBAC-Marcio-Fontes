package br.com.marciofontes.dao;

import br.com.marciofontes.dao.generic.GenericDAO;
import br.com.marciofontes.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

	public ClienteDAO() {
		super(Cliente.class);
	}

}
