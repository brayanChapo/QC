package pe.qc.com.validator.negocio.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.negocio.bo.BODominio;
import pe.qc.com.validator.negocio.servicio.NDominio;
import pe.qc.com.validator.persistencia.entity.BDominio;
import pe.qc.com.validator.persistencia.mapper.MDominio;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.BusinessLogicException;
import pe.qc.com.validator.util.excepcion.DataAccessException;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;
import pe.qc.com.validator.util.excepcion.aplicacion.PersistenciaExcepcion;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NDominioImpl implements NDominio{
	
	@Autowired
	MDominio mDominio;
	
	@Autowired
	@Qualifier("tDominioEntityBO")
	TransformadorEntityBO<BDominio, BODominio> transformador;
	
	@Override
	public List<BODominio> listarDominio() {
		List<BODominio> listaDominio = new ArrayList<BODominio>();
		try{
			listaDominio = transformador.toBO(mDominio.listarDominio());
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e ){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaDominio;
	}
	
	@Override
	public List<BODominio> listarDominioXNombre(String nombreDominio) {
		List<BODominio> listaDominio = new ArrayList<BODominio>();
		try{
			listaDominio = transformador.toBO(mDominio.listarDominioXNombre(nombreDominio+"%"));
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e ){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaDominio;
	}

	@Override
	public BODominio obtenerDominioXId(Integer id) {
		BODominio Dominio = null;
		try{
			Dominio = transformador.toBO(mDominio.obtenerDominioXId(id));
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return Dominio;
	}

	@Override
	public BODominio obtenerDominioXNombre(String nombreDominio) {
		BODominio Dominio = null;
		try {
			Dominio = transformador.toBO(mDominio.obtenerDominioXNombre(nombreDominio));
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return Dominio;
	}

	@Override
	public void insertarDominio(BODominio Dominio) {
		try {

			System.out.println("VERDAD  : " + Dominio.toString());
			mDominio.insertarDominio(transformador.toEntity(Dominio));
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
	}

	@Override
	public void modificarDominio(BODominio Dominio) {
		try {
			System.out.println("VERDAAAAAAAAAAAAAD : " + (transformador.toEntity(Dominio)).toString());
			mDominio.modificarDominio(transformador.toEntity(Dominio));
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
	}

	@Override
	public void eliminarDominio(Integer idDominio) {
		try {
			mDominio.eliminarDominio(idDominio);
		} catch (PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_ELIMINACION_REGISTRO, e);
		} catch (Exception e){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
	}
	
}
