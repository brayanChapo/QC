package pe.qc.com.validator.presentacion.controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pe.qc.com.validator.negocio.bo.BOArchivoMIS;
import pe.qc.com.validator.negocio.servicio.NArchivoMIS;
import pe.qc.com.validator.negocio.servicio.NSolicitud;
import pe.qc.com.validator.presentacion.form.Reporte;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.PaginaUtil;
import pe.qc.com.validator.util.excepcion.BusinessLogicException;
import pe.qc.com.validator.util.excepcion.DataAccessException;

@Controller("cReporteMIS")

public class CReporteMIS {

	@Autowired
	NSolicitud nSolicitud;
	@Autowired
	NArchivoMIS nArchivoMIS;
	
	private Date fechaInicio;
	private Date fechaFin;
	
	Reporte fReporte;
	
	List<Map<String, Object>> listaSolicitudFecha;
	List<BOArchivoMIS> listaArchivoMIS;
	BOArchivoMIS boArchivoMISReporte;
	
	@PostConstruct
	public void init() {
		inicializarObjetos();
	}

	public void inicializarObjetos() {
		try {
			listaSolicitudFecha = new ArrayList<>();
			fechaFin = null;
			fechaInicio = null;
			fReporte = new Reporte();
			fReporte.init(0,0);
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}	
	}
	
	public void buscarSolicitud() {
		listaSolicitudFecha = nSolicitud.listarMapSolicitudXFechas(fechaInicio, fechaFin);
	}
	
	public void visualizarReporte(Map<String, Object> mapSeleccionado) {
		try{
			BOArchivoMIS boArchivotemp = new BOArchivoMIS();
			Integer idSolicitud = Integer.parseInt(String.valueOf(mapSeleccionado.get("idSolicitud")));
			listaArchivoMIS = new ArrayList<>();
			List<String> lista = listarIHistoricoSolicitud(idSolicitud);
			boArchivotemp = buscarReporte(lista);
			listaArchivoMIS = nArchivoMIS.listarArchivoMISHistorico(boArchivotemp.getIdArchivoMIS());
			PaginaUtil.ejecutar("PF('wgvHistoricoReporte').show()");
		}catch (DataAccessException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (BusinessLogicException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}	
	}
	
	public List<String> listarIHistoricoSolicitud(Integer idSolicitud){
		List<Map<String, Object>> listaMapHistoricaSolicitud = new ArrayList<Map<String, Object>>();
		listaMapHistoricaSolicitud = nSolicitud.listarMapHistoricaSolicitud(idSolicitud);
		List<String> listaIDHistorico = new ArrayList<>();
		for (Map<String, Object> solicitud : listaMapHistoricaSolicitud) {
			listaIDHistorico.add(String.valueOf(solicitud.get("idSolicitud")));
		}
		return listaIDHistorico;
	}
	
	public BOArchivoMIS buscarReporte(List<String> lista) {
		for (String string : lista) {
			int id = Integer.parseInt(string);
			if(nArchivoMIS.obtenerArchivoMISXId(id)!=null) {
				return nArchivoMIS.obtenerArchivoMISXId(id);
			}
		}
		return null;
	}
	
	public void verReporte(BOArchivoMIS boArchivoMIS) {
		boArchivoMISReporte = new BOArchivoMIS();
		boArchivoMISReporte = boArchivoMIS;
		
		try{
			fReporte = new Reporte();
			fReporte.init(boArchivoMIS.getCantValCorrMIS(), boArchivoMIS.getCantValIncMIS());
			PaginaUtil.ejecutar("PF('wgvReporteMIS').show()");
		}catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<Map<String, Object>> getListaSolicitudFecha() {
		return listaSolicitudFecha;
	}

	public void setListaSolicitudFecha(List<Map<String, Object>> listaSolicitudFecha) {
		this.listaSolicitudFecha = listaSolicitudFecha;
	}

	public List<BOArchivoMIS> getListaArchivoMIS() {
		return listaArchivoMIS;
	}

	public void setListaArchivoMIS(List<BOArchivoMIS> listaArchivoMIS) {
		this.listaArchivoMIS = listaArchivoMIS;
	}
	
	public Reporte getfReporte() {
		return fReporte;
	}
	
	public void setfReporte(Reporte fReporte) {
		this.fReporte = fReporte;
	}

	public BOArchivoMIS getBoArchivoMISReporte() {
		return boArchivoMISReporte;
	}

	public void setBoArchivoMISReporte(BOArchivoMIS boArchivoMISReporte) {
		this.boArchivoMISReporte = boArchivoMISReporte;
	}
	
}
