package pe.qc.com.validator.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.qc.com.validator.negocio.bo.BOUsuario;
import pe.qc.com.validator.persistencia.entity.BUsuario;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Component("tUsuarioEntityBO")
public class TUsuario implements TransformadorEntityBO<BUsuario, BOUsuario>{
	
	@Override
	public BOUsuario toBO(BUsuario input) {
		BOUsuario boUsuario = null;
		if(input !=null){
			boUsuario = new BOUsuario();
			boUsuario.setIdUsuario(input.getIdUsuario());
			boUsuario.setIdRol(input.getIdRol());
			boUsuario.setIdArea(input.getIdArea());
			boUsuario.setNombreUsuario(input.getNombreUsuario());
			boUsuario.setApellidoUsuario(input.getApellidoUsuario());
			boUsuario.setCodigoUsuario(input.getCodigoUsuario());
			boUsuario.setPassUsuario(input.getPassUsuario());
			boUsuario.setEstadoUsuario(input.getEstadoUsuario());
		}	
		return boUsuario;
	}
	
	@Override
	public List<BOUsuario> toBO(List<BUsuario> lista){
		List<BOUsuario> listaBO = null;
		if(lista != null){
			listaBO = new ArrayList<BOUsuario>();
			for(BUsuario bUsuario : lista){
				listaBO.add(toBO(bUsuario));
			}
		}
		return listaBO;
	}
	
	@Override
	public BUsuario toEntity(BOUsuario input){
		BUsuario bUsuario = null;
		if(input != null){
			bUsuario = new BUsuario();
			bUsuario.setIdUsuario(input.getIdUsuario());
			bUsuario.setIdRol(input.getIdRol());
			bUsuario.setIdArea(input.getIdArea());
			bUsuario.setNombreUsuario(input.getNombreUsuario());
			bUsuario.setApellidoUsuario(input.getApellidoUsuario());
			bUsuario.setCodigoUsuario(input.getCodigoUsuario());
			bUsuario.setPassUsuario(input.getPassUsuario());
			bUsuario.setEstadoUsuario(input.getEstadoUsuario());
		}
		return bUsuario;
	}
	
}
