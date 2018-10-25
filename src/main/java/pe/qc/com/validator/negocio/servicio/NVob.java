package pe.qc.com.validator.negocio.servicio;

import java.util.List;

import pe.qc.com.validator.negocio.bo.BOVob;

public interface NVob {

	public List<BOVob> listarVob();
	
	public List<BOVob> listarVobXNombre(String nombreVob);
	
	public BOVob obtenerVobXId(Integer id);
	
	public BOVob obtenerVobXNombre(String nombreVob);
	
	public void insertarVob(BOVob Vob);
	
	public void modificarVob(BOVob Vob);
	
	public void eliminarVob(Integer idVob);

}
