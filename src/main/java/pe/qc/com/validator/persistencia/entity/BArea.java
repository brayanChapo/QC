package pe.qc.com.validator.persistencia.entity;

public class BArea {
	
	private Integer idArea;
	private String nombreArea;
	
	public BArea(){
		
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
		return "BArea [idArea=" + idArea + ", nombreArea=" + nombreArea + ", getIdArea()=" + getIdArea() + ", getNombreArea()="
				+ getNombreArea() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
