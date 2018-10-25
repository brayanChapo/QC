package pe.qc.com.validator.persistencia.entity;

public class BTipoSolicitud {
	
	private Integer idTipoSolicitud;
	private String nombreTipoSolicitud;
	
	public BTipoSolicitud(){
		
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
		return "BTipoSolicitud [idTipoSolicitud=" + idTipoSolicitud + ", nombreTipoSolicitud=" + nombreTipoSolicitud + ", getIdTipoSolicitud()=" + getIdTipoSolicitud() + ", getNombreTipoSolicitud()="
				+ getNombreTipoSolicitud() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
