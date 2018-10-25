package pe.qc.com.validator.negocio.bo;

import java.io.Serializable;

public class BOTipoSolicitud implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer idTipoSolicitud;
	private String nombreTipoSolicitud;
	
	public BOTipoSolicitud(){
		
	}
	
	public Integer getIdTipoSolicitud() {
		return idTipoSolicitud;
	}
	public void setIdTipoSolicitud(Integer idTipoSolicitud) {
		this.idTipoSolicitud = idTipoSolicitud;
	}
	public String getNombreTipoSolicitud() {
		return nombreTipoSolicitud;
	}
	public void setNombreTipoSolicitud(String nombreTipoSolicitud) {
		this.nombreTipoSolicitud = nombreTipoSolicitud;
	}

	@Override
	public String toString() {
		return "BOTipoSolicitud [idTipoSolicitud=" + idTipoSolicitud + ", nombreTipoSolicitud=" + nombreTipoSolicitud + ", getIdTipoSolicitud()=" + getIdTipoSolicitud() + ", getNombreTipoSolicitud()="
				+ getNombreTipoSolicitud() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
