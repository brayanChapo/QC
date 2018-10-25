package pe.qc.com.validator.persistencia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import pe.qc.com.validator.persistencia.entity.BUsuarioAIX;

@Transactional(propagation = Propagation.MANDATORY)
public interface MUsuarioAIX {
	
	@ResultMap(value = "bUsuarioAIX")
	@Select("SELECT id_usuario_aix, nombre_usuario_aix FROM validator_usuario_aix")
	public List<BUsuarioAIX> listarUsuarioAIX();
	
	@ResultMap(value = "bUsuarioAIX")
	@Select("SELECT id_usuario_aix, nombre_usuario_aix FROM validator_usuario_aix"
			+ " WHERE nombre_usuario_aix = #{nombreUsuarioAIX}")
	public BUsuarioAIX obtenerUsuarioAIXXNombre(@Param("nombreUsuarioAIX") String nombreUsuarioAIX);

}
