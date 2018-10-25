package pe.qc.com.validator.presentacion.form.formReversion.formSeccion;

public class FSubSeccionReversionF {
	private String idSubSeccion;
	private String tarea;
	
	
	public FSubSeccionReversionF() {
		
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


	@Override
	public String toString() {
		return "FSubSeccionReversionF [idSubSeccion=" + idSubSeccion + ", tarea=" + tarea + "]";
	}
	
}
