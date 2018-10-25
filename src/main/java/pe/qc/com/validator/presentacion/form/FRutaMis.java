package pe.qc.com.validator.presentacion.form;

public class FRutaMis {
	String servidor;
	String ruta;

	public FRutaMis() {
	}

	public FRutaMis(String servidor, String ruta) {
		this.servidor = servidor;
		this.ruta = ruta;
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
		return "RutaMis{" + "servidor=" + servidor + ", ruta=" + ruta + '}';
	}
}
