package pe.qc.com.validator.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.qc.com.validator.negocio.bo.BOArchivoMIS;
import pe.qc.com.validator.persistencia.entity.BArchivoMIS;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Component("tArchivoMISEntityBO")
public class TArchivoMIS implements TransformadorEntityBO<BArchivoMIS, BOArchivoMIS>{
	
	@Override
	public BOArchivoMIS toBO(BArchivoMIS input) {
		BOArchivoMIS boArchivoMIS = null;
		if(input !=null){
			boArchivoMIS = new BOArchivoMIS();
			boArchivoMIS.setIdArchivoMIS(input.getIdArchivoMIS());
			boArchivoMIS.setIdHistoricoMIS(input.getIdHistoricoMIS());
			boArchivoMIS.setCantValTotalMIS(input.getCantValTotalMIS());
			boArchivoMIS.setCantValCorrMIS(input.getCantValCorrMIS());
			boArchivoMIS.setCantValIncMIS(input.getCantValIncMIS());
			boArchivoMIS.setEsHistorico(input.getEsHistorico());
			boArchivoMIS.setFechaMIS(input.getFechaMIS());
			boArchivoMIS.setTkMIS(input.getTkMIS());
		}	
		return boArchivoMIS;
	}
	
	@Override
	public List<BOArchivoMIS> toBO(List<BArchivoMIS> lista){
		List<BOArchivoMIS> listaBO = null;
		if(lista != null){
			listaBO = new ArrayList<BOArchivoMIS>();
			for(BArchivoMIS bArchivoMIS : lista){
				listaBO.add(toBO(bArchivoMIS));
			}
		}
		return listaBO;
	}
	
	@Override
	public BArchivoMIS toEntity(BOArchivoMIS input){
		BArchivoMIS bArchivoMIS = null;
		if(input != null){
			bArchivoMIS = new BArchivoMIS();
			bArchivoMIS.setIdArchivoMIS(input.getIdArchivoMIS());
			bArchivoMIS.setIdHistoricoMIS(input.getIdHistoricoMIS());
			bArchivoMIS.setCantValTotalMIS(input.getCantValTotalMIS());
			bArchivoMIS.setCantValCorrMIS(input.getCantValCorrMIS());
			bArchivoMIS.setCantValIncMIS(input.getCantValIncMIS());
			bArchivoMIS.setEsHistorico(input.getEsHistorico());
			bArchivoMIS.setFechaMIS(input.getFechaMIS());
			bArchivoMIS.setTkMIS(input.getTkMIS());
		}
		return bArchivoMIS;
	}
	
}
