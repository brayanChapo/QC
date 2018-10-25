package pe.qc.com.validator.presentacion.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import pe.qc.com.validator.negocio.bo.BOAplicativo;
import pe.qc.com.validator.negocio.bo.BOClearCase;
import pe.qc.com.validator.negocio.bo.BODetalleSolicitud;
import pe.qc.com.validator.negocio.bo.BOSolicitud;
import pe.qc.com.validator.negocio.bo.BOValidacionClearCase;
import pe.qc.com.validator.negocio.servicio.NAplicativo;
import pe.qc.com.validator.negocio.servicio.NDetalleSolicitud;
import pe.qc.com.validator.negocio.servicio.NSolicitud;
import pe.qc.com.validator.negocio.servicio.NUsuario;
import pe.qc.com.validator.negocio.servicio.NVob;
import pe.qc.com.validator.presentacion.form.FLogin;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.PaginaUtil;

@Controller("cValidarClearCase")
public class CValidarClearCase {
	
	@Autowired
	NSolicitud nSolicitud;
	@Autowired
	NUsuario nUsuario;
	@Autowired
	NVob nVob;
	@Autowired
	NAplicativo nAplicativo;
	@Autowired
	NDetalleSolicitud nDetalleSolicitud;
	
	
	FLogin fLogin;
	
	private String nombreUsuario;
	private String nombreTk;
	private String nombreVob;
	
	BOClearCase boClearCase;
	BOValidacionClearCase boValidacionClearCase;
	List<BOClearCase> listaClearCase;
	
	BOAplicativo boAplicativo;
	BODetalleSolicitud boDetalleSolicitud;
	BOSolicitud boSolicitud;
	
	
	
	@PostConstruct
	public void init() {
		inicializarObjetos();
	}

	public void inicializarObjetos() {
		try {
			fLogin = new FLogin();
			fLogin = (FLogin)SecurityContextHolder.getContext().getAuthentication().getDetails();
			nombreUsuario = nUsuario.obtenerUsuarioXCodigo(fLogin.getUsuario()).getCodigoUsuario();
			boClearCase = new BOClearCase();
			listaClearCase = new ArrayList<>();
			nombreTk="";
			nombreVob="";
			boValidacionClearCase = new BOValidacionClearCase();
		}catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
	}

	public void buscarTK() {
		boAplicativo = new BOAplicativo();
		boDetalleSolicitud = new BODetalleSolicitud();
		boSolicitud = new BOSolicitud();
		boSolicitud = nSolicitud.obtenerSolicitudXnombreTk(nombreTk);
		boAplicativo = nAplicativo.obtenerAplicativoXId(boSolicitud.getIdCodigoApp());
		boDetalleSolicitud = nDetalleSolicitud.obtenerDetalleSolicitudXId(boSolicitud.getIdDetalleSolicitud());
		nombreVob = nVob.obtenerVobXId(nAplicativo.obtenerAplicativoXId((nSolicitud.obtenerSolicitudXnombreTk(nombreTk)).getIdCodigoApp()).getIdVob()).getNombreVob();
		
		PaginaUtil.ejecutar("PF('wgvConfirmacionClearCase').show()");
	}
	
	public void buscarElementos() {
		iniciarValidaciones();
		PaginaUtil.ejecutar("PF('wgvConfirmacionClearCase').hide()");
	}
	
	public void iniciarCargaDocumentoTXT() {
		PaginaUtil.ejecutar("PF('wgvCargarDocumentoTXT').show()");
	}
	
	public void convertirArchivoTXT() {
		listaClearCase = boClearCase.transformarArchivoTXT();
		PaginaUtil.ejecutar("PF('wgvCargarDocumentoTXT').hide()");

	}
	
	public void iniciarValidaciones() {
		boValidacionClearCase = new BOValidacionClearCase();
		boValidacionClearCase.validarClearCase(listaClearCase, boSolicitud.getIdTipoSolicitud(), boDetalleSolicitud, boAplicativo, nombreTk);
	}
	
	public FLogin getfLogin() {
		return fLogin;
	}

	public void setfLogin(FLogin fLogin) {
		this.fLogin = fLogin;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombreTk() {
		return nombreTk;
	}

	public void setNombreTk(String nombreTk) {
		this.nombreTk = nombreTk;
	}

	public String getNombreVob() {
		return nombreVob;
	}

	public void setNombreVob(String nombreVob) {
		this.nombreVob = nombreVob;
	}

	public BOClearCase getBoClearCase() {
		return boClearCase;
	}

	public void setBoClearCase(BOClearCase boClearCase) {
		this.boClearCase = boClearCase;
	}

	public List<BOClearCase> getListaClearCase() {
		return listaClearCase;
	}

	public void setListaClearCase(List<BOClearCase> listaClearCase) {
		this.listaClearCase = listaClearCase;
	}

	public BOValidacionClearCase getBoValidacionClearCase() {
		return boValidacionClearCase;
	}

	public void setBoValidacionClearCase(BOValidacionClearCase boValidacionClearCase) {
		this.boValidacionClearCase = boValidacionClearCase;
	}

	public BOAplicativo getBoAplicativo() {
		return boAplicativo;
	}

	public void setBoAplicativo(BOAplicativo boAplicativo) {
		this.boAplicativo = boAplicativo;
	}

	public BODetalleSolicitud getBoDetalleSolicitud() {
		return boDetalleSolicitud;
	}

	public void setBoDetalleSolicitud(BODetalleSolicitud boDetalleSolicitud) {
		this.boDetalleSolicitud = boDetalleSolicitud;
	}

	public BOSolicitud getBoSolicitud() {
		return boSolicitud;
	}

	public void setBoSolicitud(BOSolicitud boSolicitud) {
		this.boSolicitud = boSolicitud;
	}
	
}
