package pe.qc.com.validator.negocio.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

public class BOUsuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer idUsuario;
	private Integer idRol;
	private Integer idArea;
	private String nombreUsuario;
	private String apellidoUsuario;
	private String codigoUsuario;
	private String passUsuario;
	private char estadoUsuario;
	
	private List<SelectItem> listaroles;
	private List<SelectItem> listaAreas;
	
	public BOUsuario(){
		
	}
	
	/**
	 * @param lista
	 * lleno el atributo listaRoles (List<SelectItem>) con datos
	 * para eso los datos se transforma de List<BORol> a List<SelectItem>
	 */
	public void obtenerSelectItemsRol(List<BORol> lista) {
		if (lista != null && lista.size() > 0) {
			listaroles = new ArrayList<SelectItem>();
			for (BORol boRol : lista) {
				SelectItem item = new SelectItem();
				item.setLabel(boRol.getNombreRol());
				item.setValue(boRol.getIdRol());
				listaroles.add(item);
			}
		}
	}
	
	/**
	 * @param lista
	 * lleno el atributo listaAreas (List<SelectItem>) con datos
	 * para eso los datos se transforma de List<BOArea> a List<SelectItem>
	 */
	public void obtenerSelectItemsArea(List<BOArea> lista) {
		if (lista != null && lista.size() > 0) {
			listaAreas = new ArrayList<SelectItem>();
			for (BOArea boArea : lista) {
				SelectItem item = new SelectItem();
				item.setLabel(boArea.getNombreArea());
				item.setValue(boArea.getIdArea());
				listaAreas.add(item);
			}
		}
	}
	
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	
	public Integer getIdArea() {
		return idArea;
	}

	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidoUsuario() {
		return apellidoUsuario;
	}

	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getPassUsuario() {
		return passUsuario;
	}

	public void setPassUsuario(String passUsuario) {
		this.passUsuario = passUsuario;
	}

	public char getEstadoUsuario() {
		return estadoUsuario;
	}

	public void setEstadoUsuario(char estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}

	public List<SelectItem> getListaroles() {
		return listaroles;
	}

	public void setListaroles(List<SelectItem> listaroles) {
		this.listaroles = listaroles;
	}

	public List<SelectItem> getListaAreas() {
		return listaAreas;
	}

	public void setListaAreas(List<SelectItem> listaAreas) {
		this.listaAreas = listaAreas;
	}

	@Override
	public String toString() {
		return "BOUsuario [idUsuario=" + idUsuario + ", idRol=" + idRol + ", idArea=" + idArea + ", nombreUsuario="
				+ nombreUsuario + ", apellidoUsuario=" + apellidoUsuario + ", codigoUsuario=" + codigoUsuario
				+ ", passUsuario=" + passUsuario + ", estadoUsuario=" + estadoUsuario + "]";
	}
	
	
}
