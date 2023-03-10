package br.com.htex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.htex.conexao.FabricaConexoes;
import br.com.htex.model.Cliente;



public class ClienteDao {

	public void insere (Cliente cliente) throws SQLException {
		Connection conn = FabricaConexoes.criaConexao();
		
		String sql = "insert into clientes (telefone, email, usuario_id) values (?,?,?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, cliente.getTelefone());
		st.setString(2, cliente.getEmail());
		st.setInt(3, cliente.getUsuarioId());
		
		st.execute();
		
		st.close();			
		conn.close();
	}
	
	public List<Cliente> lista() throws SQLException {
		Connection conn = FabricaConexoes.criaConexao();
		
		String sql = "select usuario.nome,clientes.telefone,clientes.email from clientes join usuario on clientes.usuario_id=usuario.id";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		List<Cliente> clientes = new ArrayList<>();
		
		while(rs.next()) {
			Cliente cliente = new Cliente(rs.getString(1),rs.getString(2),rs.getString(3));
			clientes.add(cliente);
		}
			rs.close();
			st.close();
			conn.close();
			
			return clientes;
	}
	
	public void atualiza(Cliente cliente) throws SQLException {
	    Connection conn = FabricaConexoes.criaConexao();
		
		String sql = "update clientes set telefone = ?, email = ? where id = ?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, cliente.getTelefone());
		st.setString(2, cliente.getEmail());
		st.setInt(3, cliente.getUsuarioId());
		
		st.execute();
		System.out.println("Cliente alterado com sucesso!" );
		
		st.close();			
		conn.close();
	}
	
	public void remove(int id) throws SQLException {
		 Connection conn = FabricaConexoes.criaConexao();
			
			String sql = "delete from clientes where id = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			
			st.execute();
			System.out.println("Cliente deletado com sucesso!" );
			
			st.close();			
			conn.close();
	}

	public Cliente buscaPorId(int id) throws SQLException {
		Cliente cliente = null;
		
		Connection conn = FabricaConexoes.criaConexao();
		
		String sql = "select * from clientes where id = ?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			cliente = new Cliente(
					rs.getInt("id"),
					rs.getString("telefone"),
					rs.getString("email")
					);
		}
		rs.close();
		st.close();
		conn.close();
		return cliente;
	}
	
}
