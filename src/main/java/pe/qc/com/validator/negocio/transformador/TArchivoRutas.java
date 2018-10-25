package pe.qc.com.validator.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.qc.com.validator.negocio.bo.BOArchivoRutas;
import pe.qc.com.validator.persistencia.entity.BArchivoRutas;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Component("tArchivoRutasEntityBO")
public class TArchivoRutas implements TransformadorEntityBO<BArchivoRutas, BOArchivoRutas>{
	
	@Override
	public BOArchivoRutas toBO(BArchivoRutas input) {
		BOArchivoRutas boArchivoRutas = null;
		if(input !=null){
			boArchivoRutas = new BOArchivoRutas();
			boArchivoRutas.setIdValidatorRutas(input.getIdValidatorRutas());
			boArchivoRutas.setServidorValidatorRutas(input.getServidorValidatorRutas());
			boArchivoRutas.setRutaValidatorRutas(input.getRutaValidatorRutas());
			boArchivoRutas.setFechaRegistro(input.getFechaRegistro());
		}	
		return boArchivoRutas;
	}
	
	@Override
	public List<BOArchivoRutas> toBO(List<BArchivoRutas> lista){
		List<BOArchivoRutas> listaBO = null;
		if(lista != null){
			listaBO = new ArrayList<BOArchivoRutas>();
			for(BArchivoRutas bArchivoRutas : lista){
				listaBO.add(toBO(bArchivoRutas));
			}
		}
		return listaBO;
	}
	
	@Override
	public BArchivoRutas toEntity(BOArchivoRutas input){
		BArchivoRutas bArchivoRutas = null;
		if(input != null){
			bArchivoRutas = new BArchivoRutas();
			bArchivoRutas.setIdValidatorRutas(input.getIdValidatorRutas());
			bArchivoRutas.setServidorValidatorRutas(input.getServidorValidatorRutas());
			bArchivoRutas.setRutaValidatorRutas(input.getRutaValidatorRutas());
			bArchivoRutas.setFechaRegistro(input.getFechaRegistro());
		}
		return bArchivoRutas;
	}
	
}
