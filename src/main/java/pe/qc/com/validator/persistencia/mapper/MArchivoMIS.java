package pe.qc.com.validator.persistencia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.persistencia.entity.BArchivoMIS;

@Transactional(propagation = Propagation.MANDATORY)
public interface MArchivoMIS {
	
	@ResultMap(value = "bArchivoMIS")
	@Select("SELECT id_MIS, val_id_MIS, cant_val_tot_MIS, cant_val_corr_MIS, cant_val_inco_MIS, porc_val_MIS, esHistorico_MIS, fecha_MIS, tk_MIS FROM validator_MIS")
	public List<BArchivoMIS> listarArchivoMIS();
	
	@ResultMap(value = "bArchivoMIS")
	@Select("SELECT id_MIS, val_id_MIS, cant_val_tot_MIS, cant_val_corr_MIS, cant_val_inco_MIS, porc_val_MIS, esHistorico_MIS, fecha_MIS, tk_MIS FROM validator_MIS"
			+ " WHERE id_MIS = #{idArchivoMIS}")
	public BArchivoMIS obtenerArchivoMISXId(@Param("idArchivoMIS") Integer idArchivoMIS);
	
	@ResultMap(value = "bArchivoMIS")
	@Select("SELECT id_MIS, val_id_MIS, cant_val_tot_MIS, cant_val_corr_MIS, cant_val_inco_MIS, porc_val_MIS, esHistorico_MIS, fecha_MIS, tk_MIS FROM validator_MIS"
			+ " WHERE tk_MIS = #{tkMIS} AND esHistorico_MIS='0'")
	public BArchivoMIS obtenerArchivoMISXTK(@Param("tkMIS") String tkMIS);
	
	@Update("update validator_MIS SET esHistorico_MIS = '1'"
			+ " WHERE id_MIS = #{idArchivoMIS}")
	public int convertirAHistoricoArchivoMIS(@Param("idArchivoMIS") Integer idArchivoMIS);
	
	@Insert("insert into validator_MIS (id_MIS, val_id_MIS, cant_val_tot_MIS, cant_val_corr_MIS, cant_val_inco_MIS, porc_val_MIS, esHistorico_MIS, fecha_MIS, tk_MIS)"
			+ " values(#{idArchivoMIS}, #{idHistoricoMIS}, #{cantValTotalMIS}, #{cantValCorrMIS}, #{cantValIncMIS}, #{porcValMIS}, #{esHistorico}, #{fechaMIS}, #{tkMIS})")
	public int insertarArchivoMIS(BArchivoMIS bArchivoMis);
	
	@ResultMap(value = "bArchivoMIS")
	@Select("SELECT id_MIS, val_id_MIS, cant_val_tot_MIS, cant_val_corr_MIS, cant_val_inco_MIS, porc_val_MIS, esHistorico_MIS, fecha_MIS, tk_MIS FROM validator_MIS"
			+ " where eshistorico_mis <> '0' and tk_MIS = #{tkMIS}")
	public List<BArchivoMIS> listarArchivoMISNoFinalizados(@Param("tkMIS") String tkMIS);

}
