package pe.qc.com.validator.negocio.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.negocio.bo.BORelacion;
import pe.qc.com.validator.negocio.servicio.NRelacion;
import pe.qc.com.validator.persistencia.entity2.BRelacion;
import pe.qc.com.validator.persistencia.mapper2.MRelacion;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;
import pe.qc.com.validator.util.excepcion.aplicacion.PersistenciaExcepcion;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NRelacionImpl implements NRelacion{
	
	@Autowired
	MRelacion mRelacion;
	
	@Autowired
	@Qualifier("tRelacionEntityBO")
	TransformadorEntityBO<BRelacion, BORelacion> transformador;
	
	@Override
	public List<BORelacion> listarRelacion() {
		List<BORelacion> listaRelacion = new ArrayList<BORelacion>();
		try{
			listaRelacion = transformador.toBO(mRelacion.listarRelacion());
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e ){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaRelacion;
	}
	
}
