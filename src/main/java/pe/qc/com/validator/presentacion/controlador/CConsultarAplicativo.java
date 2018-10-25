package pe.qc.com.validator.presentacion.controlador;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pe.qc.com.validator.negocio.servicio.NAplicativo;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.PaginaUtil;

@Controller("cConsultarAplicativo")

public class CConsultarAplicativo {

	@Autowired
	NAplicativo nAplicativo;

	List<Map<String, Object>> listaMapAplicativo;
	
	@PostConstruct
	public void init() {
		inicializarObjetos();
	}

	public void inicializarObjetos() {
		try {
			listarAplicativos();
		}catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
	}
	
	public void listarAplicativos() {
		listaMapAplicativo = nAplicativo.listarMapAplicativos();
	}

	public List<Map<String, Object>> getListaMapAplicativo() {
		return listaMapAplicativo;
	}

	public void setListaMapAplicativo(List<Map<String, Object>> listaMapAplicativo) {
		this.listaMapAplicativo = listaMapAplicativo;
	}

}
