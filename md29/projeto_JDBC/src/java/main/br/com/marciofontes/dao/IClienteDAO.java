package br.com.marciofontes.dao;

import java.util.List;

import br.com.marciofontes.domain.Cliente;

public interface IClienteDAO {

	public Integer cadastrar(Cliente cliente) throws Exception;

	public Cliente consultar(String codigo) throws Exception;

	public Integer excluir(Cliente clienteBD) throws Exception;

	public List<Cliente> buscarTodos() throws Exception;

	public Integer alterar(Cliente cliente) throws Exception;

}
