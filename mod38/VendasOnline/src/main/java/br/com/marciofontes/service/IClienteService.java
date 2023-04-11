/**
 * 
 */
package br.com.marciofontes.service;

import br.com.marciofontes.domain.Cliente;
import br.com.marciofontes.exceptions.DAOException;
import br.com.marciofontes.services.generic.IGenericService;


public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;

}
