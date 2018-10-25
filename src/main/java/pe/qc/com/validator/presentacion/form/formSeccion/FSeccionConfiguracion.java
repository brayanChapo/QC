package pe.qc.com.validator.presentacion.form.formSeccion;

public class FSeccionConfiguracion {
	private String idSubSeccion;
	private String tarea;
	private String subTarea;
	
	public FSeccionConfiguracion() {
		
	}

	public String getIdSubSeccion() {
		return idSubSeccion;
	}

	public void setIdSubSeccion(String idSubSeccion) {
		this.idSubSeccion = idSubSeccion;
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public String getSubTarea() {
		return subTarea;
	}

	public void setSubTarea(String subTarea) {
		this.subTarea = subTarea;
	}

	@Override
	public String toString() {
		return "FSeccionConfiguracion [idSubSeccion=" + idSubSeccion + ", tarea=" + tarea + ", subTarea=" + subTarea
				+ "]";
	}

}
