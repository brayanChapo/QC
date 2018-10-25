package pe.qc.com.validator.presentacion.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pe.qc.com.validator.negocio.servicio.NArchivoRutas;
import pe.qc.com.validator.negocio.servicio.NUnidades;
import pe.qc.com.validator.negocio.servicio.NUsuarioAIX;
import pe.qc.com.validator.presentacion.form.formSeccion.FSeccionConfiguracion;
import pe.qc.com.validator.util.Constantes;

public class FDatosConfiguracion implements Serializable {
	private static final long serialVersionUID = 1L;

	private int cantTot;
	private int cantVal;
	private int cantValCor;
	private int cantValInc;
	private List<String> listaServidorProd;
	private List<String> listaServidorCert;
	private List<FConfiguracionServidor> listaConfiguracionServidor;
	private List<FValidacion> listaValidacion;
	private List<FValidacion> listaValidacion2;
	private FValidacion fValidacion;
	private List<Boolean> listaBoolean;
	private List<Boolean> listaCasos;
	private List<String> listaRutasClearCase;
	private FValidacionSubSeccion fValidacionSubSeccion;
	private FValidacionSubSeccionWindows fValidacionSubSeccionWindows;
	private FSeccionConfiguracion fSeccionConfiguracion;
	private List<FSeccionConfiguracion> listaSeccionConfiguracion;
	@Autowired
	private NUnidades nUnidades;
	@Autowired
	private NUsuarioAIX nUsuarioAIX;
	@Autowired
	private NArchivoRutas nArchivoRutas;

	public FDatosConfiguracion() {
		listaValidacion = new ArrayList<>();
		listaBoolean = new ArrayList<>();
		listaCasos = new ArrayList<>();
	}
	
	public FDatosConfiguracion(NUnidades nUnidades, NUsuarioAIX nUsuarioAIX, NArchivoRutas nArchivoRutas) {
		this.nUnidades = nUnidades;
		this.nUsuarioAIX = nUsuarioAIX;
		this.nArchivoRutas = nArchivoRutas;
		listaValidacion = new ArrayList<>();
		listaBoolean = new ArrayList<>();
		listaCasos = new ArrayList<>();
	}
	
	public void setnUnidades(NUnidades nUnidades) {
		this.nUnidades = nUnidades;
	}
	
	public void setnUsuarioAIX(NUsuarioAIX nUsuarioAIX) {
		this.nUsuarioAIX = nUsuarioAIX;
	}
	
	public void setnArchivoRutas(NArchivoRutas nArchivoRutas) {
		this.nArchivoRutas = nArchivoRutas;
	}

	public void extraerLista(List<FConfiguracionServidor> listaFConfiguracionServidor, List<String> listaProd,
			List<String> listaCert) {
		listaConfiguracionServidor = new ArrayList<>();
		listaServidorCert = new ArrayList<>();
		listaServidorProd = new ArrayList<>();
		for (FConfiguracionServidor fConfiguracionServidor : listaFConfiguracionServidor) {
			listaConfiguracionServidor.add(fConfiguracionServidor);
		}

		for (int y = 0; y < listaCert.size(); y++) {
			listaServidorCert.add(listaCert.get(y));
		}

		for (int z = 0; z < listaProd.size(); z++) {
			listaServidorProd.add(listaProd.get(z));
		}
	}

