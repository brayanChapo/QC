package springdb;

public class ClearCase {
	
	private String carpeta;
	private String elemento;
	private String ambiente;
	private String ruta;
	private String fecha;
	
	public ClearCase() {
		
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
	public String getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "\n ClearCase [carpeta=" + carpeta + ", elemento=" + elemento + ", ambiente=" + ambiente + ", ruta=" + ruta
				+ ", fecha=" + fecha + "]";
	}

}
