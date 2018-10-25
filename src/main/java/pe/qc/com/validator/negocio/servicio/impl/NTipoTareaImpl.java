package pe.qc.com.validator.negocio.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.negocio.bo.BOTipoTarea;
import pe.qc.com.validator.negocio.servicio.NTipoTarea;
import pe.qc.com.validator.persistencia.entity.BTipoTarea;
import pe.qc.com.validator.persistencia.mapper.MTipoTarea;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;
import pe.qc.com.validator.util.excepcion.aplicacion.PersistenciaExcepcion;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NTipoTareaImpl implements NTipoTarea{
	
	@Autowired
	MTipoTarea mTipoTarea;
	
	@Autowired
	@Qualifier("tTipoTareaEntityBO")
	TransformadorEntityBO<BTipoTarea, BOTipoTarea> transformador;
	
	@Override
	public List<BOTipoTarea> listarTipoTarea() {
		List<BOTipoTarea> listaTipoTarea = new ArrayList<BOTipoTarea>();
		try{
			listaTipoTarea = transformador.toBO(mTipoTarea.listarTipoTarea());
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e ){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaTipoTarea;
	}
	
	
	@Override
	public BOTipoTarea obtenerTipoTareaXId(Integer id) {
		BOTipoTarea TipoTarea = null;
		try{
			TipoTarea = transformador.toBO(mTipoTarea.obtenerTipoTareaXId(id));
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return TipoTarea;
	}

	@Override
	public BOTipoTarea obtenerTipoTareaXNombre(String nombreTipoTarea) {
		BOTipoTarea TipoTarea = null;
		try {
			TipoTarea = transformador.toBO(mTipoTarea.obtenerTipoTareaXNombre(nombreTipoTarea));
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return TipoTarea;
	}

	
}
