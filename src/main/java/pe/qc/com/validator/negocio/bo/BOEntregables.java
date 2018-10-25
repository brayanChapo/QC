package pe.qc.com.validator.negocio.bo;

public class BOEntregables {
	private String carpeta;
	private String elemento;
	
	public BOEntregables(String carpeta, String elemento) {
		this.carpeta = carpeta;
		this.elemento = elemento;
	}
	
	public BOEntregables() {
		
	}
	
	public String getCarpeta() {
		return carpeta;
	}

	public void setCarpeta(String carpeta) {
		this.carpeta = carpeta;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	@Override
	public String toString() {
		return "BOEntregables [carpeta=" + carpeta + ", elemento=" + elemento + "]";
	}

}
