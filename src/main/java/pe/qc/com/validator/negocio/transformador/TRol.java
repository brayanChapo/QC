package pe.qc.com.validator.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.qc.com.validator.negocio.bo.BORol;
import pe.qc.com.validator.persistencia.entity.BRol;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Component("tRolEntityBO")
public class TRol implements TransformadorEntityBO<BRol, BORol>{
	
	@Override
	public BORol toBO(BRol input) {
		BORol boRol = null;
		if(input !=null){
			boRol = new BORol();
			boRol.setIdRol(input.getIdRol());
			boRol.setNombreRol(input.getNombreRol());
		}	
		return boRol;
	}
	
	@Override
	public List<BORol> toBO(List<BRol> lista){
		List<BORol> listaBO = null;
		if(lista != null){
			listaBO = new ArrayList<BORol>();
			for(BRol bRol : lista){
				listaBO.add(toBO(bRol));
			}
		}
		return listaBO;
	}
	
	@Override
	public BRol toEntity(BORol input){
		BRol bRol = null;
		if(input != null){
			bRol = new BRol();
			bRol.setIdRol(input.getIdRol());
			bRol.setNombreRol(input.getNombreRol());
		}
		return bRol;
	}
	
}
