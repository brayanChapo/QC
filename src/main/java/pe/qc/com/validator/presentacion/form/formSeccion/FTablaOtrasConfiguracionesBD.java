package pe.qc.com.validator.presentacion.form.formSeccion;

public class FTablaOtrasConfiguracionesBD {
	private String accion;
	private String ambiente;
	private String servidor;
	
	public FTablaOtrasConfiguracionesBD() {
		
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

	public String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

	@Override
	public String toString() {
		return "FTablaOtrasConfiguracionesBD [accion=" + accion + ", ambiente=" + ambiente + ", servidor=" + servidor
				+ "]";
	}
	
	
	
}
