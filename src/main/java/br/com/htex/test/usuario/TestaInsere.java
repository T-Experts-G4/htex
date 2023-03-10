package br.com.htex.test.usuario;

import java.sql.SQLException;

import br.com.htex.dao.UsuarioDao;
import br.com.htex.model.Usuario;

public class TestaInsere {
	public static void main(String[] args) throws SQLException {
		UsuarioDao dao = new UsuarioDao();
		Usuario user = new Usuario("Adriano","senha4");
		dao.insere(user);
	}
 
}
