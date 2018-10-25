package pe.qc.com.validator.negocio.bo;

import java.util.Date;

public class BOReporteFinal {
	private Integer idReporteFinal;
	private Integer idSolicitud;
	private Integer idArchivoMIS;
	private Integer idArchivoFCD;
	private Integer idHistoricoReporte;
	private Date fechaReporteFinal;
	
	public BOReporteFinal(){
	
	}

	public Integer getIdReporteFinal() {
		return idReporteFinal;
	}

	public void setIdReporteFinal(Integer idReporteFinal) {
		this.idReporteFinal = idReporteFinal;
	}

	public Integer getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public Integer getIdArchivoMIS() {
		return idArchivoMIS;
	}

	public void setIdArchivoMIS(Integer idArchivoMIS) {
		this.idArchivoMIS = idArchivoMIS;
	}

	public Integer getIdArchivoFCD() {
		return idArchivoFCD;
	}

	public void setIdArchivoFCD(Integer idArchivoFCD) {
		this.idArchivoFCD = idArchivoFCD;
	}

	public Integer getIdHistoricoReporte() {
		return idHistoricoReporte;
	}

	public void setIdHistoricoReporte(Integer idHistoricoReporte) {
		this.idHistoricoReporte = idHistoricoReporte;
	}

	public Date getFechaReporteFinal() {
		return fechaReporteFinal;
	}

	public void setFechaReporteFinal(Date fechaReporteFinal) {
		this.fechaReporteFinal = fechaReporteFinal;
	}

	@Override
	public String toString() {
		return "BOReporteFinal [idReporteFinal=" + idReporteFinal + ", idSolicitud=" + idSolicitud + ", idArchivoMIS="
				+ idArchivoMIS + ", idArchivoFCD=" + idArchivoFCD + ", idHistoricoReporte=" + idHistoricoReporte
				+ ", fechaReporteFinal=" + fechaReporteFinal + "]";
	}
	
}
