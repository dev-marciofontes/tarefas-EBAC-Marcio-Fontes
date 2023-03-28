/**
 * 
 */
package br.com.marciofontes.dao;

import br.com.marciofontes.dao.generic.IGenericDAO;
import br.com.marciofontes.domain.Venda;
import br.com.marciofontes.exceptions.DAOException;
import br.com.marciofontes.exceptions.TipoChaveNaoEncontradaException;


public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
