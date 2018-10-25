package pe.qc.com.validator.negocio.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.negocio.bo.BOArea;
import pe.qc.com.validator.negocio.servicio.NArea;
import pe.qc.com.validator.persistencia.entity.BArea;
import pe.qc.com.validator.persistencia.mapper.MArea;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;
import pe.qc.com.validator.util.excepcion.aplicacion.PersistenciaExcepcion;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NAreaImpl implements NArea{
	
	@Autowired
	MArea mArea;
	
	@Autowired
	@Qualifier("tAreaEntityBO")
	TransformadorEntityBO<BArea, BOArea> transformador;
	
	@Override
	public List<BOArea> listarArea() {
		List<BOArea> listaArea = new ArrayList<BOArea>();
		try{
			listaArea = transformador.toBO(mArea.listarArea());
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e ){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaArea;
	}
	
	@Override
	public BOArea obtenerAreaXId(Integer id) {
		BOArea Area = null;
		try{
			Area = transformador.toBO(mArea.obtenerAreaXId(id));
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return Area;
	}

	@Override
	public BOArea obtenerAreaXNombre(String nombreArea) {
		BOArea Area = null;
		try {
			Area = transformador.toBO(mArea.obtenerAreaXNombre(nombreArea));
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return Area;
	}

}
