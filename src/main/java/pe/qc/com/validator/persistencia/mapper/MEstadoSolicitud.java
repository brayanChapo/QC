package pe.qc.com.validator.persistencia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.persistencia.entity.BEstadoSolicitud;

@Transactional(propagation = Propagation.MANDATORY)
public interface MEstadoSolicitud {
	
	@ResultMap(value = "bEstadoSolicitud")
	@Select("SELECT id_estado_sol, nombre_estado_sol FROM validator_Estado_solicitud")
	public List<BEstadoSolicitud> listarEstadoSolicitud();
	
	@ResultMap(value = "bEstadoSolicitud")
	@Select("SELECT id_estado_sol, nombre_estado_sol FROM validator_Estado_solicitud"
			+ " WHERE id_estado_sol = #{idEstadoSolicitud}")
	public BEstadoSolicitud obtenerEstadoSolicitudXId(@Param("idEstadoSolicitud") Integer id);
	
	@ResultMap(value = "bEstadoSolicitud")
	@Select("SELECT id_estado_sol, nombre_estado_sol FROM validator_Estado_solicitud"
			+ " WHERE nombre_estado_sol = #{nombreEstadoSolicitud}")
	public BEstadoSolicitud obtenerEstadoSolicitudXNombre(@Param("nombreEstadoSolicitud") String nombreEstadoSolicitud);
	

}
