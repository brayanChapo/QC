package pe.qc.com.validator.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.qc.com.validator.negocio.bo.BOTarea;
import pe.qc.com.validator.persistencia.entity.BTarea;
import pe.qc.com.validator.util.AplicacionUtil;
import pe.qc.com.validator.util.ArchivoUtil;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Component("tTareaEntityBO")
public class TTarea implements TransformadorEntityBO<BTarea, BOTarea>{
	
	@Override
	public BOTarea toBO(BTarea input) {
		BOTarea boTarea = null;
		if(input !=null){
			boTarea = new BOTarea();
			boTarea.setIdTarea(input.getIdTarea());
			boTarea.setNombreTarea(input.getNombreTarea());
			boTarea.setCrqTarea(input.getCrqTarea());
			boTarea.setDescripcionTarea(input.getDescripcionTarea());
			boTarea.setArchivoTarea(input.getArchivoTarea());
			boTarea.setArchivoTareaStreamed(ArchivoUtil.convertirAStreamed(input.getArchivoTarea(), input.getNombreArchivo()));
			boTarea.setNombreArchivo((input.getNombreArchivo()!=null ? input.getNombreArchivo().toUpperCase().trim():null));
			boTarea.setIdEquipoTarea(input.getIdEquipoTarea());
			boTarea.setIdEtapaTarea(input.getIdEtapaTarea());
			boTarea.setIdSolicitudTarea(input.getIdSolicitudTarea());
			boTarea.setIdTipoTarea(input.getIdTipoTarea());
			boTarea.setFechaTarea(input.getFechaTarea());
			boTarea.setIdUsuarioTarea(input.getIdUsuarioTarea());
			boTarea.setWoTarea(input.getWoTarea());
		}	
		return boTarea;
	}
	
	@Override
	public List<BOTarea> toBO(List<BTarea> lista){
		List<BOTarea> listaBO = null;
		if(lista != null){
			listaBO = new ArrayList<BOTarea>();
			for(BTarea bTarea : lista){
				listaBO.add(toBO(bTarea));
			}
		}
		return listaBO;
	}
	
	@Override
	public BTarea toEntity(BOTarea input){
		BTarea bTarea = null;
		if(input != null){
			bTarea = new BTarea();
			bTarea.setIdTarea(input.getIdTarea());
			bTarea.setNombreTarea(input.getNombreTarea());
			bTarea.setCrqTarea(input.getCrqTarea());
			bTarea.setDescripcionTarea(input.getDescripcionTarea());
			bTarea.setArchivoTarea((input.getArchivoUpTarea()!=null)? input.getArchivoUpTarea().getContents(): null);
			bTarea.setNombreArchivo(AplicacionUtil.convertirAMayusculas(input.getNombreArchivo()));
			bTarea.setIdEquipoTarea(input.getIdEquipoTarea());
			bTarea.setIdEtapaTarea(input.getIdEtapaTarea());
			bTarea.setIdSolicitudTarea(input.getIdSolicitudTarea());
			bTarea.setIdTipoTarea(input.getIdTipoTarea());
			bTarea.setFechaTarea(input.getFechaTarea());
			bTarea.setIdUsuarioTarea(input.getIdUsuarioTarea());
			bTarea.setWoTarea(input.getWoTarea());
		}
		return bTarea;
	}
	
}
