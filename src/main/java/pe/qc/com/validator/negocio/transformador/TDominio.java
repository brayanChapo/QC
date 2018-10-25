package pe.qc.com.validator.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.qc.com.validator.negocio.bo.BODominio;
import pe.qc.com.validator.persistencia.entity.BDominio;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Component("tDominioEntityBO")
public class TDominio implements TransformadorEntityBO<BDominio, BODominio>{
	
	@Override
	public BODominio toBO(BDominio input) {
		BODominio boDominio = null;
		if(input !=null){
			boDominio = new BODominio();
			boDominio.setIdDominio(input.getIdDominio());
			boDominio.setNombreDominio(input.getNombreDominio());
			boDominio.setDescripcionDominio(input.getDescripcionDominio());
		}	
		return boDominio;
	}
	
	@Override
	public List<BODominio> toBO(List<BDominio> lista){
		List<BODominio> listaBO = null;
		if(lista != null){
			listaBO = new ArrayList<BODominio>();
			for(BDominio bDominio : lista){
				listaBO.add(toBO(bDominio));
			}
		}
		return listaBO;
	}
	
	@Override
	public BDominio toEntity(BODominio input){
		BDominio bDominio = null;
		if(input != null){
			bDominio = new BDominio();
			bDominio.setIdDominio(input.getIdDominio());
			bDominio.setNombreDominio(input.getNombreDominio());
			bDominio.setDescripcionDominio(input.getDescripcionDominio());
		}
		return bDominio;
	}
	
}
