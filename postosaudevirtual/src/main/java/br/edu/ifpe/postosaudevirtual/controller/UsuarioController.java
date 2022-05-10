package br.edu.ifpe.postosaudevirtual.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import br.edu.ifpe.postosaudevirtual.dao.UsuarioDAO;
import br.edu.ifpe.postosaudevirtual.model.Usuario;
import br.edu.ifpe.postosaudevirtual.service.UsuarioService;

@RestController
@RequestMapping("/usuario")

public class UsuarioController {
	UsuarioService usuarioService = new UsuarioService();
	
	//	UsuarioDAO usuarioDao = new UsuarioDAO();
	
	@GetMapping ("")
	public List<Usuario> List() {
		return usuarioService.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> consultarPessoaPorId(@PathVariable Integer id){
		try {
			return new ResponseEntity<Usuario>(usuarioService.listar().get(id), HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/")
	public void add(@RequestBody Usuario usuario) {
		usuarioService.inserir(usuario);
	}
	
	@DeleteMapping("/r/{id}")
	public void remove(@PathVariable Integer id) {
		usuarioService.remover(id);
	}
	
	@PutMapping("/u")
	public void update(@RequestBody Usuario usuario) {
		usuarioService.alterar(usuario);
	}

}
