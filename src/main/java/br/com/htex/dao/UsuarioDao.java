package br.com.htex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.htex.conexao.FabricaConexoes;
import br.com.htex.model.Usuario;

public class UsuarioDao {

	
	public void insere(Usuario usuario) throws SQLException {
		Connection conn = FabricaConexoes.criaConexao();
		
		String sql = "INSERT INTO usuarios (nome, senha) VALUE (?, ?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, usuario.getNome());
		st.setString(2, usuario.getSenha());
		
		st.execute();
		System.out.println("Usuario: " + usuario.getNome() + " adicionado com sucesso.");
		
		st.close();
		conn.close();
	}
	
	public List<Usuario> lista() throws SQLException {
		Connection conn = FabricaConexoes.criaConexao();
		
		String sql = "select * from usuarios";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		List<Usuario> usuarios = new ArrayList<>();
		
		while(rs.next()) {
			Usuario usuario = new Usuario(rs.getInt(1), rs.getString(2),rs.getString(3));
			usuarios.add(usuario);
		}
			rs.close();
			st.close();
			conn.close();
			
			return usuarios;
	}
	
	public void atualiza(Usuario usuario) throws SQLException {
	    Connection conn = FabricaConexoes.criaConexao();
		
		String sql = "update usuarios set nome = ?, senha = ? where id = ?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, usuario.getNome());
		st.setString(2, usuario.getSenha());
		st.setInt(3, usuario.getUsuarioId());
		
		st.execute();
		System.out.println("Usuario alterado com sucesso!" );
		
		st.close();			
		conn.close();
	}
	
	public void remove(int id) throws SQLException {
		 Connection conn = FabricaConexoes.criaConexao();
			
			String sql = "delete from usuarios where id = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			
			st.execute();
			System.out.println("Usuario deletado com sucesso!" );
			
			st.close();			
			conn.close();
	}

	public Usuario buscaPorId(int id) throws SQLException {
		Usuario usuario = null;
		
		Connection conn = FabricaConexoes.criaConexao();
		
		String sql = "select * from usuarios where id = ?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, id);
		st.execute();
		ResultSet rs = st.getResultSet();
		if(rs.next()) {
			usuario = new Usuario(
					rs.getInt("id"),
					rs.getString("nome"),
					rs.getString("senha")
					);
		}
		rs.close();
		st.close();
		conn.close();
		return usuario;
	}


	
}
