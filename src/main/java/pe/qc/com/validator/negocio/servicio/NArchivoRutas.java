package pe.qc.com.validator.negocio.servicio;

import java.util.List;

import pe.qc.com.validator.negocio.bo.BOArchivoRutas;

public interface NArchivoRutas {

	public List<BOArchivoRutas> listarArchivoRutas();
	
	public List<BOArchivoRutas> listarRutaxServidor(String servidorValidatorRutas);
	
	public BOArchivoRutas obtenerRutaxRuta(String rutaValidatorRutas,String servidorValidatorRutas);
	
	public void insertarArchivoRuta(BOArchivoRutas boArchivoRutas);
	
	public void modificarArchivoRuta(BOArchivoRutas boArchivoRutas);
	
	public void eliminarArchivoRuta(Integer idValidatorRutas);

}
