package pe.qc.com.validator.persistencia.entity;

import java.util.Arrays;
import java.util.Date;

public class BTarea {
	
	private Integer idTarea;
	private Integer idUsuarioTarea;
	private Integer idEquipoTarea;
	private Integer idTipoTarea;
	private Integer idEtapaTarea;
	private Integer idSolicitudTarea;
	private String nombreTarea;
	private String crqTarea;
	private String descripcionTarea;
	private byte[] archivoTarea;
	private String nombreArchivo;
	private Date fechaTarea;
	private String woTarea;
	
	public BTarea() {
		
	}

	public Integer getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(Integer idTarea) {
		this.idTarea = idTarea;
	}

	public Integer getIdEquipoTarea() {
		return idEquipoTarea;
	}

	public void setIdEquipoTarea(Integer idEquipoTarea) {
		this.idEquipoTarea = idEquipoTarea;
	}

	public Integer getIdTipoTarea() {
		return idTipoTarea;
	}

	public void setIdTipoTarea(Integer idTipoTarea) {
		this.idTipoTarea = idTipoTarea;
	}

	public Integer getIdEtapaTarea() {
		return idEtapaTarea;
	}

	public void setIdEtapaTarea(Integer idEtapaTarea) {
		this.idEtapaTarea = idEtapaTarea;
	}

	public Integer getIdSolicitudTarea() {
		return idSolicitudTarea;
	}

	public void setIdSolicitudTarea(Integer idSolicitudTarea) {
		this.idSolicitudTarea = idSolicitudTarea;
	}

	public String getNombreTarea() {
		return nombreTarea;
	}

	public void setNombreTarea(String nombreTarea) {
		this.nombreTarea = nombreTarea;
	}

	public String getCrqTarea() {
		return crqTarea;
	}

	public void setCrqTarea(String crqTarea) {
		this.crqTarea = crqTarea;
	}

	public String getDescripcionTarea() {
		return descripcionTarea;
	}

	public void setDescripcionTarea(String descripcionTarea) {
		this.descripcionTarea = descripcionTarea;
	}

	public byte[] getArchivoTarea() {
		return archivoTarea;
	}

	public void setArchivoTarea(byte[] archivoTarea) {
		this.archivoTarea = archivoTarea;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public Date getFechaTarea() {
		return fechaTarea;
	}

	public void setFechaTarea(Date fechaTarea) {
		this.fechaTarea = fechaTarea;
	}
	
	public Integer getIdUsuarioTarea() {
		return idUsuarioTarea;
	}

	public void setIdUsuarioTarea(Integer idUsuarioTarea) {
		this.idUsuarioTarea = idUsuarioTarea;
	}

	public String getWoTarea() {
		return woTarea;
	}

	public void setWoTarea(String woTarea) {
		this.woTarea = woTarea;
	}

	@Override
	public String toString() {
		return "BTarea [idTarea=" + idTarea + ", idUsuarioTarea=" + idUsuarioTarea + ", idEquipoTarea=" + idEquipoTarea
				+ ", idTipoTarea=" + idTipoTarea + ", idEtapaTarea=" + idEtapaTarea + ", idSolicitudTarea="
				+ idSolicitudTarea + ", nombreTarea=" + nombreTarea + ", crqTarea=" + crqTarea + ", descripcionTarea="
				+ descripcionTarea + ", archivoTarea=" + Arrays.toString(archivoTarea) + ", nombreArchivo="
				+ nombreArchivo + ", fechaTarea=" + fechaTarea + ", woTarea=" + woTarea + "]";
	}

}
