package pe.qc.com.validator.presentacion.form;

import java.io.Serializable;

import pe.qc.com.validator.seguridad.Usuario;

public class FLogin implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String usuario;
	private String clave;
	private String fecha;
	private Usuario datosUsuario;
	
	int tiempoSesionExpirada;
	private int tiempoSesion;
	
	
	
	public int getTiempoSesion() {
		return tiempoSesion;
	}

	public void setTiempoSesion(int tiempoSesion) {
		this.tiempoSesion = tiempoSesion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public FLogin(String usuario, String clave) {
		super();
		this.usuario = usuario;
		this.clave = clave;
	}
	
	public Usuario getDatosUsuario() {
		return datosUsuario;
	}

	public void setDatosUsuario(Usuario datosUsuario) {
		this.datosUsuario = datosUsuario;
	}

	public FLogin() {
		super();
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getTiempoSesionExpirada() {
		return tiempoSesionExpirada;
	}

	public void setTiempoSesionExpirada(int tiempoSesionExpirada) {
		this.tiempoSesionExpirada = tiempoSesionExpirada;
	}
}
