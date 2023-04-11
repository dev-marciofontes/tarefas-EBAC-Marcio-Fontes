/**
 * 
 */
package br.com.marciofontes.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.marciofontes.dao.IClienteDAO;
import br.com.marciofontes.domain.Cliente;
import br.com.marciofontes.exceptions.DAOException;
import br.com.marciofontes.exceptions.MaisDeUmRegistroException;
import br.com.marciofontes.exceptions.TableException;
import br.com.marciofontes.services.generic.GenericService;


@Stateless
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
	
	@Inject
	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
	}

	@Override
	public Cliente buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
