package pe.qc.com.validator.negocio.servicio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.negocio.bo.BOAplicativo;
import pe.qc.com.validator.negocio.servicio.NAplicativo;
import pe.qc.com.validator.persistencia.entity.BAplicativo;
import pe.qc.com.validator.persistencia.mapper.MAplicativo;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.BusinessLogicException;
import pe.qc.com.validator.util.excepcion.DataAccessException;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;
import pe.qc.com.validator.util.excepcion.aplicacion.PersistenciaExcepcion;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NAplicativoImpl implements NAplicativo {

	@Autowired
	MAplicativo mAplicativo;

	@Autowired
	@Qualifier("tAplicativoEntityBO")
	TransformadorEntityBO<BAplicativo, BOAplicativo> transformador;

	@Override
	public List<BOAplicativo> listarAplicativo() {
		List<BOAplicativo> listaAplicativo = new ArrayList<>();
		try {
			listaAplicativo = transformador.toBO(mAplicativo.listarAplicativo());
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaAplicativo;
	}
	
	@Override
	public List<BOAplicativo> listarAplicativoXNombre(String nombreAplicativo) {
		List<BOAplicativo> listaAplicativo = new ArrayList<>();
		try {
			listaAplicativo = transformador.toBO(mAplicativo.listarAplicativoXNombre(nombreAplicativo+"%"));
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaAplicativo;
	}

	@Override
	public BOAplicativo obtenerAplicativoXId(Integer id) {
		BOAplicativo Aplicativo = null;
		try {
			Aplicativo = transformador.toBO(mAplicativo.obtenerAplicativoXId(id));
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return Aplicativo;
	}
	
	@Override
	public BOAplicativo obtenerAplicativoXIdVob(Integer id) {
		BOAplicativo Aplicativo = null;
		try {
			Aplicativo = transformador.toBO(mAplicativo.obtenerAplicativoXIdVob(id));
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return Aplicativo;
	}
	
	@Override
	public List<BOAplicativo> obtenerAplicativoXIdDominio(Integer id) {
		List<BOAplicativo> Aplicativo = new ArrayList<>();
		try {
			Aplicativo = transformador.toBO(mAplicativo.obtenerAplicativoXIdDominio(id));
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return Aplicativo;
	}

	@Override
	public BOAplicativo obtenerAplicativoXNombre(String nombreAplicativo) {
		BOAplicativo Aplicativo = null;
		try {
			Aplicativo = transformador.toBO(mAplicativo.obtenerAplicativoXNombre(nombreAplicativo));
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return Aplicativo;
	}

	@Override
	public void insertarAplicativo(BOAplicativo Aplicativo) {
		try {
			System.out.println("VERDAAAAAAAAAAAAAD : " + (transformador.toEntity(Aplicativo)).toString());
			mAplicativo.insertarAplicativo(transformador.toEntity(Aplicativo));
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}

	}

	@Override
	public void modificarAplicativo(BOAplicativo Aplicativo) {
		try {
			System.out.println("VERDAAAAAAAAAAAAAD : " + (transformador.toEntity(Aplicativo)).toString());
			mAplicativo.modificarAplicativo(transformador.toEntity(Aplicativo));
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
	}

	@Override
	public void eliminarAplicativo(Integer idAplicativo) {
		try {
			mAplicativo.eliminarAplicativo(idAplicativo);
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_ELIMINACION_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
	}

	@Override
	public List<Map<String, Object>> listarMapAplicativos() {
		List<Map<String, Object>> listaMapAplicativo = null;
		try {
			listaMapAplicativo = mAplicativo.listarMapAplicativo();
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(
					Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaMapAplicativo;
	}

	@Override
	public Map<String, Object> obtenerMapAplicativo(Integer idAplicativo) {
		Map<String, Object> MapAplicativo = null;
		try {
			MapAplicativo = mAplicativo.obtenerMapAplicativoXId(idAplicativo);
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(
					Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return MapAplicativo;
	}

}
