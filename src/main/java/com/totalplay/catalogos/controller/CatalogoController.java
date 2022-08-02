package com.totalplay.catalogos.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.totalplay.catalogos.model.CatalogoModel;
import com.totalplay.catalogos.model.CentroCostosModel;

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
	
	
	@GetMapping("/getActividadesByReq/{id}")
	public ResponseEntity<List<CatalogoModel>> getActividadesByReq(@PathVariable(required = true, name = "id") String id) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(catalogoService.getActividadesByReq(id));
	}
	
	@PostMapping("/updateEstados")
	public ResponseEntity<List<CatalogoModel>> updateEstadosRegion(@RequestBody CatalogoModel[] cat) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(catalogoService.updateEstadosRegion(cat));
	}
	
	
	@PostMapping("/deleteEstado")
	public ResponseEntity<CatalogoModel> deleteEstado(@RequestBody CatalogoModel cat) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(catalogoService.deleteEstado(cat));
	}
	
	
	@PostMapping("/setRegionEdo")
	public ResponseEntity<CatalogoModel> setRegionEdo(@RequestBody CatalogoModel[] cat) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(catalogoService.setRegionEdo(cat));
	}
	
	@GetMapping("/allmunicipio")
	public ResponseEntity<List<CatalogoModel>> getAllMunicipios() throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(catalogoService.getAllMunicipios());
	}
	

	@PostMapping("/setCC")
	public ResponseEntity<List<CentroCostosModel>> setCC(@RequestBody CentroCostosModel[] cat) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(catalogoService.setCC(cat));
	}
	
	@GetMapping("/getAllCC")
	public ResponseEntity<List<CentroCostosModel>> getAllCC() throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(catalogoService.getAllCC());
	}
	
	@GetMapping("/getAllCCEnabled")
	public ResponseEntity<List<CentroCostosModel>> getAllCCEnabled() throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(catalogoService.getAllCCEnabled());
	}
	
	
	@PostMapping("/updateCC")
	public ResponseEntity<CentroCostosModel> updateCC(@RequestBody CentroCostosModel cat) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(catalogoService.updateCC(cat));
	}
	
	
}