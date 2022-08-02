package com.totalplay.catalogos.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.totalplay.catalogos.model.CatalogoModel;

import com.totalplay.catalogos.model.CentroCostosModel;
import com.totalplay.catalogos.model.StatsuVo;

@Mapper
public interface SelectDao {

	public StatsuVo getStatus();

	List<CatalogoModel> getUnidadMedida(@Param("enabledcat") Integer enabledcat);

	List<CatalogoModel> getEstados(@Param("enabledcat") Integer enabledcat);

	List<CatalogoModel> getPermiso(@Param("enabledcat") Integer enabledcat);

	List<CatalogoModel> getArea(@Param("enabledcat") Integer enabledcat);

	List<CatalogoModel> getUbicacion(@Param("enabledcat") Integer enabledcat);

	List<CatalogoModel> getSolicitud(@Param("enabledcat") Integer enabledcat);

	List<CatalogoModel> getCobertura(@Param("enabledcat") Integer enabledcat);

	List<CatalogoModel> getActividad(@Param("enabledcat") Integer enabledcat);

	List<CatalogoModel> getMunicipio(@Param("id") Integer id);
	
	List<CatalogoModel> getRegiones();
	
	
	
	List<CatalogoModel> getEstadosByRegion(@Param("id") String id);


	int setArea(@Param("area") CatalogoModel area);

	int updArea(@Param("area") CatalogoModel area);

	public void updEstado(@Param("estado") CatalogoModel estado);

	public void setPermiso(@Param("permiso") CatalogoModel permiso);

	public void updPermiso(@Param("permiso") CatalogoModel permiso);

	public void setUnidad(@Param("unidad") CatalogoModel unidad);

	public void updUnidad(@Param("unidad") CatalogoModel unidad);

	public void setSolicitud(@Param("solicitud") CatalogoModel solicitud);

	public void updSolicitud(@Param("solicitud") CatalogoModel solicitud);

	public void setCobertura(@Param("cobertura") CatalogoModel cobertura);

	public void updCobertura(@Param("cobertura") CatalogoModel cobertura);

	public void setActividad(@Param("actividad") CatalogoModel actividad);

	public void updActividad(@Param("actividad") CatalogoModel actividad);
	
	public List<CatalogoModel> getActividadesByReq(@Param("id") String id);
	
	public void updateEstadosRegion(@Param("cat") CatalogoModel cat);
	
	public void deleteEstado(@Param("cat")CatalogoModel cat);
	
	public void setRegionEdo(@Param("reg")CatalogoModel reg);

	List<CatalogoModel> getAllMunicipios();

	List<CentroCostosModel> getAllCC();
	
	public void setCC(@Param("cc")CentroCostosModel reg);

	List<CentroCostosModel> getAllCCEnabled();

	public void updateCC(@Param("cc")CentroCostosModel reg);

	
	
}
