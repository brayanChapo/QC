package pe.qc.com.validator.negocio.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.negocio.bo.BOServidor;
import pe.qc.com.validator.negocio.servicio.NServidor;
import pe.qc.com.validator.persistencia.entity2.BServidor;
import pe.qc.com.validator.persistencia.mapper2.MServidor;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;
import pe.qc.com.validator.util.excepcion.aplicacion.PersistenciaExcepcion;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NServidorImpl implements NServidor{
	
	@Autowired
	MServidor mServidor;
	
	@Autowired
	@Qualifier("tServidorEntityBO")
	TransformadorEntityBO<BServidor, BOServidor> transformador;
	
	@Override
	public BOServidor obtenerServidor(String nombreServidor) {
		BOServidor Servidor = new BOServidor();
		try{
			Servidor = transformador.toBO(mServidor.obtenerServidor(nombreServidor));
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e ){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return Servidor;
	}
	
}
