package pe.qc.com.validator.negocio.bo;

import java.io.Serializable;
import java.text.DecimalFormat;

public class BOUnidades implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String nombreUnidad;
	private String capacidadTotal;
	private String capacidadDisponible;
	
	public BOUnidades (){
		
	}
	
	public String getNombreUnidad() {
		return nombreUnidad;
	}
	public void setNombreUnidad(String nombreUnidad) {
		String linea = nombreUnidad.split("on")[0];
		nombreUnidad = linea;
		this.nombreUnidad = nombreUnidad;
	}
	public String getCapacidadTotal() {
		return capacidadTotal;
	}
	public void setCapacidadTotal(String capacidadTotal) {
		if(capacidadTotal.length()>0){
			DecimalFormat formato1 = new DecimalFormat("#.00");
			Double capacidadTot = Double.parseDouble(capacidadTotal);
			capacidadTot = (capacidadTot/1048576);
			capacidadTotal = formato1.format(capacidadTot) + " GB";
		}else {
			capacidadTotal = "";
		}
		this.capacidadTotal = capacidadTotal;
	}
	public String getCapacidadDisponible() {
		return capacidadDisponible;
	}
	public void setCapacidadDisponible(String capacidadDisponible) {
		if(capacidadDisponible.length()>0) {
			DecimalFormat formato2 = new DecimalFormat("#.00");
			Double capacidad = Double.parseDouble(capacidadDisponible);
			capacidad = (capacidad/1048576);
			capacidadDisponible = formato2.format(capacidad) + " GB";
		}else {
			capacidadDisponible="";
		}
		
		this.capacidadDisponible = capacidadDisponible;
	}
	@Override
	public String toString() {
		return "BOUnidades [nombreUnidad=" + nombreUnidad + ", capacidadTotal=" + capacidadTotal
				+ ", capacidadDisponible=" + capacidadDisponible + "]";
	}
}
