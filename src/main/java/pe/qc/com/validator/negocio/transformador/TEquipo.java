package pe.qc.com.validator.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.qc.com.validator.negocio.bo.BOEquipo;
import pe.qc.com.validator.persistencia.entity.BEquipo;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Component("tEquipoEntityBO")
public class TEquipo implements TransformadorEntityBO<BEquipo, BOEquipo>{
	
	@Override
	public BOEquipo toBO(BEquipo input) {
		BOEquipo boEquipo = null;
		if(input !=null){
			boEquipo = new BOEquipo();
			boEquipo.setIdEquipo(input.getIdEquipo());
			boEquipo.setNombreEquipo(input.getNombreEquipo());
		}	
		return boEquipo;
	}
	
	@Override
	public List<BOEquipo> toBO(List<BEquipo> lista){
		List<BOEquipo> listaBO = null;
		if(lista != null){
			listaBO = new ArrayList<BOEquipo>();
			for(BEquipo bEquipo : lista){
				listaBO.add(toBO(bEquipo));
			}
		}
		return listaBO;
	}
	
	@Override
	public BEquipo toEntity(BOEquipo input){
		BEquipo bEquipo = null;
		if(input != null){
			bEquipo = new BEquipo();
			bEquipo.setIdEquipo(input.getIdEquipo());
			bEquipo.setNombreEquipo(input.getNombreEquipo());
		}
		return bEquipo;
	}
	
}
