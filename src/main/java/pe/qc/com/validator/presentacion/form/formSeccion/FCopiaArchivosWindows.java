package pe.qc.com.validator.presentacion.form.formSeccion;

public class FCopiaArchivosWindows {
	private String accion;
	private String rutaCC;
	private String archivo;
	private String rutaDestino;
	private String tk;
	
	public FCopiaArchivosWindows() {
		
	}
	
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public String getRutaCC() {
		return rutaCC;
	}
	public void setRutaCC(String rutaCC) {
		this.rutaCC = rutaCC;
	}
	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	public String getRutaDestino() {
		return rutaDestino;
	}
	public void setRutaDestino(String rutaDestino) {
		this.rutaDestino = rutaDestino;
	}
	public String getTk() {
		return tk;
	}
	public void setTk(String tk) {
		this.tk = tk;
	}

	@Override
	public String toString() {
		return "FCopiaArchivosWindows [accion=" + accion + ", rutaCC=" + rutaCC + ", archivo=" + archivo
				+ ", rutaDestino=" + rutaDestino + ", tk=" + tk + "]";
	}
	
	
}
