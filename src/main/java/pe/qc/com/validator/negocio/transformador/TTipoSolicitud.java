package pe.qc.com.validator.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.qc.com.validator.negocio.bo.BOTipoSolicitud;
import pe.qc.com.validator.persistencia.entity.BTipoSolicitud;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Component("tTipoSolicitudEntityBO")
public class TTipoSolicitud implements TransformadorEntityBO<BTipoSolicitud, BOTipoSolicitud>{
	
	@Override
	public BOTipoSolicitud toBO(BTipoSolicitud input) {
		BOTipoSolicitud boTipoSolicitud = null;
		if(input !=null){
			boTipoSolicitud = new BOTipoSolicitud();
			boTipoSolicitud.setIdTipoSolicitud(input.getIdTipoSolicitud());
			boTipoSolicitud.setNombreTipoSolicitud(input.getNombreTipoSolicitud());
		}	
		return boTipoSolicitud;
	}
	
	@Override
	public List<BOTipoSolicitud> toBO(List<BTipoSolicitud> lista){
		List<BOTipoSolicitud> listaBO = null;
		if(lista != null){
			listaBO = new ArrayList<BOTipoSolicitud>();
			for(BTipoSolicitud bTipoSolicitud : lista){
				listaBO.add(toBO(bTipoSolicitud));
			}
		}
		return listaBO;
	}
	
	@Override
	public BTipoSolicitud toEntity(BOTipoSolicitud input){
		BTipoSolicitud bTipoSolicitud = null;
		if(input != null){
			bTipoSolicitud = new BTipoSolicitud();
			bTipoSolicitud.setIdTipoSolicitud(input.getIdTipoSolicitud());
			bTipoSolicitud.setNombreTipoSolicitud(input.getNombreTipoSolicitud());
		}
		return bTipoSolicitud;
	}
	
}
