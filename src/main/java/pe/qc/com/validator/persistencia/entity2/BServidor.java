package pe.qc.com.validator.persistencia.entity2;

public class BServidor {
	private String hostnameServidor;
	private String categoriaServidor;
	private String memoriaFisica;
	private String descripcionServidor;
	private String fabricanteServidor;
	private String estadoPlataforma;
	private int estadoCmdb;	
	
	public BServidor() {
		
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
		return "BServidor [hostnameServidor=" + hostnameServidor + ", categoriaServidor=" + categoriaServidor
				+ ", memoriaFisica=" + memoriaFisica + ", descripcionServidor=" + descripcionServidor
				+ ", fabricanteServidor=" + fabricanteServidor + ", estadoPlataforma=" + estadoPlataforma
				+ ", estadoCmdb=" + estadoCmdb + "]";
	}
}
