package pe.qc.com.validator.persistencia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.persistencia.entity.BEquipo;

@Transactional(propagation = Propagation.MANDATORY)
public interface MEquipo {
	
	@ResultMap(value = "bEquipo")
	@Select("SELECT id_equipo, nombre_equipo FROM validator_equipo")
	public List<BEquipo> listarEquipo();
	
	@ResultMap(value = "bEquipo")
	@Select("SELECT id_equipo, nombre_equipo FROM validator_equipo"
			+ " WHERE id_equipo = #{idEquipo}")
	public BEquipo obtenerEquipoXId(@Param("idEquipo") Integer id);
	
	@ResultMap(value = "bEquipo")
	@Select("SELECT id_equipo, nombre_equipo FROM validator_equipo"
			+ " WHERE nombre_equipo = #{nombreEquipo}")
	public BEquipo obtenerEquipoXNombre(@Param("nombreEquipo") String nombreEquipo);
	

}
