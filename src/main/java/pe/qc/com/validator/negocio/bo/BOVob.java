package pe.qc.com.validator.negocio.bo;

import java.io.Serializable;

public class BOVob implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer idVob;
	private String nombreVob;
	
	public BOVob(){
		
	}
	
	public Integer getIdVob() {
		return idVob;
	}
	public void setIdVob(Integer idVob) {
		this.idVob = idVob;
	}
	public String getNombreVob() {
		return nombreVob;
	}
	public void setNombreVob(String nombreVob) {
		this.nombreVob = nombreVob;
	}

	@Override
	public String toString() {
		return "BOVob [idVob=" + idVob + ", nombreVob=" + nombreVob + ", getIdVob()=" + getIdVob() + ", getNombreVob()="
				+ getNombreVob() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
