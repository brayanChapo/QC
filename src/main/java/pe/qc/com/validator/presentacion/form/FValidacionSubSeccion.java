package pe.qc.com.validator.presentacion.form;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pe.qc.com.validator.negocio.bo.BOArchivoRutas;
import pe.qc.com.validator.negocio.servicio.NArchivoRutas;
import pe.qc.com.validator.negocio.servicio.NUsuarioAIX;
import pe.qc.com.validator.presentacion.form.formLinux.FArchivoSeguridadBD;
import pe.qc.com.validator.presentacion.form.formLinux.FBackupConfigWAS;
import pe.qc.com.validator.presentacion.form.formLinux.FConfigBDUsar;
import pe.qc.com.validator.presentacion.form.formLinux.FConfigWSP;
import pe.qc.com.validator.presentacion.form.formLinux.FConfigWebSphereOtrasConf;
import pe.qc.com.validator.presentacion.form.formLinux.FConfigWinSCP;
import pe.qc.com.validator.presentacion.form.formLinux.FCopiaArchivosCc;
import pe.qc.com.validator.presentacion.form.formLinux.FEjecucionSQLUsuarios;
import pe.qc.com.validator.presentacion.form.formLinux.FEjecucionScriptSQL;
import pe.qc.com.validator.presentacion.form.formLinux.FTablaCreacionCopiaArchivos;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;
import pe.qc.com.validator.util.excepcion.aplicacion.PersistenciaExcepcion;

public class FValidacionSubSeccion {
	private FConfigBDUsar fConfigBDUsar;
	private FEjecucionScriptSQL fEjecucionScriptSQL;
	private FEjecucionSQLUsuarios fEjecucionSQLUsuarios;
	private FValidacion fValidacion;
	private FArchivoSeguridadBD fArchivoSeguridadBD;
	private FTablaCreacionCopiaArchivos fTablaCreacionCopiaArchivos;
	private FCopiaArchivosCc fCopiaArchivosCc;
	private FBackupConfigWAS fBackupConfigWAS;
	private FConfigWSP fConfigWSP;
	private FConfigWinSCP fConfigWinSCP;
	private FConfigWebSphereOtrasConf fConfigWebSphereOtrasConf;

	private List<FValidacion> listaValidacion;
	@Autowired
	private NUsuarioAIX nUsuarioAIX;
	@Autowired
	private NArchivoRutas nArchivoRutas;

	public FValidacionSubSeccion() {
		listaValidacion = new ArrayList<>();
	}

	public FValidacionSubSeccion(NUsuarioAIX nUsuarioAIX, NArchivoRutas nArchivoRutas) {
		this.nUsuarioAIX = nUsuarioAIX;
		this.nArchivoRutas = nArchivoRutas;
		listaValidacion = new ArrayList<>();
	}

	
	public void setnUsuarioAIX(NUsuarioAIX nUsuarioAIX) {
		this.nUsuarioAIX = nUsuarioAIX;
	}

	public void setnArchivoRutas(NArchivoRutas nArchivoRutas) {
		this.nArchivoRutas = nArchivoRutas;
	}

