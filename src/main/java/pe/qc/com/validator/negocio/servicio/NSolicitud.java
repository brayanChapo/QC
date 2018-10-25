package pe.qc.com.validator.negocio.servicio;

import java.util.Date;
import java.util.List;
import java.util.Map;

import pe.qc.com.validator.negocio.bo.BOSolicitud;

public interface NSolicitud {

	public List<BOSolicitud> listarSolicitud(Integer idUsuario);
	
	public List<BOSolicitud> listarSolicitudGeneral(Integer idRevisor);
	
	public BOSolicitud obtenerSolicitudXId(Integer id);
	
	public BOSolicitud obtenerSolicitudXnombreTk(String nombreTk);
	
	public BOSolicitud obtenerSolicitudXnombreTkPrimero(String nombreTk);
	
	public void insertarSolicitud(BOSolicitud Solicitud);
	
	public void modificarSolicitudTK(BOSolicitud Solicitud);
	
	public void modificarSolicitud(BOSolicitud Solicitud, Integer idSolicitud);
	
	public List<Map<String, Object>> listarMapSolicitud();
	
	public List<Map<String, Object>> listarMapHistoricaSolicitud(Integer idSolicitud);
	
	public List<Map<String, Object>> listarMapSolicitudXFechas(Date fechaInicio, Date fechaFin);
	
	public List<Map<String, Object>> listarMapSolicitudReporteQc();

}
