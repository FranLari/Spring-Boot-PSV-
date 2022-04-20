package br.edu.ifpe.postosaudevirtual.service;

import java.util.ArrayList;

import br.edu.ifpe.postosaudevirtual.model.Usuario;

public class UsuarioService {
	ArrayList<Usuario>lista= new ArrayList<Usuario>();
	public ArrayList<Usuario> listAllUsuario(){
		Usuario usuario= new Usuario();
		usuario.setCpf("1234");
		usuario.setNome("Hiany");
		
		Usuario usuario1= new Usuario();
		usuario1.setCpf("1234");
		usuario1.setNome("Silva");
		
		
		lista.add(usuario);
		lista.add(usuario1);
		return lista;

		
		
		
		
	}
	
	public void saveUsuario(Usuario usuario) {
		lista.add(usuario);
	}
	

}
