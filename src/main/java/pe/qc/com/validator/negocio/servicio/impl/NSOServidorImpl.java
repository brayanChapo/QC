package pe.qc.com.validator.negocio.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.negocio.bo.BOSOServidor;
import pe.qc.com.validator.negocio.servicio.NSOServidor;
import pe.qc.com.validator.persistencia.entity2.BSOServidor;
import pe.qc.com.validator.persistencia.mapper2.MSOServidor;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;
import pe.qc.com.validator.util.excepcion.aplicacion.PersistenciaExcepcion;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NSOServidorImpl implements NSOServidor{
	
	@Autowired
	MSOServidor mSOServidor;
	
	@Autowired
	@Qualifier("tSOServidorEntityBO")
	TransformadorEntityBO<BSOServidor, BOSOServidor> transformador;
	
	@Override
	public List<BOSOServidor> listarSOServidor(String nombreServidor) {
		List<BOSOServidor> listaSOServidor = new ArrayList<BOSOServidor>();
		try{
			listaSOServidor = transformador.toBO(mSOServidor.listarSOServidor(nombreServidor));
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e ){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaSOServidor;
	}
	
}
