package br.com.htex.test.usuario;

import java.sql.SQLException;

import br.com.htex.dao.UsuarioDao;
import br.com.htex.model.Usuario;

public class TestaInsereUsuario {
	public static void main(String[] args) throws SQLException {
		UsuarioDao usuarioDao = new UsuarioDao();
		Usuario user = new Usuario("Silvio","senha1");
		usuarioDao.insere(user);
	}

}
