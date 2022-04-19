package com.totalplay.catalogos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.totalplay.catalogos.dao.SelectDao;
import com.totalplay.catalogos.model.CatalogoModel;

@Service
public class AreaService {

	@Autowired
	private SelectDao selectDao;
	
	
	public List<CatalogoModel> getArea() {
		return selectDao.getArea(0);
	}

	@Transactional
	public CatalogoModel setArea(CatalogoModel area) {	
		selectDao.setArea(area);
		area.setEnabled(true);
		return area;
	}
	@Transactional
	public CatalogoModel updateArea(CatalogoModel area) {
		selectDao.updArea(area);
		if(area.getActivo()== 0) {
			area.setEnabled(false);
			area.setActivo(null);
		}
		return area;
	}
}
