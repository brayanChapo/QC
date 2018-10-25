package pe.qc.com.validator.negocio.bo;

import java.io.Serializable;

public class BOUsuarioAIX implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer idUsuarioAIX;
	private String nombreUsuarioAIX;
	
	public BOUsuarioAIX(){
		
	}
	
	public Integer getIdUsuarioAIX() {
		return idUsuarioAIX;
	}
	public void setIdUsuarioAIX(Integer idUsuarioAIX) {
		this.idUsuarioAIX = idUsuarioAIX;
	}
	public String getNombreUsuarioAIX() {
		return nombreUsuarioAIX;
	}
	public void setNombreUsuarioAIX(String nombreUsuarioAIX) {
		this.nombreUsuarioAIX = nombreUsuarioAIX;
	}

	@Override
	public String toString() {
		return "BOUsuarioAIX [idUsuarioAIX=" + idUsuarioAIX + ", nombreUsuarioAIX=" + nombreUsuarioAIX + "]";
	}

}
