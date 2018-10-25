package pe.qc.com.validator.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.qc.com.validator.negocio.bo.BOVob;
import pe.qc.com.validator.persistencia.entity.BVob;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Component("tVobEntityBO")
public class TVob implements TransformadorEntityBO<BVob, BOVob>{
	
	@Override
	public BOVob toBO(BVob input) {
		BOVob boVob = null;
		if(input !=null){
			boVob = new BOVob();
			boVob.setIdVob(input.getIdVob());
			boVob.setNombreVob(input.getNombreVob());
		}	
		return boVob;
	}
	
	@Override
	public List<BOVob> toBO(List<BVob> lista){
		List<BOVob> listaBO = null;
		if(lista != null){
			listaBO = new ArrayList<BOVob>();
			for(BVob bVob : lista){
				listaBO.add(toBO(bVob));
			}
		}
		return listaBO;
	}
	
	@Override
	public BVob toEntity(BOVob input){
		BVob bVob = null;
		if(input != null){
			bVob = new BVob();
			bVob.setIdVob(input.getIdVob());
			bVob.setNombreVob(input.getNombreVob());
		}
		return bVob;
	}
	
}
