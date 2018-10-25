package pe.qc.com.validator.negocio.servicio;

import java.util.List;

import pe.qc.com.validator.negocio.bo.BODominio;

public interface NDominio {

	public List<BODominio> listarDominio();
	
	public List<BODominio> listarDominioXNombre(String nombreDominio);
	
	public BODominio obtenerDominioXId(Integer id);
	
	public BODominio obtenerDominioXNombre(String nombreDominio);
	
	public void insertarDominio(BODominio Dominio);
	
	public void modificarDominio(BODominio Dominio);
	
	public void eliminarDominio(Integer idDominio);

}
