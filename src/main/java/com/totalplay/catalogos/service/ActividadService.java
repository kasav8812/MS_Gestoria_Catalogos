package com.totalplay.catalogos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.totalplay.catalogos.dao.SelectDao;
import com.totalplay.catalogos.model.CatalogoModel;

@Service
@Transactional
public class ActividadService {

	@Autowired
	private SelectDao selectDao;
	
	
	public List<CatalogoModel> getActividad() {
		return selectDao.getActividad(0);
	}


	public CatalogoModel setActividad(CatalogoModel actividad) {
		selectDao.setActividad(actividad);
		actividad.setEnabled(true);
		return actividad;
	}


	public CatalogoModel updateActividad(CatalogoModel actividad) {
		selectDao.updActividad(actividad);
		if(actividad.getActivo()== 0) {
			actividad.setEnabled(false);
			actividad.setActivo(null);
		}
		return actividad;
	}

}
