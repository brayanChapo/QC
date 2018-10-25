package pe.qc.com.validator.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.qc.com.validator.negocio.bo.BOTipoTarea;
import pe.qc.com.validator.persistencia.entity.BTipoTarea;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Component("tTipoTareaEntityBO")
public class TTipoTarea implements TransformadorEntityBO<BTipoTarea, BOTipoTarea>{
	
	@Override
	public BOTipoTarea toBO(BTipoTarea input) {
		BOTipoTarea boTipoTarea = null;
		if(input !=null){
			boTipoTarea = new BOTipoTarea();
			boTipoTarea.setIdTipoTarea(input.getIdTipoTarea());
			boTipoTarea.setNombreTipoTarea(input.getNombreTipoTarea());
		}	
		return boTipoTarea;
	}
	
	@Override
	public List<BOTipoTarea> toBO(List<BTipoTarea> lista){
		List<BOTipoTarea> listaBO = null;
		if(lista != null){
			listaBO = new ArrayList<BOTipoTarea>();
			for(BTipoTarea bTipoTarea : lista){
				listaBO.add(toBO(bTipoTarea));
			}
		}
		return listaBO;
	}
	
	@Override
	public BTipoTarea toEntity(BOTipoTarea input){
		BTipoTarea bTipoTarea = null;
		if(input != null){
			bTipoTarea = new BTipoTarea();
			bTipoTarea.setIdTipoTarea(input.getIdTipoTarea());
			bTipoTarea.setNombreTipoTarea(input.getNombreTipoTarea());
		}
		return bTipoTarea;
	}
	
}
