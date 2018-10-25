package pe.qc.com.validator.negocio.bo;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import pe.qc.com.validator.util.ArchivoUtil;

public class BOTarea implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer idTarea;
	private Integer idUsuarioTarea;
	private Integer idEquipoTarea;
	private Integer idTipoTarea;
	private Integer idEtapaTarea;
	private Integer idSolicitudTarea;
	private String nombreTarea;
	private String crqTarea;
	private String descripcionTarea;
	private byte[] archivoTarea;
	private String nombreArchivo;
	private UploadedFile archivoUpTarea;
	private StreamedContent archivoTareaStreamed;
	private Date fechaTarea;
	private String woTarea;
	
	private List<SelectItem> listaTipoTarea;
	private List<SelectItem> listaEtapa;
	private List<SelectItem> listaEquipo;
	
	private Boolean mostrarCampos;
	private Boolean mostrarEtapa;
	private Boolean mostrarEquipo;
	private Boolean mostrarBoton;
	private Boolean mostrarMensaje;
	
	public BOTarea() {
		
	}
	
	/**
	 * @param lista
	 * lleno el atributo listaTipoTarea (List<SelectItem>) con datos
	 * para eso los datos se transforma de List<BOTipoTarea> a List<SelectItem>
	 */
	public void obtenerSelectItemsTipoTarea(List<BOTipoTarea> lista) {
		if (lista != null && lista.size() > 0) {
			listaTipoTarea = new ArrayList<SelectItem>();
			for (BOTipoTarea boTipoTarea : lista) {
				SelectItem item = new SelectItem();
				item.setLabel(boTipoTarea.getNombreTipoTarea());
				item.setValue(boTipoTarea.getIdTipoTarea());
				listaTipoTarea.add(item);
			}
		}
	}
	
	/**
	 * @param lista
	 * lleno el atributo listaEtapa (List<SelectItem>) con datos
	 * para eso los datos se transforma de List<BOEtapa> a List<SelectItem>
	 */
	public void obtenerSelectItemsEtapa(List<BOEtapa> lista) {
		if (lista != null && lista.size() > 0) {
			listaEtapa = new ArrayList<SelectItem>();
			for (BOEtapa boEtapa : lista) {
				SelectItem item = new SelectItem();
				item.setLabel(boEtapa.getNombreEtapa());
				item.setValue(boEtapa.getIdEtapa());
				listaEtapa.add(item);
			}
		}
	}
	
	/**
	 * @param lista
	 * lleno el atributo listaEquipo (List<SelectItem>) con datos
	 * para eso los datos se transforma de List<BOEquipo> a List<SelectItem>
	 */
	public void obtenerSelectItemsEquipo(List<BOEquipo> lista) {
		if (lista != null && lista.size() > 0) {
			listaEquipo = new ArrayList<SelectItem>();
			for (BOEquipo boEquipo : lista) {
				SelectItem item = new SelectItem();
				item.setLabel(boEquipo.getNombreEquipo());
				item.setValue(boEquipo.getIdEquipo());
				listaEquipo.add(item);
			}
		}
	}
	
	public void cargarDocumento(FileUploadEvent event) {
		archivoUpTarea = event.getFile();
		nombreArchivo = ArchivoUtil.obtenerNombreDeArchivo(archivoUpTarea.getFileName());
		try {
			archivoTareaStreamed = new DefaultStreamedContent(archivoUpTarea.getInputstream());
			System.out.println("Archivo Cargado con exito" + nombreArchivo);
		} catch (IOException e) {
			archivoTareaStreamed = null;
		}
	}

	public Integer getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(Integer idTarea) {
		this.idTarea = idTarea;
	}

	public Integer getIdEquipoTarea() {
		return idEquipoTarea;
	}

	public void setIdEquipoTarea(Integer idEquipoTarea) {
		this.idEquipoTarea = idEquipoTarea;
	}

	public Integer getIdTipoTarea() {
		return idTipoTarea;
	}

	public void setIdTipoTarea(Integer idTipoTarea) {
		this.idTipoTarea = idTipoTarea;
	}

	public Integer getIdEtapaTarea() {
		return idEtapaTarea;
	}

	public void setIdEtapaTarea(Integer idEtapaTarea) {
		this.idEtapaTarea = idEtapaTarea;
	}

	public Integer getIdSolicitudTarea() {
		return idSolicitudTarea;
	}

	public void setIdSolicitudTarea(Integer idSolicitudTarea) {
		this.idSolicitudTarea = idSolicitudTarea;
	}

	public String getNombreTarea() {
		return nombreTarea;
	}

	public void setNombreTarea(String nombreTarea) {
		this.nombreTarea = nombreTarea;
	}

	public String getCrqTarea() {
		return crqTarea;
	}

	public void setCrqTarea(String crqTarea) {
		this.crqTarea = crqTarea;
	}

	public String getDescripcionTarea() {
		return descripcionTarea;
	}

	public void setDescripcionTarea(String descripcionTarea) {
		this.descripcionTarea = descripcionTarea;
	}

	public byte[] getArchivoTarea() {
		return archivoTarea;
	}

	public void setArchivoTarea(byte[] archivoTarea) {
		this.archivoTarea = archivoTarea;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public UploadedFile getArchivoUpTarea() {
		return archivoUpTarea;
	}

	public void setArchivoUpTarea(UploadedFile archivoUpTarea) {
		this.archivoUpTarea = archivoUpTarea;
	}

	public StreamedContent getArchivoTareaStreamed() {
		return archivoTareaStreamed;
	}

	public void setArchivoTareaStreamed(StreamedContent archivoTareaStreamed) {
		this.archivoTareaStreamed = archivoTareaStreamed;
	}
	
	public Date getFechaTarea() {
		return fechaTarea;
	}

	public void setFechaTarea(Date fechaTarea) {
		this.fechaTarea = fechaTarea;
	}
	
	public Integer getIdUsuarioTarea() {
		return idUsuarioTarea;
	}

	public void setIdUsuarioTarea(Integer idUsuarioTarea) {
		this.idUsuarioTarea = idUsuarioTarea;
	}

	public List<SelectItem> getListaTipoTarea() {
		return listaTipoTarea;
	}

	public void setListaTipoTarea(List<SelectItem> listaTipoTarea) {
		this.listaTipoTarea = listaTipoTarea;
	}
	
	public Boolean getMostrarCampos() {
		return mostrarCampos;
	}

	public void setMostrarCampos(Boolean mostrarCampos) {
		this.mostrarCampos = mostrarCampos;
	}
	
	public List<SelectItem> getListaEtapa() {
		return listaEtapa;
	}

	public void setListaEtapa(List<SelectItem> listaEtapa) {
		this.listaEtapa = listaEtapa;
	}

	public List<SelectItem> getListaEquipo() {
		return listaEquipo;
	}

	public void setListaEquipo(List<SelectItem> listaEquipo) {
		this.listaEquipo = listaEquipo;
	}

	public Boolean getMostrarEtapa() {
		return mostrarEtapa;
	}

	public void setMostrarEtapa(Boolean mostrarEtapa) {
		this.mostrarEtapa = mostrarEtapa;
	}

	public Boolean getMostrarEquipo() {
		return mostrarEquipo;
	}

	public void setMostrarEquipo(Boolean mostrarEquipo) {
		this.mostrarEquipo = mostrarEquipo;
	}

	public Boolean getMostrarBoton() {
		return mostrarBoton;
	}

	public void setMostrarBoton(Boolean mostrarBoton) {
		this.mostrarBoton = mostrarBoton;
	}

	public Boolean getMostrarMensaje() {
		return mostrarMensaje;
	}

	public void setMostrarMensaje(Boolean mostrarMensaje) {
		this.mostrarMensaje = mostrarMensaje;
	}

	public String getWoTarea() {
		return woTarea;
	}

	public void setWoTarea(String woTarea) {
		this.woTarea = woTarea;
	}

	@Override
	public String toString() {
		return "BOTarea [idTarea=" + idTarea + ", idUsuarioTarea=" + idUsuarioTarea + ", idEquipoTarea=" + idEquipoTarea
				+ ", idTipoTarea=" + idTipoTarea + ", idEtapaTarea=" + idEtapaTarea + ", idSolicitudTarea="
				+ idSolicitudTarea + ", nombreTarea=" + nombreTarea + ", crqTarea=" + crqTarea + ", descripcionTarea="
				+ descripcionTarea + ", archivoTarea=" + Arrays.toString(archivoTarea) + ", nombreArchivo="
				+ nombreArchivo + ", archivoUpTarea=" + archivoUpTarea + ", archivoTareaStreamed="
				+ archivoTareaStreamed + ", fechaTarea=" + fechaTarea + ", woTarea=" + woTarea + ", listaTipoTarea="
				+ listaTipoTarea + ", listaEtapa=" + listaEtapa + ", listaEquipo=" + listaEquipo + ", mostrarCampos="
				+ mostrarCampos + ", mostrarEtapa=" + mostrarEtapa + ", mostrarEquipo=" + mostrarEquipo
				+ ", mostrarBoton=" + mostrarBoton + ", mostrarMensaje=" + mostrarMensaje + "]";
	}

}
