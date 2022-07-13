package com.totalplay.catalogos.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.totalplay.catalogos.model.CatalogoModel;
import com.totalplay.catalogos.service.CatalogoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/catalogo")
public class CatalogoController {

	@Autowired
	private CatalogoService catalogoService;
	
	@GetMapping
	public ResponseEntity<Map<String, Object>> catalogos() throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(catalogoService.getCatalogos());
	}
	
	@GetMapping("/municipio/{id}")
	public ResponseEntity<List<CatalogoModel>> catalogos(@PathVariable(required = true, name = "id") Integer id) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(catalogoService.getMunicipio(id));
	}
	
	@GetMapping("/regiones")
	public ResponseEntity<List<CatalogoModel>> getRegiones() throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(catalogoService.getRegiones());
	}
	
	@GetMapping("/getEstadosByRegion/{id}")
	public ResponseEntity<List<CatalogoModel>> getEstadosByRegion(@PathVariable (required = true, name = "id") String id) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(catalogoService.getEstadosByRegion(id));
	}
}