package pe.qc.com.validator.presentacion.form.formReversion;

import java.util.ArrayList;
import java.util.List;

import pe.qc.com.validator.presentacion.form.FValidacion;
import pe.qc.com.validator.presentacion.form.formReversion.formSeccion.FEjecucionScriptCcReversion;
import pe.qc.com.validator.util.Constantes;

public class FValidacionSubSeccionReversion {
	private FEjecucionScriptCcReversion fEjecucionScriptCcReversion;
	private FValidacion fValidacion;
	private List<FValidacion> listaValidacion;
	
	
	public FValidacionSubSeccionReversion() {
		listaValidacion = new ArrayList<>();
	}
	
	public void validarEjecucionScipt(String idSubseccion, List<String> palabra, List<String> listaClearCase) {
		fValidacion = new FValidacion();
		List<String> listaNOClearCase = new ArrayList<>();
		List<FEjecucionScriptCcReversion> listaFEjecucionScriptCcReversion = new ArrayList<>();
		fEjecucionScriptCcReversion = new FEjecucionScriptCcReversion();
		String palabras[] = new String [6];
		int f = 0;
		int i = 0;
		for (String string : palabra) {
			if(i!=0) {
				i++;
				palabras[i] = string;
			}
			if(string.equalsIgnoreCase("Ejecutar")) {
				i = 1;
				palabras[i] = string;
				f=1;
			}
			if(i==5) {
				fEjecucionScriptCcReversion.setAccion(palabras[1]);
				fEjecucionScriptCcReversion.setRuta(palabras[2]);
				fEjecucionScriptCcReversion.setArchivo(palabras[3]);
				fEjecucionScriptCcReversion.setDescripcion(palabras[4]);
				fEjecucionScriptCcReversion.setTk(palabras[5]);
				listaFEjecucionScriptCcReversion.add(fEjecucionScriptCcReversion);
				fEjecucionScriptCcReversion = new FEjecucionScriptCcReversion();
				i=0;
			}
		}
		if(f==1) {
			int p =0;
			int a = 0;
			String validacion = "Punto: " + idSubseccion +" Valicacion de Ejecución de Script Sql";
			String comentario = "";
			String estado = "";
			String nombre;
			for (FEjecucionScriptCcReversion fEjecucionScriptCcReversion : listaFEjecucionScriptCcReversion) {
				nombre = fEjecucionScriptCcReversion.getRuta().intern() + "\\" + fEjecucionScriptCcReversion.getArchivo().intern();
				p=0;
				for (String ClearCase : listaClearCase) {
					if(ClearCase.trim().equals(nombre.trim())) {
						p=1;
					}
				}
				if(p==0) {
					listaNOClearCase.add(nombre);
					a=1;
				}
			}
			if(a==0) {
				estado = Constantes.VALIDACION_OK;
				comentario = Constantes.VALIDACION_OK;
			}else {
				estado = Constantes.VALIDACION_ERROR;
				comentario = "Existen rutas no registrados en el ClearCase";
			}
			fValidacion.setValidacion(validacion);
			fValidacion.setEstado(estado);
			fValidacion.setComentario(comentario);
			fValidacion.setComentarioAdicional(listaNOClearCase);
			listaValidacion.add(fValidacion);
			f=0;
		}else {
			System.out.println("No hay que validar");
		}		
	}

	public FEjecucionScriptCcReversion getfEjecucionScriptCcReversion() {
		return fEjecucionScriptCcReversion;
	}

	public void setfEjecucionScriptCcReversion(FEjecucionScriptCcReversion fEjecucionScriptCcReversion) {
		this.fEjecucionScriptCcReversion = fEjecucionScriptCcReversion;
	}

	public FValidacion getfValidacion() {
		return fValidacion;
	}

	public void setfValidacion(FValidacion fValidacion) {
		this.fValidacion = fValidacion;
	}

	public List<FValidacion> getListaValidacion() {
		return listaValidacion;
	}

	public void setListaValidacion(List<FValidacion> listaValidacion) {
		this.listaValidacion = listaValidacion;
	}
	
	
}
