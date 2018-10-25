package pe.qc.com.validator.presentacion.controlador;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import pe.qc.com.validator.negocio.bo.BOAplicativo;
import pe.qc.com.validator.negocio.bo.BODetalleSolicitud;
import pe.qc.com.validator.negocio.bo.BODominio;
import pe.qc.com.validator.negocio.bo.BOEquipo;
import pe.qc.com.validator.negocio.bo.BOEtapa;
import pe.qc.com.validator.negocio.bo.BOSolicitud;
import pe.qc.com.validator.negocio.bo.BOTarea;
import pe.qc.com.validator.negocio.bo.BOTipoSolicitud;
import pe.qc.com.validator.negocio.bo.BOTipoTarea;
import pe.qc.com.validator.negocio.bo.BOVob;
import pe.qc.com.validator.negocio.servicio.NAplicativo;
import pe.qc.com.validator.negocio.servicio.NDetalleSolicitud;
import pe.qc.com.validator.negocio.servicio.NDominio;
import pe.qc.com.validator.negocio.servicio.NEquipo;
import pe.qc.com.validator.negocio.servicio.NEtapa;
import pe.qc.com.validator.negocio.servicio.NSolicitud;
import pe.qc.com.validator.negocio.servicio.NTarea;
import pe.qc.com.validator.negocio.servicio.NTipoSolicitud;
import pe.qc.com.validator.negocio.servicio.NTipoTarea;
import pe.qc.com.validator.negocio.servicio.NUsuario;
import pe.qc.com.validator.negocio.servicio.NVob;
import pe.qc.com.validator.presentacion.form.FLogin;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.PaginaUtil;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;

@Controller("cTareaRechazada")

public class CTareaRechazada {
	
	FLogin fLogin;
	
	List<Map<String, Object>> listaMapTarea;
	Map<String, Object> mapTarea;
	
	BOTarea boTarea;
	BOSolicitud boSolicitud;
	BODetalleSolicitud boDetalleSolicitud;
	BOTipoSolicitud boTipoSolicitud;
	BOVob boVob;
	BODominio boDominio;
	BOAplicativo boAplicativo;
	BOTipoTarea boTipoTarea;
	BOEquipo boEquipo;
	BOEtapa boEtapa;
	
	
	private String nombreTK;
	
	private boolean mostrarSN;
	private boolean mostrarSS;
	private boolean mostrarINC;
	private boolean mostrarEtapa;
	private boolean mostrarEquipo;
	
	@Autowired
	NTarea nTarea;
	@Autowired
	NUsuario nUsuario;
	@Autowired
	NTipoTarea nTipoTarea;
	@Autowired
	NEtapa nEtapa;
	@Autowired
	NEquipo nEquipo;
	@Autowired
	NSolicitud nSolicitud;
	@Autowired
	NDetalleSolicitud nDetalleSolicitud;
	@Autowired
	NTipoSolicitud nTipoSolicitud;
	@Autowired
	NAplicativo nAplicativo;
	@Autowired
	NDominio nDominio;
	@Autowired
	NVob nVob;
	@Autowired

	@PostConstruct
	public void init() {
		inicializarObjetos();
	}

	public void inicializarObjetos() {
		try {
			fLogin = new FLogin();
			boTarea = new BOTarea();
			nombreTK="";
			fLogin = (FLogin)SecurityContextHolder.getContext().getAuthentication().getDetails();
			listaMapTarea = nTarea.listarMapTarea(nUsuario.obtenerUsuarioXCodigo(fLogin.getUsuario()).getIdUsuario());
		}catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
	}
	
	public void iniciarAgregarTarea() {
		inicializar();
		PaginaUtil.ejecutar("PF('wgvAgregarTarea').show()");
	}
	
	public void iniciarCargaCorreo() {
		boTarea.setArchivoTarea(null);
		boTarea.setArchivoTareaStreamed(null);
		boTarea.setNombreArchivo(null);
		PaginaUtil.ejecutar("PF('wgvCargarCorreo').show()");
	}
	
