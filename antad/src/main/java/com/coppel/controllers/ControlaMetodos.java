package com.coppel.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controlador")
@CrossOrigin(origins= {"http://localhost:8085"})
public class ControlaMetodos {

	
	
	@GetMapping("/prueba")
	public String metodoPrueba() {
		return "pruebisimaaaaaa";
	}
	
}
