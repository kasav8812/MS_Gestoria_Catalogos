package com.totalplay.catalogos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.totalplay.catalogos.dao.SelectDao;
import com.totalplay.catalogos.model.CatalogoModel;

@Service
public class EstadoService {

	@Autowired
	private SelectDao selectDao;
	
	
	public List<CatalogoModel> getEstados() {
		return selectDao.getEstados(0);
	}
	
	@Transactional
	public CatalogoModel setEstados(CatalogoModel estado) {
		selectDao.updEstado(estado);
		return estado;
	}
}