	public void mostrarPanel() {
		if(boTarea.getIdTipoTarea() == 0) {
			
			boTarea.setMostrarCampos(false);
		}else {
			
			if(boTarea.getIdTipoTarea() == 1) {
				boTarea.setMostrarEtapa(true);
				boTarea.setMostrarEquipo(false);
				boTarea.setMostrarBoton(true);
				boTarea.setMostrarMensaje(false);
			}else if(boTarea.getIdTipoTarea() == 2) {
				boTarea.setMostrarEquipo(true);
				boTarea.setMostrarEtapa(false);
				boTarea.setMostrarBoton(true);
				boTarea.setMostrarMensaje(false);
			}
			boTarea.setMostrarCampos(true);
		}
	}
	
	public void inicializar() {
		boTarea = new BOTarea();
		boSolicitud = new BOSolicitud();
		boDetalleSolicitud = new BODetalleSolicitud();
		boTipoSolicitud = new BOTipoSolicitud();
		boVob = new BOVob();
		boDominio = new BODominio();
		boAplicativo = new BOAplicativo();
		nombreTK="";
		boTarea.setMostrarCampos(false);
		boTarea.setMostrarEquipo(false);
		boTarea.setMostrarEtapa(false);
		boTarea.setMostrarBoton(true);
		boTarea.setMostrarMensaje(false);
		obtenerSelectItemTipoTarea();
		obtenerSelectItemEquipo();
		obtenerSelectItemEtapa();
	}
	
	public void inicializarObjectos() {
		boTarea = new BOTarea();
		boEtapa = new BOEtapa();
		boEquipo = new BOEquipo();
		boTipoTarea = new BOTipoTarea();
		boSolicitud = new BOSolicitud();
		boDetalleSolicitud = new BODetalleSolicitud();
		boTipoSolicitud = new BOTipoSolicitud();
		boVob = new BOVob();
		boDominio = new BODominio();
		boAplicativo = new BOAplicativo();
		mostrarSN = false;
		mostrarSS = false;
		mostrarEquipo = false;
		mostrarEtapa = false;
		mostrarINC = false;
	}
	
	public void obtenerSelectItemTipoTarea() {
		boTarea.obtenerSelectItemsTipoTarea(nTipoTarea.listarTipoTarea());
	}
	
	public void obtenerSelectItemEtapa() {
		boTarea.obtenerSelectItemsEtapa(nEtapa.listarEtapa());
	}
	
	public void obtenerSelectItemEquipo() {
		boTarea.obtenerSelectItemsEquipo(nEquipo.listarEquipo());
	}
	
	public void iniciarDescargarCorreo(int idTarea) {
		boTarea = nTarea.obtenerTareaXId(idTarea);
	}
	
	public void buscarTK() {
		boSolicitud = nSolicitud.obtenerSolicitudXnombreTkPrimero(nombreTK);
		boDetalleSolicitud = nDetalleSolicitud.obtenerDetalleSolicitudXId(boSolicitud.getIdDetalleSolicitud());
		boTipoSolicitud = new BOTipoSolicitud();
		boVob = new BOVob();
		boDominio = new BODominio();
		boAplicativo = new BOAplicativo();
		boTipoSolicitud = nTipoSolicitud.obtenerTipoSolicitudXId(boSolicitud.getIdTipoSolicitud());
		if(boTipoSolicitud.getIdTipoSolicitud() == Constantes.SOL_NEGOCIO) {
			boDetalleSolicitud.setIncDetalleSolicitud("-");
			boDetalleSolicitud.setSsDetalleSolicitud("-");
		}else if(boTipoSolicitud.getIdTipoSolicitud() == Constantes.SOL_SERVICIO) {
			boDetalleSolicitud.setIncDetalleSolicitud("-");
			boDetalleSolicitud.setSnDetalleSolicitud("-");
			boDetalleSolicitud.setStDetalleSolicitud("-");
		}else if(boTipoSolicitud.getIdTipoSolicitud() == Constantes.ERROR_EN_PRODUCCION) {
			boDetalleSolicitud.setSnDetalleSolicitud("-");
			boDetalleSolicitud.setStDetalleSolicitud("-");
			boDetalleSolicitud.setSsDetalleSolicitud("-");
		}
		boAplicativo = nAplicativo.obtenerAplicativoXIdVob(boSolicitud.getIdCodigoApp());
		boVob = nVob.obtenerVobXId(boAplicativo.getIdVob());
		boDominio = nDominio.obtenerDominioXId(boAplicativo.getIdDominio());
		if(boTarea.getIdTipoTarea() == 2) {
			boTarea.setMostrarBoton(false);
		}
		
	}
	
