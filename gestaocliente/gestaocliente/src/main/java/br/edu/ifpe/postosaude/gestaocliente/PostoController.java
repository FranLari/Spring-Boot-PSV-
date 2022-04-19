package br.edu.ifpe.postosaude.gestaocliente;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostoController {
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

}
