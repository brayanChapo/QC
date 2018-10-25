package pe.qc.com.validator.negocio.bo;

import java.io.Serializable;

public class BODominio implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer idDominio;
	private String nombreDominio;
	private String descripcionDominio;
	
	public BODominio(){
		
	}

	public Integer getIdDominio() {
		return idDominio;
	}

	public void setIdDominio(Integer idDominio) {
		this.idDominio = idDominio;
	}

	public String getNombreDominio() {
		return nombreDominio;
	}

	public void setNombreDominio(String nombreDominio) {
		this.nombreDominio = nombreDominio;
	}

	public String getDescripcionDominio() {
		return descripcionDominio;
	}

	public void setDescripcionDominio(String descripcionDominio) {
		this.descripcionDominio = descripcionDominio;
	}

	@Override
	public String toString() {
		return "BODominio [idDominio=" + idDominio + ", nombreDominio=" + nombreDominio + ", descripcionDominio="
				+ descripcionDominio + "]";
	}
	
}
