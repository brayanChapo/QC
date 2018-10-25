package pe.qc.com.validator.negocio.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

public class BOAplicativo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idAplicativo;
	private Integer idVob;
	private Integer idDominio;
	private String nombreAplicativo;
	
	private List<SelectItem> listaVob;
	private List<SelectItem> listaDominio;
	
	public BOAplicativo() {

	}
	
	/**
	 * @param lista
	 * lleno el atributo listaVob (List<SelectItem>) con datos
	 * para eso los datos se transforma de List<BOVob> a List<SelectItem>
	 */
	public void obtenerSelectItemsVob(List<BOVob> lista) {
		if (lista != null && lista.size() > 0) {
			listaVob = new ArrayList<SelectItem>();
			for (BOVob boVob : lista) {
				SelectItem item = new SelectItem();
				item.setLabel(boVob.getNombreVob());
				item.setValue(boVob.getIdVob());
				listaVob.add(item);
			}
		}
	}
	
	/**
	 * @param lista
	 * lleno el atributo listaDominio (List<SelectItem>) con datos
	 * para eso los datos se transforma de List<BODominio> a List<SelectItem>
	 */
	public void obtenerSelectItemsDominio(List<BODominio> lista) {
		if (lista != null && lista.size() > 0) {
			listaDominio = new ArrayList<SelectItem>();
			for (BODominio boDominio : lista) {
				SelectItem item = new SelectItem();
				item.setLabel(boDominio.getNombreDominio());
				item.setValue(boDominio.getIdDominio());
				listaDominio.add(item);
			}
		}
	}

	public Integer getIdAplicativo() {
		return idAplicativo;
	}

	public void setIdAplicativo(Integer idAplicativo) {
		this.idAplicativo = idAplicativo;
	}

	public Integer getIdVob() {
		return idVob;
	}

	public void setIdVob(Integer idVob) {
		this.idVob = idVob;
	}

	public Integer getIdDominio() {
		return idDominio;
	}

	public void setIdDominio(Integer idDominio) {
		this.idDominio = idDominio;
	}

	public String getNombreAplicativo() {
		return nombreAplicativo;
	}

	public void setNombreAplicativo(String nombreAplicativo) {
		this.nombreAplicativo = nombreAplicativo;
	}

	@Override
	public String toString() {
		return "BOAplicativo [idAplicativo=" + idAplicativo + ", idVob=" + idVob + ", idDominio=" + idDominio
				+ ", nombreAplicativo=" + nombreAplicativo + "]";
	}

	public List<SelectItem> getListaVob() {
		return listaVob;
	}

	public void setListaVob(List<SelectItem> listaVob) {
		this.listaVob = listaVob;
	}

	public List<SelectItem> getListaDominio() {
		return listaDominio;
	}

	public void setListaDominio(List<SelectItem> listaDominio) {
		this.listaDominio = listaDominio;
	}

}
