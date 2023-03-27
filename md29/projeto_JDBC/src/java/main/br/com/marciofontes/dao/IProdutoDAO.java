package br.com.marciofontes.dao;

import java.util.List;

import br.com.marciofontes.domain.Produto;

public interface IProdutoDAO {

	public Integer cadastrar(Produto produto) throws Exception;

	public Produto consultar(String codigo) throws Exception;

	public Integer excluir(Produto produto) throws Exception;

	public List<Produto> buscarTodos() throws Exception;

	public Integer alterar(Produto produto) throws Exception;

}
