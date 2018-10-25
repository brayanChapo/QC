package pe.qc.com.validator.negocio.bo;

import java.io.Serializable;

public class BORelacion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nombreServidor;
	private String nombreCodigoApp;
	private String nombreAmbiente;
	
	public BORelacion() {
		
	}
	
	public String getNombreServidor() {
		return nombreServidor;
	}
	public void setNombreServidor(String nombreServidor) {
		this.nombreServidor = nombreServidor;
	}
	public String getNombreCodigoApp() {
		return nombreCodigoApp;
	}
	public void setNombreCodigoApp(String nombreCodigoApp) {
		this.nombreCodigoApp = nombreCodigoApp;
	}
	public String getNombreAmbiente() {
		return nombreAmbiente;
	}
	public void setNombreAmbiente(String nombreAmbiente) {
		this.nombreAmbiente = nombreAmbiente;
	}
	@Override
	public String toString() {
		return "BORelacion [nombreServidor=" + nombreServidor + ", nombreCodigoApp=" + nombreCodigoApp
				+ ", nombreAmbiente=" + nombreAmbiente + "]";
	}
	
}
