package br.com.htex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.htex.conexao.FabricaConexao;
import br.com.htex.model.Cliente;
import br.com.htex.model.Hotel;

public class HotelDao {
	
	public void insere (Hotel hotel) throws SQLException {
		Connection conn = FabricaConexao.criaConexao();
		
		String sql = "insert into hoteis (id, nome, endereco) values (?,?,?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, hotel.getId());
		st.setString(2, hotel.getNome());
		st.setString(3, hotel.getEndereco().toString());
		
		st.execute();
		
		st.close();			
		conn.close();
	}
	
	public List<Hotel> lista() throws SQLException {
		Connection conn = FabricaConexao.criaConexao();
		
		String sql = "select hotel.nome,hoteis.endereco,hoteis.nome from hoteis join hotel on hoteis.hotel_id=hotel.id";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		List<Hotel> hoteis = new ArrayList<>();
		
		while(rs.next()) {
			Hotel hotel = new Hotel(rs.getInt(1),rs.getString(2));
			hoteis.add(hotel);
		}
			rs.close();
			st.close();
			conn.close();
			
			return hoteis;
	}
	
	public void atualiza(Hotel hotel) throws SQLException {
	    Connection conn = FabricaConexao.criaConexao();
		
		String sql = "update hoteis set endereco = ?, nome = ? where id = ?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, hotel.getEndereco().toString());
		st.setString(2, hotel.getNome());
		st.setInt(3, hotel.getId());
		
		st.execute();
		System.out.println("Dados do Hotel alterados com sucesso!" );
		
		st.close();			
		conn.close();
	}
	
	public void remove(int id) throws SQLException {
		 Connection conn = FabricaConexao.criaConexao();
			
			String sql = "delete from hoteis where id = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			
			st.execute();
			System.out.println("Hotel deletado com sucesso!" );
			
			st.close();			
			conn.close();
	}

	public Hotel buscaPorId(int id) throws SQLException {
		Hotel hotel = null;
		
		Connection conn = FabricaConexao.criaConexao();
		
		String sql = "select * from hoteis where id = ?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			hotel = new Hotel(
					rs.getInt(id), 
					rs.getString("nome")
					);		
		}
		rs.close();
		st.close();
		conn.close();
		return hotel;
	}

}
