package br.com.htex.test;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.htex.conexao.FabricaConexoes;

public class TestaConexao {
	
	public static void main(String[] args) throws SQLException {
		Connection conn = FabricaConexoes.criaConexao();
		
		System.out.println("Banco");
		conn.close();
	}

}
