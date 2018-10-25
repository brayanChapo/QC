package pe.qc.com.validator.persistencia.entity;

public class BUsuario {
	private Integer idUsuario;
	private Integer idRol;
	private Integer idArea;
	private String nombreUsuario;
	private String apellidoUsuario;
	private String codigoUsuario;
	private String passUsuario;
	private char estadoUsuario;
	
	public BUsuario(){
		
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public Integer getIdArea() {
		return idArea;
	}

	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidoUsuario() {
		return apellidoUsuario;
	}

	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getPassUsuario() {
		return passUsuario;
	}

	public void setPassUsuario(String passUsuario) {
		this.passUsuario = passUsuario;
	}

	public char getEstadoUsuario() {
		return estadoUsuario;
	}

	public void setEstadoUsuario(char estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}

	@Override
	public String toString() {
		return "BUsuario [idUsuario=" + idUsuario + ", idRol=" + idRol + ", idArea=" + idArea + ", nombreUsuario="
				+ nombreUsuario + ", apellidoUsuario=" + apellidoUsuario + ", codigoUsuario=" + codigoUsuario
				+ ", passUsuario=" + passUsuario + ", estadoUsuario=" + estadoUsuario + "]";
	}
	
}
