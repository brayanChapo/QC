package pe.qc.com.validator.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.qc.com.validator.negocio.bo.BOEtapa;
import pe.qc.com.validator.persistencia.entity.BEtapa;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Component("tEtapaEntityBO")
public class TEtapa implements TransformadorEntityBO<BEtapa, BOEtapa>{
	
	@Override
	public BOEtapa toBO(BEtapa input) {
		BOEtapa boEtapa = null;
		if(input !=null){
			boEtapa = new BOEtapa();
			boEtapa.setIdEtapa(input.getIdEtapa());
			boEtapa.setNombreEtapa(input.getNombreEtapa());
		}	
		return boEtapa;
	}
	
	@Override
	public List<BOEtapa> toBO(List<BEtapa> lista){
		List<BOEtapa> listaBO = null;
		if(lista != null){
			listaBO = new ArrayList<BOEtapa>();
			for(BEtapa bEtapa : lista){
				listaBO.add(toBO(bEtapa));
			}
		}
		return listaBO;
	}
	
	@Override
	public BEtapa toEntity(BOEtapa input){
		BEtapa bEtapa = null;
		if(input != null){
			bEtapa = new BEtapa();
			bEtapa.setIdEtapa(input.getIdEtapa());
			bEtapa.setNombreEtapa(input.getNombreEtapa());
		}
		return bEtapa;
	}
	
}
