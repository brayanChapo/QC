package pe.qc.com.validator.presentacion.form.formReversion;

import java.util.ArrayList;
import java.util.List;

public class FSeccionReversion {
	private String idSeccionReversion;
	private String seccion;
	private List<FSubSeccionReversion> listaSubseccion;
	
	public FSeccionReversion() {
		listaSubseccion = new ArrayList<>();
	}

	
	public String getIdSeccionReversion() {
		return idSeccionReversion;
	}
	public void setIdSeccionReversion(String idSeccionReversion) {
		this.idSeccionReversion = idSeccionReversion;
	}
	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public List<FSubSeccionReversion> getListaSubseccion() {
		return listaSubseccion;
	}

	public void setListaSubseccion(FSubSeccionReversion listaSubseccion) {
		this.listaSubseccion.add(listaSubseccion);
	}

	@Override
	public String toString() {
		return "\n                         FSeccion [idSeccionReversion=" + idSeccionReversion + ", seccion=" + seccion + ", listaSubseccion=" + listaSubseccion
				+ "]";
	}
}
