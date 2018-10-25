package pe.qc.com.validator.presentacion.form.formSeccion;

public class FConfigServidorPermisosOtros {
	private String accion;
	private String rutaFisica;
	private String rutaCompartida;
	private String usuario;
	private String permisos;
	private String permisosExtendidos;
	
	public FConfigServidorPermisosOtros() {
		
	}
	
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public String getRutaFisica() {
		return rutaFisica;
	}
	public void setRutaFisica(String rutaFisica) {
		this.rutaFisica = rutaFisica;
	}
	public String getRutaCompartida() {
		return rutaCompartida;
	}
	public void setRutaCompartida(String rutaCompartida) {
		this.rutaCompartida = rutaCompartida;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPermisos() {
		return permisos;
	}
	public void setPermisos(String permisos) {
		this.permisos = permisos;
	}
	public String getPermisosExtendidos() {
		return permisosExtendidos;
	}
	public void setPermisosExtendidos(String permisosExtendidos) {
		this.permisosExtendidos = permisosExtendidos;
	}
	@Override
	public String toString() {
		return "FConfigServidorPermisosOtros [accion=" + accion + ", rutaFisica=" + rutaFisica + ", rutaCompartida="
				+ rutaCompartida + ", usuario=" + usuario + ", permisos=" + permisos + ", permisosExtendidos="
				+ permisosExtendidos + "]";
	}
	
	
	
}
