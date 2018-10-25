package pe.qc.com.validator.presentacion.controlador;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pe.qc.com.validator.negocio.bo.BODominio;
import pe.qc.com.validator.negocio.servicio.NAplicativo;
import pe.qc.com.validator.negocio.servicio.NDominio;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.PaginaUtil;
import pe.qc.com.validator.util.excepcion.BusinessLogicException;
import pe.qc.com.validator.util.excepcion.DataAccessException;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;

@Controller("cMantenerDominio")

public class CMantenerDominio {

	@Autowired
	NDominio nDominio;

	@Autowired
	NAplicativo nAplicativo;

	List<BODominio> listarDominio;
	BODominio boDominio;

	@PostConstruct
	public void init() {
		inicializarObjetos();
	}

	public void inicializarObjetos() {
		boDominio = new BODominio();
		listarDominio = nDominio.listarDominio();
	}

	public void iniciarAgregarDominio() {
		boDominio = new BODominio();
		PaginaUtil.ejecutar("PF('wgvAgregarDominio').show()");
	}

	public void agregarDominio() {
		try {
			nDominio.insertarDominio(boDominio);
			listarDominio = nDominio.listarDominio();
			PaginaUtil.ejecutar("PF('wgvAgregarDominio').hide()");
			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Dominio agregada correctamente");
		} catch (DataAccessException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (BusinessLogicException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
	}

	public void iniciarModificarDominio(BODominio boDominio) {
		this.boDominio = boDominio;
		PaginaUtil.ejecutar("PF('wgvModificarDominio').show()");
	}

	public void modificarDominio() {
		try {
			nDominio.modificarDominio(boDominio);
			PaginaUtil.ejecutar("PF('wgvModificarDominio').hide()");
			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Dominio modificado exitosamente");
		} catch (DataAccessException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (BusinessLogicException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
		listarDominio = nDominio.listarDominio();
	}

	public void eliminarDominio() {
		try {
			nDominio.eliminarDominio(boDominio.getIdDominio());
			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Dominio eliminado exitosamente");
			PaginaUtil.ejecutar("PF('wgvEliminarDominio').hide()");
			listarDominio = nDominio.listarDominio();
		} catch (NegocioExcepcion e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} finally {
			PaginaUtil.ejecutar("PF('wgvEliminarDominio').hide()");
		}
	}

	public boolean obtenerinfo(BODominio boDominio1) {
		boolean info = false;
		if (nAplicativo.obtenerAplicativoXIdDominio(boDominio1.getIdDominio()).size() > 0) {
			info = true;
		} else {
			info = false;
		}
		return info;
	}

	public List<BODominio> getListarDominio() {
		return listarDominio;
	}

	public void setListarDominio(List<BODominio> listarDominio) {
		this.listarDominio = listarDominio;
	}

	public BODominio getBoDominio() {
		return boDominio;
	}

	public void setBoDominio(BODominio boDominio) {
		this.boDominio = boDominio;
	}

}
