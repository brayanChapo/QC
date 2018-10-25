package pe.qc.com.validator.persistencia.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.persistencia.entity.BDetalleSolicitud;



@Transactional(propagation = Propagation.MANDATORY)
public interface MDetalleSolicitud {
	
	@ResultMap(value = "bDetalleSolicitud")
	@Select("SELECT id_detalle_sol, sn_detalle_sol, st_detalle_sol, ss_detalle_sol, inc_detalle_sol FROM validator_detalle_solicitud"
			+ " WHERE id_detalle_sol = #{idDetalleSolicitud}")
	public BDetalleSolicitud obtenerDetalleSolicitudXId(@Param("idDetalleSolicitud") Integer id);
	
	@Insert("insert into validator_detalle_solicitud(sn_detalle_sol, st_detalle_sol, ss_detalle_sol, inc_detalle_sol) values(UPPER(TRIM(#{snDetalleSolicitud})),UPPER(TRIM(#{stDetalleSolicitud})),UPPER(TRIM(#{ssDetalleSolicitud})),UPPER(TRIM(#{incDetalleSolicitud})))")
	public int insertarDetalleSolicitud(BDetalleSolicitud DetalleSolicitud);
	
	@Update("update validator_detalle_solicitud SET sn_detalle_sol = UPPER(TRIM(#{snDetalleSolicitud})), st_detalle_sol = UPPER(TRIM(#{stDetalleSolicitud})), ss_detalle_sol = UPPER(TRIM(#{ssDetalleSolicitud})), inc_detalle_sol = UPPER(TRIM(#{incDetalleSolicitud}))"
			+ "	WHERE id_detalle_sol = #{idDetalleSolicitud}")
	public int modificarDetalleSolicitud(BDetalleSolicitud DetalleSolicitud);
	
	@Select("SELECT MAX(id_detalle_sol) FROM validator_detalle_solicitud")
	public int obtenerUltimoIdDetalleSolicitud();

}
