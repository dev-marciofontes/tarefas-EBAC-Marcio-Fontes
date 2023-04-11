/**
 *
 */
package br.com.marciofontes.dao;

import br.com.marciofontes.dao.generic.GenericDAO;
import br.com.marciofontes.domain.Cliente;
import br.com.marciofontes.domain.Produto;


public class ProdutoDAO extends GenericDAO<Produto, Long> implements IProdutoDAO {

    public ProdutoDAO() {
        super(Produto.class);
    }

}
