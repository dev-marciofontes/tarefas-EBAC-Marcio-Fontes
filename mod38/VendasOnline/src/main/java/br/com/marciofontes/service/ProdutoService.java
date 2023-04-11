/**
 * 
 */
package br.com.marciofontes.service;

import br.com.marciofontes.dao.IClienteDAO;
import br.com.marciofontes.dao.IProdutoDAO;
import br.com.marciofontes.domain.Cliente;
import br.com.marciofontes.domain.Produto;
import br.com.marciofontes.exceptions.DAOException;
import br.com.marciofontes.exceptions.MaisDeUmRegistroException;
import br.com.marciofontes.exceptions.TableException;
import br.com.marciofontes.services.generic.GenericService;

import javax.ejb.Stateless;
import javax.inject.Inject;


@Stateless
public class ProdutoService extends GenericService<Produto, Long> implements IProdutoService {

	@Inject
	public ProdutoService(IProdutoDAO produtoDAO) {
		super(produtoDAO);
	}

	@Override
	public Produto buscarPorCodigo(Long codigo) throws DAOException {
		try {
			return this.dao.consultar(codigo);
		} catch (MaisDeUmRegistroException | TableException e) {
			e.printStackTrace();
		}
		return null;
	}

}
