package com.totalplay.catalogos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.totalplay.catalogos.dao.SelectDao;
import com.totalplay.catalogos.model.CatalogoModel;

@Service
public class PermisoService {

	@Autowired
	private SelectDao selectDao;
	
	
	public List<CatalogoModel> getPermiso() {
		return selectDao.getPermiso(0);
	}

	@Transactional
	public CatalogoModel getPermiso(CatalogoModel permiso) {
		selectDao.setPermiso(permiso);
		permiso.setEnabled(true);
		return permiso;
	}
	@Transactional
	public CatalogoModel updatePermiso(CatalogoModel permiso) {
		selectDao.updPermiso(permiso);
		if(permiso.getActivo()== 0) {
			permiso.setEnabled(false);
			permiso.setActivo(null);
		}
		return permiso;
	}
}
