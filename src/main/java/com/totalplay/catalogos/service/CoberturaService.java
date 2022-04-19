package com.totalplay.catalogos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.totalplay.catalogos.dao.SelectDao;
import com.totalplay.catalogos.model.CatalogoModel;

@Service
@Transactional
public class CoberturaService {

	@Autowired
	private SelectDao selectDao;
	
	
	public List<CatalogoModel> getCobertura() {
		return selectDao.getCobertura(0);
	}


	public CatalogoModel setCoberturad(CatalogoModel cobertura) {
		selectDao.setCobertura(cobertura);
		cobertura.setEnabled(true);
		return cobertura;
	}


	public CatalogoModel updateCobertura(CatalogoModel cobertura) {
		selectDao.updCobertura(cobertura);
		if(cobertura.getActivo()== 0) {
			cobertura.setEnabled(false);
			cobertura.setActivo(null);
		}
		return cobertura;
	}
}
