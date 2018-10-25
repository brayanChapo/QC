package pe.qc.com.validator.persistencia.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.persistencia.entity.BAplicativo;



@Transactional(propagation = Propagation.MANDATORY)
public interface MAplicativo {
	
	@Insert("insert into validator_Aplicativo(id_dominio, id_vob, nombre_codigo_ap) values(#{idDominio}, #{idVob}, UPPER(TRIM(#{nombreAplicativo})))")
	public int insertarAplicativo(BAplicativo Aplicativo);
	
	@Update("update validator_Aplicativo SET id_dominio = #{idDominio}, id_vob = #{idVob}, nombre_codigo_ap = UPPER(TRIM(#{nombreAplicativo}))"
			+ "	WHERE id_codigo_ap = #{idAplicativo}")
	public int modificarAplicativo(BAplicativo Aplicativo);
	
	@Delete("DELETE FROM validator_Aplicativo WHERE id_codigo_ap = #{idAplicativo}")
	public int eliminarAplicativo(@Param("idAplicativo") Integer idAplicativo);
	
	@ResultMap(value = "bAplicativo")
	@Select("SELECT id_codigo_ap, id_dominio, id_vob, nombre_codigo_ap FROM validator_Aplicativo")
	public List<BAplicativo> listarAplicativo();
	
	@ResultMap(value = "bAplicativo")
	@Select("SELECT id_codigo_ap, id_dominio, id_vob, nombre_codigo_ap FROM validator_Aplicativo WHERE nombre_codigo_ap LIKE #{nombreAplicativo} ORDER BY nombre_codigo_ap")
	public List<BAplicativo> listarAplicativoXNombre(@Param("nombreAplicativo") String nombreAplicativo);
	
	@ResultMap(value = "bAplicativo")
	@Select("SELECT id_codigo_ap, id_dominio, id_vob, nombre_codigo_ap FROM validator_Aplicativo"
			+ " WHERE id_codigo_ap = #{idAplicativo}")
	public BAplicativo obtenerAplicativoXId(@Param("idAplicativo") Integer idAplicativo);
	
	@ResultMap(value = "bAplicativo")
	@Select("SELECT id_codigo_ap, id_dominio, id_vob, nombre_codigo_ap FROM validator_Aplicativo"
			+ " WHERE id_vob = #{idVob}")
	public BAplicativo obtenerAplicativoXIdVob(@Param("idVob") Integer idVob);
	
	@ResultMap(value = "bAplicativo")
	@Select("SELECT id_codigo_ap, id_dominio, id_vob, nombre_codigo_ap FROM validator_Aplicativo"
			+ " WHERE id_dominio = #{idDominio}")
	public List<BAplicativo> obtenerAplicativoXIdDominio(@Param("idDominio") Integer idDominio);
	
	@ResultMap(value = "bAplicativo")
	@Select("SELECT id_codigo_ap, id_dominio, id_vob, nombre_codigo_ap FROM validator_Aplicativo"
			+ " WHERE nombre_codigo_ap = #{nombreAplicativo}")
	public BAplicativo obtenerAplicativoXNombre(@Param("nombreAplicativo") String nombreAplicativo);
	
	@ResultMap(value = "mapAplicativo")
	@Select("SELECT ID_CODIGO_AP, NOMBRE_DOMINIO, NOMBRE_VOB, NOMBRE_CODIGO_AP"
			+ " FROM validator_aplicativo ap"
			+ " INNER JOIN validator_dominio dom"
			+ " ON ap.ID_DOMINIO = dom.ID_DOMINIO"
			+ " INNER JOIN validator_vob vo"
			+ " ON ap.ID_VOB = vo.ID_VOB"
			+ " ORDER BY NOMBRE_CODIGO_AP")
	public List<Map<String, Object>> listarMapAplicativo();
	
	@ResultMap(value = "mapAplicativo")
	@Select("SELECT ID_CODIGO_AP, NOMBRE_DOMINIO, NOMBRE_VOB, NOMBRE_CODIGO_AP"
			+ " FROM validator_aplicativo ap"
			+ " INNER JOIM validator_dominio dom"
			+ " ON ap.ID_DOMINIO = dom.ID_DOMINIO"
			+ " INNER JOIN validator_vob vo"
			+ " ON ap.ID_VOB = vo.ID_VOB"
			+ " WHERE ID_CODIGO_AP =  #{idAplicativo}")
	public Map<String, Object> obtenerMapAplicativoXId(@Param("idAplicativo") Integer idAplicativo);
	
}
