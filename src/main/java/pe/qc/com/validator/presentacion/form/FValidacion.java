package pe.qc.com.validator.presentacion.form;

import java.util.List;

public class FValidacion {
	private String validacion;
	private String estado;
	private String comentario;
	private List<String> comentarioAdicional;
	
	public FValidacion(){
		
	}

	public String getValidacion() {
		return validacion;
	}

	public void setValidacion(String validacion) {
		this.validacion = validacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public List<String> getComentarioAdicional() {
		return comentarioAdicional;
	}

	public void setComentarioAdicional(List<String> comentarioAdicional) {
		this.comentarioAdicional = comentarioAdicional;
	}

	@Override
	public String toString() {
		return "FValidacion [validacion=" + validacion + ", estado=" + estado + ", comentario=" + comentario
				+ ", comentarioAdicional=" + comentarioAdicional + "]";
	}

}	
