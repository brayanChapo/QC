package pe.qc.com.validator.presentacion.controlador;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pe.qc.com.validator.negocio.bo.BOUsuario;
import pe.qc.com.validator.negocio.servicio.NArea;
import pe.qc.com.validator.negocio.servicio.NRol;
import pe.qc.com.validator.negocio.servicio.NUsuario;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.BusinessLogicException;
import pe.qc.com.validator.util.excepcion.DataAccessException;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;
import pe.qc.com.validator.util.PaginaUtil;

@Controller("cMantenerUsuario")
public class CMantenerUsuario {

	@Autowired
	NUsuario nUsuario;
	@Autowired
	NRol nRol;
	@Autowired
	NArea nArea;

	BOUsuario boUsuario;
	List<BOUsuario> listarUsuario;

	@PostConstruct
	public void init() {
		inicializarObjetos();
	}

	public void inicializarObjetos() {
		boUsuario = new BOUsuario();
		listarUsuario = nUsuario.listarUsuario();
	}

	public void iniciarAgregarUsuario() {
		boUsuario = new BOUsuario();
		obtenerSelectItemRol();
		obtenerSelectItemArea();
		PaginaUtil.ejecutar("PF('wgvAgregarUsuario').show()");
	}

	public void agregarUsuario() {
		try {
			nUsuario.insertarUsuario(boUsuario);
			listarUsuario = nUsuario.listarUsuario();
			PaginaUtil.ejecutar("PF('wgvAgregarUsuario').hide()");
			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Usuario agregado correctamente");
		} catch (DataAccessException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (BusinessLogicException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
	}

	public void iniciarModificarUsuario(BOUsuario boUsuario) {
		this.boUsuario = boUsuario;
		obtenerSelectItemRol();
		obtenerSelectItemArea();
		PaginaUtil.ejecutar("PF('wgvModificarUsuario').show()");
	}

	public void modificarUsuario() {
		try {
			nUsuario.modificarUsuario(boUsuario);
			PaginaUtil.ejecutar("PF('wgvModificarUsuario').hide()");
			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Usuario modificado exitosamente");
		} catch (DataAccessException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (BusinessLogicException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
		listarUsuario = nUsuario.listarUsuario();
	}

	public void eliminarUsuario() {
		try {
			nUsuario.eliminarUsuario(boUsuario);
			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Usuario eliminado exitosamente");
			PaginaUtil.ejecutar("PF('wgvEliminarUsuario').hide()");
			listarUsuario = nUsuario.listarUsuario();
		} catch (NegocioExcepcion e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} finally {
			PaginaUtil.ejecutar("PF('wgvEliminarUsuario').hide()");
		}
	}

	public void obtenerSelectItemRol() {
		boUsuario.obtenerSelectItemsRol(nRol.listarRol());
	}

	public void obtenerSelectItemArea() {
		boUsuario.obtenerSelectItemsArea(nArea.listarArea());
	}

	public BOUsuario getBoUsuario() {
		return boUsuario;
	}

	public void setBoUsuario(BOUsuario boUsuario) {
		this.boUsuario = boUsuario;
	}

	public List<BOUsuario> getListarUsuario() {
		return listarUsuario;
	}

	public void setListarUsuario(List<BOUsuario> listarUsuario) {
		this.listarUsuario = listarUsuario;
	}

}
