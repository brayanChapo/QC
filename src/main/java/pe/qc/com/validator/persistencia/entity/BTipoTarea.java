package pe.qc.com.validator.persistencia.entity;

public class BTipoTarea {
	
	private Integer idTipoTarea;
	private String nombreTipoTarea;
	
	public BTipoTarea(){
		
	}
	
	public Integer getIdTipoTarea() {
		return idTipoTarea;
	}
	public void setIdTipoTarea(Integer idTipoTarea) {
		this.idTipoTarea = idTipoTarea;
	}
	public String getNombreTipoTarea() {
		return nombreTipoTarea;
	}
	public void setNombreTipoTarea(String nombreTipoTarea) {
		this.nombreTipoTarea = nombreTipoTarea;
	}

	@Override
	public String toString() {
		return "BTipoTarea [idTipoTarea=" + idTipoTarea + ", nombreTipoTarea=" + nombreTipoTarea + ", getIdTipoTarea()=" + getIdTipoTarea() + ", getNombreTipoTarea()="
				+ getNombreTipoTarea() + "]";
	}
	
}
