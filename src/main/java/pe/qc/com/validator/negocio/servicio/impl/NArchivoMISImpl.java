package pe.qc.com.validator.negocio.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.negocio.bo.BOArchivoMIS;
import pe.qc.com.validator.negocio.servicio.NArchivoMIS;
import pe.qc.com.validator.persistencia.entity.BArchivoMIS;
import pe.qc.com.validator.persistencia.mapper.MArchivoMIS;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.BusinessLogicException;
import pe.qc.com.validator.util.excepcion.DataAccessException;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;
import pe.qc.com.validator.util.excepcion.aplicacion.PersistenciaExcepcion;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NArchivoMISImpl implements NArchivoMIS{
	
	@Autowired
	MArchivoMIS mArchivoMIS;
	
	@Autowired
	@Qualifier("tArchivoMISEntityBO")
	TransformadorEntityBO<BArchivoMIS, BOArchivoMIS> transformador;
	
	@Override
	public List<BOArchivoMIS> listarArchivoMIS() {
		List<BOArchivoMIS> listaArchivoMIS = new ArrayList<BOArchivoMIS>();
		try{
			listaArchivoMIS = transformador.toBO(mArchivoMIS.listarArchivoMIS());
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e ){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaArchivoMIS;
	}

	@Override
	public BOArchivoMIS obtenerArchivoMISXId(Integer id) {
		BOArchivoMIS boArchivoMIS = null;
		try{
			boArchivoMIS = transformador.toBO(mArchivoMIS.obtenerArchivoMISXId(id));
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return boArchivoMIS;
	}
	
	@Override
	public BOArchivoMIS obtenerArchivoMISXTK(String tkMIS) {
		BOArchivoMIS boArchivoMIS = null;
		try{
			boArchivoMIS = transformador.toBO(mArchivoMIS.obtenerArchivoMISXTK(tkMIS));
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return boArchivoMIS;
	}

	@Override
	public void insertarArchivoMIS(BOArchivoMIS ArchivoMIS) {
		try {
			mArchivoMIS.insertarArchivoMIS(transformador.toEntity(ArchivoMIS));
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
	}

	@Override
	public void convertirAHistoricoArchivoMIS(Integer idArchivoMIS) {
		try {
			mArchivoMIS.convertirAHistoricoArchivoMIS(idArchivoMIS);
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
	}
	
	@Override
	public List<BOArchivoMIS> listarArchivoMISNoFinalizados(String tkMIS) {
		List<BOArchivoMIS> listaArchivoMIS = new ArrayList<BOArchivoMIS>();
		try{
			listaArchivoMIS = transformador.toBO(mArchivoMIS.listarArchivoMISNoFinalizados(tkMIS));
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e ){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaArchivoMIS;
	}
	
	@Override
	public List<BOArchivoMIS> listarArchivoMISHistorico(Integer idArchivoMIS) {
		List<BOArchivoMIS> listaArchivoMISHistorico = new ArrayList<>();
		BOArchivoMIS boArchivoMis = new BOArchivoMIS();
		try {
			if(idArchivoMIS!=0) {
				while (idArchivoMIS!=null) {
					boArchivoMis =transformador.toBO(mArchivoMIS.obtenerArchivoMISXId(idArchivoMIS));
					idArchivoMIS = boArchivoMis.getIdHistoricoMIS();
					listaArchivoMISHistorico.add(boArchivoMis);
				}
			}
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e ){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaArchivoMISHistorico;
	}
}
