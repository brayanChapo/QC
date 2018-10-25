package pe.qc.com.validator.presentacion.form.formSeccion;

public class FConfigBDDTSXConexion {
	private String accion;
	private String ambiente;
	private String conexion;
	private String rutaOrigen;
	
	public FConfigBDDTSXConexion() {
		
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

	public String getConexion() {
		return conexion;
	}

	public void setConexion(String conexion) {
		this.conexion = conexion;
	}

	public String getRutaOrigen() {
		return rutaOrigen;
	}

	public void setRutaOrigen(String rutaOrigen) {
		this.rutaOrigen = rutaOrigen;
	}

	@Override
	public String toString() {
		return "FConfigBDDTSXConexion [accion=" + accion + ", ambiente=" + ambiente + ", conexion=" + conexion
				+ ", rutaOrigen=" + rutaOrigen + "]";
	}

}
