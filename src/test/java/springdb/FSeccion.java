package springdb;

import java.util.ArrayList;
import java.util.List;

public class FSeccion {
	
	private String idSeccion;
	private String seccion;
	private List<FSubSeccion> listaSubseccion;
	
	public FSeccion() {
		listaSubseccion = new ArrayList<>();
	}

	public String getIdSeccion() {
		return idSeccion;
	}

	public void setIdSeccion(String idSeccion) {
		this.idSeccion = idSeccion;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public List<FSubSeccion> getListaSubseccion() {
		return listaSubseccion;
	}

	public void setListaSubseccion(FSubSeccion listaSubseccion) {
		this.listaSubseccion.add(listaSubseccion);
	}

	@Override
	public String toString() {
		return "\n                         FSeccion [idSeccion=" + idSeccion + ", seccion=" + seccion + ", listaSubseccion=" + listaSubseccion
				+ "]";
	}

}
