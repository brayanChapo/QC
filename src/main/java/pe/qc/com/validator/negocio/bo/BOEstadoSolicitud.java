package pe.qc.com.validator.negocio.bo;

import java.io.Serializable;

public class BOEstadoSolicitud implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer idEstadoSolicitud;
	private String nombreEstadoSolicitud;
	
	public BOEstadoSolicitud(){
		
	}
	
	public Integer getIdEstadoSolicitud() {
		return idEstadoSolicitud;
	}
	public void setIdEstadoSolicitud(Integer idEstadoSolicitud) {
		this.idEstadoSolicitud = idEstadoSolicitud;
	}
	public String getNombreEstadoSolicitud() {
		return nombreEstadoSolicitud;
	}
	public void setNombreEstadoSolicitud(String nombreEstadoSolicitud) {
		this.nombreEstadoSolicitud = nombreEstadoSolicitud;
	}

	@Override
	public String toString() {
		return "BOEstadoSolicitud [idEstadoSolicitud=" + idEstadoSolicitud + ", nombreEstadoSolicitud=" + nombreEstadoSolicitud + ", getIdEstadoSolicitud()=" + getIdEstadoSolicitud() + ", getNombreEstadoSolicitud()="
				+ getNombreEstadoSolicitud() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
