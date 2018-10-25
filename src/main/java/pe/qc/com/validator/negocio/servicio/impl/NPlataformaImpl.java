package pe.qc.com.validator.negocio.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.negocio.bo.BOPlataforma;
import pe.qc.com.validator.negocio.servicio.NPlataforma;
import pe.qc.com.validator.persistencia.entity.BPlataforma;
import pe.qc.com.validator.persistencia.mapper.MPlataforma;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;
import pe.qc.com.validator.util.excepcion.aplicacion.PersistenciaExcepcion;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NPlataformaImpl implements NPlataforma{
	
	@Autowired
	MPlataforma mPlataforma;
	
	@Autowired
	@Qualifier("tPlataformaEntityBO")
	TransformadorEntityBO<BPlataforma, BOPlataforma> transformador;
	
	@Override
	public List<BOPlataforma> listarPlataforma() {
		List<BOPlataforma> listaPlataforma = new ArrayList<BOPlataforma>();
		try{
			listaPlataforma = transformador.toBO(mPlataforma.listarPlataforma());
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e ){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaPlataforma;
	}
	
	@Override
	public BOPlataforma obtenerPlataformaXId(Integer id) {
		BOPlataforma Plataforma = null;
		try{
			Plataforma = transformador.toBO(mPlataforma.obtenerPlataformaXId(id));
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return Plataforma;
	}

	@Override
	public BOPlataforma obtenerPlataformaXNombre(String nombrePlataforma) {
		BOPlataforma Plataforma = null;
		try {
			Plataforma = transformador.toBO(mPlataforma.obtenerPlataformaXNombre(nombrePlataforma));
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return Plataforma;
	}

}
