package com.totalplay.catalogos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.totalplay.catalogos.dao.SelectDao;
import com.totalplay.catalogos.model.CatalogoModel;

@Service
public class UnidadMedidaService {

	@Autowired
	private SelectDao selectDao;
	
	
	public List<CatalogoModel> getUnidad() {
		return selectDao.getUnidadMedida(0);
	}

	@Transactional
	public CatalogoModel setUnidadMedida(CatalogoModel unidad) {
		selectDao.setUnidad(unidad);
		unidad.setEnabled(true);
		return unidad;
	}
	@Transactional
	public CatalogoModel updateUnidadMedida(CatalogoModel unidad) {
		selectDao.updUnidad(unidad);
		if(unidad.getActivo()== 0) {
			unidad.setEnabled(false);
			unidad.setActivo(null);
		}
		return unidad;
	}
}
