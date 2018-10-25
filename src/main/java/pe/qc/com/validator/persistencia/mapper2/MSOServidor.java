package pe.qc.com.validator.persistencia.mapper2;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.persistencia.entity2.BSOServidor;



@Transactional(propagation = Propagation.MANDATORY)
public interface MSOServidor {
	
	@ResultMap(value = "bSOServidor")
	@Select("select so.Fabricante as fabricante_so, so.TipoSO as tipo_so, so.NombreDetallado as nombre_detallado, so.Activo as estado_so from cmdb.SOServidor so"
			+ " inner join cmdb.Servidor s on so.IdServidor = s.IdServidor where s.hostname = #{nombreServidor}")
	public List<BSOServidor> listarSOServidor(@Param("nombreServidor") String nombreServidor);

}
