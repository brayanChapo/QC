package pe.qc.com.validator.presentacion.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import pe.qc.com.validator.negocio.bo.BOAplicativo;
import pe.qc.com.validator.negocio.bo.BODetalleSolicitud;
import pe.qc.com.validator.negocio.bo.BODominio;
import pe.qc.com.validator.negocio.bo.BOSolicitud;
import pe.qc.com.validator.negocio.bo.BOTipoSolicitud;
import pe.qc.com.validator.negocio.bo.BOVob;
import pe.qc.com.validator.negocio.servicio.NAplicativo;
import pe.qc.com.validator.negocio.servicio.NArchivoRutas;
import pe.qc.com.validator.negocio.servicio.NDetalleSolicitud;
import pe.qc.com.validator.negocio.servicio.NDominio;
import pe.qc.com.validator.negocio.servicio.NPlataforma;
import pe.qc.com.validator.negocio.servicio.NSOServidor;
import pe.qc.com.validator.negocio.servicio.NServidor;
import pe.qc.com.validator.negocio.servicio.NSolicitud;
import pe.qc.com.validator.negocio.servicio.NTipoSolicitud;
import pe.qc.com.validator.negocio.servicio.NUnidades;
import pe.qc.com.validator.negocio.servicio.NUsuario;
import pe.qc.com.validator.negocio.servicio.NUsuarioAIX;
import pe.qc.com.validator.negocio.servicio.NVob;
import pe.qc.com.validator.presentacion.form.FArchivoMisHandler;
import pe.qc.com.validator.presentacion.form.FDatosMis;
import pe.qc.com.validator.presentacion.form.FInformacionTk;
import pe.qc.com.validator.presentacion.form.FLogin;
import pe.qc.com.validator.presentacion.form.FValidacion;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.PaginaUtil;
import pe.qc.com.validator.util.excepcion.BusinessLogicException;
import pe.qc.com.validator.util.excepcion.DataAccessException;

@Controller("cValidarMIS")
public class CValidarMIS {
	
	@Autowired
	NVob nVob;
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
	@Autowired
	NUsuario nUsuario;
	
	@Autowired
	NUnidades nUnidades;
	@Autowired
	NServidor nServidor;
	@Autowired
	NSOServidor nSOServidor;
	@Autowired
	NUsuarioAIX nUsuarioAIX;
	
	@Autowired
	NArchivoRutas nArchivoRutas;
	
	BOTipoSolicitud boTipoSolicitud;
	BODominio boDominio;
	BOVob boVob;
	
	FArchivoMisHandler fArchivoMISHandler;
	FInformacionTk fInformacionTk;
	FDatosMis fDatos;
	

	BOSolicitud boSolicitud;
	List<BOSolicitud> listaSolicitud;

	BODetalleSolicitud boDetalleSolicitud;
	List<BODetalleSolicitud> listaDetalleSolicitud;

	BOAplicativo boAplicativo;
	List<BOAplicativo> listaAplicativo;
	
	FLogin fLogin;
	
	private List<String> listaRutasNoClearCase;
	private boolean mostrar;
	private boolean mostrar1;
	private boolean mostrar2;
	private boolean mostrar3;

	@PostConstruct
	public void init() {
		inicializarObjetos();
	}

	public void inicializarObjetos() {
		try {
			fLogin = new FLogin();
			fLogin = (FLogin)SecurityContextHolder.getContext().getAuthentication().getDetails();
			fArchivoMISHandler = new FArchivoMisHandler(nUnidades,nServidor,nSOServidor, nUsuarioAIX, nArchivoRutas);
			boSolicitud = new BOSolicitud();
			boDetalleSolicitud = new BODetalleSolicitud();
			boVob =new BOVob();
			boDominio = new BODominio();
			boAplicativo = new BOAplicativo();
			boTipoSolicitud = new BOTipoSolicitud();
			listaSolicitud = nSolicitud.listarSolicitud(nUsuario.obtenerUsuarioXCodigo(fLogin.getUsuario()).getIdUsuario());
			mostrar = false;
			mostrar1 = true;
			mostrar2 = true;
			mostrar3= true;
		}catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
	}

	public void iniciarCargaDocumento() {
		PaginaUtil.ejecutar("PF('wgvCargarDocumentoMIS').show()");
	}
	
	public void iniciarCargaDocumentoTXT() {
		PaginaUtil.ejecutar("PF('wgvCargarDocumentoTXT').show()");
	}
	
