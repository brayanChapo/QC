package pe.qc.com.validator.persistencia.mapper2;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.persistencia.entity2.BIPServidor;



@Transactional(propagation = Propagation.MANDATORY)
public interface MIPServidor {
	
	@ResultMap(value = "bIPServidor")
	@Select("select ip.Categoria as categoria_ip, ip.Item as item_ip, ip.IP as ip, ip.IPDetalle as ip_detalle, ip.Activo as estado_ip from cmdb.IPServidor ip"
			+ " inner join cmdb.Servidor s on ip.IdServidor = s.IdServidor where s.hostname = #{nombreServidor}")
	public List<BIPServidor> listarIPServidor(@Param("nombreServidor") String nombreServidor);

}