	public void archivoCargado() {
		boTarea.setMostrarBoton(true);
		boTarea.setMostrarMensaje(true);
		PaginaUtil.ejecutar("PF('wgvCargarCorreo').hide()");
		PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Corredo adjuntado correctamente");
	}
	
	public void agregarTarea() {
		try {
			boTarea.setIdUsuarioTarea(nUsuario.obtenerUsuarioXCodigo(fLogin.getUsuario()).getIdUsuario());
			boTarea.setIdSolicitudTarea(boSolicitud.getIdSolicitud());
			if(boTarea.getIdTipoTarea()==1) {
				boTarea.setIdEquipoTarea(Constantes.ESTADO_NULL_EQUIPO);
			}else if(boTarea.getIdTipoTarea()==2) {
				boTarea.setIdEtapaTarea(Constantes.ESTADO_NULL_ETAPA);
			}
			boTarea.setFechaTarea(new java.util.Date());
			nTarea.insertarTarea(boTarea);
			listaMapTarea = nTarea.listarMapTarea(nUsuario.obtenerUsuarioXCodigo(fLogin.getUsuario()).getIdUsuario());
			PaginaUtil.ejecutar("PF('wgvAgregarTarea').hide()");
			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Tarea Registrada correctamente");
		} catch (NegocioExcepcion e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} finally {
			PaginaUtil.ejecutar("PF('wgvAgregarTarea').hide()");
		}
	}
	
	public void eliminarTarea() {
		try {
			Integer idTareaSeleccionado = Integer.parseInt(String.valueOf(mapTarea.get("idTarea")));
			nTarea.eliminarTarea(idTareaSeleccionado);
			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Tarea eliminada exitosamente");
			PaginaUtil.ejecutar("PF('wgvEliminarTarea').hide()");
			listaMapTarea = nTarea.listarMapTarea(nUsuario.obtenerUsuarioXCodigo(fLogin.getUsuario()).getIdUsuario());
		}catch (NegocioExcepcion e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} finally {
			PaginaUtil.ejecutar("PF('wgvEliminarTarea').hide()");
		}
	}
	
	public void mostrarTarea(int idTarea) {
		inicializarObjectos();
		boTarea = nTarea.obtenerTareaXId(idTarea);
		boSolicitud = nSolicitud.obtenerSolicitudXId(boTarea.getIdSolicitudTarea());
		if(boTarea.getIdTipoTarea()==1) {
			mostrarEtapa = true;
			if(boSolicitud.getIdTipoSolicitud()==Constantes.SOL_NEGOCIO) {
				mostrarSN = true;
			}else if(boSolicitud.getIdTipoSolicitud()==Constantes.SOL_SERVICIO) {
				mostrarSS = true;
			}else if(boSolicitud.getIdTipoSolicitud()==Constantes.ERROR_EN_PRODUCCION) {
				mostrarINC = true;
			}
		}else if(boTarea.getIdTipoTarea()==2){
			mostrarEquipo = true;
			if(boSolicitud.getIdTipoSolicitud()==Constantes.SOL_NEGOCIO) {
				mostrarSN = true;
			}else if(boSolicitud.getIdTipoSolicitud()==Constantes.SOL_SERVICIO) {
				mostrarSS = true;
			}else if(boSolicitud.getIdTipoSolicitud()==Constantes.ERROR_EN_PRODUCCION) {
				mostrarINC = true;
			}
		}
		boDetalleSolicitud = nDetalleSolicitud.obtenerDetalleSolicitudXId(boSolicitud.getIdDetalleSolicitud());
		boTipoTarea = nTipoTarea.obtenerTipoTareaXId(boTarea.getIdTipoTarea());
		boEtapa = nEtapa.obtenerEtapaXId(boTarea.getIdEtapaTarea());
		boEquipo = nEquipo.obtenerEquipoXId(boTarea.getIdEquipoTarea());
		boAplicativo = nAplicativo.obtenerAplicativoXId(boSolicitud.getIdCodigoApp());
		boDominio = nDominio.obtenerDominioXId(boAplicativo.getIdDominio());
		boVob = nVob.obtenerVobXId(boAplicativo.getIdVob());
		boTipoSolicitud = nTipoSolicitud.obtenerTipoSolicitudXId(boSolicitud.getIdTipoSolicitud());	
		PaginaUtil.ejecutar("PF('wgvConsultarTarea').show()");
	}
	public List<Map<String, Object>> getListaMapTarea() {
		return listaMapTarea;
	}

