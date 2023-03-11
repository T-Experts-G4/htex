package br.com.htex.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexoes {

	
	public static Connection criaConexao() throws SQLException {
		
//		return DriverManager.getConnection("jdbc:mysql://172.17.0.2/htex", "root", "1234");
		return DriverManager.getConnection("jdbc:mysql://144.22.161.72/htex", "root", "1234");

	}
}
