package pe.qc.com.validator.presentacion.form;

public class FGrupoDominios {
	private String nombreGrupo;
	private String descripcion;
	private String liderUsuario;
	private String usuariosAutorizados;
	private String notasAdicionales;
	
	public FGrupoDominios() {
		
	}

	public String getNombreGrupo() {
		return nombreGrupo;
	}

	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLiderUsuario() {
		return liderUsuario;
	}

	public void setLiderUsuario(String liderUsuario) {
		this.liderUsuario = liderUsuario;
	}

	public String getUsuariosAutorizados() {
		return usuariosAutorizados;
	}

	public void setUsuariosAutorizados(String usuariosAutorizados) {
		this.usuariosAutorizados = usuariosAutorizados;
	}

	public String getNotasAdicionales() {
		return notasAdicionales;
	}

	public void setNotasAdicionales(String notasAdicionales) {
		this.notasAdicionales = notasAdicionales;
	}

	@Override
	public String toString() {
		return "\n				FGrupoDominios [nombreGrupo=" + nombreGrupo + ", descripcion=" + descripcion + ", liderUsuario="
				+ liderUsuario + ", usuariosAutorizados=" + usuariosAutorizados + ", notasAdicionales="
				+ notasAdicionales + "]";
	}
	
	
}
