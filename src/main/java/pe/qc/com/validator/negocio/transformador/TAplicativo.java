package pe.qc.com.validator.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.qc.com.validator.negocio.bo.BOAplicativo;
import pe.qc.com.validator.persistencia.entity.BAplicativo;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Component("tAplicativoEntityBO")
public class TAplicativo implements TransformadorEntityBO<BAplicativo, BOAplicativo>{
	
	@Override
	public BOAplicativo toBO(BAplicativo input) {
		BOAplicativo boAplicativo = null;
		if(input !=null){
			boAplicativo = new BOAplicativo();
			boAplicativo.setIdAplicativo(input.getIdAplicativo());
			boAplicativo.setIdDominio(input.getIdDominio());
			boAplicativo.setIdVob(input.getIdVob());
			boAplicativo.setNombreAplicativo(input.getNombreAplicativo());
		}	
		return boAplicativo;
	}
	
	@Override
	public List<BOAplicativo> toBO(List<BAplicativo> lista){
		List<BOAplicativo> listaBO = null;
		if(lista != null){
			listaBO = new ArrayList<BOAplicativo>();
			for(BAplicativo bAplicativo : lista){
				listaBO.add(toBO(bAplicativo));
			}
		}
		return listaBO;
	}
	
	@Override
	public BAplicativo toEntity(BOAplicativo input){
		BAplicativo bAplicativo = null;
		if(input != null){
			bAplicativo = new BAplicativo();
			bAplicativo.setIdAplicativo(input.getIdAplicativo());
			bAplicativo.setIdDominio(input.getIdDominio());
			bAplicativo.setIdVob(input.getIdVob());
			bAplicativo.setNombreAplicativo(input.getNombreAplicativo());
		}
		return bAplicativo;
	}
	
}
