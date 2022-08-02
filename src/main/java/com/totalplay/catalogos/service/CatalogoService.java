package com.totalplay.catalogos.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totalplay.catalogos.dao.SelectDao;
import com.totalplay.catalogos.model.CatalogoModel;
import com.totalplay.catalogos.model.CentroCostosModel;

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
	
	public List<CatalogoModel> getRegiones() {
		return selectDao.getRegiones();
	}
	
	public List<CatalogoModel> getEstadosByRegion(String id) {
		return selectDao.getEstadosByRegion(id);
	}
	
	public List<CatalogoModel> getActividadesByReq(String id) {
		return selectDao.getActividadesByReq(id);
	}
	
	public List<CatalogoModel> updateEstadosRegion(CatalogoModel[] cat){
		for(CatalogoModel item: cat) {
			selectDao.updateEstadosRegion(item);
		}
		return selectDao.getEstadosByRegion(cat[0].getTpgregion());
	}
	
	public CatalogoModel deleteEstado(CatalogoModel cat){
		selectDao.deleteEstado(cat);
		
		return new CatalogoModel();

	}
	
	public CatalogoModel setRegionEdo(CatalogoModel[] reg) {
		for(CatalogoModel item: reg) {
			selectDao.setRegionEdo(item);
		}
		return selectDao.getEstadosByRegion(reg[0].getTpgregion()).get(0); 
	}
	
	public List<CatalogoModel> getAllMunicipios() {
		return selectDao.getAllMunicipios();
	}
	
	public List<CentroCostosModel> setCC(CentroCostosModel[] reg) {
		List<CentroCostosModel> mTempList = selectDao.getAllCC();
		boolean mIsNew = true;
		
		for(CentroCostosModel item: reg) {
			for(CentroCostosModel mItem: mTempList) {
				if(item.getCc().contains(mItem.getCc())) {
					mIsNew = false;
				}
			}
			if(mIsNew) {
				selectDao.setCC(item);
			}
			
			mIsNew = true;
		}
		return selectDao.getAllCC(); 
	}
	
	public List<CentroCostosModel> getAllCC() {
		return selectDao.getAllCC();
	}
	
	
	public List<CentroCostosModel> getAllCCEnabled() {
		return selectDao.getAllCCEnabled();
	}
	
	public CentroCostosModel updateCC(CentroCostosModel cc) {
		selectDao.updateCC(cc);
		return cc;
	}
	
}
