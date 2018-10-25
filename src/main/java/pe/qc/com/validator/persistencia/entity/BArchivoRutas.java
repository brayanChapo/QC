package pe.qc.com.validator.persistencia.entity;

import java.util.Date;

public class BArchivoRutas {
	
	private int idValidatorRutas;
	private String servidorValidatorRutas;
	private String rutaValidatorRutas;
	private Date fechaRegistro;
	
	public BArchivoRutas () {
		
	}

	public int getIdValidatorRutas() {
		return idValidatorRutas;
	}

	public void setIdValidatorRutas(int idValidatorRutas) {
		this.idValidatorRutas = idValidatorRutas;
	}

	public String getServidorValidatorRutas() {
		return servidorValidatorRutas;
	}

	public void setServidorValidatorRutas(String servidorValidatorRutas) {
		this.servidorValidatorRutas = servidorValidatorRutas;
	}

	public String getRutaValidatorRutas() {
		return rutaValidatorRutas;
	}

	public void setRutaValidatorRutas(String rutaValidatorRutas) {
		this.rutaValidatorRutas = rutaValidatorRutas;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Override
	public String toString() {
		return "BArchivoRutas [idValidatorRutas=" + idValidatorRutas + ", servidorValidatorRutas="
				+ servidorValidatorRutas + ", rutaValidatorRutas=" + rutaValidatorRutas + ", fechaRegistro="
				+ fechaRegistro + "]";
	}
	
}
