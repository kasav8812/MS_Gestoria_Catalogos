package com.totalplay.catalogos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.totalplay.catalogos.model.CatalogoModel;
import com.totalplay.catalogos.service.UnidadMedidaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/unidad-medida")
public class UnidadMedidaController {

	@Autowired
	private UnidadMedidaService unidadMedidaService;
	
	@GetMapping
	public ResponseEntity<List<CatalogoModel>> getUnidad() throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(unidadMedidaService.getUnidad());
	}
	@PostMapping
	public ResponseEntity<CatalogoModel> setUnidadMedida(@RequestBody CatalogoModel unidad) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(unidadMedidaService.setUnidadMedida(unidad));
	}
	@PutMapping
	public ResponseEntity<CatalogoModel> updateUnidadMedida(@RequestBody CatalogoModel permiso) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(unidadMedidaService.updateUnidadMedida(permiso));
	}
}
