package br.com.marciofontes.dao;

import br.com.marciofontes.dao.generic.IGenericDAO;

public interface IClienteDAO<T extends Persistente> extends IGenericDAO<T, Long>{

}
