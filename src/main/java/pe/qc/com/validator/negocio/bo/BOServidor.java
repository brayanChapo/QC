package pe.qc.com.validator.negocio.bo;

import java.io.Serializable;

public class BOServidor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String hostnameServidor;
	private String categoriaServidor;
	private String memoriaFisica;
	private String descripcionServidor;
	private String fabricanteServidor;
	private String estadoPlataforma;
	private int estadoCmdb;	
	
	public BOServidor() {
		
	}

	public String getHostnameServidor() {
		return hostnameServidor;
	}
	public void setHostnameServidor(String hostnameServidor) {
		this.hostnameServidor = hostnameServidor;
	}
	public String getCategoriaServidor() {
		return categoriaServidor;
	}
	public void setCategoriaServidor(String categoriaServidor) {
		this.categoriaServidor = categoriaServidor;
	}
	public String getMemoriaFisica() {
		return memoriaFisica;
	}
	public void setMemoriaFisica(String memoriaFisica) {
		this.memoriaFisica = memoriaFisica;
	}
	public String getDescripcionServidor() {
		return descripcionServidor;
	}
	public void setDescripcionServidor(String descripcionServidor) {
		this.descripcionServidor = descripcionServidor;
	}
	public String getFabricanteServidor() {
		return fabricanteServidor;
	}
	public void setFabricanteServidor(String fabricanteServidor) {
		this.fabricanteServidor = fabricanteServidor;
	}
	public String getEstadoPlataforma() {
		return estadoPlataforma;
	}
	public void setEstadoPlataforma(String estadoPlataforma) {
		this.estadoPlataforma = estadoPlataforma;
	}
	public int getEstadoCmdb() {
		return estadoCmdb;
	}
	public void setEstadoCmdb(int estadoCmdb) {
		this.estadoCmdb = estadoCmdb;
	}
	@Override
	public String toString() {
		return "BOServidor [hostnameServidor=" + hostnameServidor + ", categoriaServidor=" + categoriaServidor
				+ ", memoriaFisica=" + memoriaFisica + ", descripcionServidor=" + descripcionServidor
				+ ", fabricanteServidor=" + fabricanteServidor + ", estadoPlataforma=" + estadoPlataforma
				+ ", estadoCmdb=" + estadoCmdb + "]";
	}
}
