package pe.qc.com.validator.presentacion.form.formReversion;

import java.util.ArrayList;
import java.util.List;

public class FReversionServidor {
	private String idReversionServidor;
	private List<String> listaServidor;
	private List<FSeccionReversion>listaSeccion;
	
	public FReversionServidor(){
		listaServidor = new ArrayList<>();
		listaSeccion = new ArrayList<>();
	}
	
	public String getIdReversionServidor() {
		return idReversionServidor;
	}
	
	public void setIdReversionServidor(String idReversionServidor) {
		this.idReversionServidor = idReversionServidor;
	}

	public List<String> getListaServidor() {
		return listaServidor;
	}
	public void setListaServidor(String listaServidor) {
		this.listaServidor.add(listaServidor);
	}
	public List<FSeccionReversion> getListaSeccion() {
		return listaSeccion;
	}
	public void setListaSeccion(FSeccionReversion listaSeccion) {
		this.listaSeccion.add(listaSeccion);
	}

	@Override
	public String toString() {
		return "\nFReversionServidor [idReversionServidor=" + idReversionServidor + ", listaServidor=" + listaServidor
				+ ", listaSeccion=" + listaSeccion + "]";
	}
	
}
