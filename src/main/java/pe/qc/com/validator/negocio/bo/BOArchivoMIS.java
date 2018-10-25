package pe.qc.com.validator.negocio.bo;

import java.util.Date;

public class BOArchivoMIS {
	private Integer idArchivoMIS;
    private Integer idHistoricoMIS;
    private Integer cantValTotalMIS;
    private Integer cantValCorrMIS;
    private Integer cantValIncMIS;
    private double porcValMIS;
    private char esHistorico;
    private Date fechaMIS;
    private String tkMIS;
   
    
    public BOArchivoMIS(){
    	
    }

	public Integer getIdArchivoMIS() {
		return idArchivoMIS;
	}

	public void setIdArchivoMIS(Integer idArchivoMIS) {
		this.idArchivoMIS = idArchivoMIS;
	}

	public Integer getIdHistoricoMIS() {
		return idHistoricoMIS;
	}

	public void setIdHistoricoMIS(Integer idHistoricoMIS) {
		this.idHistoricoMIS = idHistoricoMIS;
	}

	public Integer getCantValTotalMIS() {
		return cantValTotalMIS;
	}

	public void setCantValTotalMIS(Integer cantValTotalMIS) {
		this.cantValTotalMIS = cantValTotalMIS;
	}

	public Integer getCantValCorrMIS() {
		return cantValCorrMIS;
	}

	public void setCantValCorrMIS(Integer cantValCorrMIS) {
		this.cantValCorrMIS = cantValCorrMIS;
	}

	public Integer getCantValIncMIS() {
		return cantValIncMIS;
	}

	public void setCantValIncMIS(Integer cantValIncMIS) {
		this.cantValIncMIS = cantValIncMIS;
	}

	public double getPorcValMIS() {
		return porcValMIS;
	}

	public void setPorcValMIS(double porcValMIS) {
		this.porcValMIS = porcValMIS;
	}

	public char getEsHistorico() {
		return esHistorico;
	}

	public void setEsHistorico(char esHistorico) {
		this.esHistorico = esHistorico;
	}
	
	public Date getFechaMIS() {
		return fechaMIS;
	}

	public void setFechaMIS(Date fechaMIS) {
		this.fechaMIS = fechaMIS;
	}

	public String getTkMIS() {
		return tkMIS;
	}

	public void setTkMIS(String tkMIS) {
		this.tkMIS = tkMIS;
	}

	@Override
	public String toString() {
		return "BOArchivoMIS [idArchivoMIS=" + idArchivoMIS + ", idHistoricoMIS=" + idHistoricoMIS
				+ ", cantValTotalMIS=" + cantValTotalMIS + ", cantValCorrMIS=" + cantValCorrMIS + ", cantValIncMIS="
				+ cantValIncMIS + ", porcValMIS=" + porcValMIS + ", esHistorico=" + esHistorico + ", fechaMIS="
				+ fechaMIS + ", tkMIS=" + tkMIS + "]";
	}

}

