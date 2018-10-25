package pe.qc.com.validator.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.qc.com.validator.negocio.bo.BOUnidades;
import pe.qc.com.validator.persistencia.entity2.BUnidades;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Component("tUnidadesEntityBO")
public class TUnidades implements TransformadorEntityBO<BUnidades, BOUnidades>{
	
	@Override
	public BOUnidades toBO(BUnidades input) {
		BOUnidades boUnidades = null;
		if(input !=null){
			boUnidades = new BOUnidades();
			boUnidades.setNombreUnidad(input.getNombreUnidad());
			boUnidades.setCapacidadTotal(input.getCapacidadTotal());
			boUnidades.setCapacidadDisponible(input.getCapacidadDisponible());
		}	
		return boUnidades;
	}
	
	@Override
	public List<BOUnidades> toBO(List<BUnidades> lista){
		List<BOUnidades> listaBO = null;
		if(lista != null){
			listaBO = new ArrayList<BOUnidades>();
			for(BUnidades bUnidades : lista){
				listaBO.add(toBO(bUnidades));
			}
		}
		return listaBO;
	}
	
	@Override
	public BUnidades toEntity(BOUnidades input){
		BUnidades bUnidades = null;
		if(input != null){
			bUnidades = new BUnidades();
			bUnidades.setNombreUnidad(input.getNombreUnidad());
			bUnidades.setCapacidadTotal(input.getCapacidadTotal());
			bUnidades.setCapacidadDisponible(input.getCapacidadDisponible());
		}
		return bUnidades;
	}
	
}
