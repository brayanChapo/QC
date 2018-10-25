package pe.qc.com.validator.presentacion.form;

import java.util.ArrayList;
import java.util.List;

public class FConfiguracionServidor {
	private String idConfiguracionServidor;
	private List<String> listaServidor;
	private List<FSeccion>listaSeccion;
	
	public FConfiguracionServidor(){
		listaServidor = new ArrayList<>();
		listaSeccion = new ArrayList<>();
	}
	
	public String getIdConfiguracionServidor() {
		return idConfiguracionServidor;
	}
	public void setIdConfiguracionServidor(String idConfiguracionServidor) {
		this.idConfiguracionServidor = idConfiguracionServidor;
	}
	public List<String> getListaServidor() {
		return listaServidor;
	}
	public void setListaServidor(String listaServidor) {
		this.listaServidor.add(listaServidor);
	}
	public List<FSeccion> getListaSeccion() {
		return listaSeccion;
	}
	public void setListaSeccion(FSeccion listaSeccion) {
		this.listaSeccion.add(listaSeccion);
	}

	@Override
	public String toString() {
		return "\nFConfiguracionServidor [idConfiguracionServidor=" + idConfiguracionServidor + ", listaServidor="
				+ listaServidor + ", listaSeccion=" + listaSeccion + "]";
	}
	
}
