package pe.qc.com.validator.presentacion.controlador;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pe.qc.com.validator.negocio.bo.BOVob;
import pe.qc.com.validator.negocio.servicio.NVob;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.PaginaUtil;

@Controller("cConsultarVOB")

public class CConsultarVOB {

	@Autowired
	NVob nVob;

	List<BOVob> listarVob;
	
	@PostConstruct
	public void init() {
		inicializarObjetos();
	}

	public void inicializarObjetos() {
		try {
			listarVob = nVob.listarVob();
		}catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}	
	}
	
	public List<BOVob> getListarVob() {
		return listarVob;
	}

	public void setListarVob(List<BOVob> listarVob) {
		this.listarVob = listarVob;
	}
	
}
