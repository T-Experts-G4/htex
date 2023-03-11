package br.com.htex.test.usuario;

import java.sql.SQLException;

import br.com.htex.dao.UsuarioDao;

public class TestaRemoveUsuario {
	public static void main(String[] args) throws SQLException {
		UsuarioDao dao = new UsuarioDao();
		dao.remove(6);
		System.out.println("Usuairo Removido");
	}
}
