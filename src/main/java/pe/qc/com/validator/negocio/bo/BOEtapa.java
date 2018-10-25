package pe.qc.com.validator.negocio.bo;

import java.io.Serializable;

public class BOEtapa implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer idEtapa;
	private String nombreEtapa;
	
	public BOEtapa(){
		
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
		return "BOEtapa [idEtapa=" + idEtapa + ", nombreEtapa=" + nombreEtapa + ", getIdEtapa()=" + getIdEtapa() + ", getNombreEtapa()="
				+ getNombreEtapa() + "]";
	}
}
