package co.mz.ibi.backenddeveloperchallenge.paisesApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 * Um simples controller para validar disponibilidade da API
 *
 */
@RestController
@RequestMapping("/")
public class HelloController {
	
	@GetMapping
	public String welcome() {
		return "Welcome to 2iBi RestFull API Java Challenge 2021";
	}

}
