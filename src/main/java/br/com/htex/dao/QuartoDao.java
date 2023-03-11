package br.com.htex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.htex.conexao.FabricaConexoes;
import br.com.htex.model.Quarto;

public class QuartoDao {

	public void insere(Quarto quarto) throws SQLException {
		Connection conn = FabricaConexoes.criaConexao();
		
		String sql = "INSERT INTO quartos (numero, preco_diaria, disponivel, hotel_id) "
				+ "VALUE (?, ?, ?, ?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, quarto.getNumero());
		st.setBigDecimal(2, quarto.getPrecoDiaria());
		st.setBoolean(3, quarto.isDisponivel());
		st.setInt(4, quarto.getHotelId());
		
		st.execute();
		System.out.println("Quarto: " + quarto.getNumero() + " adicionado com sucesso.");
		
		st.close();
		conn.close();
	}
	
	public List<Quarto> lista() throws SQLException {
		Connection conn = FabricaConexoes.criaConexao();
		
		String sql = "select * from quartos";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		List<Quarto> quartos = new ArrayList<>();
		
		while(rs.next()) {
			Quarto quarto = new Quarto(
					rs.getInt(1),
					rs.getInt(2),
					rs.getBigDecimal(3),
					rs.getBoolean(4),
					rs.getInt(5)
					);
			quartos.add(quarto);
		}
			rs.close();
			st.close();
			conn.close();
			
			return quartos;
	}
	
	public void atualiza(Quarto quarto) throws SQLException {
	    Connection conn = FabricaConexoes.criaConexao();
		
		String sql = "update quartos set numero = ?, preco_diaria = ?, disponivel = ?, hotel_id = ? where id = ?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, quarto.getNumero());
		st.setBigDecimal(1, quarto.getPrecoDiaria());
		st.setBoolean(2, quarto.isDisponivel());
		st.setInt(3, quarto.getHotelId());
		
		st.execute();
		System.out.println("Quartos alterado com sucesso!" );
		
		st.close();			
		conn.close();
	}
	
	public void remove(int id) throws SQLException {
		 Connection conn = FabricaConexoes.criaConexao();
			
			String sql = "delete from quartos where id = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			
			st.execute();
			System.out.println("Quarto deletado com sucesso!" );
			
			st.close();			
			conn.close();
	}

	public Quarto buscaPorId(int id) throws SQLException {
		Quarto quarto = null;
		
		Connection conn = FabricaConexoes.criaConexao();
		
		String sql = "select * from quartos where id = ?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, id);
		st.execute();
		ResultSet rs = st.getResultSet();
		if(rs.next()) {
			quarto = new Quarto(
					rs.getInt(1),
					rs.getInt(2),
					rs.getBigDecimal(3),
					rs.getBoolean(4),
					rs.getInt(5)
					);
		}
		rs.close();
		st.close();
		conn.close();
		return quarto;
	}

	
}
