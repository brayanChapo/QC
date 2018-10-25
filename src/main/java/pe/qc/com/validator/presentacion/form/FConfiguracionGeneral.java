package pe.qc.com.validator.presentacion.form;

import java.util.List;

public class FConfiguracionGeneral {
	private List<FSeccionConfiguracionGeneral> listaFSeccionConfiguracionGeneral;
	
	public FConfiguracionGeneral() {
		
	}

	public List<FSeccionConfiguracionGeneral> getListaFSeccionConfiguracionGeneral() {
		return listaFSeccionConfiguracionGeneral;
	}

	public void setListaFSeccionConfiguracionGeneral(List<FSeccionConfiguracionGeneral> listaFSeccionConfiguracionGeneral) {
		this.listaFSeccionConfiguracionGeneral = listaFSeccionConfiguracionGeneral;
	}

	@Override
	public String toString() {
		return "FConfiguracionGeneral [listaFSeccionConfiguracionGeneral=" + listaFSeccionConfiguracionGeneral + "]";
	}
	
}
