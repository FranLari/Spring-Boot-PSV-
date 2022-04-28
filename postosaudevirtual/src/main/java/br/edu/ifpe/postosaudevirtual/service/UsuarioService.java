package br.edu.ifpe.postosaudevirtual.service;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpe.postosaudevirtual.dao.UsuarioDAO;
import br.edu.ifpe.postosaudevirtual.model.Usuario;

public class UsuarioService {
	UsuarioDAO usuariodao = new UsuarioDAO();
	public List<Usuario> consultarTodosUsuarios() throws ClassNotFoundException, SQLException {
		return usuariodao.consultarTodosUsuarios();
	}
	
	public void adiciona(Usuario usuario) throws ClassNotFoundException, SQLException {
		usuariodao.adiciona(usuario);
	}
	
	public void alterarUsuarioDAO(Usuario usuario) throws ClassNotFoundException, SQLException {
		usuariodao.alterarUsuarioDAO(usuario);
	}
	
	public void deletarUsuarioDAO(int id) throws ClassNotFoundException, SQLException {
		usuariodao.deletarUsuarioDAO(id);
	}
}
	