package pe.qc.com.validator.negocio.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.negocio.bo.BOIPServidor;
import pe.qc.com.validator.negocio.servicio.NIPServidor;
import pe.qc.com.validator.persistencia.entity2.BIPServidor;
import pe.qc.com.validator.persistencia.mapper2.MIPServidor;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;
import pe.qc.com.validator.util.excepcion.aplicacion.PersistenciaExcepcion;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NIPServidorImpl implements NIPServidor{
	
	@Autowired
	MIPServidor mIPServidor;
	
	@Autowired
	@Qualifier("tIPServidorEntityBO")
	TransformadorEntityBO<BIPServidor, BOIPServidor> transformador;
	
	@Override
	public List<BOIPServidor> listarIPServidor(String nombreServidor) {
		List<BOIPServidor> listaIPServidor = new ArrayList<BOIPServidor>();
		try{
			listaIPServidor = transformador.toBO(mIPServidor.listarIPServidor(nombreServidor));
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e ){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaIPServidor;
	}
	
}
