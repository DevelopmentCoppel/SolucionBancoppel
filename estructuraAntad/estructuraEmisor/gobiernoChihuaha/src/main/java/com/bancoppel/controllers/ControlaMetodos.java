package com.bancoppel.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancoppel.entitys.Crud;
import com.bancoppel.services.IControlService;

@RestController
@RequestMapping("/controlador")
@CrossOrigin(origins= {"http://localhost:8081"})
public class ControlaMetodos {
	
	@Autowired
	private IControlService iControlService;

	@GetMapping("/listCruds")
	public List<Crud> listCruds() {
		return iControlService.findAll();
	}	
	
	
	@PostMapping("/createCrud")
	public ResponseEntity<?> create(@Valid @RequestBody Crud crud , BindingResult result){
		Crud crudNew = null;
		Map<String,Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage()).collect(Collectors.toList());
		response.put("errors", errors);
		return new ResponseEntity<Map<String , Object>>(response , HttpStatus.BAD_REQUEST);
		}
		
		try {
			crudNew = iControlService.save(crud);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String , Object>>(response , HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El crud ha sido creado con exito");
		response.put("crud", crud);
		return new ResponseEntity<Map<String , Object>>(response , HttpStatus.CREATED);
		
	}
	
}
