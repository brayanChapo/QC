package pe.qc.com.validator.persistencia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.persistencia.entity.BRol;

@Transactional(propagation = Propagation.MANDATORY)
public interface MRol {
	
	@ResultMap(value = "bRol")
	@Select("SELECT id_Rol, nombre_Rol FROM validator_Rol")
	public List<BRol> listarRol();
	
	@ResultMap(value = "bRol")
	@Select("SELECT id_Rol, nombre_Rol FROM validator_Rol"
			+ " WHERE id_Rol = #{idRol}")
	public BRol obtenerRolXId(@Param("idRol") Integer id);
	
	@ResultMap(value = "bRol")
	@Select("SELECT id_Rol, nombre_Rol FROM validator_Rol"
			+ " WHERE nombre_Rol = #{nombreRol}")
	public BRol obtenerRolXNombre(@Param("nombreRol") String nombreRol);
	

}
