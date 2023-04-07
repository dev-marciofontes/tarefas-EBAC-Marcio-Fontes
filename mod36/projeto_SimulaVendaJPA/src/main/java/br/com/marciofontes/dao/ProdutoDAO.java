package br.com.marciofontes.dao;

import br.com.marciofontes.dao.generic.GenericJPADB1DAO;
import br.com.marciofontes.domain.Produto;

public class ProdutoDAO extends GenericJPADB1DAO<Produto, Long> implements IProdutoDAO {

	public ProdutoDAO() {
		super(Produto.class);
	}

}