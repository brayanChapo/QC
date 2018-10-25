package pe.qc.com.validator.negocio.servicio;

import java.util.List;

import pe.qc.com.validator.negocio.bo.BOUsuarioAIX;

public interface NUsuarioAIX {

	public List<BOUsuarioAIX> listarUsuarioAIX();
	
	public BOUsuarioAIX obtenerUsuarioAIXXNombre(String nombreUsuarioAIX);
	
}
