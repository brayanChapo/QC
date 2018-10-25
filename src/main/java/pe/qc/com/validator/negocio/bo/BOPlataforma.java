package pe.qc.com.validator.negocio.bo;

import java.io.Serializable;

public class BOPlataforma implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer idPlataforma;
	private String nombrePlataforma;
	
	public BOPlataforma(){
		
	}

	public Integer getIdPlataforma() {
		return idPlataforma;
	}

	public void setIdPlataforma(Integer idPlataforma) {
		this.idPlataforma = idPlataforma;
	}

	public String getNombrePlataforma() {
		return nombrePlataforma;
	}

	public void setNombrePlataforma(String nombrePlataforma) {
		this.nombrePlataforma = nombrePlataforma;
	}

	@Override
	public String toString() {
		return "BOPlataforma [idPlataforma=" + idPlataforma + ", nombrePlataforma=" + nombrePlataforma + "]";
	}
	
}
