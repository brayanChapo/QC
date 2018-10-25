package pe.qc.com.validator.presentacion.form.formSeccion;

public class FConfigBDCreacionYCambiosSQL {
	private String accion;
	private String ruta;
	private String archivo;
	private String descripcion;
	private String tk;
	
	public FConfigBDCreacionYCambiosSQL() {
		
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTk() {
		return tk;
	}

	public void setTk(String tk) {
		this.tk = tk;
	}

	@Override
	public String toString() {
		return "FConfigBDCreacionYCambiosSQL [accion=" + accion + ", ruta=" + ruta + ", archivo=" + archivo
				+ ", descripcion=" + descripcion + ", tk=" + tk + "]";
	}
	
}
