package pe.qc.com.validator.persistencia.entity;

public class BEtapa {
	
	private Integer idEtapa;
	private String nombreEtapa;
	
	public BEtapa(){
		
	}
	
	public Integer getIdEtapa() {
		return idEtapa;
	}
	public void setIdEtapa(Integer idEtapa) {
		this.idEtapa = idEtapa;
	}
	public String getNombreEtapa() {
		return nombreEtapa;
	}
	public void setNombreEtapa(String nombreEtapa) {
		this.nombreEtapa = nombreEtapa;
	}

	@Override
	public String toString() {
		return "BEtapa [idEtapa=" + idEtapa + ", nombreEtapa=" + nombreEtapa + ", getIdEtapa()=" + getIdEtapa() + ", getNombreEtapa()="
				+ getNombreEtapa() + "]";
	}
	
}
