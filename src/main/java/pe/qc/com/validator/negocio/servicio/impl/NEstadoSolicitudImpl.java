package pe.qc.com.validator.negocio.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.negocio.bo.BOEstadoSolicitud;
import pe.qc.com.validator.negocio.servicio.NEstadoSolicitud;
import pe.qc.com.validator.persistencia.entity.BEstadoSolicitud;
import pe.qc.com.validator.persistencia.mapper.MEstadoSolicitud;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;
import pe.qc.com.validator.util.excepcion.aplicacion.PersistenciaExcepcion;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NEstadoSolicitudImpl implements NEstadoSolicitud{
	
	@Autowired
	MEstadoSolicitud mEstadoSolicitud;
	
	@Autowired
	@Qualifier("tEstadoSolicitudEntityBO")
	TransformadorEntityBO<BEstadoSolicitud, BOEstadoSolicitud> transformador;
	
	@Override
	public List<BOEstadoSolicitud> listarEstadoSolicitud() {
		List<BOEstadoSolicitud> listaEstadoSolicitud = new ArrayList<BOEstadoSolicitud>();
		try{
			listaEstadoSolicitud = transformador.toBO(mEstadoSolicitud.listarEstadoSolicitud());
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e ){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaEstadoSolicitud;
	}
	
	@Override
	public BOEstadoSolicitud obtenerEstadoSolicitudXId(Integer id) {
		BOEstadoSolicitud EstadoSolicitud = null;
		try{
			EstadoSolicitud = transformador.toBO(mEstadoSolicitud.obtenerEstadoSolicitudXId(id));
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return EstadoSolicitud;
	}

	@Override
	public BOEstadoSolicitud obtenerEstadoSolicitudXNombre(String nombreEstadoSolicitud) {
		BOEstadoSolicitud EstadoSolicitud = null;
		try {
			EstadoSolicitud = transformador.toBO(mEstadoSolicitud.obtenerEstadoSolicitudXNombre(nombreEstadoSolicitud));
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return EstadoSolicitud;
	}

}
