package springdb;

public class ClearCases {
	
	private String elemento;
	private String ruta;
	
	public ClearCases() {
		
	}
	
	public String getElemento() {
		return elemento;
	}
	public void setElemento(String elemento) {
		this.elemento = elemento;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	@Override
	public String toString() {
		return "ClearCases [elemento=" + elemento + ", ruta=" + ruta + "]";
	}
	

}