	public void validarSubSeccion(String idSubseccion, List<String> palabra, String nombreSeccion, String nombreTarea,String nombreSubTarea, List<String> listaClearCase, List<String> listaServProd, List<String> listaServCert,
			List<FSubTabla> listasSubTabla, List<String> listaServidor) {
		fValidacion = new FValidacion();
		if (nombreSeccion.contains("Configuracion de Base de Datos")&& nombreTarea.contains("Otras configuraciones de BD")&& nombreSubTarea.contains("Otras configuraciones de BD")) {
			try {
				fValidacion = validarConfigBDOtros(idSubseccion, palabra, listaServCert);
				if(fValidacion!=null) {
					listaValidacion.add(fValidacion);
				}
			}catch(PersistenciaExcepcion e){
				throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
			}catch(Exception e ){
				throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
			}
		}else if(nombreSeccion.contains("Configuracion de Base de Datos") && nombreTarea.contains("Configuracion de BD") && nombreSubTarea.contains("Ejecucion de Scripts SQL")) {
			try {
				fValidacion = validarEjecucionScript(idSubseccion,palabra,listaClearCase);
				if(fValidacion!=null) {
					listaValidacion.add(fValidacion);
				}
			}catch(PersistenciaExcepcion e){
				throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
			}catch(Exception e ){
				throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
			}
			try {
				fValidacion = new FValidacion();
				fValidacion = validarUsuariosEjecucion(idSubseccion,palabra);
				if(fValidacion!=null) {
					listaValidacion.add(fValidacion);
				}
			}catch(PersistenciaExcepcion e){
				throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
			}catch(Exception e ){
				throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
			}
			try {
				fValidacion = new FValidacion();
				fValidacion = validarArchivoScript(idSubseccion,palabra,listaClearCase);
				if(fValidacion!=null) {
					listaValidacion.add(fValidacion);
				}
			}catch(PersistenciaExcepcion e){
				throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
			}catch(Exception e ){
				throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
			}
		}else if(nombreSeccion.contains("Configuracion del Servidor") && nombreTarea.contains("Copia de archivos") && nombreSubTarea.contains("Servidor AIX y Linux: Copia de archivos")) {
			try {
				fValidacion = validarCreacionCarpetas(idSubseccion,palabra,listaServidor);
				if(fValidacion!=null) {
					listaValidacion.add(fValidacion);
				}
			}catch(PersistenciaExcepcion e){
				throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
			}catch(Exception e ){
				throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
			}
			try {
				fValidacion = new FValidacion();
				fValidacion = validarCopiaArchivos(idSubseccion, palabra, listaClearCase);
				if(fValidacion!=null) {
					listaValidacion.add(fValidacion);
				}
			}catch(PersistenciaExcepcion e){
				throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
			}catch(Exception e ){
				throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
			}
			try {
				fValidacion = new FValidacion();
				fValidacion = validarRutasCopiaArchivos(idSubseccion, palabra, listaServidor);
				if(fValidacion!=null) {
					listaValidacion.add(fValidacion);
				}
			}
			catch(PersistenciaExcepcion e){
				throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
			}catch(Exception e ){
				throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
			}	
		}else if(nombreSeccion.contains("Configuración del servidor") && nombreTarea.contains("Creación de directorios") && nombreSubTarea.contains("Servidor AIX y Linux: Creación de directorios")) {
			try {
				fValidacion = validarCreacionDirectorio(idSubseccion,listaServidor,listasSubTabla);
				listaValidacion.add(fValidacion);
			}catch(PersistenciaExcepcion e){
				throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
			}catch(Exception e ){
				throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
			}
		}else if(nombreSeccion.contains("Configuración del servidor") && nombreTarea.contains("Configuración Web") && nombreSubTarea.contains("WAS (Web Sphere Aplication)")) {
			try {
				fValidacion = validarBackupConfWas(idSubseccion,palabra);
				if(fValidacion!=null) {
					listaValidacion.add(fValidacion);
				}
			}catch(PersistenciaExcepcion e){
				throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
			}catch(Exception e ){
				throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
			}
		}else if(nombreSeccion.contains("Configuración del servidor") && nombreTarea.contains("Configuración Web") && nombreSubTarea.contains("WSP (Web Sphere Portal)")) {
			try {
				fValidacion = validarConfigWSP(idSubseccion,palabra);
				if(fValidacion!=null) {
					listaValidacion.add(fValidacion);
				}
			}catch(PersistenciaExcepcion e){
				throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
			}catch(Exception e ){
				throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
			}
		}else if(nombreSeccion.contains("Configuración del servidor") && nombreTarea.contains("Otras configuración por servidor") && nombreSubTarea.contains("Otras configuraciones")) {
			try {
				fValidacion = validarConfigWinSCP(idSubseccion,palabra);
				if(fValidacion!=null) {
					listaValidacion.add(fValidacion);
				}
			}catch(PersistenciaExcepcion e){
				throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
			}catch(Exception e ){
				throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
			}
		}else if(nombreSeccion.contains("Configuración del servidor") && nombreTarea.contains("Otras configuración por servidor") && nombreSubTarea.contains("Otras configuraciones Web")) {
			fValidacion = validarConfigWebSphere(idSubseccion,palabra);
			listaValidacion.add(fValidacion);
		}
	}

	public FValidacion validarConfigBDOtros(String idSubseccion, List<String> palabra, List<String> listaServCert) {
		FValidacion fValidacion1 = new FValidacion();
		List<FConfigBDUsar> listaFConfigBDUsar = new ArrayList<>();
		fConfigBDUsar = new FConfigBDUsar();
		String palabras[] = new String[4];
		int i = 0;
		int f = 0;
		for (String string : palabra) {

			if (i != 0) {
				i++;
				palabras[i] = string.trim();
			}
			if (string.trim().equalsIgnoreCase("usar")) {
				i = 1;
				palabras[i] = string;
			}
			if (i == 3) {
				fConfigBDUsar.setAccion(palabras[1]);
				fConfigBDUsar.setAmbiente(palabras[2]);
				fConfigBDUsar.setServidor(palabras[3]);
				listaFConfigBDUsar.add(fConfigBDUsar);
				fConfigBDUsar = new FConfigBDUsar();
				i = 0;
				f= 1;
			}
		}
		if(f==1){
			int p = 0;
			int a = 0;
			String validacion = "Punto: " + idSubseccion + " Valicacion en la Subtarea Otras configuraciones de BD";
			String comentario = "";
			String estado = "";
			for (FConfigBDUsar fConfigBDUsar : listaFConfigBDUsar) {
				p = 0;
				for (String servCert : listaServCert) {
					if (servCert.contains(fConfigBDUsar.getServidor().intern())) {
						p = 1;
					}
				}
				if (p == 0) {
					String valor = fConfigBDUsar.getServidor().intern() + " ";
					comentario = comentario + valor;
					a = 1;
				}
			}
			if (a == 0) {
				estado = Constantes.VALIDACION_OK;
				comentario = Constantes.VALIDACION_OK;
			} else {
				estado = Constantes.VALIDACION_ERROR;
				comentario = comentario + "no se encuentra listado en el cuadro de homologación";
			}
			fValidacion1.setValidacion(validacion);
			fValidacion1.setEstado(estado);
			fValidacion1.setComentario(comentario);
			return fValidacion1;
		}else {
			return null;
		}
	}
	
