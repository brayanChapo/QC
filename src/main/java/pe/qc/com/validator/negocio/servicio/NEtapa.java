package pe.qc.com.validator.negocio.servicio;

import java.util.List;

import pe.qc.com.validator.negocio.bo.BOEtapa;

public interface NEtapa {

	public List<BOEtapa> listarEtapa();
	
	public BOEtapa obtenerEtapaXId(Integer id);
	
	public BOEtapa obtenerEtapaXNombre(String nombreEtapa);
	

}
