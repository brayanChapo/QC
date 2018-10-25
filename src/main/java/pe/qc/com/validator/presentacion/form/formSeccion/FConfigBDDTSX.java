package pe.qc.com.validator.presentacion.form.formSeccion;

public class FConfigBDDTSX {
	private String accion;
	private String ambiente;
	private String rutaOrigen;
	private String archivo;
	private String tk;
	
	public FConfigBDDTSX() {
		
	}
	
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public String getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}
	public String getRutaOrigen() {
		return rutaOrigen;
	}
	public void setRutaOrigen(String rutaOrigen) {
		this.rutaOrigen = rutaOrigen;
	}
	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	public String getTk() {
		return tk;
	}
	public void setTk(String tk) {
		this.tk = tk;
	}

	@Override
	public String toString() {
		return "FConfigBDDTSX [accion=" + accion + ", ambiente=" + ambiente + ", rutaOrigen=" + rutaOrigen
				+ ", archivo=" + archivo + ", tk=" + tk + "]";
	}
	
}
