package pe.qc.com.validator.presentacion.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pe.qc.com.validator.negocio.bo.BOIPServidor;
import pe.qc.com.validator.negocio.bo.BORelacion;
import pe.qc.com.validator.negocio.bo.BOSOServidor;
import pe.qc.com.validator.negocio.bo.BOServidor;
import pe.qc.com.validator.negocio.bo.BOUnidades;
import pe.qc.com.validator.negocio.servicio.NIPServidor;
import pe.qc.com.validator.negocio.servicio.NRelacion;
import pe.qc.com.validator.negocio.servicio.NSOServidor;
import pe.qc.com.validator.negocio.servicio.NServidor;
import pe.qc.com.validator.negocio.servicio.NUnidades;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.PaginaUtil;

@Controller("cConsultarServidores")

public class CConsultarServidores {
	
	@Autowired
	NRelacion nRelacion;
	@Autowired
	NServidor nServidor;
	@Autowired
	NSOServidor nSOServidor;
	@Autowired
	NIPServidor nIPServidor;
	@Autowired
	NUnidades nUnidades;
	
	List<BORelacion> listarRelacion;
	List<BOIPServidor> listarIPServidor;
	BOServidor boServidor;
	List<BOSOServidor> listarSOServidor;
	List<BOUnidades> listarUnidades;
	
	@PostConstruct
	public void init(){
		inicializarObjetos();
	}
	
	public void inicializarObjetos(){
		try {
			listarRelacion = nRelacion.listarRelacion();
		}catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
	}
	
	public void iniciarConsultarServidor(BORelacion boRelacion) {
		obtenerInformacionServidor(boRelacion.getNombreServidor());
		obtenerListaIPServidor(boRelacion.getNombreServidor());
		obtenerListaSOServidor(boRelacion.getNombreServidor());
		obtenerListaUnidades(boRelacion.getNombreServidor());
		PaginaUtil.ejecutar("PF('wgvDetalleServidor').show()");
		
	}
	
	public void obtenerInformacionServidor(String nombreServidor) {
		boServidor = new BOServidor();
		boServidor = nServidor.obtenerServidor(nombreServidor);
	}
	
	public void obtenerListaSOServidor(String nombreServidor) {
		listarSOServidor = new ArrayList<>();
		listarSOServidor = nSOServidor.listarSOServidor(nombreServidor);
	}
	
	public void obtenerListaIPServidor(String nombreServidor) {
		listarIPServidor = new ArrayList<>();
		listarIPServidor = nIPServidor.listarIPServidor(nombreServidor);
	}
	
	public void obtenerListaUnidades(String nombreServidor) {
		listarUnidades = new ArrayList<>();
		listarUnidades = nUnidades.listarUnidades(nombreServidor);
	}
	
	public List<BORelacion> getListarRelacion() {
		return listarRelacion;
	}
	public void setListarRelacion(List<BORelacion> listarRelacion) {
		this.listarRelacion = listarRelacion;
	}

	public List<BOIPServidor> getListarIPServidor() {
		return listarIPServidor;
	}

	public void setListarIPServidor(List<BOIPServidor> listarIPServidor) {
		this.listarIPServidor = listarIPServidor;
	}

	public BOServidor getBoServidor() {
		return boServidor;
	}

	public void setBoServidor(BOServidor boServidor) {
		this.boServidor = boServidor;
	}

	public List<BOSOServidor> getListarSOServidor() {
		return listarSOServidor;
	}

	public void setListarSOServidor(List<BOSOServidor> listarSOServidor) {
		this.listarSOServidor = listarSOServidor;
	}

	public List<BOUnidades> getListarUnidades() {
		return listarUnidades;
	}

	public void setListarUnidades(List<BOUnidades> listarUnidades) {
		this.listarUnidades = listarUnidades;
	}
	
}
