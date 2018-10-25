package pe.qc.com.validator.negocio.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.negocio.bo.BOUnidades;
import pe.qc.com.validator.negocio.servicio.NUnidades;
import pe.qc.com.validator.persistencia.entity2.BUnidades;
import pe.qc.com.validator.persistencia.mapper2.MUnidades;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;
import pe.qc.com.validator.util.excepcion.aplicacion.PersistenciaExcepcion;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NUnidadesImpl implements NUnidades{
	
	@Autowired
	MUnidades mUnidades;
	
	@Autowired
	@Qualifier("tUnidadesEntityBO")
	TransformadorEntityBO<BUnidades, BOUnidades> transformador;
	
	@Override
	public List<BOUnidades> listarUnidades(String nombreServidor) {
		List<BOUnidades> listaUnidades = new ArrayList<>();
		try{
			listaUnidades = transformador.toBO(mUnidades.listarUnidades(nombreServidor));
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e ){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaUnidades;
	}
	
}
