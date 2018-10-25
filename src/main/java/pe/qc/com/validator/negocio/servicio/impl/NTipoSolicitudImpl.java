package pe.qc.com.validator.negocio.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.negocio.bo.BOTipoSolicitud;
import pe.qc.com.validator.negocio.servicio.NTipoSolicitud;
import pe.qc.com.validator.persistencia.entity.BTipoSolicitud;
import pe.qc.com.validator.persistencia.mapper.MTipoSolicitud;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;
import pe.qc.com.validator.util.excepcion.aplicacion.PersistenciaExcepcion;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NTipoSolicitudImpl implements NTipoSolicitud{
	
	@Autowired
	MTipoSolicitud mTipoSolicitud;
	
	@Autowired
	@Qualifier("tTipoSolicitudEntityBO")
	TransformadorEntityBO<BTipoSolicitud, BOTipoSolicitud> transformador;
	
	@Override
	public List<BOTipoSolicitud> listarTipoSolicitud() {
		List<BOTipoSolicitud> listaTipoSolicitud = new ArrayList<BOTipoSolicitud>();
		try{
			listaTipoSolicitud = transformador.toBO(mTipoSolicitud.listarTipoSolicitud());
			System.out.println("tipo: "+ listaTipoSolicitud.toString());
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e ){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaTipoSolicitud;
	}
	
	@Override
	public BOTipoSolicitud obtenerTipoSolicitudXId(Integer id) {
		BOTipoSolicitud TipoSolicitud = null;
		try{
			TipoSolicitud = transformador.toBO(mTipoSolicitud.obtenerTipoSolicitudXId(id));
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return TipoSolicitud;
	}

	@Override
	public BOTipoSolicitud obtenerTipoSolicitudXNombre(String nombreTipoSolicitud) {
		BOTipoSolicitud TipoSolicitud = null;
		try {
			TipoSolicitud = transformador.toBO(mTipoSolicitud.obtenerTipoSolicitudXNombre(nombreTipoSolicitud));
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return TipoSolicitud;
	}

}
