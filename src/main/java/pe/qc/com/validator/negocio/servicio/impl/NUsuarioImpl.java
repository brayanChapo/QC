package pe.qc.com.validator.negocio.servicio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.negocio.bo.BOUsuario;
import pe.qc.com.validator.negocio.servicio.NUsuario;
import pe.qc.com.validator.persistencia.entity.BUsuario;
import pe.qc.com.validator.persistencia.mapper.MUsuario;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.BusinessLogicException;
import pe.qc.com.validator.util.excepcion.DataAccessException;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;
import pe.qc.com.validator.util.excepcion.aplicacion.PersistenciaExcepcion;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NUsuarioImpl implements NUsuario {

	@Autowired
	MUsuario mUsuario;

	@Autowired
	@Qualifier("tUsuarioEntityBO")
	TransformadorEntityBO<BUsuario, BOUsuario> transformador;

	@Override
	public List<BOUsuario> listarUsuario() {
		List<BOUsuario> listaUsuario = new ArrayList<BOUsuario>();
		try {
			listaUsuario = transformador.toBO(mUsuario.listarUsuario());
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaUsuario;
	}

	@Override
	public BOUsuario obtenerUsuarioXId(Integer id) {
		BOUsuario Usuario = null;
		try {
			Usuario = transformador.toBO(mUsuario.obtenerUsuarioXId(id));
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return Usuario;
	}

	@Override
	public BOUsuario obtenerUsuarioXCodigo(String codigoUsuario) {
		BOUsuario Usuario = null;
		try {
			Usuario = transformador.toBO(mUsuario.obtenerUsuarioXCodigo(codigoUsuario));
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return Usuario;
	}

	@Override
	public void insertarUsuario(BOUsuario Usuario) {
		try {
			Usuario.setEstadoUsuario(Constantes.VALOR_ESTADO_ACTIVO);
			mUsuario.insertarUsuario(transformador.toEntity(Usuario));
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}

	}

	@Override
	public void modificarUsuario(BOUsuario Usuario) {
		try {
			mUsuario.modificarUsuario(transformador.toEntity(Usuario));
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
	}

	@Override
	public void eliminarUsuario(BOUsuario Usuario) {
		try {
			Usuario.setEstadoUsuario(Constantes.VALOR_ESTADO_INACTIVO);
			mUsuario.eliminarUsuario(transformador.toEntity(Usuario));
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_ELIMINACION_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
	}

	@Override
	public List<Map<String, Object>> listarMapUsuarios() {
		List<Map<String, Object>> listaMapUsuario = null;
		try {
			listaMapUsuario = mUsuario.listarMapUsuario();
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(
					Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaMapUsuario;
	}

	@Override
	public Map<String, Object> obtenerMapUsuario(Integer idUsuario) {
		Map<String, Object> MapUsuario = null;
		try {
			MapUsuario = mUsuario.obtenerMapUsuarioXId(idUsuario);
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(
					Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return MapUsuario;
	}

	@Override
	public List<Map<String, Object>> listarMapconsultaUsuarios() {
		List<Map<String, Object>> listarMapConsultaUsuario = null;
		try {
			listarMapConsultaUsuario = mUsuario.listarMapConsultaUsuario();
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(
					Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listarMapConsultaUsuario;
	}

}
