package pe.qc.com.validator.presentacion.form;

import java.util.ArrayList;
import java.util.List;

public class FSeccionConfiguracionGeneral {
	private String idSeccionConfiguracionGeneral;
	private String nombreSeccionConfiguracionGeneral;
	private List<String> palabras;
	private List<FGrupoDominios> listaFGrupoDominios;
	private List<FDirectoryCreacionUsuario> listaFDirectoryCreacionUsuario;
	
	public FSeccionConfiguracionGeneral() {
		palabras = new ArrayList<>();
	}

	public String getIdSeccionConfiguracionGeneral() {
		return idSeccionConfiguracionGeneral;
	}

	public void setIdSeccionConfiguracionGeneral(String idSeccionConfiguracionGeneral) {
		this.idSeccionConfiguracionGeneral = idSeccionConfiguracionGeneral;
	}

	public String getNombreSeccionConfiguracionGeneral() {
		return nombreSeccionConfiguracionGeneral;
	}

	public void setNombreSeccionConfiguracionGeneral(String nombreSeccionConfiguracionGeneral) {
		this.nombreSeccionConfiguracionGeneral = nombreSeccionConfiguracionGeneral;
	}

	public List<String> getPalabras() {
		return palabras;
	}

	public void setPalabras(String palabras) {
		this.palabras.add(palabras);
	}

	public List<FGrupoDominios> getListaFGrupoDominios() {
		return listaFGrupoDominios;
	}

	public void setListaFGrupoDominios(List<FGrupoDominios> listaFGrupoDominios) {
		this.listaFGrupoDominios = listaFGrupoDominios;
	}

	public List<FDirectoryCreacionUsuario> getListaFDirectoryCreacionUsuario() {
		return listaFDirectoryCreacionUsuario;
	}

	public void setListaFDirectoryCreacionUsuario(List<FDirectoryCreacionUsuario> listaFDirectoryCreacionUsuario) {
		this.listaFDirectoryCreacionUsuario = listaFDirectoryCreacionUsuario;
	}

	@Override
	public String toString() {
		return "\n FSeccionConfiguracionGeneral [idSeccionConfiguracionGeneral=" + idSeccionConfiguracionGeneral
				+ ", nombreSeccionConfiguracionGeneral=" + nombreSeccionConfiguracionGeneral + ", palabras=" + palabras
				+ ", listaFGrupoDominios=" + listaFGrupoDominios + ", listaFDirectoryCreacionUsuario="
				+ listaFDirectoryCreacionUsuario + "]";
	}
	
}
