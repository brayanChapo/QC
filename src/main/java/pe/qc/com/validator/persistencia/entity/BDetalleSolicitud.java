package pe.qc.com.validator.persistencia.entity;

public class BDetalleSolicitud {
	private Integer idDetalleSolicitud;
	private String snDetalleSolicitud;
	private String stDetalleSolicitud;
	private String ssDetalleSolicitud;
	private String incDetalleSolicitud;
	
	public BDetalleSolicitud(){
		
	}

	public Integer getIdDetalleSolicitud() {
		return idDetalleSolicitud;
	}

	public void setIdDetalleSolicitud(Integer idDetalleSolicitud) {
		this.idDetalleSolicitud = idDetalleSolicitud;
	}

	public String getSnDetalleSolicitud() {
		return snDetalleSolicitud;
	}

	public void setSnDetalleSolicitud(String snDetalleSolicitud) {
		this.snDetalleSolicitud = snDetalleSolicitud;
	}

	public String getStDetalleSolicitud() {
		return stDetalleSolicitud;
	}

	public void setStDetalleSolicitud(String stDetalleSolicitud) {
		this.stDetalleSolicitud = stDetalleSolicitud;
	}

	public String getSsDetalleSolicitud() {
		return ssDetalleSolicitud;
	}

	public void setSsDetalleSolicitud(String ssDetalleSolicitud) {
		this.ssDetalleSolicitud = ssDetalleSolicitud;
	}

	public String getIncDetalleSolicitud() {
		return incDetalleSolicitud;
	}

	public void setIncDetalleSolicitud(String incDetalleSolicitud) {
		this.incDetalleSolicitud = incDetalleSolicitud;
	}

	@Override
	public String toString() {
		return "BDetalleSolicitud [idDetalleSolicitud=" + idDetalleSolicitud + ", snDetalleSolicitud="
				+ snDetalleSolicitud + ", stDetalleSolicitud=" + stDetalleSolicitud + ", ssDetalleSolicitud="
				+ ssDetalleSolicitud + ", incDetalleSolicitud=" + incDetalleSolicitud + "]";
	}
	
}
