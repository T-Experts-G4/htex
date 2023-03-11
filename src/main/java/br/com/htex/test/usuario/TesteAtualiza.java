package br.com.htex.test.usuario;

import java.sql.SQLException;

import br.com.htex.dao.UsuarioDao;
import br.com.htex.model.Usuario;

public class TesteAtualiza {
	public static void main(String[] args) throws SQLException {
		UsuarioDao dao = new UsuarioDao();
		Usuario usuario = dao.buscaPorId(1);
		System.out.println(usuario.getNome() + " " + usuario.getSenha());

		usuario.setNome("Adriano Lucio");
		usuario.setSenha("senhanova");

		dao.atualiza(usuario);
		
		Usuario usuarioAlterado = dao.buscaPorId(1);
		System.out.println(usuarioAlterado);
	}

}
