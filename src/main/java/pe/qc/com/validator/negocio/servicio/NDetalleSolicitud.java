package pe.qc.com.validator.negocio.servicio;

import pe.qc.com.validator.negocio.bo.BODetalleSolicitud;

public interface NDetalleSolicitud {
	
	public BODetalleSolicitud obtenerDetalleSolicitudXId(Integer id);
	
	public void insertarDetalleSolicitud(BODetalleSolicitud DetalleSolicitud);
	
	public void modificarDetalleSolicitud(BODetalleSolicitud DetalleSolicitud);
	
	public int obtenerUltimoRegistroDetalle();

}
