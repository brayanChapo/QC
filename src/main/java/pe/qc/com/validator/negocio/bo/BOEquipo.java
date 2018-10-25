package pe.qc.com.validator.negocio.bo;

import java.io.Serializable;

public class BOEquipo implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer idEquipo;
	private String nombreEquipo;
	
	public BOEquipo(){
		
	}
	
	public Integer getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}
	public String getNombreEquipo() {
		return nombreEquipo;
	}
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	@Override
	public String toString() {
		return "BOEquipo [idEquipo=" + idEquipo + ", nombreEquipo=" + nombreEquipo + ", getIdEquipo()=" + getIdEquipo() + ", getNombreEquipo()="
				+ getNombreEquipo();
	}
	
}
