package pe.qc.com.validator.persistencia.entity;

public class BEstadoSolicitud {
	
	private Integer idEstadoSolicitud;
	private String nombreEstadoSolicitud;
	
	public BEstadoSolicitud(){
		
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
		return "BEstadoSolicitud [idEstadoSolicitud=" + idEstadoSolicitud + ", nombreEstadoSolicitud=" + nombreEstadoSolicitud + ", getIdEstadoSolicitud()=" + getIdEstadoSolicitud() + ", getNombreEstadoSolicitud()="
				+ getNombreEstadoSolicitud() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
