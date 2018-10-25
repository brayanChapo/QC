package pe.qc.com.validator.presentacion.controlador;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pe.qc.com.validator.negocio.bo.BODominio;
import pe.qc.com.validator.negocio.servicio.NDominio;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.PaginaUtil;

@Controller("cConsultarDominio")

public class CConsultarDominio {

	@Autowired
	NDominio nDominio;

	List<BODominio> listarDominio;
	
	@PostConstruct
	public void init() {
		inicializarObjetos();
	}

	public void inicializarObjetos() {
		try {
			listarDominio = nDominio.listarDominio();
		}catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}	
	}

	public List<BODominio> getListarDominio() {
		return listarDominio;
	}

	public void setListarDominio(List<BODominio> listarDominio) {
		this.listarDominio = listarDominio;
	}


}
