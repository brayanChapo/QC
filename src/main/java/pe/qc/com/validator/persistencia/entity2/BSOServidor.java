package pe.qc.com.validator.persistencia.entity2;

public class BSOServidor {
	private String fabricante;
	private String tipoSO;
	private String nombreDetallado;
	private int estado;
	
	public BSOServidor() {
		
	}
	
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getTipoSO() {
		return tipoSO;
	}
	public void setTipoSO(String tipoSO) {
		this.tipoSO = tipoSO;
	}
	public String getNombreDetallado() {
		return nombreDetallado;
	}
	public void setNombreDetallado(String nombreDetallado) {
		this.nombreDetallado = nombreDetallado;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "BSOServidor [fabricante=" + fabricante + ", tipoSO=" + tipoSO + ", nombreDetallado=" + nombreDetallado
				+ ", estado=" + estado + "]";
	}
	
}
