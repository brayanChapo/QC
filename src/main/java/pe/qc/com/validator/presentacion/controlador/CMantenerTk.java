package pe.qc.com.validator.presentacion.controlador;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import pe.qc.com.validator.negocio.bo.BOAplicativo;
import pe.qc.com.validator.negocio.bo.BODetalleSolicitud;
import pe.qc.com.validator.negocio.bo.BOSolicitud;
import pe.qc.com.validator.negocio.servicio.NAplicativo;
import pe.qc.com.validator.negocio.servicio.NDetalleSolicitud;
import pe.qc.com.validator.negocio.servicio.NDominio;
import pe.qc.com.validator.negocio.servicio.NPlataforma;
import pe.qc.com.validator.negocio.servicio.NSolicitud;
import pe.qc.com.validator.negocio.servicio.NTipoSolicitud;
import pe.qc.com.validator.negocio.servicio.NUsuario;
import pe.qc.com.validator.negocio.servicio.NVob;
import pe.qc.com.validator.presentacion.form.FLogin;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;
import pe.qc.com.validator.util.PaginaUtil;

@Controller("cMantenerTk")

public class CMantenerTk {

	@Autowired
	NVob nVob;
	
	@Autowired
	NUsuario nUsuario;

	@Autowired
	NDominio nDominio;

	@Autowired
	NAplicativo nAplicativo;

	@Autowired
	NTipoSolicitud nTipoSolicitud;

	@Autowired
	NPlataforma nPlataforma;

	@Autowired
	NDetalleSolicitud nDetalleSolicitud;

	@Autowired
	NSolicitud nSolicitud;

	private String nombreDominio;
	private String nombreVob;
	private String nombreTipoSolicitud;
	private String nombrePlataforma;
	private String nombreAplicativo;

	BOSolicitud boSolicitud;
	List<BOSolicitud> listaSolicitud;

	BODetalleSolicitud boDetalleSolicitud;
	List<BODetalleSolicitud> listaDetalleSolicitud;

	BOAplicativo boAplicativo;
	List<BOAplicativo> listaAplicativo;
	
	FLogin fLogin;

	@PostConstruct
	public void init() {
		inicializarObjetos();
	}

