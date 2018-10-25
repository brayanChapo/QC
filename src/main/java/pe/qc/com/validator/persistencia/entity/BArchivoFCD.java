package pe.qc.com.validator.persistencia.entity;

import java.math.BigDecimal;

public class BArchivoFCD {
	private Integer idArchivoFCD;
    private Integer idHistoricoFCD;
    private Integer cantValTotalFCD;
    private Integer cantValCorrFCD;
    private Integer cantValIncFCD;
    private BigDecimal porcValFCD;
    private char esHistorico;
    
    public BArchivoFCD(){
    	
    }
    
	public Integer getIdArchivoFCD() {
		return idArchivoFCD;
	}
	public void setIdArchivoFCD(Integer idArchivoFCD) {
		this.idArchivoFCD = idArchivoFCD;
	}
	public Integer getIdHistoricoFCD() {
		return idHistoricoFCD;
	}
	public void setIdHistoricoFCD(Integer idHistoricoFCD) {
		this.idHistoricoFCD = idHistoricoFCD;
	}
	public Integer getCantValTotalFCD() {
		return cantValTotalFCD;
	}
	public void setCantValTotalFCD(Integer cantValTotalFCD) {
		this.cantValTotalFCD = cantValTotalFCD;
	}
	public Integer getCantValCorrFCD() {
		return cantValCorrFCD;
	}
	public void setCantValCorrFCD(Integer cantValCorrFCD) {
		this.cantValCorrFCD = cantValCorrFCD;
	}
	public Integer getCantValIncFCD() {
		return cantValIncFCD;
	}
	public void setCantValIncFCD(Integer cantValIncFCD) {
		this.cantValIncFCD = cantValIncFCD;
	}
	public BigDecimal getPorcValFCD() {
		return porcValFCD;
	}
	public void setPorcValFCD(BigDecimal porcValFCD) {
		this.porcValFCD = porcValFCD;
	}
	public char getEsHistorico() {
		return esHistorico;
	}
	public void setEsHistorico(char esHistorico) {
		this.esHistorico = esHistorico;
	}

	@Override
	public String toString() {
		return "BArchivoFCD [idArchivoFCD=" + idArchivoFCD + ", idHistoricoFCD=" + idHistoricoFCD + ", cantValTotalFCD="
				+ cantValTotalFCD + ", cantValCorrFCD=" + cantValCorrFCD + ", cantValIncFCD=" + cantValIncFCD
				+ ", porcValFCD=" + porcValFCD + ", esHistorico=" + esHistorico + "]";
	}
    
}
