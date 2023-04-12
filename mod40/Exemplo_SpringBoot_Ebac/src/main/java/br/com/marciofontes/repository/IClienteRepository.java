package br.com.marciofontes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.marciofontes.domain.Cliente;

/**
 * @author Márcio Fontes
 */
@Repository
public interface IClienteRepository extends CrudRepository<Cliente, Long> {

}

