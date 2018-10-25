package pe.qc.com.validator.presentacion.form.formSeccion;

public class FConfServidorWindows {
	private String accion;
	private String ambiente;
	private String servidor;
	private String ruta;
	
	public FConfServidorWindows() {
		
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

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	@Override
	public String toString() {
		return "FConfServidorWindows [accion=" + accion + ", ambiente=" + ambiente + ", servidor=" + servidor
				+ ", ruta=" + ruta + "]";
	}
	
}
