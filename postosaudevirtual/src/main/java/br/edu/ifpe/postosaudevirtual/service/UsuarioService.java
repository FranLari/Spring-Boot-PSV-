package br.edu.ifpe.postosaudevirtual.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestBody;

import br.edu.ifpe.postosaudevirtual.dao.UsuarioDAO;
import br.edu.ifpe.postosaudevirtual.model.Usuario;

public class UsuarioService {
	UsuarioDAO usuariodao = new UsuarioDAO();
	public void saveUsuario(Usuario usuario) throws ClassNotFoundException, SQLException {
		usuariodao.adiciona(usuario);
	}
	public void listAllUsuario(Usuario usuario){
		
	}
}
	