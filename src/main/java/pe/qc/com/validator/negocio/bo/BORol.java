package pe.qc.com.validator.negocio.bo;

import java.io.Serializable;

public class BORol implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer idRol;
	private String nombreRol;
	
	public BORol(){
		
	}
	
	public Integer getIdRol() {
		return idRol;
	}
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	@Override
	public String toString() {
		return "BORol [idRol=" + idRol + ", nombreRol=" + nombreRol + ", getIdRol()=" + getIdRol() + ", getNombreRol()="
				+ getNombreRol() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
