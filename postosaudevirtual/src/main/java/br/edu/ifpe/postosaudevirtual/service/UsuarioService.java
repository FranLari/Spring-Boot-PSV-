package br.edu.ifpe.postosaudevirtual.service;

import java.util.List;

import br.edu.ifpe.postosaudevirtual.dao.UsuarioDao;
import br.edu.ifpe.postosaudevirtual.model.Usuario;

public class UsuarioService {
	
	UsuarioDao usuariodao = new UsuarioDao();
	public List<Usuario> listar() {
		return usuariodao.listar();
	}
	
	public void alterar(Usuario usuario) {
		usuariodao.alterar(usuario);
	}
	
	public void inserir(Usuario usuario) {
		usuariodao.inserir(usuario);
	}
	
	public void remover(int id) {
		usuariodao.remover(id);
	}
}