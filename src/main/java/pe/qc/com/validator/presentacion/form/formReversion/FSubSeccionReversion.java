package pe.qc.com.validator.presentacion.form.formReversion;

import java.util.ArrayList;
import java.util.List;

public class FSubSeccionReversion {
	private String idSubseccionReversion;
	private String tarea;
	private List<String> palabras;
	
	public FSubSeccionReversion(){
		palabras = new ArrayList<>();
	}

	public String getIdSubseccionReversion() {
		return idSubseccionReversion;
	}
	
	public void setIdSubseccionReversion(String idSubseccionReversion) {
		this.idSubseccionReversion = idSubseccionReversion;
	}
	
	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public List<String> getPalabras() {
		return palabras;
	}

	public void setPalabras(String palabras) {
		this.palabras.add(palabras);
	}

	@Override
	public String toString() {
		return "\n                                              FSubSeccion [idSubseccionReversion=" + idSubseccionReversion + ", tarea=" + tarea 
				+ ", palabras=" + palabras + "]";
	}
}
