package pe.qc.com.validator.presentacion.form.formSeccion;

public class FConectEjecucionScript {
	private String accion;
	private String ambiente;
	private String servidor;
	private String serverType;
	private String serverName;
	private String authentication;
	
	public FConectEjecucionScript() {
		
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

	public String getServerType() {
		return serverType;
	}

	public void setServerType(String serverType) {
		this.serverType = serverType;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getAuthentication() {
		return authentication;
	}

	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}

	@Override
	public String toString() {
		return "FConectEjecucionScript [accion=" + accion + ", ambiente=" + ambiente + ", servidor=" + servidor
				+ ", serverType=" + serverType + ", serverName=" + serverName + ", authentication=" + authentication
				+ "]";
	}
	
}
