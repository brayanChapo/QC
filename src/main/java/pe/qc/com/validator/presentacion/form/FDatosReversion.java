package pe.qc.com.validator.presentacion.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pe.qc.com.validator.presentacion.form.formReversion.FReversionServidor;
import pe.qc.com.validator.presentacion.form.formReversion.FSeccionReversion;
import pe.qc.com.validator.presentacion.form.formReversion.FSubSeccionReversion;
import pe.qc.com.validator.presentacion.form.formReversion.FValidacionSubSeccionReversion;
import pe.qc.com.validator.presentacion.form.formReversion.formSeccion.FSubSeccionReversionF;
import pe.qc.com.validator.util.Constantes;

public class FDatosReversion implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<String> listaServidorProd;
	private List<String> listaServidorCert;
	private List<FReversionServidor> listaReversionServidor;
	private List<FValidacion> listaValidacion1;
	private List<FValidacion> listaValidacion2;
	private FValidacion fValidacion;
	private List<String> listaClearCase;
	private FReversionServidor fReversionServidor;
	private FSubSeccionReversionF fSubSeccionReversionF;
	private List<FSubSeccionReversionF> listaFSubSeccionReversionF;
	private FValidacionSubSeccionReversion fValidacionSubSeccionReversion;
	
	
	public FDatosReversion() {
		listaValidacion1 = new ArrayList<>();
		listaValidacion2 = new ArrayList<>();
	}
	
	public void extraerListas(List<FReversionServidor> listaFReversionServidor , List<String> listasClearCase, List<String> listaProd, List<String> listaCert) {
		listaReversionServidor= new ArrayList<>();
		listaServidorCert = new ArrayList<>();
		listaServidorProd = new ArrayList<>();
		listaClearCase = new ArrayList<>();
		
		for (FReversionServidor fReversionServidor : listaFReversionServidor) {
			listaReversionServidor.add(fReversionServidor);
		}
		
		for (String Cc : listasClearCase) {
			listaClearCase.add(Cc);
		}
		
		for (int y = 0; y < listaCert.size(); y++) {
			listaServidorCert.add(listaCert.get(y));
		}

		for (int z = 0; z < listaProd.size(); z++) {
			listaServidorProd.add(listaProd.get(z));
		}
	}
	
	/* validacion de Servidores presentados en el punto de Reversion*/
	public void validarServidores() {
		fValidacion = new FValidacion();
		List<String> listaServidores = new ArrayList<>();
		int c;
		int p;
		String validacion = "Validación de Servidores listados";
		String estado = "";
		String comentario = "";
		p = 0;
		c = 0;
		for (FReversionServidor fReversionServidor : listaReversionServidor) {
			for (int i = 0; i < fReversionServidor.getListaServidor().size(); i++) {
				listaServidores.add(fReversionServidor.getListaServidor().get(i));
			}
		}
		for (String servidorProd : listaServidorProd) {
			c=0;
			for (String servidor : listaServidores) {
				if (servidor.contains(servidorProd)) {
					c = 1;
				}
			}
			if (c == 0) {
				comentario = comentario + servidorProd + " ";
				p = 1;
			}
		}
		if (p == 0) {
			estado = Constantes.VALIDACION_OK;
			comentario = Constantes.VALIDACION_OK;
		} else {
			estado = Constantes.VALIDACION_ERROR;
			comentario = comentario + "no listados en cuadro de homologacion, adjuntar correo de AIO PreProducción";
		}
		fValidacion.setComentario(comentario);
		fValidacion.setEstado(estado);
		fValidacion.setValidacion(validacion);
		listaValidacion1.add(fValidacion);
	}
	
	/* validacion de tareas en el punto de Reversion por servidor */
	public void validarTareas() {
		fValidacion = new FValidacion();
		int c = 0;
		String validacion = "Validación de Tareas listadas";
		String estado = "";
		String comentario = "";
		
		for (FReversionServidor fReversionServidor : listaReversionServidor) {
			for (FSeccionReversion fSeccionReversion : fReversionServidor.getListaSeccion()) {
				for (FSubSeccionReversion fSubSeccionReversion : fSeccionReversion.getListaSubseccion()) {
					if (fSubSeccionReversion.getTarea().equals("")) {
						String valor = fSubSeccionReversion.getIdSubseccionReversion().intern() + " ";
						comentario = comentario + valor;
						c = 1;
					}
				}
			}	
		}
		if (c == 0) {
			estado = Constantes.VALIDACION_OK;
			comentario = Constantes.VALIDACION_OK;
		} else {
			estado = Constantes.VALIDACION_ERROR;
			comentario = comentario + " tareas se encuentran vacias";
		}

		fValidacion.setValidacion(validacion);
		fValidacion.setEstado(estado);
		fValidacion.setComentario(comentario);
		listaValidacion1.add(fValidacion);
	}
	
	/* validacion de Secciones en el punto de reversion por servidor */
	public void validarSecciones() {
		fValidacion = new FValidacion();
		int c = 0;
		String validacion = "Validación de Secciones listadas";
		String estado = "";
		String comentario = "";
		for (FReversionServidor fReversionServidor : listaReversionServidor) {
			for (FSeccionReversion fSeccionReversion : fReversionServidor.getListaSeccion()) {
				if (fSeccionReversion.getSeccion().equals("")) {
					String valor = fSeccionReversion.getIdSeccionReversion().intern() + " ";
					comentario = comentario + valor;
					c = 1;
				}
			}
		}
		if (c == 0) {
			estado = Constantes.VALIDACION_OK;
			comentario = Constantes.VALIDACION_OK;
		} else {
			estado = Constantes.VALIDACION_ERROR;
			comentario = comentario + " secciones se encuentran vacias";
		}

		fValidacion.setValidacion(validacion);
		fValidacion.setEstado(estado);
		fValidacion.setComentario(comentario);
		listaValidacion1.add(fValidacion);
	}
	
	/*Validar Unidad C*/
	public void validarUnidadC() {
		fValidacion = new FValidacion();
		int c = 0;
		String validacion = "Validación de la Unidad C:\\";
		String estado = "";
		String comentario = "";
		for (FReversionServidor fReversionServidor : listaReversionServidor) {
			for (FSeccionReversion fSeccionReversion : fReversionServidor.getListaSeccion()) {
				for (FSubSeccionReversion fSubSeccionReversion : fSeccionReversion.getListaSubseccion()) {
					for (String string : fSubSeccionReversion.getPalabras()) {
						if (string.contains("c:") || string.contains("C:")) {
							String valor = fSubSeccionReversion.getIdSubseccionReversion().intern() + " ";
							comentario = comentario + valor;
							c = 1;
						}
					}
				}
			}
		}
		if (c == 0) {
			estado = Constantes.VALIDACION_OK;
			comentario = Constantes.VALIDACION_OK;
		} else {
			estado = Constantes.VALIDACION_ERROR;
			comentario = comentario + " presentan ejecución en la unidad C";
		}

		fValidacion.setValidacion(validacion);
		fValidacion.setEstado(estado);
		fValidacion.setComentario(comentario);
		listaValidacion1.add(fValidacion);
	}
	
	/*Palabra Clave Validar*/
	public void validarPalabraValidar() {
		fValidacion = new FValidacion();
		int c = 0;
		String validacion = "Validación de palabras clave: Validar";
		String estado = "";
		String comentario = "";

		for (FReversionServidor fReversionServidor : listaReversionServidor) {
			for (FSeccionReversion fSeccionReversion : fReversionServidor.getListaSeccion()) {
				for (FSubSeccionReversion fSubSeccionReversion : fSeccionReversion.getListaSubseccion()) {
					for (String string : fSubSeccionReversion.getPalabras()) {
						if (string.trim().contains("validar") || string.trim().contains("Validar")) {
							String valor = fSubSeccionReversion.getIdSubseccionReversion().intern() + " ";
							comentario = comentario + valor;
							c = 1;
						}
					}
				}
			}
		}
		if (c == 0) {
			estado = Constantes.VALIDACION_OK;
			comentario = Constantes.VALIDACION_OK;
		} else {
			estado = Constantes.VALIDACION_ERROR;
			comentario = comentario + " presentan la palabra validar";
		}

		fValidacion.setValidacion(validacion);
		fValidacion.setEstado(estado);
		fValidacion.setComentario(comentario);
		listaValidacion1.add(fValidacion);
	}
	
	/*palabra Clava Verificar*/
	public void validarPalabraVerificar() {
		fValidacion = new FValidacion();
		int c = 0;
		String validacion = "Validación de palabras clave: Verificar";
		String estado = "";
		String comentario = "";

		for (FReversionServidor fReversionServidor : listaReversionServidor) {
			for (FSeccionReversion fSeccionReversion : fReversionServidor.getListaSeccion()) {
				for (FSubSeccionReversion fSubSeccionReversion : fSeccionReversion.getListaSubseccion()) {
					for (String string : fSubSeccionReversion.getPalabras()) {
						if (string.trim().contains("verificar") || string.trim().contains("Verificar")) {
							String valor = fSubSeccionReversion.getIdSubseccionReversion().intern() + " ";
							comentario = comentario + valor;
							c = 1;
						}
					}
				}
			}
		}
		if (c == 0) {
			estado = Constantes.VALIDACION_OK;
			comentario = Constantes.VALIDACION_OK;
		} else {
			estado = Constantes.VALIDACION_ERROR;
			comentario = comentario + " presentan la palabra verificar";
		}

		fValidacion.setValidacion(validacion);
		fValidacion.setEstado(estado);
		fValidacion.setComentario(comentario);
		listaValidacion1.add(fValidacion);
	}
	
	/*Palabra Clave SOLO PRODUCCION*/
	public void validarPalabraSoloProduccion() {
		fValidacion = new FValidacion();
		int c = 0;
		String validacion = "Validación de palabras clave: Solo Produccion";
		String estado = "";
		String comentario = "";

		for (FReversionServidor fReversionServidor : listaReversionServidor) {
			for (FSeccionReversion fSeccionReversion : fReversionServidor.getListaSeccion()) {
				for (FSubSeccionReversion fSubSeccionReversion : fSeccionReversion.getListaSubseccion()) {
					for (String string : fSubSeccionReversion.getPalabras()) {
						if (string.trim().equalsIgnoreCase("solo produccion")) {
							String valor = fSubSeccionReversion.getIdSubseccionReversion().intern() + " ";
							comentario = comentario + valor;
							c = 1;
						}
					}
				}
			}
		}
		if (c == 0) {
			estado = Constantes.VALIDACION_OK;
			comentario = Constantes.VALIDACION_OK;
		} else {
			estado = Constantes.VALIDACION_ERROR;
			comentario = comentario + " presentan puntos a ejecutar solo en produccion, adjuntar conformidad AIO";
		}

		fValidacion.setValidacion(validacion);
		fValidacion.setEstado(estado);
		fValidacion.setComentario(comentario);
		listaValidacion1.add(fValidacion);
	}
	
	/*Metodo para listar las subsecciones*/
	public void listarSubSecciones() {
		fSubSeccionReversionF = new FSubSeccionReversionF();
		listaFSubSeccionReversionF = new ArrayList<>();
		for (FReversionServidor fReversionServidor : listaReversionServidor) {
			for (FSeccionReversion fSeccionReversion : fReversionServidor.getListaSeccion()) {
				for (FSubSeccionReversion fSubSeccionReversion : fSeccionReversion.getListaSubseccion()) {
					fSubSeccionReversionF.setIdSubSeccion(fSubSeccionReversion.getIdSubseccionReversion());
					fSubSeccionReversionF.setTarea(fSubSeccionReversion.getTarea());
					listaFSubSeccionReversionF.add(fSubSeccionReversionF);
					fSubSeccionReversionF = new FSubSeccionReversionF();
				}
			}
		}
	}
	
	public void validarCuerpoReversionMIS() {
		listaValidacion2 = new ArrayList<>();
		fValidacionSubSeccionReversion = new FValidacionSubSeccionReversion();
		for (FReversionServidor fReversionServidor1 : listaReversionServidor) {
			for (FSeccionReversion fSeccionReversion1 : fReversionServidor1.getListaSeccion()) {
				for (FSubSeccionReversion fSubSeccionReversion1 : fSeccionReversion1.getListaSubseccion()) {
					fValidacionSubSeccionReversion.validarEjecucionScipt(fSubSeccionReversion1.getIdSubseccionReversion(), fSubSeccionReversion1.getPalabras(), listaClearCase);
				}
			}
		}
		for (FValidacion fValidacion4 : fValidacionSubSeccionReversion.getListaValidacion()) {
			listaValidacion2.add(fValidacion4);
		}
	}

	public List<String> getListaServidorProd() {
		return listaServidorProd;
	}

	public void setListaServidorProd(List<String> listaServidorProd) {
		this.listaServidorProd = listaServidorProd;
	}

	public List<String> getListaServidorCert() {
		return listaServidorCert;
	}

	public void setListaServidorCert(List<String> listaServidorCert) {
		this.listaServidorCert = listaServidorCert;
	}

	public List<FReversionServidor> getListaReversionServidor() {
		return listaReversionServidor;
	}

	public void setListaReversionServidor(List<FReversionServidor> listaReversionServidor) {
		this.listaReversionServidor = listaReversionServidor;
	}

	public List<FValidacion> getListaValidacion1() {
		return listaValidacion1;
	}

	public void setListaValidacion1(List<FValidacion> listaValidacion1) {
		this.listaValidacion1 = listaValidacion1;
	}

	public List<FValidacion> getListaValidacion2() {
		return listaValidacion2;
	}

	public void setListaValidacion2(List<FValidacion> listaValidacion2) {
		this.listaValidacion2 = listaValidacion2;
	}

	public FValidacion getfValidacion() {
		return fValidacion;
	}

	public void setfValidacion(FValidacion fValidacion) {
		this.fValidacion = fValidacion;
	}

	public List<String> getListaClearCase() {
		return listaClearCase;
	}

	public void setListaClearCase(List<String> listaClearCase) {
		this.listaClearCase = listaClearCase;
	}

	public FReversionServidor getfReversionServidor() {
		return fReversionServidor;
	}

	public void setfReversionServidor(FReversionServidor fReversionServidor) {
		this.fReversionServidor = fReversionServidor;
	}

	public FSubSeccionReversionF getfSubSeccionReversionF() {
		return fSubSeccionReversionF;
	}

	public void setfSubSeccionReversionF(FSubSeccionReversionF fSubSeccionReversionF) {
		this.fSubSeccionReversionF = fSubSeccionReversionF;
	}

	public List<FSubSeccionReversionF> getListaFSubSeccionReversionF() {
		return listaFSubSeccionReversionF;
	}

	public void setListaFSubSeccionReversionF(List<FSubSeccionReversionF> listaFSubSeccionReversionF) {
		this.listaFSubSeccionReversionF = listaFSubSeccionReversionF;
	}

	public FValidacionSubSeccionReversion getfValidacionSubSeccionReversion() {
		return fValidacionSubSeccionReversion;
	}

	public void setfValidacionSubSeccionReversion(FValidacionSubSeccionReversion fValidacionSubSeccionReversion) {
		this.fValidacionSubSeccionReversion = fValidacionSubSeccionReversion;
	}
	
}
