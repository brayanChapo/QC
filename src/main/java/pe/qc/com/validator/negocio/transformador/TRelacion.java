package pe.qc.com.validator.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.qc.com.validator.negocio.bo.BORelacion;
import pe.qc.com.validator.persistencia.entity2.BRelacion;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Component("tRelacionEntityBO")
public class TRelacion implements TransformadorEntityBO<BRelacion, BORelacion>{
	
	@Override
	public BORelacion toBO(BRelacion input) {
		BORelacion boRelacion = null;
		if(input !=null){
			boRelacion = new BORelacion();
			boRelacion.setNombreServidor(input.getNombreServidor());
			boRelacion.setNombreCodigoApp(input.getNombreCodigoApp());
			boRelacion.setNombreAmbiente(input.getNombreAmbiente());
		}	
		return boRelacion;
	}
	
	@Override
	public List<BORelacion> toBO(List<BRelacion> lista){
		List<BORelacion> listaBO = null;
		if(lista != null){
			listaBO = new ArrayList<BORelacion>();
			for(BRelacion bRelacion : lista){
				listaBO.add(toBO(bRelacion));
			}
		}
		return listaBO;
	}
	
	@Override
	public BRelacion toEntity(BORelacion input){
		BRelacion bRelacion = null;
		if(input != null){
			bRelacion = new BRelacion();
			bRelacion.setNombreServidor(input.getNombreServidor());
			bRelacion.setNombreCodigoApp(input.getNombreCodigoApp());
			bRelacion.setNombreAmbiente(input.getNombreAmbiente());
		}
		return bRelacion;
	}
	
}
