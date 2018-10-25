package pe.qc.com.validator.presentacion.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pe.qc.com.validator.negocio.bo.BOSOServidor;
import pe.qc.com.validator.negocio.bo.BOServidor;
import pe.qc.com.validator.negocio.servicio.NSOServidor;
import pe.qc.com.validator.negocio.servicio.NServidor;
import pe.qc.com.validator.util.Constantes;

public class FDatosServidor implements Serializable {
	private static final long serialVersionUID = 1L;

	private String produccion;
	private String certificacion;
	private List<String> servidorCert;
	private List<String> servidorProd;
	private int cantTot;
	private int cantVal;
	private int cantValCor;
	private int cantValInc;
	private List<FValidacion> listaValidacion;
	private FValidacion fValidacion;
	private String tipo;
	
	@Autowired
	private NServidor nServidor;
	@Autowired
	private NSOServidor nSOServidor;
	
	public void setnServidor(NServidor nServidor) {
		this.nServidor = nServidor;
	}
	
	public void setnSOServidor(NSOServidor nSOServidor) {
		this.nSOServidor = nSOServidor;
	}

	public FDatosServidor() {
		servidorCert = new ArrayList<>();
		servidorProd = new ArrayList<>();
		listaValidacion = new ArrayList<>();
		cantTot = 0;
		cantVal = 0;
		cantValCor = 0;
		cantValInc = 0;
	}
	
	public FDatosServidor(NServidor nServidor, NSOServidor nSOServidor) {
		this.nServidor = nServidor;
		this.nSOServidor = nSOServidor;
		servidorCert = new ArrayList<>();
		servidorProd = new ArrayList<>();
		listaValidacion = new ArrayList<>();
		cantTot = 0;
		cantVal = 0;
		cantValCor = 0;
		cantValInc = 0;
	}

	public void completaInformacion() {
		for (int x = 0; x < servidorProd.size(); x++) {
			if (x == 0) {
				produccion = servidorProd.get(x).intern();
			}
			if (x > 0) {
				produccion = produccion + "\n" + servidorProd.get(x).intern();
			}
		}
		for (int j = 0; j < servidorCert.size(); j++) {
			if (j == 0) {
				certificacion = servidorCert.get(j).intern();
			}
			if (j > 0) {
				certificacion = certificacion + "\n" + servidorCert.get(j).intern();
			}
		}
	}

	public void validarHomomlogacion() {
		int a = servidorProd.size();
		int b = servidorCert.size();
		fValidacion = new FValidacion();
		cantVal = cantVal + 1;
		fValidacion.setValidacion(Constantes.HOMOLOGACION);
		if(a == b) {
			fValidacion.setEstado(Constantes.VALIDACION_OK);
			fValidacion.setComentario(Constantes.VALIDACION_OK);
			cantValCor = cantValCor + 1;
		}
		
		if(a > b) {
			fValidacion.setEstado(Constantes.VALIDACION_ERROR);
			int c = a-b;
			String s = "El cuadro de homologación presenta " + c + "servidor(es) vacios en certificación" ;
			fValidacion.setComentario(s);
			cantValInc = cantValInc + 1;
		}
		listaValidacion.add(fValidacion);
		
	}

	public void validarServidoresProduccion() {
		fValidacion = new FValidacion();
		String validacion = "Validacion de existencia de servidores en producción";
		String comentario = "";
		int  i= 0;
		for (String prod : servidorProd) {
			BOServidor boServidor = new BOServidor();
			boServidor = nServidor.obtenerServidor(prod);
			if(boServidor.getHostnameServidor().equalsIgnoreCase(prod) && boServidor.getEstadoCmdb()==1) {
				i = 0;
			}else {
				if(boServidor.getHostnameServidor().equalsIgnoreCase(prod)) {
					comentario = comentario + prod + "INACTIVO";
				}else {
					if(boServidor.getEstadoCmdb()==1) {
						comentario = comentario + prod + "No Existe";
					}
				}
				i=1;
			}
		}
		if(i==0) {
			fValidacion.setEstado(Constantes.VALIDACION_OK);
			fValidacion.setComentario(Constantes.VALIDACION_OK);
		}else {
			fValidacion.setEstado(Constantes.VALIDACION_ERROR);
			fValidacion.setComentario(comentario);
		}
		fValidacion.setValidacion(validacion);
		listaValidacion.add(fValidacion);
	}
	
