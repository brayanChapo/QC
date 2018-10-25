package pe.qc.com.validator.persistencia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.persistencia.entity.BArchivoRutas;



@Transactional(propagation = Propagation.MANDATORY)
public interface MArchivoRutas {
	
	
	@ResultMap(value = "bArchivoRutas")
	@Select("SELECT id_validator_rutas, servidor_validator_rutas, ruta_validator_rutas, fecha_registro FROM validator_rutas")
	public List<BArchivoRutas> listarArchivoRutas();
	
	@ResultMap(value = "bArchivoRutas")
	@Select("SELECT id_validator_rutas, servidor_validator_rutas, ruta_validator_rutas, fecha_registro FROM validator_rutas"
			+ " WHERE servidor_validator_rutas LIKE #{servidorValidatorRutas} ORDER BY servidor_validator_rutas")
	public List<BArchivoRutas> listarRutaxServidor(@Param("servidorValidatorRutas") String servidorValidatorRutas);
	
	@ResultMap(value = "bArchivoRutas")
	@Select("SELECT id_validator_rutas, servidor_validator_rutas, ruta_validator_rutas, fecha_registro FROM validator_rutas"
			+ " WHERE ruta_validator_rutas = #{rutaValidatorRutas} AND servidor_validator_rutas= #{servidorValidatorRutas}")
	public BArchivoRutas obtenerRutaxRuta(@Param("rutaValidatorRutas") String rutaValidatorRutas, @Param("servidorValidatorRutas") String servidorValidatorRutas);
	
	@Insert("insert into validator_rutas(servidor_validator_rutas, ruta_validator_rutas, fecha_registro) values(#{servidorValidatorRutas}, #{rutaValidatorRutas}, #{fechaRegistro})")
	public int insertarRuta(BArchivoRutas bArchivoRutas);
	
	@Update("update validator_rutas SET fecha_registro = #{fechaRegistro}"
			+ " WHERE id_validator_rutas = #{idValidatorRutas}")
	public int modificarRuta(BArchivoRutas bArchivoRutas);
	
	@Delete("DELETE FROM validator_rutas WHERE id_validator_rutas = #{idValidatorRutas}")
	public int eliminarRuta(@Param("idValidatorRutas") Integer idValidatorRutas);
	

}
