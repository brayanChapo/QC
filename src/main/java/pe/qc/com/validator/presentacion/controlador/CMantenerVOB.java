package pe.qc.com.validator.presentacion.controlador;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pe.qc.com.validator.negocio.bo.BOVob;
import pe.qc.com.validator.negocio.servicio.NAplicativo;
import pe.qc.com.validator.negocio.servicio.NVob;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.PaginaUtil;
import pe.qc.com.validator.util.excepcion.BusinessLogicException;
import pe.qc.com.validator.util.excepcion.DataAccessException;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;

@Controller("cMantenerVOB")

public class CMantenerVOB {

	@Autowired
	NVob nVob;

	@Autowired
	NAplicativo nAplicativo;

	List<BOVob> listarVob;
	List<BOVob> listarVob2;

	BOVob boVob;

	@PostConstruct
	public void init() {
		inicializarObjetos();
	}

	public void inicializarObjetos() {
		boVob = new BOVob();
		listarVob = nVob.listarVob();
	}

	public void iniciarAgregarVOB() {
		boVob = new BOVob();
		PaginaUtil.ejecutar("PF('wgvAgregarVOB').show()");
	}

	public void agregarVob() {
		try {
			nVob.insertarVob(boVob);
			listarVob = nVob.listarVob();
			PaginaUtil.ejecutar("PF('wgvAgregarVOB').hide()");
			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Vob agregada correctamente");
		} catch (DataAccessException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (BusinessLogicException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
	}

	public void iniciarModificarVob(BOVob boVob) {
		this.boVob = boVob;
		PaginaUtil.ejecutar("PF('wgvModificarVOB').show()");
	}

	public void modificarVob() {
		try {
			nVob.modificarVob(boVob);
			PaginaUtil.ejecutar("PF('wgvModificarVOB').hide()");
			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Vob modificado exitosamente");
		} catch (DataAccessException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (BusinessLogicException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
		listarVob = nVob.listarVob();
	}

	public void eliminarVob() {
		try {
			nVob.eliminarVob(boVob.getIdVob());
			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Vob eliminado exitosamente");
			PaginaUtil.ejecutar("PF('wgvEliminarVOB').hide()");
			listarVob = nVob.listarVob();
		} catch (NegocioExcepcion e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} finally {
			PaginaUtil.ejecutar("PF('wgvEliminarVOB').hide()");
		}
	}

	public boolean obtenerinfo(BOVob boVob1) {
		boolean info = false;
		if (nAplicativo.obtenerAplicativoXIdVob(boVob1.getIdVob()) != null) {
			info = true;
		} else {
			info = false;
		}
		return info;
	}

	public List<BOVob> getListarVob() {
		return listarVob;
	}

	public void setListarVob(List<BOVob> listarVob) {
		this.listarVob = listarVob;
	}

	public BOVob getBoVob() {
		return boVob;
	}

	public void setBoVob(BOVob boVob) {
		this.boVob = boVob;
	}

	public List<BOVob> getListarVob2() {
		return listarVob2;
	}

	public void setListarVob2(List<BOVob> listarVob2) {
		this.listarVob2 = listarVob2;
	}

}