	/* validacion de Servidores presentados en el punto de */
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
		for (FConfiguracionServidor fConfiguracionServidor : listaConfiguracionServidor) {
			for (int i = 0; i < fConfiguracionServidor.getListaServidor().size(); i++) {
				listaServidores.add(fConfiguracionServidor.getListaServidor().get(i));
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
		listaValidacion.add(fValidacion);
		listaBoolean.add(true);
	}

	/* validacion de subtareas en el punto de configuracion por servidor */
	public void validarSubTareas() {
		fValidacion = new FValidacion();
		int c = 0;
		String validacion = "Validación de Subtareas listadas";
		String estado = "";
		String comentario = "";

		for (FConfiguracionServidor fConfiguracionServidor : listaConfiguracionServidor) {
			for (FSeccion fSeccion : fConfiguracionServidor.getListaSeccion()) {
				for (FSubSeccion fSubSeccion : fSeccion.getListaSubseccion()) {
					if (fSubSeccion.getSubtarea().equals("")) {
						String valor = fSubSeccion.getIdSubseccion().intern() + " ";
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
			comentario = comentario + " subtareas se encuentran vacias";
		}

		fValidacion.setValidacion(validacion);
		fValidacion.setEstado(estado);
		fValidacion.setComentario(comentario);
		listaValidacion.add(fValidacion);
		listaBoolean.add(true);

	}

	/* validacion de tareas en el punto de configuracion por servidor */
	public void validarTareas() {
		fValidacion = new FValidacion();
		int c = 0;
		String validacion = "Validación de tareas listadas";
		String estado = "";
		String comentario = "";

		for (FConfiguracionServidor fConfiguracionServidor : listaConfiguracionServidor) {
			for (FSeccion fSeccion : fConfiguracionServidor.getListaSeccion()) {
				for (FSubSeccion fSubSeccion : fSeccion.getListaSubseccion()) {
					if (fSubSeccion.getTarea().equals("")) {
						String valor = fSubSeccion.getIdSubseccion().intern() + " / ";
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
		listaValidacion.add(fValidacion);
		listaBoolean.add(true);

	}

	/* validacion de Secciones en el punto de configuracion por servidor */
	public void validarSecciones() {
		fValidacion = new FValidacion();
		int c = 0;
		String validacion = "Validación de Secciones listadas";
		String estado = "";
		String comentario = "";

		for (FConfiguracionServidor fConfiguracionServidor : listaConfiguracionServidor) {
			for (FSeccion fSeccion : fConfiguracionServidor.getListaSeccion()) {
				if (fSeccion.getSeccion().equals("")) {
					String valor = fSeccion.getIdSeccion().intern() + " ";
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
		listaValidacion.add(fValidacion);
		listaBoolean.add(true);

	}
	/*Validar Unidad C*/
	public void validarUnidadC() {
		fValidacion = new FValidacion();
		int c = 0;
		String validacion = "Validación de la Unidad C:\\";
		String estado = "";
		String comentario = "";

		for (FConfiguracionServidor fConfiguracionServidor : listaConfiguracionServidor) {
			for (FSeccion fSeccion : fConfiguracionServidor.getListaSeccion()) {
				for (FSubSeccion fSubSeccion : fSeccion.getListaSubseccion()) {
					for (String string : fSubSeccion.getPalabras()) {
						if (string.contains("c:") || string.contains("C:")) {
							String valor = fSubSeccion.getIdSubseccion().intern() + " ";
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
		listaValidacion.add(fValidacion);
		listaBoolean.add(true);
	}
	/*Palabra Clave Validar*/
	public void validarPalabraValidar() {
		fValidacion = new FValidacion();
		int c = 0;
		String validacion = "Validación de palabras clave: Validar";
		String estado = "";
		String comentario = "";

		for (FConfiguracionServidor fConfiguracionServidor : listaConfiguracionServidor) {
			for (FSeccion fSeccion : fConfiguracionServidor.getListaSeccion()) {
				for (FSubSeccion fSubSeccion : fSeccion.getListaSubseccion()) {
					for (String string : fSubSeccion.getPalabras()) {
						if (string.trim().contains("validar") || string.trim().contains("Validar")) {
							String valor = fSubSeccion.getIdSubseccion().intern() + " ";
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
		listaValidacion.add(fValidacion);
		listaBoolean.add(true);
	}
	
	/*palabra Clava Verificar*/
	public void validarPalabraVerificar() {
		fValidacion = new FValidacion();
		int c = 0;
		String validacion = "Validación de palabras clave: Verificar";
		String estado = "";
		String comentario = "";

		for (FConfiguracionServidor fConfiguracionServidor : listaConfiguracionServidor) {
			for (FSeccion fSeccion : fConfiguracionServidor.getListaSeccion()) {
				for (FSubSeccion fSubSeccion : fSeccion.getListaSubseccion()) {
					for (String string : fSubSeccion.getPalabras()) {
						if (string.contains("verificar") || string.contains("Verificar")) {
							String valor = fSubSeccion.getIdSubseccion().intern() + " ";
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
		listaValidacion.add(fValidacion);
		listaBoolean.add(true);
	}
	
	/*Palabra Clave SOLO PRODUCCION*/
	public void validarPalabraSoloProduccion() {
		fValidacion = new FValidacion();
		int c = 0;
		String validacion = "Validación de palabras clave: Solo Produccion";
		String estado = "";
		String comentario = "";

		for (FConfiguracionServidor fConfiguracionServidor : listaConfiguracionServidor) {
			for (FSeccion fSeccion : fConfiguracionServidor.getListaSeccion()) {
				for (FSubSeccion fSubSeccion : fSeccion.getListaSubseccion()) {
					for (String string : fSubSeccion.getPalabras()) {
						if (string.equalsIgnoreCase("solo produccion")) {
							String valor = fSubSeccion.getIdSubseccion().intern() + " ";
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
		listaValidacion.add(fValidacion);
		listaBoolean.add(true);
	}
	
	public void generarRutasCc(List<String> listaRutas) {
		listaRutasClearCase = new ArrayList<>();
		for (String string : listaRutas) {
			listaRutasClearCase.add(string);
		}
	}
	
	/*Metodo para generar las rutas del ClearCase*/
//	public void generarRutasClearCase(String vob, String tk, String matricula) {
//		listaRutasClearCase = new ArrayList<>();
//		if (vob.isEmpty() || tk.isEmpty()) {
//			System.out.println("Vacio");
//		}
//		String linea = null;
//		try {
//			Process p = Runtime.getRuntime().exec("cleartool find -all -version \"{lbtype_sub("+tk+")}\" -print", null,
//		            new File("M:\\"+matricula+"_TK_cons_dv" + File.separator + vob));
//		            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
//			while ((linea = in.readLine()) != null) {
//				listaRutasClearCase.add((linea.split("@@")[0]).split("_dv")[1].substring(1));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	/*Metodo para listar las subsecciones*/
	public void listarSubSecciones() {
		fSeccionConfiguracion = new FSeccionConfiguracion();
		listaSeccionConfiguracion = new ArrayList<>();
		for (FConfiguracionServidor fConfiguracionServidor : listaConfiguracionServidor) {
			for (FSeccion fSeccion : fConfiguracionServidor.getListaSeccion()) {
				for (FSubSeccion fSubSeccion : fSeccion.getListaSubseccion()) {
					fSeccionConfiguracion.setIdSubSeccion(fSubSeccion.getIdSubseccion());
					fSeccionConfiguracion.setTarea(fSubSeccion.getTarea());
					fSeccionConfiguracion.setSubTarea(fSubSeccion.getSubtarea());
					listaSeccionConfiguracion.add(fSeccionConfiguracion);
					fSeccionConfiguracion = new FSeccionConfiguracion();
				}
			}
		}
	}
	
	public void validarCuerpoConfiguracionMIS(String tipo) {
		listaValidacion2 = new ArrayList<>();
		if(tipo.contains("AIX")) {
			System.out.println("Holi");
			fValidacionSubSeccion = new FValidacionSubSeccion(nUsuarioAIX, nArchivoRutas);
			for (FConfiguracionServidor fConfiguracionServidor : listaConfiguracionServidor) {
				for (FSeccion fSeccion : fConfiguracionServidor.getListaSeccion()) {
					for (FSubSeccion fSubSeccion : fSeccion.getListaSubseccion()) {
						fValidacionSubSeccion.validarSubSeccion(fSubSeccion.getIdSubseccion() ,fSubSeccion.getPalabras(), fSeccion.getSeccion(), fSubSeccion.getTarea(), fSubSeccion.getSubtarea(), listaRutasClearCase,
								listaServidorProd, listaServidorCert, fSubSeccion.getListasSubTabla(), fConfiguracionServidor.getListaServidor());
					}
				}
			}
			for (FValidacion fValidacion4 : fValidacionSubSeccion.getListaValidacion()) {
				listaValidacion2.add(fValidacion4);
			}
		}else {
			System.out.println("Holi2");
			fValidacionSubSeccionWindows = new FValidacionSubSeccionWindows(nUnidades, nUsuarioAIX ,nArchivoRutas);
			for (FConfiguracionServidor fConfiguracionServidor : listaConfiguracionServidor) {
				for (FSeccion fSeccion : fConfiguracionServidor.getListaSeccion()) {
					for (FSubSeccion fSubSeccion : fSeccion.getListaSubseccion()) {
						fValidacionSubSeccionWindows.validarSubSeccion(fSubSeccion.getIdSubseccion() ,fSubSeccion.getPalabras(), fSeccion.getSeccion(), fSubSeccion.getTarea(), fSubSeccion.getSubtarea(), listaRutasClearCase,
								listaServidorProd, listaServidorCert, fSubSeccion.getListasSubTabla(), fConfiguracionServidor.getListaServidor());
					}
				}
			}
			for (FValidacion fValidacion4 : fValidacionSubSeccionWindows.getListaValidacion()) {
				listaValidacion2.add(fValidacion4);
			}
		}
		
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

	public List<FConfiguracionServidor> getListaConfiguracionServidor() {
		return listaConfiguracionServidor;
	}

	public void setListaConfiguracionServidor(List<FConfiguracionServidor> listaConfiguracionServidor) {
		this.listaConfiguracionServidor = listaConfiguracionServidor;
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

	public FValidacionSubSeccion getfValidacionSubSeccion() {
		return fValidacionSubSeccion;
	}

	public void setfValidacionSubSeccion(FValidacionSubSeccion fValidacionSubSeccion) {
		this.fValidacionSubSeccion = fValidacionSubSeccion;
	}

	public List<FValidacion> getListaValidacion2() {
		return listaValidacion2;
	}

	public void setListaValidacion2(List<FValidacion> listaValidacion2) {
		this.listaValidacion2 = listaValidacion2;
	}

	public List<Boolean> getListaBoolean() {
		return listaBoolean;
	}

	public void setListaBoolean(List<Boolean> listaBoolean) {
		this.listaBoolean = listaBoolean;
	}

	public List<Boolean> getListaCasos() {
		return listaCasos;
	}

	public void setListaCasos(List<Boolean> listaCasos) {
		this.listaCasos = listaCasos;
	}

	public List<String> getListaRutasClearCase() {
		return listaRutasClearCase;
	}

	public void setListaRutasClearCase(List<String> listaRutasClearCase) {
		this.listaRutasClearCase = listaRutasClearCase;
	}

	public FSeccionConfiguracion getfSeccionConfiguracion() {
		return fSeccionConfiguracion;
	}

	public void setfSeccionConfiguracion(FSeccionConfiguracion fSeccionConfiguracion) {
		this.fSeccionConfiguracion = fSeccionConfiguracion;
	}

	public List<FSeccionConfiguracion> getListaSeccionConfiguracion() {
		return listaSeccionConfiguracion;
	}

	public void setListaSeccionConfiguracion(List<FSeccionConfiguracion> listaSeccionConfiguracion) {
		this.listaSeccionConfiguracion = listaSeccionConfiguracion;
	}

	public FValidacionSubSeccionWindows getfValidacionSubSeccionWindows() {
		return fValidacionSubSeccionWindows;
	}

	public void setfValidacionSubSeccionWindows(FValidacionSubSeccionWindows fValidacionSubSeccionWindows) {
		this.fValidacionSubSeccionWindows = fValidacionSubSeccionWindows;
	}
	
}
