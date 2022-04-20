package br.edu.ifpe.postosaudevirtual.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpe.postosaudevirtual.model.Usuario;
import br.edu.ifpe.postosaudevirtual.service.UsuarioService;

@RestController
@RequestMapping("/usuario")

public class UsuarioController {
	UsuarioService usuarioService = new UsuarioService ();
	@GetMapping ("")
	public List<Usuario>list(){
		return usuarioService.listAllUsuario();
		
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> consultarUsuarioPorId(@PathVariable Integer id){
		try {
			return new ResponseEntity<Usuario>(usuarioService.listAllUsuario().get(id),HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
					
		}
		
	}
	
	@PostMapping("/")
	public void add(@RequestBody Usuario usuario) {
		usuarioService.saveUsuario(usuario);
	}

}
