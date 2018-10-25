package pe.qc.com.validator.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.qc.com.validator.negocio.bo.BODetalleSolicitud;
import pe.qc.com.validator.persistencia.entity.BDetalleSolicitud;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Component("tDetalleSolicitudEntityBO")
public class TDetalleSolicitud implements TransformadorEntityBO<BDetalleSolicitud, BODetalleSolicitud>{
	
	@Override
	public BODetalleSolicitud toBO(BDetalleSolicitud input) {
		BODetalleSolicitud boDetalleSolicitud = null;
		if(input !=null){
			boDetalleSolicitud = new BODetalleSolicitud();
			boDetalleSolicitud.setIdDetalleSolicitud(input.getIdDetalleSolicitud());
			boDetalleSolicitud.setIncDetalleSolicitud(input.getIncDetalleSolicitud());
			boDetalleSolicitud.setSsDetalleSolicitud(input.getSsDetalleSolicitud());
			boDetalleSolicitud.setSnDetalleSolicitud(input.getSnDetalleSolicitud());
			boDetalleSolicitud.setStDetalleSolicitud(input.getStDetalleSolicitud());
		}	
		return boDetalleSolicitud;
	}
	
	@Override
	public List<BODetalleSolicitud> toBO(List<BDetalleSolicitud> lista){
		List<BODetalleSolicitud> listaBO = null;
		if(lista != null){
			listaBO = new ArrayList<BODetalleSolicitud>();
			for(BDetalleSolicitud bDetalleSolicitud : lista){
				listaBO.add(toBO(bDetalleSolicitud));
			}
		}
		return listaBO;
	}
	
	@Override
	public BDetalleSolicitud toEntity(BODetalleSolicitud input){
		BDetalleSolicitud bDetalleSolicitud = null;
		if(input != null){
			bDetalleSolicitud = new BDetalleSolicitud();
			bDetalleSolicitud.setIdDetalleSolicitud(input.getIdDetalleSolicitud());
			bDetalleSolicitud.setIncDetalleSolicitud(input.getIncDetalleSolicitud());
			bDetalleSolicitud.setSsDetalleSolicitud(input.getSsDetalleSolicitud());
			bDetalleSolicitud.setSnDetalleSolicitud(input.getSnDetalleSolicitud());
			bDetalleSolicitud.setStDetalleSolicitud(input.getStDetalleSolicitud());
		}
		return bDetalleSolicitud;
	}
	
}
