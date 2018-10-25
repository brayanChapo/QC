package pe.qc.com.validator.persistencia.entity;

public class BPlataforma {
	private Integer idPlataforma;
	private String nombrePlataforma;
	
	public BPlataforma(){
		
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
		return "BPlataforma [idPlataforma=" + idPlataforma + ", nombrePlataforma=" + nombrePlataforma + "]";
	}
	
}
