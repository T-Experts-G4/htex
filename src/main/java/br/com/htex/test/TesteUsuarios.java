package br.com.htex.test;

import java.sql.SQLException;
import java.util.List;

import br.com.htex.dao.UsuarioDao;
import br.com.htex.model.Usuario;



public class TesteUsuarios {

	public static void main(String[] args) throws SQLException {
		
		//Cria usuario
		
//		UsuarioDao insereUsuarios = new UsuarioDAO();
//		Usuario user = new Usuario("Adriano","senha4");
//		insereUsuarios.insereUsuario(user);
//		
		System.out.println("    ");
		System.out.println("    ");
		
		//Lista Usuario
		
		List<Usuario> usuarios = new UsuarioDao().lista();
		usuarios.forEach(usuario -> System.out.println(usuario));
		
		System.out.println("    ");
		System.out.println("    ");
		
//      Atualiza usuario
		
//		UsuarioDao dao = new UsuarioDao();
//		Usuario usuario = dao.buscaPor(1);
//		
//		System.out.println(usuario);
//
//		usuario.setNome("NovoNome");
//		usuario.setSenha("senhanova");
//		
//		dao.atualizaUsuario(usuario);
//		
//		Usuario usuarioAlterado = dao.buscaPor(10);
//		System.out.println(usuarioAlterado);
		
		//Deleta usuario
//		UsuarioDao dao = new UsuarioDao();
//		dao.deletaUsuario(3);
	
	
		}

}
