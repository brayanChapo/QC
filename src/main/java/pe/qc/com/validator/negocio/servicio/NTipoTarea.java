package pe.qc.com.validator.negocio.servicio;

import java.util.List;

import pe.qc.com.validator.negocio.bo.BOTipoTarea;

public interface NTipoTarea {

	public List<BOTipoTarea> listarTipoTarea();
	
	public BOTipoTarea obtenerTipoTareaXId(Integer id);
	
	public BOTipoTarea obtenerTipoTareaXNombre(String nombreTipoTarea);
	

}
