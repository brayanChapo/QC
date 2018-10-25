package pe.qc.com.validator.persistencia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.persistencia.entity.BPlataforma;

@Transactional(propagation = Propagation.MANDATORY)
public interface MPlataforma {
	
	@ResultMap(value = "bPlataforma")
	@Select("SELECT id_plataforma, plataforma_nombre FROM validator_plataforma")
	public List<BPlataforma> listarPlataforma();
	
	@ResultMap(value = "bPlataforma")
	@Select("SELECT id_plataforma, plataforma_nombre FROM validator_plataforma"
			+ " WHERE id_plataforma = #{idPlataforma}")
	public BPlataforma obtenerPlataformaXId(@Param("idPlataforma") Integer id);
	
	@ResultMap(value = "bPlataforma")
	@Select("SELECT id_plataforma, plataforma_nombre FROM validator_plataforma"
			+ " WHERE plataforma_nombre = #{nombrePlataforma}")
	public BPlataforma obtenerPlataformaXNombre(@Param("nombrePlataforma") String nombrePlataforma);
	
}
