package pe.qc.com.validator.presentacion.form;

public class FBalanceCarga {
	private String nombreServidor;
	private String direccionIp;
	private String url;
	
	public FBalanceCarga(){
		
	}
	
	public String getNombreServidor() {
		return nombreServidor;
	}
	public void setNombreServidor(String nombreServidor) {
		this.nombreServidor = nombreServidor;
	}
	public String getDireccionIp() {
		return direccionIp;
	}
	public void setDireccionIp(String direccionIp) {
		this.direccionIp = direccionIp;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "\n                                                                                                                                        FBalanceCarga [nombreServidor=" + nombreServidor + ", direccionIp=" + direccionIp + ", url=" + url
				+ "]";
	}
}
