package pe.qc.com.validator.negocio.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.negocio.bo.BODetalleSolicitud;
import pe.qc.com.validator.negocio.servicio.NDetalleSolicitud;
import pe.qc.com.validator.persistencia.entity.BDetalleSolicitud;
import pe.qc.com.validator.persistencia.mapper.MDetalleSolicitud;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;
import pe.qc.com.validator.util.excepcion.aplicacion.PersistenciaExcepcion;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NDetalleSolicitudImpl implements NDetalleSolicitud{
	
	@Autowired
	MDetalleSolicitud mDetalleSolicitud;
	
	@Autowired
	@Qualifier("tDetalleSolicitudEntityBO")
	TransformadorEntityBO<BDetalleSolicitud, BODetalleSolicitud> transformador;
	
	
	@Override
	public BODetalleSolicitud obtenerDetalleSolicitudXId(Integer id) {
		BODetalleSolicitud DetalleSolicitud = null;
		try{
			DetalleSolicitud = transformador.toBO(mDetalleSolicitud.obtenerDetalleSolicitudXId(id));
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return DetalleSolicitud;
	}


	@Override
	public void insertarDetalleSolicitud(BODetalleSolicitud DetalleSolicitud) {
		try {
			mDetalleSolicitud.insertarDetalleSolicitud(transformador.toEntity(DetalleSolicitud));
		} catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_INSERCION_REGISTRO, e);
		} catch(Exception e){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
	}

	@Override
	public void modificarDetalleSolicitud(BODetalleSolicitud DetalleSolicitud) {
		try {
			mDetalleSolicitud.modificarDetalleSolicitud(transformador.toEntity(DetalleSolicitud));
		} catch (PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_MODIFICACION_REGISTRO, e);
		} catch (Exception e){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
	}
	
	@Override
	public int obtenerUltimoRegistroDetalle(){
		Integer idUltimo;
		try {
			idUltimo = mDetalleSolicitud.obtenerUltimoIdDetalleSolicitud();
		} catch (PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_MODIFICACION_REGISTRO, e);
		} catch (Exception e){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return idUltimo;
	}
	
}
