package pe.qc.com.validator.persistencia.entity;

public class BEquipo {
	
	private Integer idEquipo;
	private String nombreEquipo;
	
	public BEquipo(){
		
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
		return "BEquipo [idEquipo=" + idEquipo + ", nombreEquipo=" + nombreEquipo + ", getIdEquipo()=" + getIdEquipo() + ", getNombreEquipo()="
				+ getNombreEquipo();
	}
	
}
