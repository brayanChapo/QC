package pe.qc.com.validator.persistencia.mapper2;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.persistencia.entity2.BRelacion;



@Transactional(propagation = Propagation.MANDATORY)
public interface MRelacion {
	
	@ResultMap(value = "bRelacion")
	@Select("select r.Servidor as nombre_servidor , r.CodigoApp as nombre_codigoApp, a.DetalleAmbiente as ambiente from  Relacion r"
			+ " inner join Ambiente a on r.AmbienteId = a.AmbienteId")
	public List<BRelacion> listarRelacion();

}
