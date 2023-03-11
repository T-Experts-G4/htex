package br.com.htex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.htex.conexao.FabricaConexoes;
import br.com.htex.model.ServicoAdicional;
import br.com.htex.model.Usuario;

public class ServicoAdicionalDao {

	public void insere (ServicoAdicional servico) throws SQLException {
		
		Connection conn = FabricaConexoes.criaConexao();
		
		String sql = "INSERT INTO servicos_adicionais (nome, descricao, preco) VALUE (?, ?, ?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, servico.getNome());
		st.setString(2, servico.getDescricao());
		st.setBigDecimal(2, servico.getPreco());
		
		st.execute();
		System.out.println("Serviço: " + servico.getNome() + " adicionado com sucesso.");
		
		st.close();
		conn.close();
		
	}
	
	public List<ServicoAdicional> lista() throws SQLException {
		Connection conn = FabricaConexoes.criaConexao();
		
		String sql = "select * from servicos_adicionais";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		List<ServicoAdicional> servicos = new ArrayList<>();
		
		while(rs.next()) {
			ServicoAdicional servico = new ServicoAdicional(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getBigDecimal(4));
			servicos.add(servico);
		}
			rs.close();
			st.close();
			conn.close();
			
		return servicos;
	}	
	
	public void remove(int id) throws SQLException {
		 Connection conn = FabricaConexoes.criaConexao();
			
			String sql = "delete from servicos_adicionais where id = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			
			st.execute();
			System.out.println("Usuario deletado com sucesso!" );
			
			st.close();			
			conn.close();
	}
	
	public ServicoAdicional buscaPorId(int id) throws SQLException {
		ServicoAdicional servico = null;
		
		Connection conn = FabricaConexoes.criaConexao();
		
		String sql = "select * from servicos_adicionais where id = ?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, id);
		st.execute();
		ResultSet rs = st.getResultSet();
		if(rs.next()) {
			servico = new ServicoAdicional(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getBigDecimal(4)
					);
		}
		rs.close();
		st.close();
		conn.close();
		return servico;
	}

	
}
