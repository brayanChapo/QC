package pe.qc.com.validator.negocio.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.negocio.bo.BOEtapa;
import pe.qc.com.validator.negocio.servicio.NEtapa;
import pe.qc.com.validator.persistencia.entity.BEtapa;
import pe.qc.com.validator.persistencia.mapper.MEtapa;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;
import pe.qc.com.validator.util.excepcion.aplicacion.PersistenciaExcepcion;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NEtapaImpl implements NEtapa{
	
	@Autowired
	MEtapa mEtapa;
	
	@Autowired
	@Qualifier("tEtapaEntityBO")
	TransformadorEntityBO<BEtapa, BOEtapa> transformador;
	
	@Override
	public List<BOEtapa> listarEtapa() {
		List<BOEtapa> listaEtapa = new ArrayList<BOEtapa>();
		try{
			listaEtapa = transformador.toBO(mEtapa.listarEtapa());
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e ){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaEtapa;
	}
	
	
	@Override
	public BOEtapa obtenerEtapaXId(Integer id) {
		BOEtapa Etapa = null;
		try{
			Etapa = transformador.toBO(mEtapa.obtenerEtapaXId(id));
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return Etapa;
	}

	@Override
	public BOEtapa obtenerEtapaXNombre(String nombreEtapa) {
		BOEtapa Etapa = null;
		try {
			Etapa = transformador.toBO(mEtapa.obtenerEtapaXNombre(nombreEtapa));
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return Etapa;
	}

	
}
