package pe.qc.com.validator.negocio.servicio;

import java.util.List;
import java.util.Map;

import pe.qc.com.validator.negocio.bo.BOAplicativo;

public interface NAplicativo {

	public List<BOAplicativo> listarAplicativo();
	
	public List<BOAplicativo> listarAplicativoXNombre(String nombreAplicativo);
	
	public BOAplicativo obtenerAplicativoXId(Integer id);
	
	public BOAplicativo obtenerAplicativoXIdVob(Integer id);
	
	public List<BOAplicativo> obtenerAplicativoXIdDominio(Integer id);
	
	public BOAplicativo obtenerAplicativoXNombre(String nombreAplicativo);
	
	public void insertarAplicativo(BOAplicativo Aplicativo);
	
	public void modificarAplicativo(BOAplicativo Aplicativo);
	
	public void eliminarAplicativo(Integer idAplicativo);
	
	public List<Map<String, Object>> listarMapAplicativos();
	
	public Map<String, Object> obtenerMapAplicativo(Integer idAplicativo);

}
