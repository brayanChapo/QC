package pe.qc.com.validator.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.qc.com.validator.negocio.bo.BOEstadoSolicitud;
import pe.qc.com.validator.persistencia.entity.BEstadoSolicitud;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Component("tEstadoSolicitudEntityBO")
public class TEstadoSolicitud implements TransformadorEntityBO<BEstadoSolicitud, BOEstadoSolicitud>{
	
	@Override
	public BOEstadoSolicitud toBO(BEstadoSolicitud input) {
		BOEstadoSolicitud boEstadoSolicitud = null;
		if(input !=null){
			boEstadoSolicitud = new BOEstadoSolicitud();
			boEstadoSolicitud.setIdEstadoSolicitud(input.getIdEstadoSolicitud());
			boEstadoSolicitud.setNombreEstadoSolicitud(input.getNombreEstadoSolicitud());
		}	
		return boEstadoSolicitud;
	}
	
	@Override
	public List<BOEstadoSolicitud> toBO(List<BEstadoSolicitud> lista){
		List<BOEstadoSolicitud> listaBO = null;
		if(lista != null){
			listaBO = new ArrayList<BOEstadoSolicitud>();
			for(BEstadoSolicitud bEstadoSolicitud : lista){
				listaBO.add(toBO(bEstadoSolicitud));
			}
		}
		return listaBO;
	}
	
	@Override
	public BEstadoSolicitud toEntity(BOEstadoSolicitud input){
		BEstadoSolicitud bEstadoSolicitud = null;
		if(input != null){
			bEstadoSolicitud = new BEstadoSolicitud();
			bEstadoSolicitud.setIdEstadoSolicitud(input.getIdEstadoSolicitud());
			bEstadoSolicitud.setNombreEstadoSolicitud(input.getNombreEstadoSolicitud());
		}
		return bEstadoSolicitud;
	}
	
}
