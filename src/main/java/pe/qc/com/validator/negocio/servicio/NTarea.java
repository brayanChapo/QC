package pe.qc.com.validator.negocio.servicio;

import java.util.Date;
import java.util.List;
import java.util.Map;

import pe.qc.com.validator.negocio.bo.BOTarea;

public interface NTarea {

	public List<BOTarea> listarTarea();
	
	public BOTarea obtenerTareaXId(Integer id);
	
	public void insertarTarea(BOTarea Tarea);
	
	public void modificarTarea(BOTarea Tarea);
	
	public void eliminarTarea(Integer idTarea);
	
	public List<Map<String, Object>> listarMapTarea(Integer idUsuario);
	
	public List<Map<String, Object>> listarMapTareaxFecha(Date fechaInicio, Date fechaFin);

}
