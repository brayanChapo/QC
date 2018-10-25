package pe.qc.com.validator.negocio.bo;

import java.io.Serializable;

public class BOTipoTarea implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer idTipoTarea;
	private String nombreTipoTarea;
	
	public BOTipoTarea(){
		
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
		return "BOTipoTarea [idTipoTarea=" + idTipoTarea + ", nombreTipoTarea=" + nombreTipoTarea + ", getIdTipoTarea()=" + getIdTipoTarea() + ", getNombreTipoTarea()="
				+ getNombreTipoTarea() + "]";
	}
	
}
