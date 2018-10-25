package pe.qc.com.validator.persistencia.mapper2;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.persistencia.entity2.BServidor;



@Transactional(propagation = Propagation.MANDATORY)
public interface MServidor {
	
	@ResultMap(value = "bServidor")
	@Select("select Hostname as hostname_servidor, Category as categoria_servidor, TotalPhysicalMemory as memoria_fisica, Description as descripcion_servidor, ManufacturerName as fabricante_servidor,"
			+ " A_Estado as estado_plataforma, Activo as estado_activacion from cmdb.Servidor where hostname = #{nombreServidor}")
	public BServidor obtenerServidor(@Param("nombreServidor") String nombreServidor);

}
