package br.com.htex.test.usuario;

import java.sql.SQLException;
import java.util.List;

import br.com.htex.dao.UsuarioDao;
import br.com.htex.model.Usuario;

public class TestaListaTodos {
	
	public static void main(String[] args) throws SQLException {
		List<Usuario> usuarios = new UsuarioDao().lista();
		usuarios.forEach(usuario -> System.out.println(usuario));
	}

}
