package pe.qc.com.validator.negocio.bo;

import java.io.Serializable;

public class BOArea implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer idArea;
	private String nombreArea;
	
	public BOArea(){
		
	}
	
	public Integer getIdArea() {
		return idArea;
	}
	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}
	public String getNombreArea() {
		return nombreArea;
	}
	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}

	@Override
	public String toString() {
		return "BOArea [idArea=" + idArea + ", nombreArea=" + nombreArea + ", getIdArea()=" + getIdArea() + ", getNombreArea()="
				+ getNombreArea() + "]";
	}
	
}
