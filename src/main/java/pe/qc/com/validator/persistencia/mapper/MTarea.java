package pe.qc.com.validator.persistencia.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.persistencia.entity.BTarea;


@Transactional(propagation = Propagation.MANDATORY)
public interface MTarea {
	
	@Insert("insert into validator_Tarea(id_Equipo_Tarea, id_Tipo_Tarea_Tarea, id_Etapa_Tarea, id_Solicitud_Tarea, nombre_Tarea, crq_Tarea, descripcion_Tarea, ARCHIVO_TAREA, nombre_Archivo_Tarea, fecha_Tarea, id_Usuario_Tarea, wo_Tarea)"
			+ " values(#{idEquipoTarea}, #{idTipoTarea}, #{idEtapaTarea}, #{idSolicitudTarea}, #{nombreTarea}, #{crqTarea}, #{descripcionTarea}, #{archivoTarea}, #{nombreArchivo}, #{fechaTarea}, #{idUsuarioTarea}, #{woTarea})")
	public int insertarTarea(BTarea bTarea);
	
	@Update("update validator_Tarea SET id_Equipo_Tarea = #{idEquipoTarea}, id_Tipo_Tarea_Tarea = #{idTipoTarea}, id_Etapa_Tarea = #{idEtapaTarea}, id_Solicitud_Tarea = #{idSolicitudTarea}, nombre_Tarea = #{nombreTarea},"
			+ " crq_Tarea = #{crqTarea}, descripcion_Tarea = #{descripcionTarea}, archivo_Tarea = #{archivoTarea}, nombre_Archivo_Tarea = #{nombreArchivo}, fecha_Tarea = #{fechaTarea}, id_Usuario_Tarea = #{idUsuarioTarea}, wo_Tarea = #{woTarea}"
			+ "	WHERE id_Tarea = #{idTarea}")
	public int modificarTarea(BTarea bTarea);
	
	@Delete("DELETE FROM validator_Tarea WHERE id_Tarea = #{idTarea}")
	public int eliminarTarea(@Param("idTarea") Integer idTarea);
	
	@ResultMap(value = "bTarea")
	@Select("SELECT id_Tarea, id_Equipo_Tarea, id_Tipo_Tarea_Tarea, id_Etapa_Tarea, id_Solicitud_Tarea, nombre_Tarea, crq_Tarea, descripcion_Tarea, archivo_Tarea, nombre_Archivo_Tarea, fecha_Tarea, wo_Tarea FROM validator_Tarea")
	public List<BTarea> listarTarea();
	
	@ResultMap(value = "bTarea")
	@Select("SELECT id_Tarea, id_Equipo_Tarea, id_Tipo_Tarea_Tarea, id_Etapa_Tarea, id_Solicitud_Tarea, nombre_Tarea, crq_Tarea, descripcion_Tarea, archivo_Tarea, nombre_Archivo_Tarea, fecha_Tarea, id_Usuario_Tarea, wo_Tarea FROM validator_Tarea"
			+ " WHERE id_Tarea = #{idTarea}")
	public BTarea obtenerTareaXId(@Param("idTarea") Integer idTarea);
	
	@ResultMap(value = "mapTarea")
	@Select("SELECT id_tarea, nombre_tarea, crq_tarea, nombre_equipo, nombre_tipo_tarea, nombre_etapa, id_solicitud_tarea, fecha_tarea, wo_Tarea"
			+ " from validator_tarea INNER JOIN validator_equipo ON id_equipo_tarea =  id_equipo"
			+ " INNER JOIN validator_tipo_tarea ON id_tipo_tarea_tarea = id_tipo_tarea"
			+ " INNER JOIN validator_etapa ON id_etapa_tarea = id_etapa"
			+ " WHERE id_usuario_tarea = #{idUsuario}")
	public List<Map<String, Object>> listarMapTarea(@Param("idUsuario") Integer idUsuario);
	
	@ResultMap(value = "mapTareaReporte")
	@Select("select id_tarea, nombre_tarea, crq_tarea, descripcion_tarea, archivo_tarea, nombre_archivo_tarea, fecha_tarea, wo_tarea, nombre_equipo,"
			+ " nombre_etapa, nombre_tipo_tarea, (s.tk_solicitud) as tk_solicitud, (a.nombre_codigo_ap) as nombre_codigo_ap, (d.nombre_dominio) as nombre_dominio"
			+ " from validator_tarea inner join validator_equipo ON id_equipo_tarea = id_equipo"
			+ " inner join validator_etapa ON id_etapa_tarea = id_etapa"
			+ " inner join validator_tipo_tarea ON id_tipo_tarea_tarea = id_tipo_tarea"
			+ " inner join validator_solicitud s ON id_solicitud_tarea = s.id_solicitud"
			+ " inner join validator_aplicativo a ON s.id_codigo_ap = a.id_codigo_ap"
			+ " inner join validator_dominio d ON a.id_dominio = d.id_dominio"
			+ " where (fecha_tarea between #{fechaInicio} and #{fechaFin})")
	public List<Map<String, Object>> listarMapTareaReporte(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);
	
}
