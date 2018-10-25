package pe.qc.com.validator.persistencia.mapper;

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

import pe.qc.com.validator.persistencia.entity.BUsuario;



@Transactional(propagation = Propagation.MANDATORY)
public interface MUsuario {
	
	@Insert("insert into validator_Usuario(id_rol, id_area, nombre_usuario, apellido_usuario, codigo_usuario, pass_usuario, estado_usuario)" +
	" values(#{idRol}, #{idArea}, #{nombreUsuario}, #{apellidoUsuario},#{codigoUsuario}, #{passUsuario}, #{estadoUsuario})")
	public int insertarUsuario(BUsuario Usuario);
	
	@Update("update validator_Usuario SET id_rol = #{idRol}, id_area = #{idArea}, nombre_usuario = #{nombreUsuario}, apellido_usuario = #{apellidoUsuario},  codigo_usuario = #{codigoUsuario}, pass_usuario = #{passUsuario}"
			+ "	WHERE id_usuario = #{idUsuario}")
	public int modificarUsuario(BUsuario Usuario);
	
	@Delete("update validator_Usuario SET estado_usuario = #{estadoUsuario}"
			+ "	WHERE id_usuario = #{idUsuario}")
	public int eliminarUsuario(BUsuario Usuario);
	
	@ResultMap(value = "bUsuario")
	@Select("SELECT id_usuario, id_rol, id_area, nombre_usuario, apellido_usuario, codigo_usuario, pass_usuario, estado_usuario FROM validator_Usuario"
			+ " WHERE estado_usuario = '1'")
	public List<BUsuario> listarUsuario();
	
	@ResultMap(value = "bUsuario")
	@Select("SELECT id_usuario, id_rol, id_area, nombre_usuario, apellido_usuario, codigo_usuario, pass_usuario, estado_usuario FROM validator_Usuario"
			+ " WHERE id_usuario = #{idUsuario}")
	public BUsuario obtenerUsuarioXId(@Param("idUsuario") Integer idUsuario);
	
	@ResultMap(value = "bUsuario")
	@Select("SELECT id_usuario, id_rol, id_area, nombre_usuario, apellido_usuario, codigo_usuario, pass_usuario, estado_usuario FROM validator_Usuario"
			+ " WHERE codigo_usuario = #{codigoUsuario}")
	public BUsuario obtenerUsuarioXCodigo(@Param("codigoUsuario") String codigoUsuario);
	
	@ResultMap(value = "mapUsuario")
	@Select("SELECT id_usuario, nombre_rol, nombre_area, nombre_usuario, apellido_usuario, codigo_usuario, pass_usuario"
			+ " FROM validator_Usuario us"
			+ " INNER JOIN validator_Rol rol"
			+ " ON us.id_rol = rol.id_rol"
			+ " INNER JOIN validator_Area area"
			+ " ON us.id_area = area.id_area"
			+ " ORDER BY apellido_usuario")
	public List<Map<String, Object>> listarMapUsuario();
	
	@ResultMap(value = "mapUsuario")
	@Select("SELECT id_usuario, nombre_rol, nombre_area, nombre_usuario, apellido_usuario, codigo_usuario, pass_usuario"
			+ " FROM validator_Usuario us"
			+ " INNER JOIN validator_Rol rol"
			+ " ON us.id_rol = rol.id_rol"
			+ " INNER JOIN validator_Area area"
			+ " ON us.id_area = area.id_area"
			+ " WHERE id_usuario =  #{idUsuario}")
	public Map<String, Object> obtenerMapUsuarioXId(@Param("idUsuario") Integer idUsuario);
	
	@ResultMap(value = "mapConsultaUsuario")
	@Select("SELECT id_usuario, nombre_rol, nombre_area, nombre_usuario, apellido_usuario, codigo_usuario, pass_usuario, estado_usuario"
			+ " FROM validator_Usuario us"
			+ " INNER JOIN validator_Rol rol"
			+ " ON us.id_rol = rol.id_rol"
			+ " INNER JOIN validator_Area area"
			+ " ON us.id_area = area.id_area"
			+ " ORDER BY apellido_usuario")
	public List<Map<String, Object>> listarMapConsultaUsuario();
	
}
