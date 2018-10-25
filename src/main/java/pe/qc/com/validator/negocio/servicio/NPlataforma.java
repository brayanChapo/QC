package pe.qc.com.validator.negocio.servicio;

import java.util.List;

import pe.qc.com.validator.negocio.bo.BOPlataforma;

public interface NPlataforma {

	public List<BOPlataforma> listarPlataforma();
	
	public BOPlataforma obtenerPlataformaXId(Integer id);
	
	public BOPlataforma obtenerPlataformaXNombre(String nombrePlataforma);
	

}
