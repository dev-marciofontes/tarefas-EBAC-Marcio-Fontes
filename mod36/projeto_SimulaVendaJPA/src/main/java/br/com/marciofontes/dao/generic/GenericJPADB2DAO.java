package br.com.marciofontes.dao.generic;

import java.io.Serializable;

import br.com.marciofontes.dao.Persistente;

public abstract class GenericJPADB2DAO<T extends Persistente, E extends Serializable> extends GenericDAO<T, E> {

	public GenericJPADB2DAO(Class<T> persistenteClass) {
		super(persistenteClass, "Projeto_SimulaVendaJPA2");
	}

}
