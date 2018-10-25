package pe.qc.com.validator.persistencia.entity;

public class BDominio {
	
	private Integer idDominio;
	private String nombreDominio;
	private String descripcionDominio;
	
	public BDominio(){
		
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
		return "BDominio [idDominio=" + idDominio + ", nombreDominio=" + nombreDominio + ", descripcionDominio="
				+ descripcionDominio + "]";
	}
	
}
