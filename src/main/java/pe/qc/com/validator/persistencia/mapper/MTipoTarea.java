package pe.qc.com.validator.persistencia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import pe.qc.com.validator.persistencia.entity.BTipoTarea;

@Transactional(propagation = Propagation.MANDATORY)
public interface MTipoTarea {
	
	@ResultMap(value = "bTipoTarea")
	@Select("SELECT id_tipo_tarea, nombre_tipo_tarea FROM validator_tipo_tarea")
	public List<BTipoTarea> listarTipoTarea();
	
	@ResultMap(value = "bTipoTarea")
	@Select("SELECT id_tipo_tarea, nombre_tipo_tarea FROM validator_tipo_tarea"
			+ " WHERE id_tipo_tarea = #{idTipoTarea}")
	public BTipoTarea obtenerTipoTareaXId(@Param("idTipoTarea") Integer idTipoTarea);
	
	@ResultMap(value = "bTipoTarea")
	@Select("SELECT id_tipo_tarea, nombre_tipo_tarea FROM validator_tipo_tarea"
			+ " WHERE nombre_tipo_tarea = #{nombreTipoTarea}")
	public BTipoTarea obtenerTipoTareaXNombre(@Param("nombreTipoTarea") String nombreTipoTarea);
	

}
