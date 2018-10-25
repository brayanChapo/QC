package pe.qc.com.validator.negocio.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.negocio.bo.BOEquipo;
import pe.qc.com.validator.negocio.servicio.NEquipo;
import pe.qc.com.validator.persistencia.entity.BEquipo;
import pe.qc.com.validator.persistencia.mapper.MEquipo;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;
import pe.qc.com.validator.util.excepcion.aplicacion.PersistenciaExcepcion;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NEquipoImpl implements NEquipo{
	
	@Autowired
	MEquipo mEquipo;
	
	@Autowired
	@Qualifier("tEquipoEntityBO")
	TransformadorEntityBO<BEquipo, BOEquipo> transformador;
	
	@Override
	public List<BOEquipo> listarEquipo() {
		List<BOEquipo> listaEquipo = new ArrayList<BOEquipo>();
		try{
			listaEquipo = transformador.toBO(mEquipo.listarEquipo());
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e ){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaEquipo;
	}
	
	
	@Override
	public BOEquipo obtenerEquipoXId(Integer id) {
		BOEquipo Equipo = null;
		try{
			Equipo = transformador.toBO(mEquipo.obtenerEquipoXId(id));
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return Equipo;
	}

	@Override
	public BOEquipo obtenerEquipoXNombre(String nombreEquipo) {
		BOEquipo Equipo = null;
		try {
			Equipo = transformador.toBO(mEquipo.obtenerEquipoXNombre(nombreEquipo));
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return Equipo;
	}

	
}
