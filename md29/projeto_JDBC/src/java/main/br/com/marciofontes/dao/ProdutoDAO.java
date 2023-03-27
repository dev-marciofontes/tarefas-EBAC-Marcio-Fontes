package br.com.marciofontes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.marciofontes.domain.Produto;
import br.com.marciofontes.jdbc.ConnectionFactory;

public class ProdutoDAO implements IProdutoDAO {

	@Override
	public Integer cadastrar(Produto produto) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "insert into tb_produto_2 (codigo_prod, nome_prod, preco) values (?,?,?)";
			stm = connection.prepareStatement(sql);
			stm.setString(1, produto.getCodigoProd());
			stm.setString(2, produto.getNomeProd());
			stm.setDouble(3, produto.getPreco());
			return stm.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

	@Override
	public Produto consultar(String codigo) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		Produto produto = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "select * from tb_produto_2 where codigo_prod = ?";
			stm = connection.prepareStatement(sql);
			stm.setString(1, codigo);
			rs = stm.executeQuery();
			if (rs.next()) {
				produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setNomeProd(rs.getString("nome_prod"));
				produto.setCodigoProd(rs.getString("codigo_prod"));
				produto.setPreco(rs.getDouble("preco"));
			}
			return produto;
		} catch (Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

	@Override
	public Integer excluir(Produto produto) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "delete from tb_produto_2 where codigo_prod = ?";
			stm = connection.prepareStatement(sql);
			stm.setString(1, produto.getCodigoProd());
			return stm.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

	@Override
	public List<Produto> buscarTodos() throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		List<Produto> produtos = new ArrayList<>();
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "select * from tb_produto_2";
			stm = connection.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setCodigoProd(rs.getString("codigo_prod"));
				produto.setNomeProd(rs.getString("nome_prod"));
				produto.setPreco(rs.getDouble("preco"));
				produtos.add(produto);
			}
			return produtos;
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

	@Override
	public Integer alterar(Produto produto) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "update tb_produto_2 set nome_prod=?, preco=? where codigo_prod=?";
			stm = connection.prepareStatement(sql);
			stm.setString(1, produto.getNomeProd());
			stm.setDouble(2, produto.getPreco());
			stm.setString(3, produto.getCodigoProd());
			return stm.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

}
