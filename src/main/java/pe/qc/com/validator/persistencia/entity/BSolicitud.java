package pe.qc.com.validator.persistencia.entity;

import java.util.Date;

public class BSolicitud {
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
	
	public BSolicitud() {
			
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
		return "BSolicitud [idSolicitud=" + idSolicitud + ", idDetalleSolicitud=" + idDetalleSolicitud
				+ ", idTipoSolicitud=" + idTipoSolicitud + ", idEstadoSolicitud=" + idEstadoSolicitud + ", idCodigoApp="
				+ idCodigoApp + ", idUsuario=" + idUsuario + ", idPlataforma=" + idPlataforma
				+ ", idHistoricoSolicitud=" + idHistoricoSolicitud + ", tkSolicitud=" + tkSolicitud + ", crqSolicitud="
				+ crqSolicitud + ", criticidadSolicitud=" + criticidadSolicitud + ", esHistorico=" + esHistorico
				+ ", fechaSolicitud=" + fechaSolicitud + "]";
	}
	
}
