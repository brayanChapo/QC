package pe.qc.com.validator.negocio.servicio;

import java.util.List;

import pe.qc.com.validator.negocio.bo.BOArchivoMIS;

public interface NArchivoMIS {

	public List<BOArchivoMIS> listarArchivoMIS();
	
	public BOArchivoMIS obtenerArchivoMISXId(Integer idArchivoMIS);
	
	public BOArchivoMIS obtenerArchivoMISXTK(String tkMIS);
	
	public void insertarArchivoMIS(BOArchivoMIS boArchivoMis);
	
	public void convertirAHistoricoArchivoMIS(Integer idArchivoMIS);
	
	public List<BOArchivoMIS> listarArchivoMISNoFinalizados(String tkMIS);
	
	public List<BOArchivoMIS> listarArchivoMISHistorico(Integer idArchivoMIS);

}
