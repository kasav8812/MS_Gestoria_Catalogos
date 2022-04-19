package com.totalplay.catalogos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.totalplay.catalogos.model.CatalogoModel;
import com.totalplay.catalogos.service.EstadoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/estado-requerimiento")
public class EstadoController {

	@Autowired
	private EstadoService estadoService;
	
	@GetMapping
	public ResponseEntity<List<CatalogoModel>> getEstados() throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(estadoService.getEstados());
	}
	
	@PutMapping
	public ResponseEntity<CatalogoModel> getEstados(@RequestBody CatalogoModel estado) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(estadoService.setEstados(estado));
	}
}
