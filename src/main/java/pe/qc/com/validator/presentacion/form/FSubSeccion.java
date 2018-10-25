package pe.qc.com.validator.presentacion.form;

import java.util.ArrayList;
import java.util.List;

public class FSubSeccion {
	private String idSubseccion;
	private String tarea;
	private String subtarea;
	private String departamento;
	private List<String> palabras;
	private List<FSubTabla> listasSubTabla;
	
	public FSubSeccion(){
		palabras = new ArrayList<>();
		listasSubTabla = new ArrayList<>();
	}

	public String getIdSubseccion() {
		return idSubseccion;
	}

	public void setIdSubseccion(String idSubseccion) {
		this.idSubseccion = idSubseccion;
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public String getSubtarea() {
		return subtarea;
	}

	public void setSubtarea(String subtarea) {
		this.subtarea = subtarea;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public List<String> getPalabras() {
		return palabras;
	}

	public void setPalabras(String palabras) {
		this.palabras.add(palabras);
	}

	public List<FSubTabla> getListasSubTabla() {
		return listasSubTabla;
	}

	public void setListasSubTabla(List<FSubTabla> listasSubTabla) {
		this.listasSubTabla = listasSubTabla;
	}

	@Override
	public String toString() {
		return "\n                                              FSubSeccion [idSubseccion=" + idSubseccion + ", tarea=" + tarea + ", subtarea=" + subtarea
				+ ", departamento=" + departamento + ", palabras=" + palabras + ", listasSubTabla=" + listasSubTabla
				+ "]";
	}
}