	public void inicializarObjetos() {
		try {
			fLogin = new FLogin();
			fLogin = (FLogin)SecurityContextHolder.getContext().getAuthentication().getDetails();
			boSolicitud = new BOSolicitud();
			boDetalleSolicitud = new BODetalleSolicitud();
			listaSolicitud = nSolicitud.listarSolicitud(nUsuario.obtenerUsuarioXCodigo(fLogin.getUsuario()).getIdUsuario());
			System.out.println("HEYYYYYYYYYYYYYYYYAAAA: " + listaSolicitud.toString());
		}catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}		
	}

	public void iniciarAgregarTk() {
		boSolicitud = new BOSolicitud();
		boDetalleSolicitud = new BODetalleSolicitud();
		boAplicativo = new BOAplicativo();
		nombreDominio = "";
		nombreVob = "";
		nombreAplicativo="";
		obtenerSelectItemTipoSolicitud();
		boSolicitud.setMostrarDatoSolicitud(false);
		obtenerSelectItemPlataforma();
		obtenerSelectItemAplicativo();
		boSolicitud.obtenerFechaActual();
		PaginaUtil.ejecutar("PF('wgvAgregarTk').show()");
	}

	public void agregarTk() {
		try {
			completarInformacion();
			nSolicitud.insertarSolicitud(boSolicitud);
			listaSolicitud = nSolicitud.listarSolicitud(nUsuario.obtenerUsuarioXCodigo(fLogin.getUsuario()).getIdUsuario());
			PaginaUtil.ejecutar("PF('wgvAgregarTk').hide()");
			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Solicitud agregada correctamente");
		} catch (NegocioExcepcion e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} finally {
			PaginaUtil.ejecutar("PF('wgvAgregarTk').hide()");
		}
	}

	public void iniciarModificarTk(BOSolicitud boSolicitud) {
		this.boSolicitud = boSolicitud;
		this.boDetalleSolicitud = nDetalleSolicitud.obtenerDetalleSolicitudXId(boSolicitud.getIdDetalleSolicitud());
		obtenerSelectItemTipoSolicitud();
		obtenerSelectItemPlataforma();
		obtenerSelectItemAplicativo();
		mostrarPanel();
		obtenerInformacionAplicativo();
		PaginaUtil.ejecutar("PF('wgvModificarTk').show()");
	}

	public void modificarTk() {
		try {
			modificarInformacion();
			nSolicitud.modificarSolicitudTK(boSolicitud);
			listaSolicitud = nSolicitud.listarSolicitud(nUsuario.obtenerUsuarioXCodigo(fLogin.getUsuario()).getIdUsuario());
			PaginaUtil.ejecutar("PF('wgvModificarTk').hide()");
			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Solicitud modificada correctamente");
		} catch (NegocioExcepcion e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} finally {
			PaginaUtil.ejecutar("PF('wgvModificarTk').hide()");
		}
	}

	public void consultarTK(BOSolicitud boSolicitud) {
		this.boSolicitud = boSolicitud;
		this.boDetalleSolicitud = nDetalleSolicitud.obtenerDetalleSolicitudXId(boSolicitud.getIdDetalleSolicitud());
		boAplicativo=new BOAplicativo();
		boAplicativo.setNombreAplicativo(nAplicativo.obtenerAplicativoXId(boSolicitud.getIdCodigoApp()).getNombreAplicativo());
		boAplicativo = nAplicativo.obtenerAplicativoXId(boSolicitud.getIdCodigoApp());
		nombreDominio = nDominio.obtenerDominioXId(boAplicativo.getIdDominio()).getNombreDominio();
		nombreVob = nVob.obtenerVobXId(boAplicativo.getIdVob()).getNombreVob();
		nombrePlataforma = nPlataforma.obtenerPlataformaXId(boSolicitud.getIdPlataforma()).getNombrePlataforma();
		nombreTipoSolicitud = nTipoSolicitud.obtenerTipoSolicitudXId(boSolicitud.getIdTipoSolicitud()).getNombreTipoSolicitud();
		mostrarDialogConsultar();
		PaginaUtil.ejecutar("PF('wgvConsultarTk').show()");
	}

	public void obtenerSelectItemTipoSolicitud() {
		boSolicitud.obtenerSelectItemsTipoSolicitud(nTipoSolicitud.listarTipoSolicitud());
	}

	public void obtenerSelectItemPlataforma() {
		boSolicitud.obtenerSelectItemsPlataforma(nPlataforma.listarPlataforma());
	}

	public void obtenerSelectItemAplicativo() {
		boSolicitud.obtenerSelectItemsAplicativo(nAplicativo.listarAplicativo());
	}

	public void mostrarPanel() {
		if (boSolicitud.getIdTipoSolicitud() == 0) {
			boSolicitud.setMostrarDatoSolicitud(false);
		} else {
			boSolicitud.setMostrarDatoSolicitud(true);
			if (boSolicitud.getIdTipoSolicitud() == 1) {
				boSolicitud.setMostrarSolNegocio(true);
				boSolicitud.setMostrarSolTecnico(true);
				boSolicitud.setMostrarSolServicio(false);
				boSolicitud.setMostrarIncidencia(false);
			}
			if (boSolicitud.getIdTipoSolicitud() == 2) {
				boSolicitud.setMostrarSolNegocio(false);
				boSolicitud.setMostrarSolTecnico(false);
				boSolicitud.setMostrarSolServicio(true);
				boSolicitud.setMostrarIncidencia(false);
			}
			if (boSolicitud.getIdTipoSolicitud() == 3) {
				boSolicitud.setMostrarSolNegocio(false);
				boSolicitud.setMostrarSolTecnico(false);
				boSolicitud.setMostrarSolServicio(false);
				boSolicitud.setMostrarIncidencia(true);
			}
		}

	}
	
	public void mostrarDialogConsultar(){
		if (boSolicitud.getIdTipoSolicitud() != 0) {
			if (boSolicitud.getIdTipoSolicitud() == 1) {
				boSolicitud.setMostrarSolNegocio(true);
				boSolicitud.setMostrarSolTecnico(true);
				boSolicitud.setMostrarSolServicio(false);
				boSolicitud.setMostrarIncidencia(false);
			}
			if (boSolicitud.getIdTipoSolicitud() == 2) {
				boSolicitud.setMostrarSolNegocio(false);
				boSolicitud.setMostrarSolTecnico(false);
				boSolicitud.setMostrarSolServicio(true);
				boSolicitud.setMostrarIncidencia(false);
			}
			if (boSolicitud.getIdTipoSolicitud() == 3) {
				boSolicitud.setMostrarSolNegocio(false);
				boSolicitud.setMostrarSolTecnico(false);
				boSolicitud.setMostrarSolServicio(false);
				boSolicitud.setMostrarIncidencia(true);
			}
		} 
	}

	public void obtenerInformacionAplicativo() {
		BOAplicativo boAplicativo1 = new BOAplicativo();
		boAplicativo1 = nAplicativo.obtenerAplicativoXId(boSolicitud.getIdCodigoApp());
		nombreDominio = nDominio.obtenerDominioXId(boAplicativo1.getIdDominio()).getNombreDominio();
		nombreVob = nVob.obtenerVobXId(boAplicativo1.getIdVob()).getNombreVob();
	}

	public void completarInformacion() {
		
		boSolicitud.setIdUsuario(nUsuario.obtenerUsuarioXCodigo(fLogin.getUsuario()).getIdUsuario());
		boSolicitud.setIdHistoricoSolicitud(null);
		boSolicitud.setEsHistorico(Constantes.VALOR_ESTADO_NO_HISTORICO);
		boSolicitud.setIdEstadoSolicitud(Constantes.ESTADO_CREADO);
		boSolicitud.setFechaSolicitud(new java.util.Date());
		insertarDetalle();
		obtenerUltimoDetalle();
	}

	public void modificarInformacion() {
		boSolicitud.setIdUsuario(nUsuario.obtenerUsuarioXCodigo(fLogin.getUsuario()).getIdUsuario());
		boSolicitud.setIdHistoricoSolicitud(null);
		boSolicitud.setEsHistorico(Constantes.VALOR_ESTADO_NO_HISTORICO);
		boSolicitud.setIdEstadoSolicitud(Constantes.ESTADO_CREADO);
		boSolicitud.setFechaSolicitud(new java.util.Date());
		modificarDetalle();
	}
	
	public void modificarEstado(BOSolicitud boSolicitud) {
		this.boSolicitud = boSolicitud;
		boSolicitud.setIdEstadoSolicitud(Constantes.ESTADO_REGISTRADO);
		nSolicitud.modificarSolicitudTK(boSolicitud);
		listaSolicitud = nSolicitud.listarSolicitud(nUsuario.obtenerUsuarioXCodigo(fLogin.getUsuario()).getIdUsuario());
	}
	
	public void buscarCodigo() {
		boSolicitud.obtenerSelectItemsAplicativo(nAplicativo.listarAplicativoXNombre(nombreAplicativo));
	}

	public void insertarDetalle() {
		nDetalleSolicitud.insertarDetalleSolicitud(boDetalleSolicitud);
	}

	public void modificarDetalle() {
		nDetalleSolicitud.modificarDetalleSolicitud(boDetalleSolicitud);
	}

	public void obtenerUltimoDetalle() {
		boSolicitud.setIdDetalleSolicitud(nDetalleSolicitud.obtenerUltimoRegistroDetalle());
	}

	public BOAplicativo getBoAplicativo() {
		return boAplicativo;
	}

	public void setBoAplicativo(BOAplicativo boAplicativo) {
		this.boAplicativo = boAplicativo;
	}

	public List<BOAplicativo> getListaAplicativo() {
		return listaAplicativo;
	}

	public void setListaAplicativo(List<BOAplicativo> listaAplicativo) {
		this.listaAplicativo = listaAplicativo;
	}

	public BOSolicitud getBoSolicitud() {
		return boSolicitud;
	}

	public void setBoSolicitud(BOSolicitud boSolicitud) {
		this.boSolicitud = boSolicitud;
	}

	public List<BOSolicitud> getListaSolicitud() {
		return listaSolicitud;
	}

	public void setListaSolicitud(List<BOSolicitud> listaSolicitud) {
		this.listaSolicitud = listaSolicitud;
	}

	public String getNombreDominio() {
		return nombreDominio;
	}

	public void setNombreDominio(String nombreDominio) {
		this.nombreDominio = nombreDominio;
	}

	public String getNombreVob() {
		return nombreVob;
	}

	public void setNombreVob(String nombreVob) {
		this.nombreVob = nombreVob;
	}

	public List<BODetalleSolicitud> getListaDetalleSolicitud() {
		return listaDetalleSolicitud;
	}

	public void setListaDetalleSolicitud(List<BODetalleSolicitud> listaDetalleSolicitud) {
		this.listaDetalleSolicitud = listaDetalleSolicitud;
	}

	public BODetalleSolicitud getBoDetalleSolicitud() {
		return boDetalleSolicitud;
	}

	public void setBoDetalleSolicitud(BODetalleSolicitud boDetalleSolicitud) {
		this.boDetalleSolicitud = boDetalleSolicitud;
	}

	public String getNombreTipoSolicitud() {
		return nombreTipoSolicitud;
	}

	public void setNombreTipoSolicitud(String nombreTipoSolicitud) {
		this.nombreTipoSolicitud = nombreTipoSolicitud;
	}

	public String getNombrePlataforma() {
		return nombrePlataforma;
	}

	public void setNombrePlataforma(String nombrePlataforma) {
		this.nombrePlataforma = nombrePlataforma;
	}

	public FLogin getfLogin() {
		return fLogin;
	}

	public void setfLogin(FLogin fLogin) {
		this.fLogin = fLogin;
	}

	public String getNombreAplicativo() {
		return nombreAplicativo;
	}

	public void setNombreAplicativo(String nombreAplicativo) {
		this.nombreAplicativo = nombreAplicativo;
	}
	
	
}
