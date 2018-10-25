package pe.qc.com.validator.persistencia.entity;

public class BVob {
	
	private Integer idVob;
	private String nombreVob;
	
	public BVob(){
		
	}
	
	public Integer getIdVob() {
		return idVob;
	}
	public void setIdVob(Integer idVob) {
		this.idVob = idVob;
	}
	public String getNombreVob() {
		return nombreVob;
	}
	public void setNombreVob(String nombreVob) {
		this.nombreVob = nombreVob;
	}

	@Override
	public String toString() {
		return "BVob [idVob=" + idVob + ", nombreVob=" + nombreVob + ", getIdVob()=" + getIdVob() + ", getNombreVob()="
				+ getNombreVob() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
