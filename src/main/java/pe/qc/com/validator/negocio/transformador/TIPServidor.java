package pe.qc.com.validator.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.qc.com.validator.negocio.bo.BOIPServidor;
import pe.qc.com.validator.persistencia.entity2.BIPServidor;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Component("tIPServidorEntityBO")
public class TIPServidor implements TransformadorEntityBO<BIPServidor, BOIPServidor>{
	
	@Override
	public BOIPServidor toBO(BIPServidor input) {
		BOIPServidor boIPServidor = null;
		if(input !=null){
			boIPServidor = new BOIPServidor();
			boIPServidor.setCategoria(input.getCategoria());
			boIPServidor.setEstado(input.getEstado());
			boIPServidor.setiP(input.getiP());
			boIPServidor.setIpDetalle(input.getIpDetalle());
			boIPServidor.setItem(input.getItem());
		}	
		return boIPServidor;
	}
	
	@Override
	public List<BOIPServidor> toBO(List<BIPServidor> lista){
		List<BOIPServidor> listaBO = null;
		if(lista != null){
			listaBO = new ArrayList<BOIPServidor>();
			for(BIPServidor bIPServidor : lista){
				listaBO.add(toBO(bIPServidor));
			}
		}
		return listaBO;
	}
	
	@Override
	public BIPServidor toEntity(BOIPServidor input){
		BIPServidor bIPServidor = null;
		if(input != null){
			bIPServidor = new BIPServidor();
			bIPServidor.setCategoria(input.getCategoria());
			bIPServidor.setEstado(input.getEstado());
			bIPServidor.setiP(input.getiP());
			bIPServidor.setIpDetalle(input.getIpDetalle());
			bIPServidor.setItem(input.getItem());
		}
		return bIPServidor;
	}
	
}
