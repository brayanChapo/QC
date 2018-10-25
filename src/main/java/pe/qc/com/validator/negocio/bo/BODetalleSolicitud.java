package pe.qc.com.validator.negocio.bo;

import java.io.Serializable;

public class BODetalleSolicitud implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer idDetalleSolicitud;
	private String snDetalleSolicitud;
	private String stDetalleSolicitud;
	private String ssDetalleSolicitud;
	private String incDetalleSolicitud;
	
	public BODetalleSolicitud(){
		
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
		return "BODetalleSolicitud [idDetalleSolicitud=" + idDetalleSolicitud + ", snDetalleSolicitud="
				+ snDetalleSolicitud + ", stDetalleSolicitud=" + stDetalleSolicitud + ", ssDetalleSolicitud="
				+ ssDetalleSolicitud + ", incDetalleSolicitud=" + incDetalleSolicitud + "]";
	}
	
}
