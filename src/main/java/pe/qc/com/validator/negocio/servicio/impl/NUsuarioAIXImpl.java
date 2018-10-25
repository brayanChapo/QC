package pe.qc.com.validator.negocio.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.negocio.bo.BOUsuarioAIX;
import pe.qc.com.validator.negocio.servicio.NUsuarioAIX;
import pe.qc.com.validator.persistencia.entity.BUsuarioAIX;
import pe.qc.com.validator.persistencia.mapper.MUsuarioAIX;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;
import pe.qc.com.validator.util.excepcion.aplicacion.PersistenciaExcepcion;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NUsuarioAIXImpl implements NUsuarioAIX{
	
	@Autowired
	MUsuarioAIX mUsuarioAIX;
	
	@Autowired
	@Qualifier("tUsuarioAIXEntityBO")
	TransformadorEntityBO<BUsuarioAIX, BOUsuarioAIX> transformador;
	
	@Override
	public List<BOUsuarioAIX> listarUsuarioAIX() {
		List<BOUsuarioAIX> listaUsuarioAIX = new ArrayList<BOUsuarioAIX>();
		try{
			listaUsuarioAIX = transformador.toBO(mUsuarioAIX.listarUsuarioAIX());
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e ){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaUsuarioAIX;
	}

	@Override
	public BOUsuarioAIX obtenerUsuarioAIXXNombre(String nombreUsuarioAIX) {
		BOUsuarioAIX UsuarioAIX = null;
		try {
			UsuarioAIX = transformador.toBO(mUsuarioAIX.obtenerUsuarioAIXXNombre(nombreUsuarioAIX));
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return UsuarioAIX;
	}

	
}
