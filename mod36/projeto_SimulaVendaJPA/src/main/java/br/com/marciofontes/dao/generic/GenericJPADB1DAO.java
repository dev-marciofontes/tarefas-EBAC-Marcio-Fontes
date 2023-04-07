package br.com.marciofontes.dao.generic;

import java.io.Serializable;

import br.com.marciofontes.dao.Persistente;

public class GenericJPADB1DAO<T extends Persistente, E extends Serializable> extends GenericDAO<T, E> {

	public GenericJPADB1DAO(Class<T> persistenteClass) {
		super(persistenteClass, "Projeto_SimulaVendaJPA");
	}

}
