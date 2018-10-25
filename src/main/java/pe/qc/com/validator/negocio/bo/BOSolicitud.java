package pe.qc.com.validator.negocio.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

public class BOSolicitud implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer idSolicitud;
	private Integer idDetalleSolicitud;
	private Integer idTipoSolicitud;
	private Integer idEstadoSolicitud;
	private Integer idCodigoApp;
	private Integer idUsuario;
	private Integer idRevisor;
	private Integer idPlataforma;
	private Integer idHistoricoSolicitud;
	private String tkSolicitud;
	private String crqSolicitud;
	private String criticidadSolicitud;
	private char esHistorico;
	private Date fechaSolicitud;
	
	private List<SelectItem> listaTipoSolicitud;
	private List<SelectItem> listaPlataforma;
	private List<SelectItem> listaAplicativo;
	private List<SelectItem> listaEstadoSolicitud;
	
	private Boolean mostrarDatoSolicitud;
	private Boolean mostrarSolNegocio;
	private Boolean mostrarSolTecnico;
	private Boolean mostrarSolServicio;
	private Boolean mostrarIncidencia;
	
	
	public BOSolicitud() {
		
	}
	
	/**
	 * @param lista
	 * lleno el atributo listaTipoSolicitud (List<SelectItem>) con datos
	 * para eso los datos se transforma de List<BOTipoSolicitud> a List<SelectItem>
	 */
	public void obtenerSelectItemsTipoSolicitud(List<BOTipoSolicitud> lista) {
		if (lista != null && lista.size() > 0) {
			listaTipoSolicitud = new ArrayList<SelectItem>();
			for (BOTipoSolicitud boTipoSolicitud : lista) {
				SelectItem item = new SelectItem();
				item.setLabel(boTipoSolicitud.getNombreTipoSolicitud());
				item.setValue(boTipoSolicitud.getIdTipoSolicitud());
				listaTipoSolicitud.add(item);
			}
		}
	}
	
	/**
	 * @param lista
	 * lleno el atributo listaPlataforma (List<SelectItem>) con datos
	 * para eso los datos se transforma de List<BOPlataforma> a List<SelectItem>
	 */
	public void obtenerSelectItemsPlataforma(List<BOPlataforma> lista) {
		if (lista != null && lista.size() > 0) {
			listaPlataforma = new ArrayList<SelectItem>();
			for (BOPlataforma boPlataforma : lista) {
				SelectItem item = new SelectItem();
				item.setLabel(boPlataforma.getNombrePlataforma());
				item.setValue(boPlataforma.getIdPlataforma());
				listaPlataforma.add(item);
			}
		}
	}

	/**
	 * @param lista
	 * lleno el atributo listaPlataforma (List<SelectItem>) con datos
	 * para eso los datos se transforma de List<BOPlataforma> a List<SelectItem>
	 */
	public void obtenerSelectItemsAplicativo(List<BOAplicativo> lista) {
		if (lista != null && lista.size() > 0) {
			listaAplicativo = new ArrayList<SelectItem>();
			for (BOAplicativo boAplicativo : lista) {
				SelectItem item = new SelectItem();
				item.setLabel(boAplicativo.getNombreAplicativo());
				item.setValue(boAplicativo.getIdAplicativo());
				listaAplicativo.add(item);
			}
		}
	}
	
	/**
	 * @param lista
	 * lleno el atributo listaTipoSolicitud (List<SelectItem>) con datos
	 * para eso los datos se transforma de List<BOTipoSolicitud> a List<SelectItem>
	 */
	public void obtenerSelectItemsEstadoSolicitud(List<BOEstadoSolicitud> lista) {
		if (lista != null && lista.size() > 0) {
			listaEstadoSolicitud = new ArrayList<SelectItem>();
			for (BOEstadoSolicitud boEstadoSolicitud : lista) {
				SelectItem item = new SelectItem();
				item.setLabel(boEstadoSolicitud.getNombreEstadoSolicitud());
				item.setValue(boEstadoSolicitud.getIdEstadoSolicitud());
				listaEstadoSolicitud.add(item);
			}
		}
	}
	
	/**
	 * @param lista
	 * lleno el atributo listaTipoSolicitud (List<SelectItem>) con datos
	 * para eso los datos se transforma de List<BOTipoSolicitud> a List<SelectItem>
	 */
	public void obtenerSelectItemsEstadoSolicitudRevisar(List<BOEstadoSolicitud> lista) {
		if (lista != null && lista.size() > 0) {
			listaEstadoSolicitud = new ArrayList<SelectItem>();
			for (BOEstadoSolicitud boEstadoSolicitud : lista) {
				if(!(boEstadoSolicitud.getIdEstadoSolicitud()==7)) {
					SelectItem item = new SelectItem();
					item.setLabel(boEstadoSolicitud.getNombreEstadoSolicitud());
					item.setValue(boEstadoSolicitud.getIdEstadoSolicitud());
					listaEstadoSolicitud.add(item);
				}
			}
		}
	}
	
	public void obtenerFechaActual(){
		fechaSolicitud = new java.util.Date();
	}
	
	public Integer getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public Integer getIdDetalleSolicitud() {
		return idDetalleSolicitud;
	}

	public void setIdDetalleSolicitud(Integer idDetalleSolicitud) {
		this.idDetalleSolicitud = idDetalleSolicitud;
	}

	public Integer getIdTipoSolicitud() {
		return idTipoSolicitud;
	}

	public void setIdTipoSolicitud(Integer idTipoSolicitud) {
		this.idTipoSolicitud = idTipoSolicitud;
	}

	public Integer getIdEstadoSolicitud() {
		return idEstadoSolicitud;
	}

	public void setIdEstadoSolicitud(Integer idEstadoSolicitud) {
		this.idEstadoSolicitud = idEstadoSolicitud;
	}

	public Integer getIdCodigoApp() {
		return idCodigoApp;
	}

	public void setIdCodigoApp(Integer idCodigoApp) {
		this.idCodigoApp = idCodigoApp;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdPlataforma() {
		return idPlataforma;
	}

	public void setIdPlataforma(Integer idPlataforma) {
		this.idPlataforma = idPlataforma;
	}

	public Integer getIdHistoricoSolicitud() {
		return idHistoricoSolicitud;
	}

	public void setIdHistoricoSolicitud(Integer idHistoricoSolicitud) {
		this.idHistoricoSolicitud = idHistoricoSolicitud;
	}

	public String getTkSolicitud() {
		return tkSolicitud;
	}

	public void setTkSolicitud(String tkSolicitud) {
		this.tkSolicitud = tkSolicitud;
	}

	public String getCrqSolicitud() {
		return crqSolicitud;
	}

	public void setCrqSolicitud(String crqSolicitud) {
		this.crqSolicitud = crqSolicitud;
	}

	public String getCriticidadSolicitud() {
		return criticidadSolicitud;
	}

	public void setCriticidadSolicitud(String criticidadSolicitud) {
		this.criticidadSolicitud = criticidadSolicitud;
	}

	public char getEsHistorico() {
		return esHistorico;
	}

	public void setEsHistorico(char esHistorico) {
		this.esHistorico = esHistorico;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Integer getIdRevisor() {
		return idRevisor;
	}

	public void setIdRevisor(Integer idRevisor) {
		this.idRevisor = idRevisor;
	}

	@Override
	public String toString() {
		return "BOSolicitud [idSolicitud=" + idSolicitud + ", idDetalleSolicitud=" + idDetalleSolicitud
				+ ", idTipoSolicitud=" + idTipoSolicitud + ", idEstadoSolicitud=" + idEstadoSolicitud + ", idCodigoApp="
				+ idCodigoApp + ", idUsuario=" + idUsuario + ", idPlataforma=" + idPlataforma
				+ ", idHistoricoSolicitud=" + idHistoricoSolicitud + ", tkSolicitud=" + tkSolicitud + ", crqSolicitud="
				+ crqSolicitud + ", criticidadSolicitud=" + criticidadSolicitud + ", esHistorico=" + esHistorico
				+ ", fechaSolicitud=" + fechaSolicitud + "]";
	}

	public List<SelectItem> getListaTipoSolicitud() {
		return listaTipoSolicitud;
	}

	public void setListaTipoSolicitud(List<SelectItem> listaTipoSolicitud) {
		this.listaTipoSolicitud = listaTipoSolicitud;
	}

	public List<SelectItem> getListaPlataforma() {
		return listaPlataforma;
	}

	public void setListaPlataforma(List<SelectItem> listaPlataforma) {
		this.listaPlataforma = listaPlataforma;
	}

	public List<SelectItem> getListaAplicativo() {
		return listaAplicativo;
	}

	public void setListaAplicativo(List<SelectItem> listaAplicativo) {
		this.listaAplicativo = listaAplicativo;
	}

	public Boolean getMostrarDatoSolicitud() {
		return mostrarDatoSolicitud;
	}

	public void setMostrarDatoSolicitud(Boolean mostrarDatoSolicitud) {
		this.mostrarDatoSolicitud = mostrarDatoSolicitud;
	}

	public Boolean getMostrarSolNegocio() {
		return mostrarSolNegocio;
	}

	public void setMostrarSolNegocio(Boolean mostrarSolNegocio) {
		this.mostrarSolNegocio = mostrarSolNegocio;
	}

	public Boolean getMostrarSolTecnico() {
		return mostrarSolTecnico;
	}

	public void setMostrarSolTecnico(Boolean mostrarSolTecnico) {
		this.mostrarSolTecnico = mostrarSolTecnico;
	}

	public Boolean getMostrarSolServicio() {
		return mostrarSolServicio;
	}

	public void setMostrarSolServicio(Boolean mostrarSolServicio) {
		this.mostrarSolServicio = mostrarSolServicio;
	}

	public Boolean getMostrarIncidencia() {
		return mostrarIncidencia;
	}

	public void setMostrarIncidencia(Boolean mostrarIncidencia) {
		this.mostrarIncidencia = mostrarIncidencia;
	}

	public List<SelectItem> getListaEstadoSolicitud() {
		return listaEstadoSolicitud;
	}

	public void setListaEstadoSolicitud(List<SelectItem> listaEstadoSolicitud) {
		this.listaEstadoSolicitud = listaEstadoSolicitud;
	}
	
}
