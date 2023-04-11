/**
 * 
 */
package br.com.marciofontes.service;

import br.com.marciofontes.domain.Cliente;
import br.com.marciofontes.domain.Produto;
import br.com.marciofontes.exceptions.DAOException;
import br.com.marciofontes.services.generic.IGenericService;


public interface IProdutoService extends IGenericService<Produto, Long> {

	Produto buscarPorCodigo(Long codigo) throws DAOException;

}
