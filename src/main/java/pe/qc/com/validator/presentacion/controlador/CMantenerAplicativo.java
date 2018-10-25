package pe.qc.com.validator.presentacion.controlador;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pe.qc.com.validator.negocio.bo.BOAplicativo;
import pe.qc.com.validator.negocio.servicio.NAplicativo;
import pe.qc.com.validator.negocio.servicio.NDominio;
import pe.qc.com.validator.negocio.servicio.NVob;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.BusinessLogicException;
import pe.qc.com.validator.util.excepcion.DataAccessException;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;
import pe.qc.com.validator.util.PaginaUtil;

@Controller("cMantenerAplicativo")

public class CMantenerAplicativo {

	@Autowired
	NAplicativo nAplicativo;

	@Autowired
	NVob nVob;

	@Autowired
	NDominio nDominio;

	private String nombreVob;
	private String nombreDominio;

	private String nombreVobBuscar;
	private String nombreDominioBuscar;

	List<BOAplicativo> listarAplicativo;
	BOAplicativo boAplicativo;

	List<Map<String, Object>> listaMapAplicativo;
	Map<String, Object> mapAplicativo;

	@PostConstruct
	public void init() {
		inicializarObjetos();
	}

	public void inicializarObjetos() {
		boAplicativo = new BOAplicativo();
		listarAplicativos();
	}

	public void iniciarAgregarAplicativo() {
		boAplicativo = new BOAplicativo();
		nombreVob = "";
		nombreDominio = "";
		nombreVobBuscar = "";
		nombreDominioBuscar = "";
		obtenerSelectItemVob();
		obtenerSelectItemDominio();
		PaginaUtil.ejecutar("PF('wgvAgregarAplicativo').show()");
	}

	public void agregarAplicativo() {
		try {
			nAplicativo.insertarAplicativo(boAplicativo);
			listarAplicativos();
			PaginaUtil.ejecutar("PF('wgvAgregarAplicativo').hide()");
			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Aplicativo agregado correctamente");
		} catch (DataAccessException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (BusinessLogicException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
	}

	public void iniciarModificarAplicativo(Map<String, Object> mapAplicativoSeleccionado) {

		Integer idAplicativo = Integer.parseInt(String.valueOf(mapAplicativoSeleccionado.get("idAplicativo")));
		String nombreAplicativo = String.valueOf(mapAplicativoSeleccionado.get("nombreAplicativo"));
		Integer idDominio = nDominio
				.obtenerDominioXNombre(String.valueOf(mapAplicativoSeleccionado.get("nombreDominio"))).getIdDominio();
		Integer idVob = nVob.obtenerVobXNombre(String.valueOf(mapAplicativoSeleccionado.get("nombreVob"))).getIdVob();

		BOAplicativo boAplicativo1 = new BOAplicativo();

		boAplicativo1.setIdAplicativo(idAplicativo);
		boAplicativo1.setIdDominio(idDominio);
		boAplicativo1.setIdVob(idVob);
		boAplicativo1.setNombreAplicativo(nombreAplicativo);

		this.boAplicativo = boAplicativo1;

		obtenerSelectItemVob();
		obtenerSelectItemDominio();
		PaginaUtil.ejecutar("PF('wgvModificarAplicativo').show()");
	}

	public void modificarAplicativo() {
		try {
			nAplicativo.modificarAplicativo(boAplicativo);
			PaginaUtil.ejecutar("PF('wgvModificarAplicativo').hide()");
			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Aplicativo modificado exitosamente");
		} catch (DataAccessException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (BusinessLogicException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
		listarAplicativos();
	}

	public void eliminarAplicativo() {
		try {
			Integer idAplicativoSeleccionado = Integer.parseInt(String.valueOf(mapAplicativo.get("idAplicativo")));
			nAplicativo.eliminarAplicativo(idAplicativoSeleccionado);
			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Aplicativo eliminado exitosamente");
			PaginaUtil.ejecutar("PF('wgvEliminarAplicativo').hide()");
			listarAplicativos();
		} catch (NegocioExcepcion e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} finally {
			PaginaUtil.ejecutar("PF('wgvEliminarAplicativo').hide()");
		}
	}

	public void buscarVob() {
		boAplicativo.obtenerSelectItemsVob(nVob.listarVobXNombre(nombreVobBuscar));
	}

	public void buscarDominio() {
		boAplicativo.obtenerSelectItemsDominio(nDominio.listarDominioXNombre(nombreDominioBuscar));
	}

	public void obtenerNombreVob() {
		nombreVob = nVob.obtenerVobXId(boAplicativo.getIdVob()).getNombreVob();
	}

	public void obtenerNombreDominio() {
		nombreDominio = nDominio.obtenerDominioXId(boAplicativo.getIdDominio()).getNombreDominio();
	}

	public void listarAplicativos() {
		listaMapAplicativo = nAplicativo.listarMapAplicativos();
	}

	public void obtenerSelectItemVob() {
		boAplicativo.obtenerSelectItemsVob(nVob.listarVob());
	}

	public void obtenerSelectItemDominio() {
		boAplicativo.obtenerSelectItemsDominio(nDominio.listarDominio());
	}

	public List<BOAplicativo> getListarAplicativo() {
		return listarAplicativo;
	}

	public void setListarAplicativo(List<BOAplicativo> listarAplicativo) {
		this.listarAplicativo = listarAplicativo;
	}

	public BOAplicativo getBoAplicativo() {
		return boAplicativo;
	}

	public void setBoAplicativo(BOAplicativo boAplicativo) {
		this.boAplicativo = boAplicativo;
	}

	public List<Map<String, Object>> getListaMapAplicativo() {
		return listaMapAplicativo;
	}

	public void setListaMapAplicativo(List<Map<String, Object>> listaMapAplicativo) {
		this.listaMapAplicativo = listaMapAplicativo;
	}

	public Map<String, Object> getMapAplicativo() {
		return mapAplicativo;
	}

	public void setMapAplicativo(Map<String, Object> mapAplicativo) {
		this.mapAplicativo = mapAplicativo;
	}

	public String getNombreVob() {
		return nombreVob;
	}

	public void setNombreVob(String nombreVob) {
		this.nombreVob = nombreVob;
	}

	public String getNombreDominio() {
		return nombreDominio;
	}

	public void setNombreDominio(String nombreDominio) {
		this.nombreDominio = nombreDominio;
	}

	public String getNombreVobBuscar() {
		return nombreVobBuscar;
	}

	public void setNombreVobBuscar(String nombreVobBuscar) {
		this.nombreVobBuscar = nombreVobBuscar;
	}

	public String getNombreDominioBuscar() {
		return nombreDominioBuscar;
	}

	public void setNombreDominioBuscar(String nombreDominioBuscar) {
		this.nombreDominioBuscar = nombreDominioBuscar;
	}

}
