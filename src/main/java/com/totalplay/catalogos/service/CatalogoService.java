package com.totalplay.catalogos.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totalplay.catalogos.dao.SelectDao;
import com.totalplay.catalogos.model.CatalogoModel;

@Service
public class CatalogoService {

	@Autowired
	private SelectDao selectDao;
	
	
	public Map<String, Object> getCatalogos(){
		Map<String, Object> catalogos = new HashMap<>();
		catalogos.put("unidaMedida", selectDao.getUnidadMedida(1));
		catalogos.put("estados", selectDao.getEstados(1));
		catalogos.put("tipoPermiso", selectDao.getPermiso(1));
		catalogos.put("areaSolitante", selectDao.getArea(1));
		catalogos.put("ubicacion", selectDao.getUbicacion(1));
		return catalogos;
	}
	
	public List<CatalogoModel> getMunicipio(Integer id) {
		return selectDao.getMunicipio(id);
	}
	
}
