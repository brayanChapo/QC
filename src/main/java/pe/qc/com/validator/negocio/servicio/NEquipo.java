package pe.qc.com.validator.negocio.servicio;

import java.util.List;

import pe.qc.com.validator.negocio.bo.BOEquipo;

public interface NEquipo {

	public List<BOEquipo> listarEquipo();
	
	public BOEquipo obtenerEquipoXId(Integer id);
	
	public BOEquipo obtenerEquipoXNombre(String nombreEquipo);
	

}
