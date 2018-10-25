package pe.qc.com.validator.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.qc.com.validator.negocio.bo.BOSolicitud;
import pe.qc.com.validator.persistencia.entity.BSolicitud;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Component("tSolicitudEntityBO")
public class TSolicitud implements TransformadorEntityBO<BSolicitud, BOSolicitud>{
	
	@Override
	public BOSolicitud toBO(BSolicitud input) {
		BOSolicitud boSolicitud = null;
		if(input !=null){
			boSolicitud = new BOSolicitud();
			boSolicitud.setIdSolicitud(input.getIdSolicitud());
			boSolicitud.setIdDetalleSolicitud(input.getIdDetalleSolicitud());
			boSolicitud.setIdTipoSolicitud(input.getIdTipoSolicitud());
			boSolicitud.setIdEstadoSolicitud(input.getIdEstadoSolicitud());
			boSolicitud.setIdCodigoApp(input.getIdCodigoApp());
			boSolicitud.setIdUsuario(input.getIdUsuario());
			boSolicitud.setIdRevisor(input.getIdRevisor());
			boSolicitud.setIdPlataforma(input.getIdPlataforma());
			boSolicitud.setIdHistoricoSolicitud(input.getIdHistoricoSolicitud());
			boSolicitud.setTkSolicitud(input.getTkSolicitud());
			boSolicitud.setCrqSolicitud(input.getCrqSolicitud());
			boSolicitud.setCriticidadSolicitud(input.getCriticidadSolicitud());
			boSolicitud.setEsHistorico(input.getEsHistorico());
			boSolicitud.setFechaSolicitud(input.getFechaSolicitud());
		}	
		return boSolicitud;
	}
	
	@Override
	public List<BOSolicitud> toBO(List<BSolicitud> lista){
		List<BOSolicitud> listaBO = null;
		if(lista != null){
			listaBO = new ArrayList<BOSolicitud>();
			for(BSolicitud bSolicitud : lista){
				listaBO.add(toBO(bSolicitud));
			}
		}
		return listaBO;
	}
	
	@Override
	public BSolicitud toEntity(BOSolicitud input){
		BSolicitud bSolicitud = null;
		if(input != null){
			bSolicitud = new BSolicitud();
			bSolicitud.setIdSolicitud(input.getIdSolicitud());
			bSolicitud.setIdDetalleSolicitud(input.getIdDetalleSolicitud());
			bSolicitud.setIdTipoSolicitud(input.getIdTipoSolicitud());
			bSolicitud.setIdEstadoSolicitud(input.getIdEstadoSolicitud());
			bSolicitud.setIdCodigoApp(input.getIdCodigoApp());
			bSolicitud.setIdUsuario(input.getIdUsuario());
			bSolicitud.setIdRevisor(input.getIdRevisor());
			bSolicitud.setIdPlataforma(input.getIdPlataforma());
			bSolicitud.setIdHistoricoSolicitud(input.getIdHistoricoSolicitud());
			bSolicitud.setTkSolicitud(input.getTkSolicitud());
			bSolicitud.setCrqSolicitud(input.getCrqSolicitud());
			bSolicitud.setCriticidadSolicitud(input.getCriticidadSolicitud());
			bSolicitud.setEsHistorico(input.getEsHistorico());
			bSolicitud.setFechaSolicitud(input.getFechaSolicitud());
		}
		return bSolicitud;
	}
	
}
