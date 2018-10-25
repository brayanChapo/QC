package pe.qc.com.validator.persistencia.entity;

public class BUsuarioAIX {
	
	private Integer idUsuarioAIX;
	private String nombreUsuarioAIX;
	
	public BUsuarioAIX(){
		
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
		return "BUsuarioAIX [idUsuarioAIX=" + idUsuarioAIX + ", nombreUsuarioAIX=" + nombreUsuarioAIX + "]";
	}

}