	public void convertirArchivoTXT() {
		try{
			fArchivoMISHandler.transformarArchivoTXT();
			mostrar1 = true;
			mostrar2 = false;
			mostrar3= true;
			PaginaUtil.ejecutar("PF('wgvCargarDocumentoTXT').hide()");
			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Archivo de Rutas cargado con éxito");
		}catch (DataAccessException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (BusinessLogicException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
	}

	public void convertirArchivo() {
		try{
			mostrar1 = true;
			mostrar2 = true;
			mostrar3= false;
			fArchivoMISHandler.transformarArchivoMISXml();
			PaginaUtil.ejecutar("PF('wgvCargarDocumentoMIS').hide()");
			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Archivo MIS cargado con éxito");
		}catch (DataAccessException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (BusinessLogicException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
	}
	
	public void consultarInformacion(BOSolicitud boSolicitud) {
		this.boSolicitud = boSolicitud;
		this.boDetalleSolicitud = nDetalleSolicitud.obtenerDetalleSolicitudXId(boSolicitud.getIdDetalleSolicitud());
		this.boAplicativo = nAplicativo.obtenerAplicativoXId(boSolicitud.getIdCodigoApp());
		this.boTipoSolicitud = nTipoSolicitud.obtenerTipoSolicitudXId(boSolicitud.getIdTipoSolicitud());
		this.boDominio = nDominio.obtenerDominioXId(boAplicativo.getIdDominio());
		this.boVob = nVob.obtenerVobXId(boAplicativo.getIdVob());
		fInformacionTk = new FInformacionTk();
		fInformacionTk.cargarInformacion(boSolicitud, boDetalleSolicitud, boAplicativo, boTipoSolicitud, boDominio, boVob);
		mostrarDialog();
		mostrar = false;
		mostrar1 = false;
		mostrar2 = true;
		mostrar3= true;
		PaginaUtil.ejecutar("PF('wgvValidarTk').show()");
	}
	
	public void mostrarDialog(){
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
	
	public void validarInformacion(){
		fArchivoMISHandler.validarFDatos();
		(fArchivoMISHandler.getfDatosMis()).validarInformacionTK(fInformacionTk);
		System.out.println("VALIDACION : " + (fArchivoMISHandler.getfDatosMis()).getListaValidacion().toString());
	}
	
	public void validarServidores(){
		fArchivoMISHandler.validarFDatosServidor();
	}
	
	public void validarConfiguracionServidor() {
		fArchivoMISHandler.validarFDatosConfiguracion(boVob.getNombreVob(),boSolicitud.getTkSolicitud(), nUsuario.obtenerUsuarioXCodigo(fLogin.getUsuario()).getCodigoUsuario());
	}
	
	public void validarReversionServidor() {
		fArchivoMISHandler.validarFDatosReversion();
	}
	
	public void mostrarValidacionInformacion(){
		validarInformacion();
		validarServidores();
		validarConfiguracionServidor();
		validarReversionServidor();
		mostrar=true;
		fArchivoMISHandler.cantidadValidacionesGeneral();
	}
	
	public void consultarInformacionRutas(FValidacion fValidacion) {
		listaRutasNoClearCase = new ArrayList<>();
		for (String string : fValidacion.getComentarioAdicional()) {
			listaRutasNoClearCase.add(string);
		}
		PaginaUtil.ejecutar("PF('wgvRutasNoExistentes').show()");
	}
	
	public void consultarInformacionRutasR(FValidacion fValidacion) {
		listaRutasNoClearCase = new ArrayList<>();
		for (String string : fValidacion.getComentarioAdicional()) {
			listaRutasNoClearCase.add(string);
		}
		PaginaUtil.ejecutar("PF('wgvRutasNoExistentesR').show()");
	}
	
	public FArchivoMisHandler getfArchivoMISHandler() {
		return fArchivoMISHandler;
	}

	public void setfArchivoMISHandler(FArchivoMisHandler fArchivoMISHandler) {
		this.fArchivoMISHandler = fArchivoMISHandler;
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

	public BODetalleSolicitud getBoDetalleSolicitud() {
		return boDetalleSolicitud;
	}

	public void setBoDetalleSolicitud(BODetalleSolicitud boDetalleSolicitud) {
		this.boDetalleSolicitud = boDetalleSolicitud;
	}

	public List<BODetalleSolicitud> getListaDetalleSolicitud() {
		return listaDetalleSolicitud;
	}

	public void setListaDetalleSolicitud(List<BODetalleSolicitud> listaDetalleSolicitud) {
		this.listaDetalleSolicitud = listaDetalleSolicitud;
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

	public FInformacionTk getfInformacionTk() {
		return fInformacionTk;
	}

	public void setfInformacionTk(FInformacionTk fInformacionTk) {
		this.fInformacionTk = fInformacionTk;
	}

	public BOTipoSolicitud getBoTipoSolicitud() {
		return boTipoSolicitud;
	}

	public void setBoTipoSolicitud(BOTipoSolicitud boTipoSolicitud) {
		this.boTipoSolicitud = boTipoSolicitud;
	}

	public BODominio getBoDominio() {
		return boDominio;
	}

	public void setBoDominio(BODominio boDominio) {
		this.boDominio = boDominio;
	}

	public BOVob getBoVob() {
		return boVob;
	}

	public void setBoVob(BOVob boVob) {
		this.boVob = boVob;
	}

	public FDatosMis getfDatos() {
		return fDatos;
	}

	public void setfDatos(FDatosMis fDatos) {
		this.fDatos = fDatos;
	}

	public boolean isMostrar() {
		return mostrar;
	}

	public void setMostrar(boolean mostrar) {
		this.mostrar = mostrar;
	}

	public FLogin getfLogin() {
		return fLogin;
	}

	public void setfLogin(FLogin fLogin) {
		this.fLogin = fLogin;
	}

	public List<String> getListaRutasNoClearCase() {
		return listaRutasNoClearCase;
	}

	public void setListaRutasNoClearCase(List<String> listaRutasNoClearCase) {
		this.listaRutasNoClearCase = listaRutasNoClearCase;
	}
	public boolean isMostrar2() {
		return mostrar2;
	}

	public void setMostrar2(boolean mostrar2) {
		this.mostrar2 = mostrar2;
	}

	public boolean isMostrar3() {
		return mostrar3;
	}

	public void setMostrar3(boolean mostrar3) {
		this.mostrar3 = mostrar3;
	}

	public boolean isMostrar1() {
		return mostrar1;
	}

	public void setMostrar1(boolean mostrar1) {
		this.mostrar1 = mostrar1;
	}

}
