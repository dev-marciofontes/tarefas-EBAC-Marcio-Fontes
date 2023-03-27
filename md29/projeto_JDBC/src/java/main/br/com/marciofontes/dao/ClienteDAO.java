package br.com.marciofontes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.marciofontes.domain.Cliente;
import br.com.marciofontes.jdbc.ConnectionFactory;

public class ClienteDAO implements IClienteDAO {

	@Override
	public Integer cadastrar(Cliente cliente) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "insert into tb_cliente_2 (codigo, nome) values (?,?)";
			stm = connection.prepareStatement(sql);
			stm.setString(1, cliente.getCodigo());
			stm.setString(2, cliente.getNome());
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
	public Cliente consultar(String codigo) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		Cliente cliente = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "select * from tb_cliente_2 where codigo = ?";
			stm = connection.prepareStatement(sql);
			stm.setString(1, codigo);
			rs = stm.executeQuery();
			if (rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setCodigo(rs.getString("codigo"));
				cliente.setNome(rs.getString("nome"));
			}
			return cliente;
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
	public Integer excluir(Cliente cliente) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "delete from tb_cliente_2 where codigo = ?";
			stm = connection.prepareStatement(sql);
			stm.setString(1, cliente.getCodigo());
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
	public List<Cliente> buscarTodos() throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		List<Cliente> clientes = new ArrayList<>();
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "select * from tb_cliente_2";
			stm = connection.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setCodigo(rs.getString("codigo"));
				cliente.setNome(rs.getString("nome"));
				clientes.add(cliente);
			}
			return clientes;
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
	public Integer alterar(Cliente cliente) throws Exception {
	    Connection connection = null;
	    PreparedStatement stm = null;
	    try {
	        connection = ConnectionFactory.getConnection();
	        String sql = "update tb_cliente_2 set nome=? where codigo=?";
	        stm = connection.prepareStatement(sql);
	        stm.setString(1, cliente.getNome());
	        stm.setString(2, cliente.getCodigo());
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
