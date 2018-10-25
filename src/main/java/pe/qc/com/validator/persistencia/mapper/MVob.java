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

import pe.qc.com.validator.persistencia.entity.BVob;



@Transactional(propagation = Propagation.MANDATORY)
public interface MVob {
	
	@ResultMap(value = "bVob")
	@Select("SELECT id_vob, nombre_vob FROM validator_vob")
	public List<BVob> listarVob();
	
	@ResultMap(value = "bVob")
	@Select("SELECT id_vob, nombre_vob FROM validator_vob WHERE nombre_vob LIKE #{nombreVob} ORDER BY nombre_vob")
	public List<BVob> listarVobXNombre(@Param("nombreVob") String nombreVob);
	
	@ResultMap(value = "bVob")
	@Select("SELECT id_vob, nombre_vob FROM validator_vob"
			+ " WHERE id_vob = #{idVob}")
	public BVob obtenerVobXId(@Param("idVob") Integer id);
	
	@ResultMap(value = "bVob")
	@Select("SELECT id_vob, nombre_vob FROM validator_Vob"
			+ " WHERE nombre_vob = #{nombreVob}")
	public BVob obtenerVobXNombre(@Param("nombreVob") String nombreVob);
	
	@Insert("insert into validator_vob(NOMBRE_VOB) values(#{nombreVob})")
	public int insertarVob(BVob Vob);
	
	@Update("update validator_vob SET NOMBRE_VOB = #{nombreVob} "
			+ "	WHERE ID_VOB = #{idVob}")
	public int modificarVob(BVob Vob);

	@Delete("DELETE FROM validator_vob WHERE ID_VOB = #{idVob}")
	public int eliminarVob(@Param("idVob") Integer idVob);

}
