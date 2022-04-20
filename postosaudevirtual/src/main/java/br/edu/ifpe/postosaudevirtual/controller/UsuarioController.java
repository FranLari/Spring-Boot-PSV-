package br.edu.ifpe.postosaudevirtual.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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

}
