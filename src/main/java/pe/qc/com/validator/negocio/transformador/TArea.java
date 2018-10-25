package pe.qc.com.validator.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.qc.com.validator.negocio.bo.BOArea;
import pe.qc.com.validator.persistencia.entity.BArea;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Component("tAreaEntityBO")
public class TArea implements TransformadorEntityBO<BArea, BOArea>{
	
	@Override
	public BOArea toBO(BArea input) {
		BOArea boArea = null;
		if(input !=null){
			boArea = new BOArea();
			boArea.setIdArea(input.getIdArea());
			boArea.setNombreArea(input.getNombreArea());
		}	
		return boArea;
	}
	
	@Override
	public List<BOArea> toBO(List<BArea> lista){
		List<BOArea> listaBO = null;
		if(lista != null){
			listaBO = new ArrayList<BOArea>();
			for(BArea bArea : lista){
				listaBO.add(toBO(bArea));
			}
		}
		return listaBO;
	}
	
	@Override
	public BArea toEntity(BOArea input){
		BArea bArea = null;
		if(input != null){
			bArea = new BArea();
			bArea.setIdArea(input.getIdArea());
			bArea.setNombreArea(input.getNombreArea());
		}
		return bArea;
	}
	
}
