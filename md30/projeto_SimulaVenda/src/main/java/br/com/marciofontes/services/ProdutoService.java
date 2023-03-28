/**
 * 
 */
package br.com.marciofontes.services;

import br.com.marciofontes.dao.IProdutoDAO;
import br.com.marciofontes.domain.Produto;
import br.com.marciofontes.services.generic.GenericService;


public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
