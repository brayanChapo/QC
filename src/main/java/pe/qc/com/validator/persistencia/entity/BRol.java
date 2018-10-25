package pe.qc.com.validator.persistencia.entity;

public class BRol {
	
	private Integer idRol;
	private String nombreRol;
	
	public BRol(){
		
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
		return "BRol [idRol=" + idRol + ", nombreRol=" + nombreRol + ", getIdRol()=" + getIdRol() + ", getNombreRol()="
				+ getNombreRol() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
