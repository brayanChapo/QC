package pe.qc.com.validator.negocio.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

public class BOArchivoRutas implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idValidatorRutas;
	private String servidorValidatorRutas;
	private String rutaValidatorRutas;
	private Date fechaRegistro;
	
	private List<SelectItem> listaTipoServidor;
	
	
	public BOArchivoRutas () {
		
	}
	
	public void obtenerSelectItemTipoServidor() {
		listaTipoServidor = new ArrayList<SelectItem>();
		SelectItem item = new SelectItem();
		item.setLabel("Servidor Window");
		item.setValue(1);
		listaTipoServidor.add(item);
		item = new SelectItem();
		item.setLabel("Servidor AIX");
		item.setValue(2);
		listaTipoServidor.add(item);
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
		return "BOArchivoRutas [idValidatorRutas=" + idValidatorRutas + ", servidorValidatorRutas="
				+ servidorValidatorRutas + ", rutaValidatorRutas=" + rutaValidatorRutas + ", fechaRegistro="
				+ fechaRegistro + "]";
	}

	public List<SelectItem> getListaTipoServidor() {
		return listaTipoServidor;
	}

	public void setListaTipoServidor(List<SelectItem> listaTipoServidor) {
		this.listaTipoServidor = listaTipoServidor;
	}
	
	
	
}
