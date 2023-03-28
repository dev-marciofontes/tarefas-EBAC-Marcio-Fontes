/**
 * 
 */
package br.com.marciofontes.services;

import br.com.marciofontes.domain.Cliente;
import br.com.marciofontes.exceptions.DAOException;
import br.com.marciofontes.services.generic.IGenericService;


public interface IClienteService extends IGenericService<Cliente, Long> {

//	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
	Cliente buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