	public void setListaMapTarea(List<Map<String, Object>> listaMapTarea) {
		this.listaMapTarea = listaMapTarea;
	}
	
	public FLogin getfLogin() {
		return fLogin;
	}

	public void setfLogin(FLogin fLogin) {
		this.fLogin = fLogin;
	}

	public BOTarea getBoTarea() {
		return boTarea;
	}

	public void setBoTarea(BOTarea boTarea) {
		this.boTarea = boTarea;
	}

	public BOSolicitud getBoSolicitud() {
		return boSolicitud;
	}

	public void setBoSolicitud(BOSolicitud boSolicitud) {
		this.boSolicitud = boSolicitud;
	}

	public BODetalleSolicitud getBoDetalleSolicitud() {
		return boDetalleSolicitud;
	}

	public void setBoDetalleSolicitud(BODetalleSolicitud boDetalleSolicitud) {
		this.boDetalleSolicitud = boDetalleSolicitud;
	}

	public String getNombreTK() {
		return nombreTK;
	}

	public void setNombreTK(String nombreTK) {
		this.nombreTK = nombreTK;
	}

	public BOTipoSolicitud getBoTipoSolicitud() {
		return boTipoSolicitud;
	}

	public void setBoTipoSolicitud(BOTipoSolicitud boTipoSolicitud) {
		this.boTipoSolicitud = boTipoSolicitud;
	}

	public BOVob getBoVob() {
		return boVob;
	}

	public void setBoVob(BOVob boVob) {
		this.boVob = boVob;
	}

	public BODominio getBoDominio() {
		return boDominio;
	}

	public void setBoDominio(BODominio boDominio) {
		this.boDominio = boDominio;
	}

	public BOAplicativo getBoAplicativo() {
		return boAplicativo;
	}

	public void setBoAplicativo(BOAplicativo boAplicativo) {
		this.boAplicativo = boAplicativo;
	}

	public Map<String, Object> getMapTarea() {
		return mapTarea;
	}

	public void setMapTarea(Map<String, Object> mapTarea) {
		this.mapTarea = mapTarea;
	}

	public BOTipoTarea getBoTipoTarea() {
		return boTipoTarea;
	}

	public void setBoTipoTarea(BOTipoTarea boTipoTarea) {
		this.boTipoTarea = boTipoTarea;
	}

	public BOEquipo getBoEquipo() {
		return boEquipo;
	}

	public void setBoEquipo(BOEquipo boEquipo) {
		this.boEquipo = boEquipo;
	}

	public BOEtapa getBoEtapa() {
		return boEtapa;
	}

	public void setBoEtapa(BOEtapa boEtapa) {
		this.boEtapa = boEtapa;
	}

	public boolean isMostrarSN() {
		return mostrarSN;
	}

	public void setMostrarSN(boolean mostrarSN) {
		this.mostrarSN = mostrarSN;
	}

	public boolean isMostrarSS() {
		return mostrarSS;
	}

	public void setMostrarSS(boolean mostrarSS) {
		this.mostrarSS = mostrarSS;
	}

	public boolean isMostrarINC() {
		return mostrarINC;
	}

	public void setMostrarINC(boolean mostrarINC) {
		this.mostrarINC = mostrarINC;
	}

	public boolean isMostrarEtapa() {
		return mostrarEtapa;
	}

	public void setMostrarEtapa(boolean mostrarEtapa) {
		this.mostrarEtapa = mostrarEtapa;
	}

	public boolean isMostrarEquipo() {
		return mostrarEquipo;
	}

	public void setMostrarEquipo(boolean mostrarEquipo) {
		this.mostrarEquipo = mostrarEquipo;
	}

}
