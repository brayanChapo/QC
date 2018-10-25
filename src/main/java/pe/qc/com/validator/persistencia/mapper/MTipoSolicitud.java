package pe.qc.com.validator.persistencia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.persistencia.entity.BTipoSolicitud;

@Transactional(propagation = Propagation.MANDATORY)
public interface MTipoSolicitud {
	
	@ResultMap(value = "bTipoSolicitud")
	@Select("SELECT id_tipo_sol, nombre_tipo_sol FROM validator_Tipo_solicitud")
	public List<BTipoSolicitud> listarTipoSolicitud();
	
	@ResultMap(value = "bTipoSolicitud")
	@Select("SELECT id_tipo_sol, nombre_tipo_sol FROM validator_Tipo_solicitud"
			+ " WHERE id_tipo_sol = #{idTipoSolicitud}")
	public BTipoSolicitud obtenerTipoSolicitudXId(@Param("idTipoSolicitud") Integer id);
	
	@ResultMap(value = "bTipoSolicitud")
	@Select("SELECT id_tipo_sol, nombre_tipo_sol FROM validator_Tipo_solicitud"
			+ " WHERE nombre_tipo_sol = #{nombreTipoSolicitud}")
	public BTipoSolicitud obtenerTipoSolicitudXNombre(@Param("nombreTipoSolicitud") String nombreTipoSolicitud);
	

}
