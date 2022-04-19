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
import com.totalplay.catalogos.service.PermisoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/tipo-permiso")
public class PermisoController {

	@Autowired
	private PermisoService permisoService;
	
	@GetMapping
	public ResponseEntity<List<CatalogoModel>> getPermiso() throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(permisoService.getPermiso());
	}
	@PostMapping
	public ResponseEntity<CatalogoModel> setPermiso(@RequestBody CatalogoModel permiso) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(permisoService.getPermiso(permiso));
	}
	@PutMapping
	public ResponseEntity<CatalogoModel> updPermiso(@RequestBody CatalogoModel permiso) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(permisoService.updatePermiso(permiso));
	}
}
