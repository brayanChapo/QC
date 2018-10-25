package pe.qc.com.validator.persistencia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.persistencia.entity.BDominio;



@Transactional(propagation = Propagation.MANDATORY)
public interface MDominio {
	
	@ResultMap(value = "bDominio")
	@Select("SELECT id_Dominio, nombre_Dominio, descripcion_Dominio FROM validator_Dominio")
	public List<BDominio> listarDominio();
	
	@ResultMap(value = "bDominio")
	@Select("SELECT id_Dominio, nombre_Dominio, descripcion_Dominio FROM validator_Dominio WHERE nombre_Dominio LIKE #{nombreDominio} ORDER BY nombre_Dominio")
	public List<BDominio> listarDominioXNombre(@Param("nombreDominio") String nombreDominio);
	
	@ResultMap(value = "bDominio")
	@Select("SELECT id_Dominio, nombre_Dominio, descripcion_Dominio FROM validator_Dominio"
			+ " WHERE id_Dominio = #{idDominio}")
	public BDominio obtenerDominioXId(@Param("idDominio") Integer id);
	
	@ResultMap(value = "bDominio")
	@Select("SELECT id_Dominio, nombre_Dominio FROM validator_Dominio"
			+ " WHERE nombre_Dominio = #{nombreDominio}")
	public BDominio obtenerDominioXNombre(@Param("nombreDominio") String nombreDominio);
	
	@Insert("insert into validator_Dominio(nombre_Dominio, descripcion_Dominio) values(UPPER(TRIM(#{nombreDominio})),UPPER(TRIM(#{descripcionDominio})))")
	public int insertarDominio(BDominio Dominio);
	
	@Update("update validator_Dominio SET nombre_Dominio = UPPER(TRIM(#{nombreDominio})), descripcion_Dominio = UPPER(TRIM(#{descripcionDominio}))"
			+ "	WHERE ID_Dominio = #{idDominio}")
	public int modificarDominio(BDominio Dominio);

	@Delete("DELETE FROM validator_Dominio WHERE ID_Dominio = #{idDominio}")
	public int eliminarDominio(@Param("idDominio") Integer idDominio);

}
