package pe.qc.com.validator.negocio.servicio;

import java.util.List;

import pe.qc.com.validator.negocio.bo.BOEstadoSolicitud;

public interface NEstadoSolicitud {

	public List<BOEstadoSolicitud> listarEstadoSolicitud();
	
	public BOEstadoSolicitud obtenerEstadoSolicitudXId(Integer id);
	
	public BOEstadoSolicitud obtenerEstadoSolicitudXNombre(String nombreEstadoSolicitud);
	

}
