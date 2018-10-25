package pe.qc.com.validator.negocio.servicio;

import java.util.List;

import pe.qc.com.validator.negocio.bo.BOTipoSolicitud;

public interface NTipoSolicitud {

	public List<BOTipoSolicitud> listarTipoSolicitud();
	
	public BOTipoSolicitud obtenerTipoSolicitudXId(Integer id);
	
	public BOTipoSolicitud obtenerTipoSolicitudXNombre(String nombreTipoSolicitud);
	

}
