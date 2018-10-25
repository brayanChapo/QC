package pe.qc.com.validator.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.qc.com.validator.negocio.bo.BOServidor;
import pe.qc.com.validator.persistencia.entity2.BServidor;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Component("tServidorEntityBO")
public class TServidor implements TransformadorEntityBO<BServidor, BOServidor>{
	
	@Override
	public BOServidor toBO(BServidor input) {
		BOServidor boServidor = null;
		if(input !=null){
			boServidor = new BOServidor();
			boServidor.setCategoriaServidor(input.getCategoriaServidor());
			boServidor.setDescripcionServidor(input.getDescripcionServidor());
			boServidor.setEstadoCmdb(input.getEstadoCmdb());
			boServidor.setEstadoPlataforma(input.getEstadoPlataforma());
			boServidor.setFabricanteServidor(input.getFabricanteServidor());
			boServidor.setHostnameServidor(input.getHostnameServidor());
			boServidor.setMemoriaFisica(input.getMemoriaFisica());
		}	
		return boServidor;
	}
	
	@Override
	public List<BOServidor> toBO(List<BServidor> lista){
		List<BOServidor> listaBO = null;
		if(lista != null){
			listaBO = new ArrayList<BOServidor>();
			for(BServidor bServidor : lista){
				listaBO.add(toBO(bServidor));
			}
		}
		return listaBO;
	}
	
	@Override
	public BServidor toEntity(BOServidor input){
		BServidor bServidor = null;
		if(input != null){
			bServidor = new BServidor();
			bServidor.setCategoriaServidor(input.getCategoriaServidor());
			bServidor.setDescripcionServidor(input.getDescripcionServidor());
			bServidor.setEstadoCmdb(input.getEstadoCmdb());
			bServidor.setEstadoPlataforma(input.getEstadoPlataforma());
			bServidor.setFabricanteServidor(input.getFabricanteServidor());
			bServidor.setHostnameServidor(input.getHostnameServidor());
			bServidor.setMemoriaFisica(input.getMemoriaFisica());
		}
		return bServidor;
	}
	
}
