package pe.qc.com.validator.negocio.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.negocio.bo.BORol;
import pe.qc.com.validator.negocio.servicio.NRol;
import pe.qc.com.validator.persistencia.entity.BRol;
import pe.qc.com.validator.persistencia.mapper.MRol;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;
import pe.qc.com.validator.util.excepcion.aplicacion.PersistenciaExcepcion;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NRolImpl implements NRol{
	
	@Autowired
	MRol mRol;
	
	@Autowired
	@Qualifier("tRolEntityBO")
	TransformadorEntityBO<BRol, BORol> transformador;
	
	@Override
	public List<BORol> listarRol() {
		List<BORol> listaRol = new ArrayList<BORol>();
		try{
			listaRol = transformador.toBO(mRol.listarRol());
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e ){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaRol;
	}
	
	@Override
	public BORol obtenerRolXId(Integer id) {
		BORol Rol = null;
		try{
			Rol = transformador.toBO(mRol.obtenerRolXId(id));
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return Rol;
	}

	@Override
	public BORol obtenerRolXNombre(String nombreRol) {
		BORol Rol = null;
		try {
			Rol = transformador.toBO(mRol.obtenerRolXNombre(nombreRol));
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return Rol;
	}

}
