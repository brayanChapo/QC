package pe.qc.com.validator.persistencia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.persistencia.entity.BEtapa;

@Transactional(propagation = Propagation.MANDATORY)
public interface MEtapa {
	
	@ResultMap(value = "bEtapa")
	@Select("SELECT id_Etapa, nombre_Etapa FROM validator_Etapa")
	public List<BEtapa> listarEtapa();
	
	@ResultMap(value = "bEtapa")
	@Select("SELECT id_Etapa, nombre_Etapa FROM validator_Etapa"
			+ " WHERE id_Etapa = #{idEtapa}")
	public BEtapa obtenerEtapaXId(@Param("idEtapa") Integer id);
	
	@ResultMap(value = "bEtapa")
	@Select("SELECT id_Etapa, nombre_Etapa FROM validator_Etapa"
			+ " WHERE nombre_Etapa = #{nombreEtapa}")
	public BEtapa obtenerEtapaXNombre(@Param("nombreEtapa") String nombreEtapa);
	

}
