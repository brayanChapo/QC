package pe.qc.com.validator.persistencia.entity2;

public class BUnidades {
	private String nombreUnidad;
	private String capacidadTotal;
	private String capacidadDisponible;
	
	public BUnidades (){
		
	}
	
	public String getNombreUnidad() {
		return nombreUnidad;
	}
	public void setNombreUnidad(String nombreUnidad) {
		this.nombreUnidad = nombreUnidad;
	}
	public String getCapacidadTotal() {
		return capacidadTotal;
	}
	public void setCapacidadTotal(String capacidadTotal) {
		this.capacidadTotal = capacidadTotal;
	}
	public String getCapacidadDisponible() {
		return capacidadDisponible;
	}
	public void setCapacidadDisponible(String capacidadDisponible) {
		this.capacidadDisponible = capacidadDisponible;
	}
	@Override
	public String toString() {
		return "BUnidades [nombreUnidad=" + nombreUnidad + ", capacidadTotal=" + capacidadTotal
				+ ", capacidadDisponible=" + capacidadDisponible + "]";
	}
}
