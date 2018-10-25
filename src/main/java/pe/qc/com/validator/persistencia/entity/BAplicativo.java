package pe.qc.com.validator.persistencia.entity;

public class BAplicativo {
	private Integer idAplicativo;
	private Integer idVob;
	private Integer idDominio;
	private String nombreAplicativo;
	
	
	public BAplicativo(){
		
	}
	
	public Integer getIdAplicativo() {
		return idAplicativo;
	}
	public void setIdAplicativo(Integer idAplicativo) {
		this.idAplicativo = idAplicativo;
	}
	public Integer getIdVob() {
		return idVob;
	}
	public void setIdVob(Integer idVob) {
		this.idVob = idVob;
	}
	public Integer getIdDominio() {
		return idDominio;
	}
	public void setIdDominio(Integer idDominio) {
		this.idDominio = idDominio;
	}
	public String getNombreAplicativo() {
		return nombreAplicativo;
	}
	public void setNombreAplicativo(String nombreAplicativo) {
		this.nombreAplicativo = nombreAplicativo;
	}
	
	@Override
	public String toString() {
		return "BAplicativo [idAplicativo=" + idAplicativo + ", idVob=" + idVob + ", idDominio=" + idDominio
				+ ", nombreAplicativo=" + nombreAplicativo  + "]";
	}
	
}	
