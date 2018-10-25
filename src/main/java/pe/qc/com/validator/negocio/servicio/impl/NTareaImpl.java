package pe.qc.com.validator.negocio.servicio.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.negocio.bo.BOTarea;
import pe.qc.com.validator.negocio.servicio.NTarea;
import pe.qc.com.validator.persistencia.entity.BTarea;
import pe.qc.com.validator.persistencia.mapper.MTarea;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.BusinessLogicException;
import pe.qc.com.validator.util.excepcion.DataAccessException;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;
import pe.qc.com.validator.util.excepcion.aplicacion.PersistenciaExcepcion;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NTareaImpl implements NTarea{
	
	@Autowired
	MTarea mTarea;
	
	@Autowired
	@Qualifier("tTareaEntityBO")
	TransformadorEntityBO<BTarea, BOTarea> transformador;
	
	@Override
	public List<BOTarea> listarTarea() {
		List<BOTarea> listaTarea = new ArrayList<BOTarea>();
		try{
			listaTarea = transformador.toBO(mTarea.listarTarea());
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e ){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaTarea;
	}
	
	@Override
	public BOTarea obtenerTareaXId(Integer id) {
		BOTarea Tarea = null;
		try{
			Tarea = transformador.toBO(mTarea.obtenerTareaXId(id));
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return Tarea;
	}

	@Override
	public void insertarTarea(BOTarea Tarea) {
		try {
			System.out.println(transformador.toEntity(Tarea).toString());
			mTarea.insertarTarea(transformador.toEntity(Tarea));
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
	}

	@Override
	public void modificarTarea(BOTarea Tarea) {
		try {
			mTarea.modificarTarea(transformador.toEntity(Tarea));
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
	}

	@Override
	public void eliminarTarea(Integer idTarea) {
		try {
			mTarea.eliminarTarea(idTarea);
		} catch (PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_ELIMINACION_REGISTRO, e);
		} catch (Exception e){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
	}
	
	@Override
	public List<Map<String, Object>> listarMapTarea(Integer idUsuario) {
		List<Map<String, Object>> listaMapTarea = null;
		try {
			listaMapTarea = mTarea.listarMapTarea(idUsuario);
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(
					Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaMapTarea;
	}
	
	@Override
	public List<Map<String, Object>> listarMapTareaxFecha(Date fechaInicio, Date fechaFin) {
		List<Map<String, Object>> listaMapTarea = null;
		try {
			listaMapTarea = mTarea.listarMapTareaReporte(fechaInicio,fechaFin);
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(
					Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaMapTarea;
	}
}
