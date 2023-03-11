package br.com.htex.test.usuario;

import java.sql.SQLException;

import br.com.htex.dao.UsuarioDao;
import br.com.htex.model.Usuario;

public class TestaBucarPorId {

	public static void main(String[] args) throws SQLException {
		Usuario user = new UsuarioDao().buscaPorId(1);
		System.out.println(user);
	}
}
