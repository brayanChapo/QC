package pe.qc.com.validator.negocio.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.negocio.bo.BOArchivoRutas;
import pe.qc.com.validator.negocio.servicio.NArchivoRutas;
import pe.qc.com.validator.persistencia.entity.BArchivoRutas;
import pe.qc.com.validator.persistencia.mapper.MArchivoRutas;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.BusinessLogicException;
import pe.qc.com.validator.util.excepcion.DataAccessException;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;
import pe.qc.com.validator.util.excepcion.aplicacion.PersistenciaExcepcion;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NArchivoRutasImpl implements NArchivoRutas{
	
	@Autowired
	MArchivoRutas mArchivoRutas;
	
	@Autowired
	@Qualifier("tArchivoRutasEntityBO")
	TransformadorEntityBO<BArchivoRutas, BOArchivoRutas> transformador;
	
	@Override
	public List<BOArchivoRutas> listarArchivoRutas() {
		List<BOArchivoRutas> listaArchivoRutas = new ArrayList<BOArchivoRutas>();
		try{
			listaArchivoRutas = transformador.toBO(mArchivoRutas.listarArchivoRutas());
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e ){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaArchivoRutas;
	}
	
	@Override
	public List<BOArchivoRutas> listarRutaxServidor(String servidorValidatorRutas) {
		List<BOArchivoRutas> listaArchivoRutas = new ArrayList<BOArchivoRutas>();
		try{
			listaArchivoRutas = transformador.toBO(mArchivoRutas.listarRutaxServidor(servidorValidatorRutas+"%"));
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e ){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaArchivoRutas;
	}
	
	@Override
	public BOArchivoRutas obtenerRutaxRuta(String rutaValidatorRutas,String servidorValidatorRutas) {
		BOArchivoRutas ArchivoRutas = null;
		try{
			ArchivoRutas = transformador.toBO(mArchivoRutas.obtenerRutaxRuta(rutaValidatorRutas,servidorValidatorRutas));
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return ArchivoRutas;
	}


	@Override
	public void insertarArchivoRuta(BOArchivoRutas ArchivoRutas) {
		try {
			mArchivoRutas.insertarRuta(transformador.toEntity(ArchivoRutas));
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
	}

	@Override
	public void modificarArchivoRuta(BOArchivoRutas ArchivoRutas) {
		try {
			mArchivoRutas.modificarRuta(transformador.toEntity(ArchivoRutas));
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
	}

	@Override
	public void eliminarArchivoRuta(Integer idArchivoRutas) {
		try {
			mArchivoRutas.eliminarRuta(idArchivoRutas);
		} catch (PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_ELIMINACION_REGISTRO, e);
		} catch (Exception e){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
	}
	
	
	
}
