package pe.qc.com.validator.persistencia.mapper2;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.persistencia.entity2.BUnidades;



@Transactional(propagation = Propagation.MANDATORY)
public interface MUnidades {
	
	@ResultMap(value = "bUnidades")
	@Select("select fs.Nombre as unidad_disco, fs.fileSystemSize as espacio_total_disco, fs.availablespace as espacion_disponible_disco from cmdb.FileServerServidor fs"
			+ " inner join  cmdb.Servidor s on s.idservidor = fs.idservidor where s.HostName = #{nombreServidor}")
	public List<BUnidades> listarUnidades(@Param("nombreServidor") String nombreServidor);

}
