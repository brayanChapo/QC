package pe.qc.com.validator.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.qc.com.validator.negocio.bo.BOPlataforma;
import pe.qc.com.validator.persistencia.entity.BPlataforma;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Component("tPlataformaEntityBO")
public class TPlataforma implements TransformadorEntityBO<BPlataforma, BOPlataforma>{
	
	@Override
	public BOPlataforma toBO(BPlataforma input) {
		BOPlataforma boPlataforma = null;
		if(input !=null){
			boPlataforma = new BOPlataforma();
			boPlataforma.setIdPlataforma(input.getIdPlataforma());
			boPlataforma.setNombrePlataforma(input.getNombrePlataforma());
		}	
		return boPlataforma;
	}
	
	@Override
	public List<BOPlataforma> toBO(List<BPlataforma> lista){
		List<BOPlataforma> listaBO = null;
		if(lista != null){
			listaBO = new ArrayList<BOPlataforma>();
			for(BPlataforma bPlataforma : lista){
				listaBO.add(toBO(bPlataforma));
			}
		}
		return listaBO;
	}
	
	@Override
	public BPlataforma toEntity(BOPlataforma input){
		BPlataforma bPlataforma = null;
		if(input != null){
			bPlataforma = new BPlataforma();
			bPlataforma.setIdPlataforma(input.getIdPlataforma());
			bPlataforma.setNombrePlataforma(input.getNombrePlataforma());
		}
		return bPlataforma;
	}
	
}
