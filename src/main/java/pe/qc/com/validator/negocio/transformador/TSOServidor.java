package pe.qc.com.validator.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.qc.com.validator.negocio.bo.BOSOServidor;
import pe.qc.com.validator.persistencia.entity2.BSOServidor;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Component("tSOServidorEntityBO")
public class TSOServidor implements TransformadorEntityBO<BSOServidor, BOSOServidor>{
	
	@Override
	public BOSOServidor toBO(BSOServidor input) {
		BOSOServidor boSOServidor = null;
		if(input !=null){
			boSOServidor = new BOSOServidor();
			boSOServidor.setEstado(input.getEstado());
			boSOServidor.setFabricante(input.getFabricante());
			boSOServidor.setNombreDetallado(input.getNombreDetallado());
			boSOServidor.setTipoSO(input.getTipoSO());
		}	
		return boSOServidor;
	}
	
	@Override
	public List<BOSOServidor> toBO(List<BSOServidor> lista){
		List<BOSOServidor> listaBO = null;
		if(lista != null){
			listaBO = new ArrayList<BOSOServidor>();
			for(BSOServidor bSOServidor : lista){
				listaBO.add(toBO(bSOServidor));
			}
		}
		return listaBO;
	}
	
	@Override
	public BSOServidor toEntity(BOSOServidor input){
		BSOServidor bSOServidor = null;
		if(input != null){
			bSOServidor = new BSOServidor();
			bSOServidor.setEstado(input.getEstado());
			bSOServidor.setFabricante(input.getFabricante());
			bSOServidor.setNombreDetallado(input.getNombreDetallado());
			bSOServidor.setTipoSO(input.getTipoSO());
		}
		return bSOServidor;
	}
	
}
