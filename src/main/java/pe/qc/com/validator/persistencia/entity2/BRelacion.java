package pe.qc.com.validator.persistencia.entity2;

public class BRelacion {
	private String nombreServidor;
	private String nombreCodigoApp;
	private String nombreAmbiente;
	
	public BRelacion() {
		
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
		return "BRelacion [nombreServidor=" + nombreServidor + ", nombreCodigoApp=" + nombreCodigoApp
				+ ", nombreAmbiente=" + nombreAmbiente + "]";
	}
}
