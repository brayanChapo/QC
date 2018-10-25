package pe.qc.com.validator.persistencia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.persistencia.entity.BArea;

@Transactional(propagation = Propagation.MANDATORY)
public interface MArea {
	
	@ResultMap(value = "bArea")
	@Select("SELECT id_area, nombre_area FROM validator_Area")
	public List<BArea> listarArea();
	
	@ResultMap(value = "bArea")
	@Select("SELECT id_area, nombre_area FROM validator_Area"
			+ " WHERE id_area = #{idArea}")
	public BArea obtenerAreaXId(@Param("idArea") Integer id);
	
	@ResultMap(value = "bArea")
	@Select("SELECT id_area, nombre_area FROM validator_Area"
			+ " WHERE nombre_area = #{nombreArea}")
	public BArea obtenerAreaXNombre(@Param("nombreArea") String nombreArea);
	

}
