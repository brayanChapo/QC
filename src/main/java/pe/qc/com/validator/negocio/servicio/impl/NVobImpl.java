package pe.qc.com.validator.negocio.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.negocio.bo.BOVob;
import pe.qc.com.validator.negocio.servicio.NVob;
import pe.qc.com.validator.persistencia.entity.BVob;
import pe.qc.com.validator.persistencia.mapper.MVob;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.BusinessLogicException;
import pe.qc.com.validator.util.excepcion.DataAccessException;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;
import pe.qc.com.validator.util.excepcion.aplicacion.PersistenciaExcepcion;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NVobImpl implements NVob{
	
	@Autowired
	MVob mVob;
	
	@Autowired
	@Qualifier("tVobEntityBO")
	TransformadorEntityBO<BVob, BOVob> transformador;
	
	@Override
	public List<BOVob> listarVob() {
		List<BOVob> listaVob = new ArrayList<BOVob>();
		try{
			listaVob = transformador.toBO(mVob.listarVob());
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e ){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaVob;
	}
	
	@Override
	public List<BOVob> listarVobXNombre(String nombreVob) {
		List<BOVob> listaVob = new ArrayList<BOVob>();
		try{
			listaVob = transformador.toBO(mVob.listarVobXNombre(nombreVob+"%"));
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e ){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaVob;
	}
	
	@Override
	public BOVob obtenerVobXId(Integer id) {
		BOVob Vob = null;
		try{
			Vob = transformador.toBO(mVob.obtenerVobXId(id));
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return Vob;
	}

	@Override
	public BOVob obtenerVobXNombre(String nombreVob) {
		BOVob Vob = null;
		try {
			Vob = transformador.toBO(mVob.obtenerVobXNombre(nombreVob));
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return Vob;
	}

	@Override
	public void insertarVob(BOVob Vob) {
		try {
			System.out.println("VERDAAAAAAAAAAAAAD : " + (transformador.toEntity(Vob)).toString());
			mVob.insertarVob(transformador.toEntity(Vob));
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
	}

	@Override
	public void modificarVob(BOVob Vob) {
		try {
			System.out.println("VERDAAAAAAAAAAAAAD : " + (transformador.toEntity(Vob)).toString());
			mVob.modificarVob(transformador.toEntity(Vob));
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
	}

	@Override
	public void eliminarVob(Integer idVob) {
		try {
			mVob.eliminarVob(idVob);
		} catch (PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_ELIMINACION_REGISTRO, e);
		} catch (Exception e){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
	}
	
	
	
}
