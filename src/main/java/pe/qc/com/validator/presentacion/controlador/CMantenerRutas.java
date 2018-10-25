package pe.qc.com.validator.presentacion.controlador;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pe.qc.com.validator.negocio.bo.BOArchivoRutas;
import pe.qc.com.validator.negocio.servicio.NArchivoRutas;
import pe.qc.com.validator.presentacion.form.FArchivoRutas;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.PaginaUtil;
import pe.qc.com.validator.util.excepcion.BusinessLogicException;
import pe.qc.com.validator.util.excepcion.DataAccessException;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;

@Controller("cMantenerRutas")

public class CMantenerRutas {

	@Autowired
	NArchivoRutas nArchivoRutas;
	
	List<BOArchivoRutas> listarRutas;
	
	BOArchivoRutas boArchivoRutas;
	
	FArchivoRutas fArchivoRutas;
	
	@PostConstruct
	public void init() {
		inicializarObjetos();
	}
	
	public void inicializarObjetos() {
		boArchivoRutas = new BOArchivoRutas();
		listarRutas = nArchivoRutas.listarArchivoRutas();
		descartarFecha();
		fArchivoRutas = new FArchivoRutas();
	}
	
	public void iniciarAgregarRutas() {
		boArchivoRutas = new BOArchivoRutas();
		PaginaUtil.ejecutar("PF('wgvAgregarRuta').show()");
		obtenerListaTipoServidor();
	}
	
	public void iniciarCargaDocumentoTXT() {
		PaginaUtil.ejecutar("PF('wgvCargarDocumentoTXT').show()");
	}
	
	public void convertirArchivoTXT() {
		try{
			fArchivoRutas.transformarArchivoTXT();
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
	
	public void visualizarInformacion() {
		boArchivoRutas.setServidorValidatorRutas(fArchivoRutas.getNombreArchivo().trim().toUpperCase());
		boArchivoRutas.setRutaValidatorRutas(fArchivoRutas.getRuta().trim());
	}
	
	public void agregarRutaServidor() {
		try {
			completarInformacion();
			buscarRepetido();
			listarRutas = nArchivoRutas.listarArchivoRutas();
			PaginaUtil.ejecutar("PF('wgvAgregarRuta').hide()");
			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Ruta Servidor agregada correctamente");
		} catch (NegocioExcepcion e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} finally {
			PaginaUtil.ejecutar("PF('wgvAgregarRuta').hide()");
		}
	}
	
	public void completarInformacion() {
		boArchivoRutas.setFechaRegistro(new java.util.Date());
	}
	
	public void obtenerListaTipoServidor() {
		boArchivoRutas.obtenerSelectItemTipoServidor();
	}
	
	public void descartarFecha() {
		Date hoy = new java.util.Date();
		for (BOArchivoRutas boArchivoRutas : listarRutas) {
			int i = (int) ((hoy.getTime()-boArchivoRutas.getFechaRegistro().getTime())/86400000);
			System.out.println("Dias : " + i);
			if(i>30) {
				nArchivoRutas.eliminarArchivoRuta(boArchivoRutas.getIdValidatorRutas());
			}
		}
		listarRutas = nArchivoRutas.listarArchivoRutas();
	}
	
	public void buscarRepetido() {
		BOArchivoRutas boArchivoRutas1 = new BOArchivoRutas();
		boArchivoRutas1 = nArchivoRutas.obtenerRutaxRuta(boArchivoRutas.getRutaValidatorRutas(), boArchivoRutas.getServidorValidatorRutas());
		if(boArchivoRutas1!=null){
			if(boArchivoRutas1.getServidorValidatorRutas().trim().equalsIgnoreCase(boArchivoRutas.getServidorValidatorRutas().trim())&& boArchivoRutas1.getRutaValidatorRutas().trim().equalsIgnoreCase(boArchivoRutas.getRutaValidatorRutas().trim())){
				boArchivoRutas.setIdValidatorRutas(boArchivoRutas1.getIdValidatorRutas());
				nArchivoRutas.modificarArchivoRuta(boArchivoRutas);
			}
		} else {
			nArchivoRutas.insertarArchivoRuta(boArchivoRutas);
		}
	}

	public List<BOArchivoRutas> getListarRutas() {
		return listarRutas;
	}

	public void setListarRutas(List<BOArchivoRutas> listarRutas) {
		this.listarRutas = listarRutas;
	}

	public BOArchivoRutas getBoArchivoRutas() {
		return boArchivoRutas;
	}

	public void setBoArchivoRutas(BOArchivoRutas boArchivoRutas) {
		this.boArchivoRutas = boArchivoRutas;
	}

	public FArchivoRutas getfArchivoRutas() {
		return fArchivoRutas;
	}

	public void setfArchivoRutas(FArchivoRutas fArchivoRutas) {
		this.fArchivoRutas = fArchivoRutas;
	}
	
}
