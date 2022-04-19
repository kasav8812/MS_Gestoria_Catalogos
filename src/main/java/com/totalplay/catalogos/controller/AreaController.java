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
import com.totalplay.catalogos.service.AreaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/area-solitante")
public class AreaController {

	@Autowired
	private AreaService areaService;
	
	@GetMapping
	public ResponseEntity<List<CatalogoModel>> getCatalogos() throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(areaService.getArea());
	}
	
	@PostMapping
	public ResponseEntity<CatalogoModel> setCatalogos(@RequestBody CatalogoModel area) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(areaService.setArea(area));
	}
	
	@PutMapping
	public ResponseEntity<CatalogoModel> catalogos(@RequestBody CatalogoModel area) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(areaService.updateArea(area));
	}
	
	
}