	public void validarServidoresCertificacion() {
		fValidacion = new FValidacion();
		String validacion = "Validacion de existencia de servidores en certificación";
		String comentario = "";
		int  i= 0;
		for (String cert : servidorCert) {
			BOServidor boServidor = new BOServidor();
			boServidor = nServidor.obtenerServidor(cert);
			if(boServidor.getHostnameServidor().equalsIgnoreCase(cert) && boServidor.getEstadoCmdb()==1) {
				i = 0;
			}else {
				if(boServidor.getHostnameServidor().equalsIgnoreCase(cert)) {
					comentario = comentario + cert + "INACTIVO";
				}else {
					if(boServidor.getEstadoCmdb()==1) {
						comentario = comentario + cert + "No Existe";
					}
				}
				i=1;
			}
		}
		if(i==0) {
			fValidacion.setEstado(Constantes.VALIDACION_OK);
			fValidacion.setComentario(Constantes.VALIDACION_OK);
		}else {
			fValidacion.setEstado(Constantes.VALIDACION_ERROR);
			fValidacion.setComentario(comentario);
		}
		fValidacion.setValidacion(validacion);
		listaValidacion.add(fValidacion);
	}
	
	public void verTipo() {
		String nombreServidor = "";
		String nombreSOServidor= "";
		int j=1;
		int i=1;
		for (String servidor : servidorCert) {
			if(i==1) {
				nombreServidor = servidor;
			}
			i++;
		}
		List<BOSOServidor> boSOServidor = nSOServidor.listarSOServidor(nombreServidor);
		
		for (BOSOServidor bosoServidor2 : boSOServidor) {
			if(j==1) {
				nombreSOServidor = bosoServidor2.getTipoSO();
			}
			j++;
		}
		tipo = nombreSOServidor;
		
	}

	public List<String> getServidorCert() {
		return servidorCert;
	}

	public void setServidorCert(String servidorCert) {
		this.servidorCert.add(servidorCert);
	}

	public List<String> getServidorProd() {
		return servidorProd;
	}

	public void setServidorProd(String servidorProd) {
		this.servidorProd.add(servidorProd);
	}

	public String getProduccion() {
		return produccion;
	}

	public void setProduccion(String produccion) {
		this.produccion = produccion;
	}

	public String getCertificacion() {
		return certificacion;
	}

	public void setCertificacion(String certificacion) {
		this.certificacion = certificacion;
	}

	public int getCantTot() {
		return cantTot;
	}

	public void setCantTot(int cantTot) {
		this.cantTot = cantTot;
	}

	public int getCantVal() {
		return cantVal;
	}

	public void setCantVal(int cantVal) {
		this.cantVal = cantVal;
	}

	public int getCantValCor() {
		return cantValCor;
	}

	public void setCantValCor(int cantValCor) {
		this.cantValCor = cantValCor;
	}

	public int getCantValInc() {
		return cantValInc;
	}

	public void setCantValInc(int cantValInc) {
		this.cantValInc = cantValInc;
	}

	public List<FValidacion> getListaValidacion() {
		return listaValidacion;
	}

	public void setListaValidacion(List<FValidacion> listaValidacion) {
		this.listaValidacion = listaValidacion;
	}

	public FValidacion getfValidacion() {
		return fValidacion;
	}

	public void setfValidacion(FValidacion fValidacion) {
		this.fValidacion = fValidacion;
	}

	public void setServidorCert(List<String> servidorCert) {
		this.servidorCert = servidorCert;
	}

	public void setServidorProd(List<String> servidorProd) {
		this.servidorProd = servidorProd;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
