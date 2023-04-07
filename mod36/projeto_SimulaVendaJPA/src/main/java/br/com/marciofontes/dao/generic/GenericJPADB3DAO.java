package br.com.marciofontes.dao.generic;

import java.io.Serializable;

import br.com.marciofontes.dao.Persistente;

public class GenericJPADB3DAO<T extends Persistente, E extends Serializable> extends GenericDAO<T, E> {

	public GenericJPADB3DAO(Class<T> persistenteClass) {
		super(persistenteClass, "mysql");
	}

}
