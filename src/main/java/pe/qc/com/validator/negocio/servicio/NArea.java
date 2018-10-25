package pe.qc.com.validator.negocio.servicio;

import java.util.List;

import pe.qc.com.validator.negocio.bo.BOArea;

public interface NArea {

	public List<BOArea> listarArea();
	
	public BOArea obtenerAreaXId(Integer id);
	
	public BOArea obtenerAreaXNombre(String nombreArea);

}
