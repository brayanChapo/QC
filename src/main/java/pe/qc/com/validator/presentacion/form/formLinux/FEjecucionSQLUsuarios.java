package pe.qc.com.validator.presentacion.form.formLinux;

public class FEjecucionSQLUsuarios {
	
	private String accion;
	private String usuario;
	private String ambiente;
	private String servidor;
	private String solPass;
	
	public FEjecucionSQLUsuarios() {
		
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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

	public String getSolPass() {
		return solPass;
	}

	public void setSolPass(String solPass) {
		this.solPass = solPass;
	}
	
}