	public FValidacion validarEjecucionScript(String idSubseccion, List<String> palabra, List<String> listaClearCase) {
		FValidacion fValidacion2 = new FValidacion();
		List<String> listaNOClearCase = new ArrayList<>();
		List<FEjecucionScriptSQL> listaFEjecucionScriptSQL = new ArrayList<>();
		fEjecucionScriptSQL = new FEjecucionScriptSQL();
		String palabras[] = new String [6];
		int i = 0;
		int f = 0;
		for (String string : palabra) {
			if(i!=0) {
				i++;
				palabras[i] = string.trim();
			}
			if(string.trim().equalsIgnoreCase("Ejecutar")) {
				i = 1;
				palabras[i] = string;
			}
			if(i==5) {
				fEjecucionScriptSQL.setAccion(palabras[1]);
				fEjecucionScriptSQL.setRuta(palabras[2]);
				fEjecucionScriptSQL.setArchivo(palabras[3]);
				fEjecucionScriptSQL.setDescripcion(palabras[4]);
				fEjecucionScriptSQL.setTk(palabras[5]);
				listaFEjecucionScriptSQL.add(fEjecucionScriptSQL);
				fEjecucionScriptSQL = new FEjecucionScriptSQL();
				i=0;
				f=1;
			}
		}
		
		if(f==1){
			int p =0;
			int a = 0;
			String validacion = "Punto: " + idSubseccion +" Valicacion en la Subtarea Ejecución de Script Sql";
			String comentario = "";
			String estado = "";
			String nombre;
			for (FEjecucionScriptSQL fEjecucionScriptSQL : listaFEjecucionScriptSQL) {
				nombre = fEjecucionScriptSQL.getRuta().intern() + "\\" + fEjecucionScriptSQL.getArchivo().intern();
				p=0;
				for (String ClearCase : listaClearCase) {
					if(ClearCase.equals(nombre)) {
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
			fValidacion2.setValidacion(validacion);
			fValidacion2.setEstado(estado);
			fValidacion2.setComentario(comentario);
			fValidacion2.setComentarioAdicional(listaNOClearCase);
			System.out.println(fValidacion2.toString());
			return fValidacion2;
		}else {
			return null;
		}
	}
	
	public FValidacion validarArchivoScript(String idSubseccion, List<String> palabra, List<String> listaClearCase) {
		FValidacion fValidacion3 = new FValidacion();
		List<FArchivoSeguridadBD> listaFArchivoSeguridadBD = new ArrayList<>();
		fArchivoSeguridadBD = new FArchivoSeguridadBD();
		String palabras[] = new String [6];
		int i = 0;
		int f = 0;
		for (String string : palabra) {
			if(i!=0) {
				i++;
				palabras[i] = string.trim();
			}
			if(string.trim().equalsIgnoreCase("Reemplazar")) {
				i = 1;
				palabras[i] = string;
			}
			if(i==5) {
				fArchivoSeguridadBD.setAccion(palabras[1]);
				fArchivoSeguridadBD.setArchivo(palabras[2]);
				fArchivoSeguridadBD.setAmbiente(palabras[3]);
				fArchivoSeguridadBD.setVariable(palabras[4]);
				fArchivoSeguridadBD.setValor(palabras[5]);
				listaFArchivoSeguridadBD.add(fArchivoSeguridadBD);
				fArchivoSeguridadBD = new FArchivoSeguridadBD();
				i=0;
				f=1;
			}
		}
		
		if(f==1) {
			int p =0;
			int a = 0;
			String validacion = "Punto: " + idSubseccion +" Valicacion de la existencia del archivo Seguridad";
			String comentario = "";
			String estado = "";
			String nombre = "";
			for (String string : listaClearCase) {
				if(string.contains("Seguridad.sql")) {
					nombre = string;
				}
			}
			for (FArchivoSeguridadBD fArchivoSeguridadBD : listaFArchivoSeguridadBD) {
				p=0;
				if(fArchivoSeguridadBD.getArchivo().contains(nombre)) {
					p=1;
				}
				if(p==0) {
					String valor = fArchivoSeguridadBD.getArchivo().intern() + " ";
					comentario = comentario + valor;
					a=1;
				}
			}
			if(a==0) {
				estado = Constantes.VALIDACION_OK;
				comentario = Constantes.VALIDACION_OK;
			}else {
				estado = Constantes.VALIDACION_ERROR;
				comentario = comentario + "no se encuentra etiquetado en el ClearCAse";
			}
			fValidacion3.setValidacion(validacion);
			fValidacion3.setEstado(estado);
			fValidacion3.setComentario(comentario);
			return fValidacion3;
		}else {
			return null;
		}
		
	}
	
	public FValidacion validarCreacionCarpetas(String idSubseccion, List<String> palabra, List<String> listaServidor) {
		FValidacion fValidacion4 = new FValidacion();
		List<FTablaCreacionCopiaArchivos> listaFTablaCreacionCopiaArchivos = new ArrayList<>();
		fTablaCreacionCopiaArchivos = new FTablaCreacionCopiaArchivos();
		BOArchivoRutas boArchivoRutas = new BOArchivoRutas();
		String palabras[] = new String [4];
		int i = 0;
		int f = 0;
		for (String string : palabra) {
			if(i!=0) {
				i++;
				palabras[i] = string.trim();
			}
			if(string.trim().equalsIgnoreCase("Crear")) {
				i = 1;
				palabras[i] = string;
			}
			if(i==3) {
				fTablaCreacionCopiaArchivos.setAccion(palabras[1]);
				fTablaCreacionCopiaArchivos.setPc(palabras[2]);
				fTablaCreacionCopiaArchivos.setAmbiente(palabras[3]);
				listaFTablaCreacionCopiaArchivos.add(fTablaCreacionCopiaArchivos);
				fTablaCreacionCopiaArchivos = new FTablaCreacionCopiaArchivos();
				i=0;
				f=1;
			}
		}
		if(f==1) {
			int p =0;
			int a = 0;
			String validacion = "Punto: " + idSubseccion +" Valicacion de existencia de Ruta";
			String comentario = "";
			String estado = "";
			
			for (String servidor : listaServidor) {
				for (FTablaCreacionCopiaArchivos fTablaCreacionCopiaArchivos : listaFTablaCreacionCopiaArchivos) {
					p=0;
					boArchivoRutas = nArchivoRutas.obtenerRutaxRuta(fTablaCreacionCopiaArchivos.getAmbiente(), servidor);
					if(boArchivoRutas!=null) {
						p=1;
					}
					if(p==0) {
						String valor = fTablaCreacionCopiaArchivos.getAmbiente() + " ";
						comentario = comentario + valor;
						a = 1;
					}
				}
			}
			if(a==0) {
				estado = Constantes.VALIDACION_OK;
				comentario = Constantes.VALIDACION_OK;
			}else {
				estado = Constantes.VALIDACION_ERROR;
				comentario = comentario + "Dichas rutas no existen";
			}
			fValidacion4.setValidacion(validacion);
			fValidacion4.setEstado(estado);
			fValidacion4.setComentario(comentario);
			return fValidacion4;
		}else {
			return null;
		}
		
	}
	
	public FValidacion validarCopiaArchivos(String idSubseccion, List<String> palabra, List<String> listaClearCase) {
		FValidacion fValidacion5 = new FValidacion();
		List<String> listaNOClearCase = new ArrayList<>();
		List<FCopiaArchivosCc> listaFCopiaArchivosCc = new ArrayList<>();
		fCopiaArchivosCc = new FCopiaArchivosCc();
		String palabras[] = new String [7];
		int i = 0;
		int f = 0;
		for (String string : palabra) {
			if(i!=0) {
				i++;
				palabras[i] = string.trim();
			}
			if(string.trim().equalsIgnoreCase("Copiar")) {
				i = 1;
				palabras[i] = string;
			}
			if(i==6) {
				fCopiaArchivosCc.setAccion(palabras[1]);
				fCopiaArchivosCc.setRuta(palabras[2]);
				fCopiaArchivosCc.setArchivo(palabras[3]);
				fCopiaArchivosCc.setDestino(palabras[4]);
				fCopiaArchivosCc.setTk(palabras[5]);
				fCopiaArchivosCc.setTipoCopiado(palabras[6]);
				listaFCopiaArchivosCc.add(fCopiaArchivosCc);
				fCopiaArchivosCc = new FCopiaArchivosCc();
				i=0;
				f=1;
			}
		}
		
		if(f==1) {
			int p =0;
			int a = 0;
			String validacion = "Punto: " + idSubseccion +" Valicacion de Copia de Archivos,existencia de elementos en el ClearCase";
			String comentario = "";
			String estado = "";
			String nombre;
			for (FCopiaArchivosCc fCopiaArchivosCc : listaFCopiaArchivosCc) {
				nombre = fCopiaArchivosCc.getRuta().intern() + "\\" + fCopiaArchivosCc.getArchivo().intern();
				p=0;
				for (String ClearCase : listaClearCase) {
					if(ClearCase.equals(nombre)) {
						if(fCopiaArchivosCc.getTipoCopiado().equalsIgnoreCase("Binario") || fCopiaArchivosCc.getTipoCopiado().equalsIgnoreCase("Texto")) {
							p=1;
						}
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
				comentario = comentario + "Existen rutas no registrados en el ClearCase o el tipo de copiado no es correcto";
			}
			fValidacion5.setValidacion(validacion);
			fValidacion5.setEstado(estado);
			fValidacion5.setComentario(comentario);
			fValidacion5.setComentarioAdicional(listaNOClearCase);
			return fValidacion5;
		}else {
			return null;
		}
		
	}
	
	public FValidacion validarRutasCopiaArchivos(String idSubseccion, List<String> palabra, List<String> listaServidor) {
		FValidacion fValidacion11 = new FValidacion();
		List<FCopiaArchivosCc> listaFCopiaArchivosCc = new ArrayList<>();
		fCopiaArchivosCc = new FCopiaArchivosCc();
		BOArchivoRutas boArchivoRutas = new BOArchivoRutas();
		String palabras[] = new String [7];
		int i = 0;
		int f=0;
		for (String string : palabra) {
			if(i!=0) {
				i++;
				palabras[i] = string.trim();
			}
			if(string.trim().equalsIgnoreCase("Copiar")) {
				i = 1;
				palabras[i] = string;
			}
			if(i==6) {
				fCopiaArchivosCc.setAccion(palabras[1]);
				fCopiaArchivosCc.setRuta(palabras[2]);
				fCopiaArchivosCc.setArchivo(palabras[3]);
				fCopiaArchivosCc.setDestino(palabras[4]);
				fCopiaArchivosCc.setTk(palabras[5]);
				fCopiaArchivosCc.setTipoCopiado(palabras[6]);
				listaFCopiaArchivosCc.add(fCopiaArchivosCc);
				fCopiaArchivosCc = new FCopiaArchivosCc();
				i=0;
				f=1;
			}
		}
		if(f==1) {
			int p =0;
			int a = 0;
			String validacion = "Punto: " + idSubseccion +" Valicacion de existencia de Ruta";
			String comentario = "";
			String estado = "";
			
			for (String servidor : listaServidor) {
				for (FCopiaArchivosCc fCopiaArchivosCc : listaFCopiaArchivosCc) {
					p=0;
					boArchivoRutas = nArchivoRutas.obtenerRutaxRuta(fCopiaArchivosCc.getRuta(), servidor);
					if(boArchivoRutas!=null) {
						p=1;
					}
					if(p==0) {
						String valor = fCopiaArchivosCc.getRuta() + " ";
						comentario = comentario + valor;
						a = 1;
					}
				}
			}
			
			if(a==0) {
				estado = Constantes.VALIDACION_OK;
				comentario = Constantes.VALIDACION_OK;
			}else {
				estado = Constantes.VALIDACION_ERROR;
				comentario = comentario + "Dichas rutas no existen";
			}
			fValidacion11.setValidacion(validacion);
			fValidacion11.setEstado(estado);
			fValidacion11.setComentario(comentario);
			return fValidacion11;
		}else {
			return null;
		}
		
	}
	
	public FValidacion validarCreacionDirectorio(String idSubseccion, List<String> listaServidor, List<FSubTabla> listasSubTabla) {
		FValidacion fValidacion12 = new FValidacion();
		BOArchivoRutas boArchivoRutas = new BOArchivoRutas();
		int p =0;
		int a = 0;
		String validacion = "Punto: " + idSubseccion +" Valicacion en existencia de rutas en Creacion de Directorios";
		String comentario = "";
		String estado = "";
		
		for (String servidor : listaServidor) {
			for (FSubTabla fSubTabla : listasSubTabla) {
				p=0;
				boArchivoRutas = nArchivoRutas.obtenerRutaxRuta(fSubTabla.getRutaAL().trim(), servidor);
				if(boArchivoRutas!=null) {
					p=1;
				}
				if(p==0) {
					String valor = fSubTabla.getRutaAL().trim() + " ";
					comentario = comentario + valor;
					a = 1;
				}
			}
		}
		
		if(a==0) {
			estado = Constantes.VALIDACION_OK;
			comentario = Constantes.VALIDACION_OK;
		}else {
			estado = Constantes.VALIDACION_ERROR;
			comentario = comentario + " Dichas rutas no existen";
		}
		fValidacion12.setValidacion(validacion);
		fValidacion12.setEstado(estado);
		fValidacion12.setComentario(comentario);
		
		return fValidacion12;
	}
	
	public FValidacion validarUsuariosEjecucion(String idSubseccion, List<String> palabra) {
		FValidacion fValidacion6 = new FValidacion();
		List<FEjecucionSQLUsuarios> listaFEjecucionSQLUsuarios = new ArrayList<>();
		fEjecucionSQLUsuarios = new FEjecucionSQLUsuarios();
		String palabras[] = new String [6];
		int i = 0;
		int f = 0;
		for (String string : palabra) {
			
			if(i!=0) {
				i++;
				palabras[i] = string.trim();
			}
			if(string.trim().equalsIgnoreCase("Utilizar")) {
				i = 1;
				palabras[i] = string;
			}
			if(i==5) {
				fEjecucionSQLUsuarios.setAccion(palabras[1]);
				fEjecucionSQLUsuarios.setUsuario(palabras[2]);
				fEjecucionSQLUsuarios.setAmbiente(palabras[3]);
				fEjecucionSQLUsuarios.setServidor(palabras[4]);
				fEjecucionSQLUsuarios.setSolPass(palabras[5]);
				listaFEjecucionSQLUsuarios.add(fEjecucionSQLUsuarios);
				fEjecucionSQLUsuarios = new FEjecucionSQLUsuarios();
				i=0;
				f=1;
			}
		}
		
		if(f==1) {
			int p =0;
			int a = 0;
			String validacion = "Punto: " + idSubseccion +" Valicacion de la existencia de Usuarios de ejecución";
			String comentario = "";
			String estado = "";
			for (FEjecucionSQLUsuarios fEjecucionSQLUsuarios : listaFEjecucionSQLUsuarios) {
				p=0;
				if(nUsuarioAIX.obtenerUsuarioAIXXNombre(fEjecucionSQLUsuarios.getUsuario())!=null) {
					p=1;
				}
				if(p==0) {
					String valor = fEjecucionSQLUsuarios.getUsuario().intern() + " ";
					comentario = comentario + valor;
					a=1;
				}
			}
			if(a==0) {
				estado = Constantes.VALIDACION_OK;
				comentario = Constantes.VALIDACION_OK;
			}else {
				estado = Constantes.VALIDACION_ERROR;
				comentario = comentario + "no se encuentran Registrados";
			}
			fValidacion6.setValidacion(validacion);
			fValidacion6.setEstado(estado);
			fValidacion6.setComentario(comentario);
			return fValidacion6;
		}else {
			return null;
		}
		
	}
	
	public FValidacion validarBackupConfWas(String idSubseccion, List<String> palabra) {
		FValidacion fValidacion7 = new FValidacion();
		List<FBackupConfigWAS> listaFBackupConfigWAS = new ArrayList<>();
		fBackupConfigWAS = new FBackupConfigWAS();
		String palabras[] = new String [7];
		int i = 0;
		int f = 0;
		for (String string : palabra) {
			
			if(i!=0) {
				i++;
				palabras[i] = string.trim();
			}
			if(string.trim().equalsIgnoreCase("Backup")) {
				i = 1;
				palabras[i] = string;
			}
			if(i==6) {
				fBackupConfigWAS.setAccion(palabras[1]);
				fBackupConfigWAS.setUsuario(palabras[2]);
				fBackupConfigWAS.setAmbiente(palabras[3]);
				fBackupConfigWAS.setServidor(palabras[4]);
				fBackupConfigWAS.setRuta(palabras[5]);
				fBackupConfigWAS.setSolPass(palabras[6]);
				listaFBackupConfigWAS.add(fBackupConfigWAS);
				fBackupConfigWAS = new FBackupConfigWAS();
				i=0;
				f=1;
			}
		}
		if(f==1) {
			int p =0;
			int a = 0;
			String validacion = "Punto: " + idSubseccion +" Valicacion de la existencia de Usuarios de Backup";
			String comentario = "";
			String estado = "";
			for (FBackupConfigWAS fBackupConfigWAS : listaFBackupConfigWAS) {
				p=0;
				if(nUsuarioAIX.obtenerUsuarioAIXXNombre(fBackupConfigWAS.getUsuario())!=null) {
					p=1;
				}
				if(p==0) {
					String valor = fBackupConfigWAS.getUsuario().intern() + " ";
					comentario = comentario + valor;
					a=1;
				}
			}
			if(a==0) {
				estado = Constantes.VALIDACION_OK;
				comentario = Constantes.VALIDACION_OK;
			}else {
				estado = Constantes.VALIDACION_ERROR;
				comentario = comentario + "no se encuentran Registrados";
			}
			fValidacion7.setValidacion(validacion);
			fValidacion7.setEstado(estado);
			fValidacion7.setComentario(comentario);
			return fValidacion7;
		}else {
			return null;
		}
		
	}
	
	public FValidacion validarConfigWSP(String idSubseccion, List<String> palabra) {
		FValidacion fValidacion8 = new FValidacion();
		List<FConfigWSP> listaFConfigWSP = new ArrayList<>();
		fConfigWSP = new FConfigWSP();
		String palabras[] = new String [7];
		int i = 0;
		int f = 0;
		for (String string : palabra) {
			
			if(i!=0) {
				i++;
				palabras[i] = string.trim();
			}
			if(string.trim().equalsIgnoreCase("Actualizar")) {
				i = 1;
				palabras[i] = string;
			}
			if(i==6) {
				fConfigWSP.setAccion(palabras[1]);
				fConfigWSP.setUsuario(palabras[2]);
				fConfigWSP.setAmbiente(palabras[3]);
				fConfigWSP.setServidor(palabras[4]);
				fConfigWSP.setRuta(palabras[5]);
				fConfigWSP.setSolPass(palabras[6]);
				listaFConfigWSP.add(fConfigWSP);
				fConfigWSP = new FConfigWSP();
				i=0;
				f=1;
			}
		}
		if(f==1) {
			int p =0;
			int a = 0;
			String validacion = "Punto: " + idSubseccion +" Valicacion de la existencia de Usuarios WSP";
			String comentario = "";
			String estado = "";
			for (FConfigWSP fConfigWSP : listaFConfigWSP) {
				p=0;
				if(nUsuarioAIX.obtenerUsuarioAIXXNombre(fConfigWSP.getUsuario())!=null) {
					p=1;
				}
				if(p==0) {
					String valor = fConfigWSP.getUsuario().intern() + " ";
					comentario = comentario + valor;
					a=1;
				}
			}
			if(a==0) {
				estado = Constantes.VALIDACION_OK;
				comentario = Constantes.VALIDACION_OK;
			}else {
				estado = Constantes.VALIDACION_ERROR;
				comentario = comentario + "no se encuentran Registrados";
			}
			fValidacion8.setValidacion(validacion);
			fValidacion8.setEstado(estado);
			fValidacion8.setComentario(comentario);
			return fValidacion8;
		}else {
			return null;
		}
		
	}
	
	public FValidacion validarConfigWinSCP(String idSubseccion, List<String> palabra) {
		FValidacion fValidacion9 = new FValidacion();
		List<FConfigWinSCP> listaFConfigWinSCP = new ArrayList<>();
		fConfigWinSCP = new FConfigWinSCP();
		String palabras[] = new String [7];
		int i = 0;
		int f = 0;
		for (String string : palabra) {
			
			if(i!=0) {
				i++;
				palabras[i] = string.trim();
			}
			if(string.trim().equalsIgnoreCase("Utilizar")) {
				i = 1;
				palabras[i] = string;
			}
			if(i==6) {
				fConfigWinSCP.setAccion(palabras[1]);
				fConfigWinSCP.setUsuario(palabras[2]);
				fConfigWinSCP.setAmbiente(palabras[3]);
				fConfigWinSCP.setServidor(palabras[4]);
				fConfigWinSCP.setRuta(palabras[5]);
				fConfigWinSCP.setSolPass(palabras[6]);
				listaFConfigWinSCP.add(fConfigWinSCP);
				fConfigWinSCP = new FConfigWinSCP();
				i=0;
				f=1;
			}
		}
		if(f==1) {
			int p =0;
			int a = 0;
			String validacion = "Punto: " + idSubseccion +" Valicacion de la existencia de Usuarios WinSCP";
			String comentario = "";
			String estado = "";
			for (FConfigWinSCP fConfigWinSCP : listaFConfigWinSCP) {
				p=0;
				if(nUsuarioAIX.obtenerUsuarioAIXXNombre(fConfigWinSCP.getUsuario())!=null) {
					p=1;
				}
				if(p==0) {
					String valor = fConfigWinSCP.getUsuario().intern() + " ";
					comentario = comentario + valor;
					a=1;
				}
			}
			if(a==0) {
				estado = Constantes.VALIDACION_OK;
				comentario = Constantes.VALIDACION_OK;
			}else {
				estado = Constantes.VALIDACION_ERROR;
				comentario = comentario + "no se encuentran Registrados";
			}
			fValidacion9.setValidacion(validacion);
			fValidacion9.setEstado(estado);
			fValidacion9.setComentario(comentario);
			return fValidacion9;
		}else {
			return null;
		}
		
	}
	
	public FValidacion validarConfigWebSphere(String idSubseccion, List<String> palabra) {
		FValidacion fValidacion10 = new FValidacion();
		List<FConfigWebSphereOtrasConf> listaFConfigWebSphereOtrasConf = new ArrayList<>();
		fConfigWebSphereOtrasConf = new FConfigWebSphereOtrasConf();
		String palabras[] = new String [7];
		int i = 0;
		for (String string : palabra) {
			
			if(i!=0) {
				i++;
				palabras[i] = string;
			}
			if(string.equalsIgnoreCase("Reinicio")|| string.equalsIgnoreCase("Sincronizacion")) {
				i = 1;
				palabras[i] = string;
			}
			if(i==6) {
				fConfigWebSphereOtrasConf.setAccion(palabras[1]);
				fConfigWebSphereOtrasConf.setUsuario(palabras[2]);
				fConfigWebSphereOtrasConf.setAmbiente(palabras[3]);
				fConfigWebSphereOtrasConf.setServidor(palabras[4]);
				fConfigWebSphereOtrasConf.setRuta(palabras[5]);
				fConfigWebSphereOtrasConf.setSolPass(palabras[6]);
				listaFConfigWebSphereOtrasConf.add(fConfigWebSphereOtrasConf);
				fConfigWebSphereOtrasConf = new FConfigWebSphereOtrasConf();
				i=0;
			}
		}
		
		int p =0;
		int a = 0;
		String validacion = "Punto: " + idSubseccion +" Valicacion de la existencia de Usuarios de Sincronizacion";
		String comentario = "";
		String estado = "";
		for (FConfigWebSphereOtrasConf fConfigWebSphereOtrasConf : listaFConfigWebSphereOtrasConf) {
			p=0;
			if(nUsuarioAIX.obtenerUsuarioAIXXNombre(fConfigWebSphereOtrasConf.getUsuario())!=null) {
				p=1;
			}
			if(p==0) {
				String valor = fConfigWebSphereOtrasConf.getUsuario().intern() + " ";
				comentario = comentario + valor;
				a=1;
			}
		}
		if(a==0) {
			estado = Constantes.VALIDACION_OK;
			comentario = Constantes.VALIDACION_OK;
		}else {
			estado = Constantes.VALIDACION_ERROR;
			comentario = comentario + "no se encuentran Registrados";
		}
		fValidacion10.setValidacion(validacion);
		fValidacion10.setEstado(estado);
		fValidacion10.setComentario(comentario);
		return fValidacion10;
	}
	

	public FConfigBDUsar getfConfigBDUsar() {
		return fConfigBDUsar;
	}

	public void setfConfigBDUsar(FConfigBDUsar fConfigBDUsar) {
		this.fConfigBDUsar = fConfigBDUsar;
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

	public FArchivoSeguridadBD getfArchivoSeguridadBD() {
		return fArchivoSeguridadBD;
	}

	public void setfArchivoSeguridadBD(FArchivoSeguridadBD fArchivoSeguridadBD) {
		this.fArchivoSeguridadBD = fArchivoSeguridadBD;
	}

	public FEjecucionScriptSQL getfEjecucionScriptSQL() {
		return fEjecucionScriptSQL;
	}

	public void setfEjecucionScriptSQL(FEjecucionScriptSQL fEjecucionScriptSQL) {
		this.fEjecucionScriptSQL = fEjecucionScriptSQL;
	}

	public FTablaCreacionCopiaArchivos getfTablaCreacionCopiaArchivos() {
		return fTablaCreacionCopiaArchivos;
	}

	public void setfTablaCreacionCopiaArchivos(FTablaCreacionCopiaArchivos fTablaCreacionCopiaArchivos) {
		this.fTablaCreacionCopiaArchivos = fTablaCreacionCopiaArchivos;
	}

	public FCopiaArchivosCc getfCopiaArchivosCc() {
		return fCopiaArchivosCc;
	}

	public void setfCopiaArchivosCc(FCopiaArchivosCc fCopiaArchivosCc) {
		this.fCopiaArchivosCc = fCopiaArchivosCc;
	}

	public FEjecucionSQLUsuarios getfEjecucionSQLUsuarios() {
		return fEjecucionSQLUsuarios;
	}

	public void setfEjecucionSQLUsuarios(FEjecucionSQLUsuarios fEjecucionSQLUsuarios) {
		this.fEjecucionSQLUsuarios = fEjecucionSQLUsuarios;
	}

	public FBackupConfigWAS getfBackupConfigWAS() {
		return fBackupConfigWAS;
	}

	public void setfBackupConfigWAS(FBackupConfigWAS fBackupConfigWAS) {
		this.fBackupConfigWAS = fBackupConfigWAS;
	}

	public FConfigWSP getfConfigWSP() {
		return fConfigWSP;
	}

	public void setfConfigWSP(FConfigWSP fConfigWSP) {
		this.fConfigWSP = fConfigWSP;
	}

	public FConfigWinSCP getfConfigWinSCP() {
		return fConfigWinSCP;
	}

	public void setfConfigWinSCP(FConfigWinSCP fConfigWinSCP) {
		this.fConfigWinSCP = fConfigWinSCP;
	}

	public FConfigWebSphereOtrasConf getfConfigWebSphereOtrasConf() {
		return fConfigWebSphereOtrasConf;
	}

	public void setfConfigWebSphereOtrasConf(FConfigWebSphereOtrasConf fConfigWebSphereOtrasConf) {
		this.fConfigWebSphereOtrasConf = fConfigWebSphereOtrasConf;
	}
	
}
