package pe.qc.com.validator.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.qc.com.validator.negocio.bo.BOUsuarioAIX;
import pe.qc.com.validator.persistencia.entity.BUsuarioAIX;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Component("tUsuarioAIXEntityBO")
public class TUsuarioAIX implements TransformadorEntityBO<BUsuarioAIX, BOUsuarioAIX>{
	
	@Override
	public BOUsuarioAIX toBO(BUsuarioAIX input) {
		BOUsuarioAIX boUsuarioAIX = null;
		if(input !=null){
			boUsuarioAIX = new BOUsuarioAIX();
			boUsuarioAIX.setIdUsuarioAIX(input.getIdUsuarioAIX());
			boUsuarioAIX.setNombreUsuarioAIX(input.getNombreUsuarioAIX());
		}	
		return boUsuarioAIX;
	}
	
	@Override
	public List<BOUsuarioAIX> toBO(List<BUsuarioAIX> lista){
		List<BOUsuarioAIX> listaBO = null;
		if(lista != null){
			listaBO = new ArrayList<BOUsuarioAIX>();
			for(BUsuarioAIX bUsuarioAIX : lista){
				listaBO.add(toBO(bUsuarioAIX));
			}
		}
		return listaBO;
	}
	
	@Override
	public BUsuarioAIX toEntity(BOUsuarioAIX input){
		BUsuarioAIX bUsuarioAIX = null;
		if(input != null){
			bUsuarioAIX = new BUsuarioAIX();
			bUsuarioAIX.setIdUsuarioAIX(input.getIdUsuarioAIX());
			bUsuarioAIX.setNombreUsuarioAIX(input.getNombreUsuarioAIX());
		}
		return bUsuarioAIX;
	}
	
}
