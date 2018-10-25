package pe.qc.com.validator.negocio.servicio;

import java.util.List;

import pe.qc.com.validator.negocio.bo.BORol;

public interface NRol {

	public List<BORol> listarRol();
	
	public BORol obtenerRolXId(Integer id);
	
	public BORol obtenerRolXNombre(String nombreRol);
	

}
