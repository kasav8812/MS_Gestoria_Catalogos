package com.totalplay.catalogos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.totalplay.catalogos.dao.SelectDao;
import com.totalplay.catalogos.model.CatalogoModel;

@Service
@Transactional
public class SolicitudService {

	@Autowired
	private SelectDao selectDao;
	
	
	public List<CatalogoModel> getSolicitud() {
		return selectDao.getSolicitud(0);
	}


	public CatalogoModel setSolicitud(CatalogoModel solicitud) {
		selectDao.setSolicitud(solicitud);
		solicitud.setEnabled(true);
		return solicitud;
	}


	public CatalogoModel updateSolicitud(CatalogoModel solicitud) {
		selectDao.updSolicitud(solicitud);
		if(solicitud.getActivo()== 0) {
			solicitud.setEnabled(false);
			solicitud.setActivo(null);
		}
		return solicitud;
	}
}
