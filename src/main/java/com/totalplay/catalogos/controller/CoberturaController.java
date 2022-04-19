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
import com.totalplay.catalogos.service.CoberturaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/cobertura")
public class CoberturaController {

	@Autowired
	private CoberturaService coberturaService;
	
	@GetMapping
	public ResponseEntity<List<CatalogoModel>> getCatalogos() throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(coberturaService.getCobertura());
	}
	
	@PostMapping
	public ResponseEntity<CatalogoModel> setCatalogos(@RequestBody CatalogoModel cobertura) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(coberturaService.setCoberturad(cobertura));
	}
	
	@PutMapping
	public ResponseEntity<CatalogoModel> catalogos(@RequestBody CatalogoModel cobertura) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(coberturaService.updateCobertura(cobertura));
	}
}
