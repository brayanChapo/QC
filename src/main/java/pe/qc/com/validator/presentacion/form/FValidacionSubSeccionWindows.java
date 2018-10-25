package pe.qc.com.validator.presentacion.form;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pe.qc.com.validator.negocio.bo.BOArchivoRutas;
import pe.qc.com.validator.negocio.bo.BOUnidades;
import pe.qc.com.validator.negocio.servicio.NArchivoRutas;
import pe.qc.com.validator.negocio.servicio.NUnidades;
import pe.qc.com.validator.negocio.servicio.NUsuarioAIX;
import pe.qc.com.validator.presentacion.form.formSeccion.FAsignacionCarpetasOtros;
import pe.qc.com.validator.presentacion.form.formSeccion.FConectEjecucionScript;
import pe.qc.com.validator.presentacion.form.formSeccion.FConfServidorWindows;
import pe.qc.com.validator.presentacion.form.formSeccion.FConfigBDCreacionYCambiosSQL;
import pe.qc.com.validator.presentacion.form.formSeccion.FConfigBDDTSX;
import pe.qc.com.validator.presentacion.form.formSeccion.FConfigBDDTSXConexion;
import pe.qc.com.validator.presentacion.form.formSeccion.FConfigServidorPermisosOtros;
import pe.qc.com.validator.presentacion.form.formSeccion.FCopiaArchivosWindows;
import pe.qc.com.validator.presentacion.form.formSeccion.FCreacionDirectorioNTFS;
import pe.qc.com.validator.presentacion.form.formSeccion.FCreacionNTFS;
import pe.qc.com.validator.presentacion.form.formSeccion.FEjecucionScriptCc;
import pe.qc.com.validator.presentacion.form.formSeccion.FInstCertDigital;
import pe.qc.com.validator.presentacion.form.formSeccion.FTablaOtrasConfiguracionesBD;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;
import pe.qc.com.validator.util.excepcion.aplicacion.PersistenciaExcepcion;


public class FValidacionSubSeccionWindows {
	private FConectEjecucionScript fConectEjecucionScript;
	private FConfigBDCreacionYCambiosSQL fConfigBDCreacionYCambiosSQL;
	private FConfigBDDTSX fConfigBDDTSX;
	private FConfigBDDTSXConexion fConfigBDDTSXConexion;
	private FConfigServidorPermisosOtros fConfigServidorPermisosOtros;
	private FConfServidorWindows fConfServidorWindows;
	private FCopiaArchivosWindows fCopiaArchivosWindows;
	private FEjecucionScriptCc fEjecucionScriptCc;
	private FTablaOtrasConfiguracionesBD fTablaOtrasConfiguracionesBD;
	private FValidacion fValidacion;
	private FAsignacionCarpetasOtros fAsignacionCarpetasOtros;
	private FCreacionNTFS fCreacionNTFS;
	private FInstCertDigital fInstCertDigital;
	private FCreacionDirectorioNTFS fCreacionDirectorioNTFS;
	
	private List<FValidacion> listaValidacion;
	@Autowired
	private NUnidades nUnidades;
	@Autowired
	private NUsuarioAIX nUsuarioAIX;
	@Autowired
	private NArchivoRutas nArchivoRutas;
	
	public FValidacionSubSeccionWindows() {
		listaValidacion = new ArrayList<>();
	}
	
	public FValidacionSubSeccionWindows(NUnidades nUnidades,NUsuarioAIX nUsuarioAIX, NArchivoRutas nArchivoRutas) {
		this.nUnidades = nUnidades;
		this.nUsuarioAIX = nUsuarioAIX;
		this.nArchivoRutas = nArchivoRutas;
		listaValidacion = new ArrayList<>();
	}
	
	public void setnUnidades(NUnidades nUnidades) {
		this.nUnidades = nUnidades;
	}
	
	public void setnUsuarioAIX(NUsuarioAIX nUsuarioAIX) {
		this.nUsuarioAIX = nUsuarioAIX;
	}

	public void validarSubSeccion(String idSubseccion, List<String> palabra, String nombreSeccion, String nombreTarea, String nombreSubTarea , List<String> listaClearCase,
		List<String> listaServProd, List<String> listaServCert, List<FSubTabla> listasSubTabla, List<String> listaServidor) {
		fValidacion = new FValidacion();
		if(nombreSeccion.contains("Configuracion de Base de Datos") && nombreTarea.contains("Otras configuraciones de BD") && nombreSubTarea.contains("Otras configuraciones de BD")) {
			try {
				fValidacion = validarConfigBDOtros(idSubseccion,palabra,listaServCert);
				if(fValidacion!=null) {
					listaValidacion.add(fValidacion);
				}
			}catch(PersistenciaExcepcion e){
				throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
			}catch(Exception e ){
				throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
			}
		} else if(nombreSeccion.contains("Configuracion de Base de Datos") && nombreTarea.contains("Configuracion de BD") && nombreSubTarea.contains("Ejecucion de Scripts SQL")) {
			try {
				fValidacion = validarConectEjecucionScript(idSubseccion,palabra,listaServCert,listaServidor);
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
				fValidacion = validarEjecucionScript(idSubseccion,palabra,listaClearCase);
				if(fValidacion!=null) {
					listaValidacion.add(fValidacion);
				}
			}catch(PersistenciaExcepcion e){
				throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
			}catch(Exception e ){
				throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
			}
			
		} else if(nombreSeccion.contains("Configuracion del Servidor") && nombreTarea.contains("Creacion de directorios") && nombreSubTarea.contains("Servidor Windows: Creacion de directorios")) {
			try {
				fValidacion = validarRutasCreacionDirectorio(idSubseccion,listaServidor,listasSubTabla);
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
				fValidacion = validarCreacionDirectriosNTFS(idSubseccion,palabra);
				if(fValidacion!=null) {
					listaValidacion.add(fValidacion);
				}
			}catch(PersistenciaExcepcion e){
				throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
			}catch(Exception e ){
				throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
			}
		} else if(nombreSeccion.contains("Configuracion del Servidor") && nombreTarea.contains("Copia de archivos") && nombreSubTarea.contains("Servidor Windows Copia de Archivos")) {
			try {
				fValidacion = validarCopiaArchivosWindowsClearCase(idSubseccion,palabra,listaClearCase);
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
				fValidacion = validarCopiaArchivosProduccion(idSubseccion,palabra,listaServidor,listaServProd);
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
				fValidacion = validarCopiaArchivosCertificacion(idSubseccion,palabra,listaServidor,listaServCert,listaServProd);
				if(fValidacion!=null) {
					listaValidacion.add(fValidacion);
				}
			}catch(PersistenciaExcepcion e){
				throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
			}catch(Exception e ){
				throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
			}
		}else if(nombreSeccion.contains("Configuracion de Base de Datos") && nombreTarea.contains("Configuracion de BD") && nombreSubTarea.contains("BD: DTSX (SQL Server)")) {
			try {
				fValidacion = validarConfigBDBuscar(idSubseccion,palabra,listaServidor,listaServCert,listaServProd);
				if(fValidacion!=null) {
					listaValidacion.add(fValidacion);
				}
			}catch(PersistenciaExcepcion e){
				throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
			}catch(Exception e ){
				throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
			}
		}else if(nombreSeccion.contains("Configuracion de Base de Datos") && nombreTarea.contains("Configuracion de BD") && nombreSubTarea.contains("BD: Creacion y Cambios Estructura (SQL Server)")) {
			try {
				fValidacion = validacionBDConfiguracionEjecucion(idSubseccion,palabra,listaClearCase);
				if(fValidacion!=null) {
					listaValidacion.add(fValidacion);
				}
			}catch(PersistenciaExcepcion e){
				throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
			}catch(Exception e ){
				throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
			}
		}else if(nombreSeccion.contains("Configuracion del Servidor") && nombreTarea.contains("Asignacion de permisos carpetas o archivos-AIX") && nombreSubTarea.contains("Otros")) {
			try {
				fValidacion = validacionConfiguracionServidorOtros(idSubseccion,palabra,listaServidor, listaServCert, listaServProd);
				if(fValidacion!=null) {
					listaValidacion.add(fValidacion);
				}
			}catch(PersistenciaExcepcion e){
				throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
			}catch(Exception e ){
				throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
			}
		}else if(nombreSeccion.contains("Configuración de Base de Datos") && nombreTarea.contains("Asignacion de permisos carpetas") && nombreSubTarea.contains("Otros")) {
			try {
				fValidacion = validarAsignacionPermisos(idSubseccion,palabra);
				if(fValidacion!=null) {
					listaValidacion.add(fValidacion);
				}
			}catch(PersistenciaExcepcion e){
				throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
			}catch(Exception e ){
				throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
			}
		}else if(nombreSeccion.contains("Configuracion del Servidor") && nombreTarea.contains("Creacion de directorios") && nombreSubTarea.contains("Permisos en Share y Ntf's")) {
			try {
				fValidacion = validarUsuarioNTFSSubtabla(idSubseccion,palabra,listasSubTabla);
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
				fValidacion = validarUsuarioNTFS(idSubseccion,palabra,listasSubTabla);
				if(fValidacion!=null) {
					listaValidacion.add(fValidacion);
				}
			}catch(PersistenciaExcepcion e){
				throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
			}catch(Exception e ){
				throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
			}
		}else if(nombreSeccion.contains("Configuración del servidor") && nombreTarea.contains("Instalación de certificado Digital") && nombreSubTarea.contains("Certificado Digital ambiente Windows")) {
			fValidacion = validarCertificadoDigital(idSubseccion,palabra,listaClearCase);
			listaValidacion.add(fValidacion);
		}
		
	}
	
	public FValidacion validarConfigBDOtros(String idSubseccion, List<String> palabra, List<String> listaServCert) {
		FValidacion fValidacion1 = new FValidacion();
		List<FTablaOtrasConfiguracionesBD> listaFTablaOtrasConfiguracionesBD = new ArrayList<>();
		fTablaOtrasConfiguracionesBD = new FTablaOtrasConfiguracionesBD();
		String palabras[] = new String [4];
		int i = 0;
		int f = 0;
		for (String string : palabra) {
			
			if(i!=0) {
				i++;
				palabras[i] = string;
			}
			if(string.trim().equalsIgnoreCase("usar")) {
				i = 1;
				palabras[i] = string;
			}
			if(i==3) {
				fTablaOtrasConfiguracionesBD.setAccion(palabras[1]);
				fTablaOtrasConfiguracionesBD.setAmbiente(palabras[2]);
				fTablaOtrasConfiguracionesBD.setServidor(palabras[3]);
				listaFTablaOtrasConfiguracionesBD.add(fTablaOtrasConfiguracionesBD);
				fTablaOtrasConfiguracionesBD = new FTablaOtrasConfiguracionesBD();
				i=0;
				f=1;
			}
		}
		if(f==1) {
			int p =0;
			int a = 0;
			String validacion = "Punto: " + idSubseccion +" Valicacion en la Subtarea Otras configuraciones de BD";
			String comentario = "";
			String estado = "";
			for (FTablaOtrasConfiguracionesBD fTablaOtrasConfiguracionesBD : listaFTablaOtrasConfiguracionesBD) {
				p=0;
				for (String servCert : listaServCert) {
					if(servCert.contains(fTablaOtrasConfiguracionesBD.getServidor().intern())) {
						p=1;
					}
				}
				if(p==0) {
					String valor = fTablaOtrasConfiguracionesBD.getServidor().intern() + " ";
					comentario = comentario + valor;
					a=1;
				}
			}
			if(a==0) {
				estado = Constantes.VALIDACION_OK;
				comentario = Constantes.VALIDACION_OK;
			}else {
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
	
	public FValidacion validarConectEjecucionScript(String idSubseccion, List<String> palabra, List<String> listaServCert, List<String> listaServidor) {
		FValidacion fValidacion2 = new FValidacion();
		List<FConectEjecucionScript> listaFConectEjecucionScript = new ArrayList<>();
		fConectEjecucionScript = new FConectEjecucionScript();
		String palabras[] = new String [7];
		int i = 0;
		int f = 0;
		for (String string : palabra) {
			
			if(i!=0) {
				i++;
				palabras[i] = string;
			}
			if(string.trim().equalsIgnoreCase("usar")) {
				i = 1;
				palabras[i] = string;
			}
			if(i==6) {
				fConectEjecucionScript.setAccion(palabras[1]);
				fConectEjecucionScript.setAmbiente(palabras[2]);
				fConectEjecucionScript.setServidor(palabras[3]);
				fConectEjecucionScript.setServerType(palabras[4]);
				fConectEjecucionScript.setServerName(palabras[5]);
				fConectEjecucionScript.setAuthentication(palabras[6]);
				listaFConectEjecucionScript.add(fConectEjecucionScript);
				fConectEjecucionScript = new FConectEjecucionScript();
				i=0;
				f=1;
			}
		}
		if(f==1) {
			int p =0;
			int a = 0;
			String validacion = "Punto: " + idSubseccion +" Valicacion en la Subtarea Ejecución de Script Sql, Conect to Server, validación de servidores";
			String comentario = "";
			String estado = "";
			for (FConectEjecucionScript fConectEjecucionScript : listaFConectEjecucionScript) {
				if(fConectEjecucionScript.getAmbiente().equalsIgnoreCase("certificacion")) {
					p=0;
					for (String servCert : listaServCert) {
						if(servCert.contains(fConectEjecucionScript.getServidor().intern())) {
							p=1;
						}
					}
					if(p==0) {
						String valor = fConectEjecucionScript.getServidor().intern() + " ";
						comentario = comentario + valor;
						a=1;
					}
				}			
			}
			
			for (FConectEjecucionScript fConectEjecucionScript1 : listaFConectEjecucionScript) {
				if(fConectEjecucionScript1.getAmbiente().equalsIgnoreCase("produccion")) {
					p=0;
					for (String serv : listaServidor) {
						if(serv.contains(fConectEjecucionScript1.getServidor().intern())) {
							p=1;
						}
					}
					if(p==0) {
						String valor = fConectEjecucionScript1.getServidor().intern() + " ";
						comentario = comentario + valor;
						a=1;
					}
				}
			}
			
			if(a==0) {
				estado = Constantes.VALIDACION_OK;
				comentario = Constantes.VALIDACION_OK;
			}else {
				estado = Constantes.VALIDACION_ERROR;
				comentario = comentario + "no se encuentra listado en el cuadro de homologación";
			}
			fValidacion2.setValidacion(validacion);
			fValidacion2.setEstado(estado);
			fValidacion2.setComentario(comentario);
			return fValidacion2;
		}else {
			return null;
		}
		
	}
	
	public FValidacion validarEjecucionScript(String idSubseccion, List<String> palabra, List<String> listaClearCase) {
		FValidacion fValidacion3 = new FValidacion();
		List<String> listaNOClearCase = new ArrayList<>();
		List<FEjecucionScriptCc> listaFEjecucionScriptCc = new ArrayList<>();
		fEjecucionScriptCc = new FEjecucionScriptCc();
		String palabras[] = new String [6];
		int i = 0;
		int f = 0;
		for (String string : palabra) {
			if(i!=0) {
				i++;
				palabras[i] = string;
			}
			if(string.trim().equalsIgnoreCase("Ejecutar")) {
				i = 1;
				palabras[i] = string;
			}
			if(i==5) {
				fEjecucionScriptCc.setAccion(palabras[1]);
				fEjecucionScriptCc.setRuta(palabras[2]);
				fEjecucionScriptCc.setArchivo(palabras[3]);
				fEjecucionScriptCc.setDescripcion(palabras[4]);
				fEjecucionScriptCc.setTk(palabras[5]);
				listaFEjecucionScriptCc.add(fEjecucionScriptCc);
				fEjecucionScriptCc = new FEjecucionScriptCc();
				i=0;
				f=1;
			}
		}
		if(f==1) {
			int p =0;
			int a = 0;
			String validacion = "Punto: " + idSubseccion +" Valicacion en la Subtarea Ejecución de Script Sql";
			String comentario = "";
			String estado = "";
			String nombre;
			for (FEjecucionScriptCc fEjecucionScriptCc : listaFEjecucionScriptCc) {
				nombre = fEjecucionScriptCc.getRuta().intern() + "\\" + fEjecucionScriptCc.getArchivo().intern();
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
			fValidacion3.setValidacion(validacion);
			fValidacion3.setEstado(estado);
			fValidacion3.setComentario(comentario);
			fValidacion3.setComentarioAdicional(listaNOClearCase);
			System.out.println(fValidacion3.toString());
			return fValidacion3;
		}else {
			return null;
		}
	}
	
	public FValidacion validarRutasCreacionDirectorio(String idSubseccion, List<String> listaServidor, List<FSubTabla> listasSubTabla) {
		FValidacion fValidacion4 = new FValidacion();
		BOArchivoRutas boArchivoRutas = null;
		int p =0;
		int a = 0;
		String validacion = "Punto: " + idSubseccion +" Valicacion en existencia de rutas en Creacion de Directorios en Produccion";
		String comentario = "";
		String estado = "";
		
		for (String servidor : listaServidor) {
			for (FSubTabla fSubTabla : listasSubTabla) {
				p=0;
				boArchivoRutas = nArchivoRutas.obtenerRutaxRuta(fSubTabla.getRutaW().trim(), servidor);
				if(boArchivoRutas!=null) {
					p=1;
				}
				if(p==0) {
					String valor = fSubTabla.getRutaW().trim() + " ";
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
		fValidacion4.setValidacion(validacion);
		fValidacion4.setEstado(estado);
		fValidacion4.setComentario(comentario);
		return fValidacion4;
	}
	
	public FValidacion validarCreacionDirectriosNTFS(String idSubseccion, List<String> palabra) {
		FValidacion fValidacion14 = new FValidacion();
		BOArchivoRutas boArchivoRutas = null;
		fCreacionDirectorioNTFS = new FCreacionDirectorioNTFS();
		List<FCreacionDirectorioNTFS> listaFCreacionDirectorioNTFS = new ArrayList<>();
		String palabras[] = new String [7];
		int i = 0;
		int f = 0;
		for (String string : palabra) {
			if(i!=0) {
				i++;
				palabras[i] = string;
			}
			if(string.trim().equalsIgnoreCase("Crear")) {
				i = 1;
				palabras[i] = string;
			}
			if(i==6) {
				fCreacionDirectorioNTFS.setAccion(palabras[1]);
				fCreacionDirectorioNTFS.setAmbiente(palabras[2]);
				fCreacionDirectorioNTFS.setServidor(palabras[3]);
				fCreacionDirectorioNTFS.setRuta(palabras[4]);
				fCreacionDirectorioNTFS.setDescripcion(palabras[5]);
				fCreacionDirectorioNTFS.setPermisosNTFS(palabras[6]);
				listaFCreacionDirectorioNTFS.add(fCreacionDirectorioNTFS);
				fCreacionDirectorioNTFS = new FCreacionDirectorioNTFS();
				i=0;
				f=1;
			}
		}
		if(f==1) {
			int p =0;
			int a = 0;
			String validacion = "Punto: " + idSubseccion +" Valicacion en la existencia de rutas en Certificación";
			String comentario = "";
			String estado = "";
			
			for (FCreacionDirectorioNTFS fCreacionDirectorioNTFS : listaFCreacionDirectorioNTFS) {
				boArchivoRutas = nArchivoRutas.obtenerRutaxRuta(fCreacionDirectorioNTFS.getRuta().trim(),fCreacionDirectorioNTFS.getServidor().trim());
				p=0;
				if(boArchivoRutas!=null) {
					p=1;
				}
				if(p==0) {
					String valor = fCreacionDirectorioNTFS.getRuta().trim() + " ";
					comentario = comentario + valor;
					a = 1;
				}
			}
			if(a==0) {
				estado = Constantes.VALIDACION_OK;
				comentario = Constantes.VALIDACION_OK;
			}else {
				estado = Constantes.VALIDACION_ERROR;
				comentario = comentario + " Dichas rutas no existen";
			}
			fValidacion14.setValidacion(validacion);
			fValidacion14.setEstado(estado);
			fValidacion14.setComentario(comentario);
			
			return fValidacion14;
		}else {
			return null;
		}
		
	}
	
	public FValidacion validarUnidadesCreacionDirectorios2(String idSubseccion, List<String> listaServCert, List<String> palabra, List<String> listaServidor) {
		FValidacion fValidacion5 = new FValidacion();
		List<BOUnidades> listaUnidades = new ArrayList<>();
		List<String> listaUnidadesString= new ArrayList<>();
		List<FConfServidorWindows> listafConfServidorWindows = new ArrayList<>();
		FConfServidorWindows fConfServidorWindows = new FConfServidorWindows();
		String palabras[] = new String [5];
		int i = 0;
		for (String string : palabra) {
			
			if(i!=0) {
				i++;
				palabras[i] = string;
			}
			if(string.equalsIgnoreCase("crear")) {
				i = 1;
				palabras[i] = string;
			}
			if(i==4) {
				fConfServidorWindows.setAccion(palabras[1]);
				fConfServidorWindows.setAmbiente(palabras[2]);
				fConfServidorWindows.setServidor(palabras[3]);
				fConfServidorWindows.setRuta(palabras[4]);
				listafConfServidorWindows.add(fConfServidorWindows);
				fConfServidorWindows = new FConfServidorWindows();
				i=0;
			}
		}
		for (String servidor : listaServidor) {
			listaUnidades = nUnidades.listarUnidades(servidor);
			for (BOUnidades boUnidades : listaUnidades) {
				listaUnidadesString.add(boUnidades.getNombreUnidad());
			}
		}
		int p =0;
		int a = 0;
		int c = 0;
		String validacion = "Punto: " + idSubseccion +" Valicacion en Unidades en Creacion de Directorios en Certificación";
		String comentario = "";
		String estado = "";
		for (FConfServidorWindows ServidorWindows : listafConfServidorWindows) {
			for (String cert : listaServCert) {
				if(ServidorWindows.getServidor().equals(cert)) {
					c=1;
					for (String string : listaUnidadesString) {
						if(ServidorWindows.getRuta().substring(0, 2).equalsIgnoreCase(string.substring(0, 2))) {
							p=1;
						}
					}
				}
			}
			if(p == 0 && c==0) {
				String valor = "Unidad " + ServidorWindows.getRuta().substring(0, 2) + "el servidor " + ServidorWindows.getServidor() + ",";
				comentario = comentario + valor;
				a=1;
			} else if(p == 0 && c==1) {
				String valor = "Unidad " + ServidorWindows.getRuta().substring(0, 2) + " en el servidor " + ServidorWindows.getServidor() + ",";
				comentario = comentario + valor;
				a=1;
			}
		}
		if(a==0) {
			estado = Constantes.VALIDACION_OK;
			comentario = Constantes.VALIDACION_OK;
		}else {
			estado = Constantes.VALIDACION_ERROR;
			comentario =comentario + "no existe";
		}
		fValidacion5.setValidacion(validacion);
		fValidacion5.setEstado(estado);
		fValidacion5.setComentario(comentario);
		return fValidacion5;
	}
	
	public FValidacion validarCopiaArchivosWindowsClearCase(String idSubseccion, List<String> palabra, List<String> listaClearCase) {
		FValidacion fValidacion6 = new FValidacion();
		List<String> listaNOClearCase = new ArrayList<>();
		List<FCopiaArchivosWindows> listafCopiaArchivosWindows = new ArrayList<>();
		FCopiaArchivosWindows fCopiaArchivosWindows = new FCopiaArchivosWindows();
		String palabras[] = new String [6];
		int i = 0;
		int j= 0;
		for (String string : palabra) {
			if(i!=0) {
				i++;
				palabras[i] = string;
			}
			if(string.trim().equalsIgnoreCase("Copiar")) {
				i = 1;
				palabras[i] = string;
			}
			if(i==5) {
				fCopiaArchivosWindows.setAccion(palabras[1]);
				fCopiaArchivosWindows.setRutaCC(palabras[2]);
				fCopiaArchivosWindows.setArchivo(palabras[3]);
				fCopiaArchivosWindows.setRutaDestino(palabras[4]);
				fCopiaArchivosWindows.setTk(palabras[5]);
				listafCopiaArchivosWindows.add(fCopiaArchivosWindows);
				fCopiaArchivosWindows = new FCopiaArchivosWindows();
				i=0;
				j=1;
			}
		}
		int p =0;
		int a = 0;
		String validacion = "Punto: " + idSubseccion +" Valicacion de Copia de Archivos, elementos en el ClearCase";
		String comentario = "";
		String estado = "";
		String nombre;
		for (FCopiaArchivosWindows fCopiaArchivosWindows1 : listafCopiaArchivosWindows) {
			nombre = fCopiaArchivosWindows1.getRutaCC().intern() + "\\" + fCopiaArchivosWindows1.getArchivo().intern();
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
		if(a==0 && j==1) {
			estado = Constantes.VALIDACION_OK;
			comentario = Constantes.VALIDACION_OK;
		}else if(j==0){
			estado = Constantes.VALIDACION_ERROR;
			comentario = "No cumple con la nueva Estandarizacion del MIS";
		}else {
			estado = Constantes.VALIDACION_ERROR;
			comentario = comentario + "Existen rutas no registrados en el ClearCase";
		}
		fValidacion6.setValidacion(validacion);
		fValidacion6.setEstado(estado);
		fValidacion6.setComentario(comentario);
		fValidacion6.setComentarioAdicional(listaNOClearCase);
		return fValidacion6;
	}
	
	public FValidacion validarCopiaArchivosProduccion(String idSubseccion, List<String> palabra, List<String> listaServidor, List<String> listaServProd) {
		FValidacion fValidacion15 = new FValidacion();
		BOArchivoRutas boArchivoRutas = null;
		FCopiaArchivosWindows fCopiaArchivosWindows = new FCopiaArchivosWindows();
		List<FCopiaArchivosWindows> listafCopiaArchivosWindowsProd = new ArrayList<>();
		String palabras[] = new String [6];
		int i = 0;
		int m = 0;
		for (String string : palabra) {
			if(string.trim().equalsIgnoreCase("para certificación")) {
				m=1;
			}
			if(i!=0) {
				i++;
				palabras[i] = string;
			}
			if(string.trim().equalsIgnoreCase("Copiar") && m==0) {
				i = 1;
				palabras[i] = string;
			}
			if(i==5) {
				fCopiaArchivosWindows.setAccion(palabras[1]);
				fCopiaArchivosWindows.setRutaCC(palabras[2]);
				fCopiaArchivosWindows.setArchivo(palabras[3]);
				fCopiaArchivosWindows.setRutaDestino(palabras[4]);
				fCopiaArchivosWindows.setTk(palabras[5]);
				listafCopiaArchivosWindowsProd.add(fCopiaArchivosWindows);
				fCopiaArchivosWindows = new FCopiaArchivosWindows();
				i=0;
			}
		}
		int p =0;
		int a = 0;
		String validacion = "Punto: " + idSubseccion +" Valicacion en existencia de rutas para Copia de Archivos en Produccion";
		String comentario = "";
		String estado = "";
		
		for (String servidor : listaServidor) {
			for (FCopiaArchivosWindows fCopiaArchivosWindows1 : listafCopiaArchivosWindowsProd) {
				p=0;
				boArchivoRutas = nArchivoRutas.obtenerRutaxRuta(fCopiaArchivosWindows1.getRutaDestino(), servidor);
				if(boArchivoRutas!=null) {
					p=1;
				}
				if(p==0) {
					String valor = fCopiaArchivosWindows1.getRutaDestino() + "-" + servidor + " ";
					comentario = comentario + valor;
					a = 1;
				}
			}
		}
		
		if(a==0 && m==1) {
			estado = Constantes.VALIDACION_OK;
			comentario = Constantes.VALIDACION_OK;
		}else if(m==0){
			estado = Constantes.VALIDACION_ERROR;
			comentario = "No cumple con la nueva Estandarizacion del MIS";
		}else {
			estado = Constantes.VALIDACION_ERROR;
			comentario = comentario + " Dichas rutas no existen";
		}
		fValidacion15.setValidacion(validacion);
		fValidacion15.setEstado(estado);
		fValidacion15.setComentario(comentario);
		return fValidacion15;
	}
	
	public FValidacion validarCopiaArchivosCertificacion(String idSubseccion, List<String> palabra, List<String> listaServidor, List<String> listaServCert, List<String> listaServProd) {
		FValidacion fValidacion16 = new FValidacion();
		BOArchivoRutas boArchivoRutas = null;
		List<String> servidorCertificacion = new ArrayList<>();
		FCopiaArchivosWindows fCopiaArchivosWindows = new FCopiaArchivosWindows();
		List<FCopiaArchivosWindows> listafCopiaArchivosWindowsCert = new ArrayList<>();
		String palabras[] = new String [6];
		int l = 0;
		int m = 0;
		for (String string : palabra) {
			if(string.trim().equalsIgnoreCase("para certificación")) {
				m=1;
			}
			if(l!=0) {
				l++;
				palabras[l] = string;
			}
			if(string.trim().equalsIgnoreCase("Copiar")&& m==1) {
				l = 1;
				palabras[l] = string;
			}
			if(l==5) {
				fCopiaArchivosWindows.setAccion(palabras[1]);
				fCopiaArchivosWindows.setRutaCC(palabras[2]);
				fCopiaArchivosWindows.setArchivo(palabras[3]);
				fCopiaArchivosWindows.setRutaDestino(palabras[4]);
				fCopiaArchivosWindows.setTk(palabras[5]);
				listafCopiaArchivosWindowsCert.add(fCopiaArchivosWindows);
				fCopiaArchivosWindows = new FCopiaArchivosWindows();
				l=0;
			}
		}
		
		int cont = 0;
		for (String servidor : listaServidor) {
			for (String servidorProd : listaServProd) {
				if(servidor.equalsIgnoreCase(servidorProd)) {
					servidorCertificacion.add(listaServCert.get(cont).intern());
				}
				cont++;
			}
			cont = 0;
		}
		
		int p =0;
		int a = 0;
		String validacion = "Punto: " + idSubseccion +" Valicacion en existencia de rutas para Copia de Archivos en Certificacion";
		String comentario = "";
		String estado = "";
		
		for (String servidor : servidorCertificacion) {
			for (FCopiaArchivosWindows fCopiaArchivosWindows1 : listafCopiaArchivosWindowsCert) {
				p=0;
				boArchivoRutas = nArchivoRutas.obtenerRutaxRuta(fCopiaArchivosWindows1.getRutaDestino(), servidor);
				if(boArchivoRutas!=null) {
					p=1;
				}
				if(p==0) {
					String valor = fCopiaArchivosWindows1.getRutaDestino() + "-" + servidor + " ";
					comentario = comentario + valor;
					a = 1;
				}
			}
		}
		
		if(a==0 && m==1) {
			estado = Constantes.VALIDACION_OK;
			comentario = Constantes.VALIDACION_OK;
		}else if(m==0){
			estado = Constantes.VALIDACION_ERROR;
			comentario = "No cumple con la nueva Estandarizacion del MIS";
		}else {
			estado = Constantes.VALIDACION_ERROR;
			comentario = comentario + " Dichas rutas no existen";
		}
		fValidacion16.setValidacion(validacion);
		fValidacion16.setEstado(estado);
		fValidacion16.setComentario(comentario);
		return fValidacion16;
	}
	
	public FValidacion validarCopiaArchivosWindowsUnidades(String idSubseccion, List<String> palabra, List<String> listaServidor, List<String> listaServCert, List<String> listaServProd) {
		FValidacion fValidacion7 = new FValidacion();
		List<BOUnidades> listaUnidades = new ArrayList<>();
		List<String> listaUnidadesStringProd= new ArrayList<>();
		List<String> listaUnidadesStringCert= new ArrayList<>();
		List<String> servidorCertificacion = new ArrayList<>();
		List<FCopiaArchivosWindows> listafCopiaArchivosWindowsProd = new ArrayList<>();
		List<FCopiaArchivosWindows> listafCopiaArchivosWindowsCert = new ArrayList<>();
		FCopiaArchivosWindows fCopiaArchivosWindows = new FCopiaArchivosWindows();
		String palabras[] = new String [6];
		int i = 0;
		int m = 0;
		int l=0;
		for (String string : palabra) {
			if(string.trim().equalsIgnoreCase("para certificación")) {
				m=1;
			}
			if(l!=0) {
				l++;
				palabras[l] = string;
			}
			if(string.equalsIgnoreCase("Copiar")& m==1) {
				l = 1;
				palabras[l] = string;
			}
			if(l==5) {
				fCopiaArchivosWindows.setAccion(palabras[1]);
				fCopiaArchivosWindows.setRutaCC(palabras[2]);
				fCopiaArchivosWindows.setArchivo(palabras[3]);
				fCopiaArchivosWindows.setRutaDestino(palabras[4]);
				fCopiaArchivosWindows.setTk(palabras[5]);
				listafCopiaArchivosWindowsCert.add(fCopiaArchivosWindows);
				fCopiaArchivosWindows = new FCopiaArchivosWindows();
				l=0;
			}
			if(i!=0) {
				i++;
				palabras[i] = string;
			}
			if(string.equalsIgnoreCase("Copiar") && m==0) {
				i = 1;
				palabras[i] = string;
			}
			if(i==5) {
				fCopiaArchivosWindows.setAccion(palabras[1]);
				fCopiaArchivosWindows.setRutaCC(palabras[2]);
				fCopiaArchivosWindows.setArchivo(palabras[3]);
				fCopiaArchivosWindows.setRutaDestino(palabras[4]);
				fCopiaArchivosWindows.setTk(palabras[5]);
				listafCopiaArchivosWindowsProd.add(fCopiaArchivosWindows);
				fCopiaArchivosWindows = new FCopiaArchivosWindows();
				i=0;
			}
		}
		int cont = 0;
		for (String servidor : listaServidor) {
			for (String servidorProd : listaServProd) {
				if(servidor.equalsIgnoreCase(servidorProd)) {
					servidorCertificacion.add(listaServCert.get(cont).intern());
				}
				cont++;
			}
			cont = 0;
		}
		
		for (String servidor : listaServidor) {
			listaUnidades = nUnidades.listarUnidades(servidor);
			for (BOUnidades boUnidades : listaUnidades) {
				listaUnidadesStringProd.add(boUnidades.getNombreUnidad().substring(0, 2));
			}
		}
		
		for (String servidor : servidorCertificacion) {
			listaUnidades = nUnidades.listarUnidades(servidor);
			for (BOUnidades boUnidades : listaUnidades) {
				listaUnidadesStringCert.add(boUnidades.getNombreUnidad().substring(0, 2));
			}
		}
		int p =0;
		int a = 0;
		String validacion = "Punto: " + idSubseccion +" Valicacion de Copia de Archivos, Unidades";
		String comentario = "";
		String estado = "";
		for (FCopiaArchivosWindows fCopiaArchivosWindows1 : listafCopiaArchivosWindowsProd) {
			for (String string : listaUnidadesStringProd) {
				if(fCopiaArchivosWindows1.getRutaDestino().substring(0, 2).equalsIgnoreCase(string.substring(0, 2))) {
					p=1;
				}
			}
			if(p==0) {
				String valor = fCopiaArchivosWindows1.getRutaDestino().substring(0, 2).intern() + " ";
				comentario = comentario + valor;
				a=1;
			}
		}
		for (FCopiaArchivosWindows fCopiaArchivosWindows1 : listafCopiaArchivosWindowsCert) {
			for (String string : listaUnidadesStringCert) {
				if(fCopiaArchivosWindows1.getRutaDestino().substring(0, 2).equalsIgnoreCase(string.substring(0, 2))) {
					p=1;
				}
			}
			if(p==0) {
				String valor = fCopiaArchivosWindows1.getRutaDestino().substring(0, 2).intern() + " ";
				comentario = comentario + valor;
				a=1;
			}
		}
		
		if(a==0) {
			estado = Constantes.VALIDACION_OK;
			comentario = Constantes.VALIDACION_OK;
		}else {
			estado = Constantes.VALIDACION_ERROR;
			comentario = comentario + ", unidades no existen";
		}
		fValidacion7.setValidacion(validacion);
		fValidacion7.setEstado(estado);
		fValidacion7.setComentario(comentario);
		return fValidacion7;
	}
	
	public FValidacion validarConfigBDBuscar(String idSubseccion, List<String> palabra, List<String> listaServidor, List<String> listaServCert, List<String> listaServProd) {
		FValidacion fValidacion8 = new FValidacion();
		List<BOUnidades> listaUnidades = new ArrayList<>();
		List<String> listaUnidadesStringProd= new ArrayList<>();
		List<String> listaUnidadesStringCert= new ArrayList<>();
		List<String> servidorCertificacion = new ArrayList<>();
		List<FConfigBDDTSX> listafConfigBDDTSX = new ArrayList<>();
		FConfigBDDTSX fConfigBDDTSX = new FConfigBDDTSX();
		String palabras[] = new String [6];
		int i = 0;
		int f = 0;
		for (String string : palabra) {
			if(i!=0) {
				i++;
				palabras[i] = string;
			}
			if(string.equalsIgnoreCase("Buscar")) {
				i = 1;
				palabras[i] = string;
			}
			if(i==5) {
				fConfigBDDTSX.setAccion(palabras[1]);
				fConfigBDDTSX.setAmbiente(palabras[2]);
				fConfigBDDTSX.setRutaOrigen(palabras[3]);
				fConfigBDDTSX.setArchivo(palabras[4]);
				fConfigBDDTSX.setTk(palabras[5]);
				listafConfigBDDTSX.add(fConfigBDDTSX);
				fConfigBDDTSX = new FConfigBDDTSX();
				i=0;
				f=1;
			}
		}
		int cont = 0;
		for (String servidor : listaServidor) {
			for (String servidorProd : listaServProd) {
				if(servidor.equalsIgnoreCase(servidorProd)) {
					servidorCertificacion.add(listaServCert.get(cont).intern());
				}
				cont++;
			}
			cont = 0;
		}
		for (String servidor : listaServidor) {
			listaUnidades = nUnidades.listarUnidades(servidor);
			for (BOUnidades boUnidades : listaUnidades) {
				listaUnidadesStringProd.add(boUnidades.getNombreUnidad().substring(0, 2));
			}
		}
		for (String servidor : servidorCertificacion) {
			listaUnidades = nUnidades.listarUnidades(servidor);
			for (BOUnidades boUnidades : listaUnidades) {
				listaUnidadesStringCert.add(boUnidades.getNombreUnidad().substring(0, 2));
			}
		}
		if(f==1) {
			int p =0;
			int a = 0;
			int p2 =0;
			int a2 = 0;
			String validacion = "Punto: " + idSubseccion +" Valicacion de Configuracion BD: DTSX, existencia unidades";
			String comentario = "";
			String estado = "";
			for (FConfigBDDTSX fConfigBDDTSX1 : listafConfigBDDTSX) {
				if(fConfigBDDTSX1.getAmbiente().trim().equalsIgnoreCase("Produccion")) {
					for (String string : listaUnidadesStringProd) {
						if(fConfigBDDTSX1.getRutaOrigen().trim().substring(0, 2).equals(string.substring(0, 2))) {
							p=1;
						}
					}
					if(p==0) {
						String valor = fConfigBDDTSX1.getRutaOrigen().substring(0, 2).intern() + " - " + fConfigBDDTSX1.getAmbiente().trim() + " ";
						comentario = comentario + valor;
						a=1;
					}
				}else if (fConfigBDDTSX1.getAmbiente().trim().equalsIgnoreCase("Certificacion")){
					for (String string : listaUnidadesStringCert) {
						if(fConfigBDDTSX1.getRutaOrigen().trim().substring(0, 2).equals(string.substring(0, 2))) {
							p2=1;
						}
					}
					if(p2==0) {
						String valor = fConfigBDDTSX1.getRutaOrigen().substring(0, 2).intern() + " - " + fConfigBDDTSX1.getAmbiente().trim() + " ";
						comentario = comentario + valor;
						a2=1;
					}
				}
			}
			if(a==0 && a2==0) {
				estado = Constantes.VALIDACION_OK;
				comentario = Constantes.VALIDACION_OK;
			}else {
				estado = Constantes.VALIDACION_ERROR;
				comentario = comentario + ", unidades no existen";
			}
			fValidacion8.setValidacion(validacion);
			fValidacion8.setEstado(estado);
			fValidacion8.setComentario(comentario);
			return fValidacion8;
		}else {
			return null;
		}
		
	}
	
	public FValidacion validacionBDConfiguracionEjecucion(String idSubseccion, List<String> palabra, List<String> listaClearCase) {
		FValidacion fValidacion9 = new FValidacion();
		List<String> listaNOClearCase = new ArrayList<>();
		List<FConfigBDCreacionYCambiosSQL> listaFConfigBDCreacionYCambiosSQL = new ArrayList<>();
		fConfigBDCreacionYCambiosSQL = new FConfigBDCreacionYCambiosSQL();
		String palabras[] = new String [6];
		int i = 0;
		int f = 0;
		for (String string : palabra) {
			if(i!=0) {
				i++;
				palabras[i] = string;
			}
			if(string.trim().equalsIgnoreCase("Ejecutar")) {
				i = 1;
				palabras[i] = string;
			}
			if(i==5) {
				fConfigBDCreacionYCambiosSQL.setAccion(palabras[1]);
				fConfigBDCreacionYCambiosSQL.setRuta(palabras[2]);
				fConfigBDCreacionYCambiosSQL.setArchivo(palabras[3]);
				fConfigBDCreacionYCambiosSQL.setDescripcion(palabras[4]);
				fConfigBDCreacionYCambiosSQL.setTk(palabras[5]);
				listaFConfigBDCreacionYCambiosSQL.add(fConfigBDCreacionYCambiosSQL);
				fConfigBDCreacionYCambiosSQL = new FConfigBDCreacionYCambiosSQL();
				i=0;
				f=1;
			}
		}
		if(f==1) {
			int p =0;
			int a = 0;
			String validacion = "Punto: " + idSubseccion +" Valicacion de Configuración de BD para Ejecución de Script Sql";
			String comentario = "";
			String estado = "";
			String nombre;
			for (FConfigBDCreacionYCambiosSQL fConfigBDCreacionYCambiosSQL1 : listaFConfigBDCreacionYCambiosSQL) {
				nombre = fConfigBDCreacionYCambiosSQL1.getRuta().intern() + "\\" + fConfigBDCreacionYCambiosSQL1.getArchivo().intern();
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
			fValidacion9.setValidacion(validacion);
			fValidacion9.setEstado(estado);
			fValidacion9.setComentario(comentario);
			fValidacion9.setComentarioAdicional(listaNOClearCase);
			return fValidacion9;
		}else {
			return null;
		}
		
	}
	
	public FValidacion validacionConfiguracionServidorOtros(String idSubseccion, List<String> palabra, List<String> listaServidor, List<String> listaServCert, List<String> listaServProd) {
		FValidacion fValidacion10 = new FValidacion();
		List<BOUnidades> listaUnidades = new ArrayList<>();
		List<String> listaUnidadesStringProd= new ArrayList<>();
		List<String> listaUnidadesStringCert= new ArrayList<>();
		List<String> servidorCertificacion = new ArrayList<>();
		List<FConfigServidorPermisosOtros> listafConfigServidorPermisosOtros = new ArrayList<>();
		FConfigServidorPermisosOtros fConfigServidorPermisosOtros = new FConfigServidorPermisosOtros();
		String palabras[] = new String [7];
		int i = 0;
		int f = 0;
		int q=0;
		for (String string : palabra) {
			if(i!=0) {
				i++;
				palabras[i] = string;
			}
			if(string.trim().equalsIgnoreCase("Ambiente")) {
				i = 1;
				palabras[i] = string;
			}
			if(i==6) {
				q= q + 1;
				fConfigServidorPermisosOtros.setAccion(palabras[1]);
				fConfigServidorPermisosOtros.setRutaFisica(palabras[2]);
				fConfigServidorPermisosOtros.setRutaCompartida(palabras[3]);
				fConfigServidorPermisosOtros.setUsuario(palabras[4]);
				fConfigServidorPermisosOtros.setPermisos(palabras[5]);
				fConfigServidorPermisosOtros.setPermisosExtendidos(palabras[6]);
				if(q>1) {
					listafConfigServidorPermisosOtros.add(fConfigServidorPermisosOtros);
				}
				fConfigServidorPermisosOtros = new FConfigServidorPermisosOtros();
				i=0;
				f=1;
			}
		}
		int cont = 0;
		for (String servidor : listaServidor) {
			for (String servidorProd : listaServProd) {
				if(servidor.equalsIgnoreCase(servidorProd)) {
					servidorCertificacion.add(listaServCert.get(cont).intern());
				}
				cont++;
			}
			cont = 0;
		}
		for (String servidor : listaServidor) {
			listaUnidades = nUnidades.listarUnidades(servidor);
			for (BOUnidades boUnidades : listaUnidades) {
				listaUnidadesStringProd.add(boUnidades.getNombreUnidad().substring(0, 2));
			}
		}
		for (String servidor : servidorCertificacion) {
			listaUnidades = nUnidades.listarUnidades(servidor);
			for (BOUnidades boUnidades : listaUnidades) {
				listaUnidadesStringCert.add(boUnidades.getNombreUnidad().substring(0, 2));
			}
		}
		if(f==1){
			int p =0;
			int a = 0;
			int p2 =0;
			int a2 = 0;
			String validacion = "Punto: " + idSubseccion +" Valicacion de Configuracion BD: DTSX, existencia unidades";
			String comentario = "";
			String estado = "";
			for (FConfigServidorPermisosOtros fConfigServidorPermisosOtros1 : listafConfigServidorPermisosOtros) {
				if(fConfigServidorPermisosOtros1.getAccion().trim().equalsIgnoreCase("Produccion")) {
					for (String string : listaUnidadesStringProd) {
						if(fConfigServidorPermisosOtros1.getRutaFisica().trim().substring(0, 2).equals(string.substring(0, 2))) {
							p=1;
						}
					}
					if(p==0) {
						String valor = fConfigServidorPermisosOtros1.getRutaFisica().substring(0, 2).intern() + " - " + fConfigServidorPermisosOtros1.getAccion().trim() + " ";
						comentario = comentario + valor;
						a=1;
					}
				}else if (fConfigServidorPermisosOtros1.getAccion().trim().equalsIgnoreCase("Certificacion")){
					for (String string : listaUnidadesStringCert) {
						if(fConfigServidorPermisosOtros1.getRutaFisica().trim().substring(0, 2).equals(string.substring(0, 2))) {
							p2=1;
						}
					}
					if(p2==0) {
						String valor = fConfigServidorPermisosOtros1.getRutaFisica().substring(0, 2).intern() + " - " + fConfigServidorPermisosOtros1.getAccion().trim() + " ";
						comentario = comentario + valor;
						a2=1;
					}
				}
			}
			if(a==0 && a2==0) {
				estado = Constantes.VALIDACION_OK;
				comentario = Constantes.VALIDACION_OK;
			}else {
				estado = Constantes.VALIDACION_ERROR;
				comentario = comentario + ", unidades no existen";
			}
			fValidacion10.setValidacion(validacion);
			fValidacion10.setEstado(estado);
			fValidacion10.setComentario(comentario);
			return fValidacion10;
		}else {
			return null;
		}
		
	}
	
	public FValidacion validarAsignacionPermisos(String idSubseccion, List<String> palabra) {
		FValidacion fValidacion11 = new FValidacion();
		List<FAsignacionCarpetasOtros> listaFAsignacionCarpetasOtros = new ArrayList<>();
		fAsignacionCarpetasOtros = new FAsignacionCarpetasOtros();
		String palabras[] = new String [8];
		int i = 0;
		int f = 0;
		for (String string : palabra) {
			
			if(i!=0) {
				i++;
				palabras[i] = string;
			}
			if(string.trim().equalsIgnoreCase("Acceso")) {
				i = 1;
				palabras[i] = string;
			}
			if(i==7) {
				fAsignacionCarpetasOtros.setAccion(palabras[1]);
				fAsignacionCarpetasOtros.setAmbiente(palabras[2]);
				fAsignacionCarpetasOtros.setRutaFisica(palabras[3]);
				fAsignacionCarpetasOtros.setRutaCompartida(palabras[4]);
				fAsignacionCarpetasOtros.setUsuario(palabras[5]);
				fAsignacionCarpetasOtros.setPermisos(palabras[6]);
				fAsignacionCarpetasOtros.setPermisosExt(palabras[7]);
				listaFAsignacionCarpetasOtros.add(fAsignacionCarpetasOtros);
				fAsignacionCarpetasOtros = new FAsignacionCarpetasOtros();
				i=0;
				f=1;
			}
		}
		if(f==1) {
			int p =0;
			int a = 0;
			String validacion = "Punto: " + idSubseccion +" Valicacion de la existencia de Usuarios de acceso";
			String comentario = "";
			String estado = "";
			for (FAsignacionCarpetasOtros fAsignacionCarpetasOtros : listaFAsignacionCarpetasOtros) {
				p=0;
				if(nUsuarioAIX.obtenerUsuarioAIXXNombre(fAsignacionCarpetasOtros.getUsuario())!=null) {
					p=1;
				}
				if(p==0) {
					String valor = fAsignacionCarpetasOtros.getUsuario().intern() + " ";
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
			fValidacion11.setValidacion(validacion);
			fValidacion11.setEstado(estado);
			fValidacion11.setComentario(comentario);
			return fValidacion11;
		}else {
			return null;
		}
		
	}
	
	public FValidacion validarUsuarioNTFSSubtabla(String idSubseccion, List<String> palabra, List<FSubTabla> listasSubTabla) {
		FValidacion fValidacion17 = new FValidacion();
		int p =0;
		int a = 0;
		int count = 0;
		String validacion = "Punto: " + idSubseccion +" Valicacion de la existencia de Usuarios en creacion de directorios, campo en blanco";
		String comentario = "";
		String estado = "";
		for (FSubTabla fSubTabla : listasSubTabla) {
			if(fSubTabla.getDescripcionShyNF()!=null) {
				if(fSubTabla.getUsuarioAutorizadorShyNF()!=null) {
					p=1;
				}
			}
			if(p==0) {
				count = count + 1;
				a=1;
			}
		}
		if(a==0) {
			estado = Constantes.VALIDACION_OK;
			comentario = Constantes.VALIDACION_OK;
		}else {
			estado = Constantes.VALIDACION_ERROR;
			comentario = "Se encuentran " + count + "espacio(s) en blanco en el campo de usuarios";
		}
		fValidacion17.setValidacion(validacion);
		fValidacion17.setEstado(estado);
		fValidacion17.setComentario(comentario);
		
		return fValidacion17;
	}
	
	public FValidacion validarUsuarioNTFS(String idSubseccion, List<String> palabra, List<FSubTabla> listasSubTabla) {
		FValidacion fValidacion12 = new FValidacion();
		List<FCreacionNTFS> listaFCreacionNTFS = new ArrayList<>();
		fCreacionNTFS = new FCreacionNTFS();
		String palabras[] = new String [8];
		int i = 0;
		int f = 0;
		for (String string : palabra) {
			
			if(i!=0) {
				i++;
				palabras[i] = string;
			}
			if(string.trim().equalsIgnoreCase("Crear")) {
				i = 1;
				palabras[i] = string;
			}
			if(i==7) {
				fCreacionNTFS.setAccion(palabras[1]);
				fCreacionNTFS.setAmbiente(palabras[2]);
				fCreacionNTFS.setServidor(palabras[3]);
				fCreacionNTFS.setRuta(palabras[4]);
				fCreacionNTFS.setNombreCarpeta(palabras[5]);
				fCreacionNTFS.setUsuario(palabras[6]);
				fCreacionNTFS.setPermisos(palabras[7]);
				listaFCreacionNTFS.add(fCreacionNTFS);
				fCreacionNTFS = new FCreacionNTFS();
				i=0;
				f=1;
			}
		}
		if(f==1) {
			int p =0;
			int a = 0;
			String validacion = "Punto: " + idSubseccion +" Valicacion de la existencia de Usuarios en creacion de directorios";
			String comentario = "";
			String estado = "";
			for (FCreacionNTFS fCreacionNTFS : listaFCreacionNTFS) {
				p=0;
				if(nUsuarioAIX.obtenerUsuarioAIXXNombre(fCreacionNTFS.getUsuario())!=null) {
					p=1;
				}
				if(p==0) {
					String valor = fCreacionNTFS.getUsuario().intern() + " ";
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
			fValidacion12.setValidacion(validacion);
			fValidacion12.setEstado(estado);
			fValidacion12.setComentario(comentario);
			return fValidacion12;
		}else {
			return null;
		}
	}
	
	public FValidacion validarCertificadoDigital(String idSubseccion, List<String> palabra, List<String> listaClearCase) {
		FValidacion fValidacion13 = new FValidacion();
		List<String> listaNOClearCase = new ArrayList<>();
		List<FInstCertDigital> listaFInstCertDigital = new ArrayList<>();
		fInstCertDigital = new FInstCertDigital();
		String palabras[] = new String [5];
		int i = 0;
		for (String string : palabra) {
			if(i!=0) {
				i++;
				palabras[i] = string;
			}
			if(string.trim().equalsIgnoreCase("Instalar")) {
				i = 1;
				palabras[i] = string;
			}
			if(i==4) {
				fInstCertDigital.setAccion(palabras[1]);
				fInstCertDigital.setRutaOrigen(palabras[2]);
				fInstCertDigital.setArchivo(palabras[3]);
				fInstCertDigital.setTk(palabras[4]);
				listaFInstCertDigital.add(fInstCertDigital);
				fInstCertDigital = new FInstCertDigital();
				i=0;
			}
		}
		int p =0;
		int a = 0;
		String validacion = "Punto: " + idSubseccion +" Valicacion de archivos a Instalar";
		String comentario = "";
		String estado = "";
		String nombre;
		for (FInstCertDigital fInstCertDigital : listaFInstCertDigital) {
			nombre = fInstCertDigital.getRutaOrigen().intern() + "\\" + fInstCertDigital.getArchivo().intern();
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
		fValidacion13.setValidacion(validacion);
		fValidacion13.setEstado(estado);
		fValidacion13.setComentario(comentario);
		fValidacion13.setComentarioAdicional(listaNOClearCase);
		return fValidacion13;
	}
	
	public FConectEjecucionScript getfConectEjecucionScript() {
		return fConectEjecucionScript;
	}

	public void setfConectEjecucionScript(FConectEjecucionScript fConectEjecucionScript) {
		this.fConectEjecucionScript = fConectEjecucionScript;
	}

	public FConfigBDCreacionYCambiosSQL getfConfigBDCreacionYCambiosSQL() {
		return fConfigBDCreacionYCambiosSQL;
	}

	public void setfConfigBDCreacionYCambiosSQL(FConfigBDCreacionYCambiosSQL fConfigBDCreacionYCambiosSQL) {
		this.fConfigBDCreacionYCambiosSQL = fConfigBDCreacionYCambiosSQL;
	}

	public FConfigBDDTSX getfConfigBDDTSX() {
		return fConfigBDDTSX;
	}

	public void setfConfigBDDTSX(FConfigBDDTSX fConfigBDDTSX) {
		this.fConfigBDDTSX = fConfigBDDTSX;
	}

	public FConfigBDDTSXConexion getfConfigBDDTSXConexion() {
		return fConfigBDDTSXConexion;
	}

	public void setfConfigBDDTSXConexion(FConfigBDDTSXConexion fConfigBDDTSXConexion) {
		this.fConfigBDDTSXConexion = fConfigBDDTSXConexion;
	}

	public FConfigServidorPermisosOtros getfConfigServidorPermisosOtros() {
		return fConfigServidorPermisosOtros;
	}

	public void setfConfigServidorPermisosOtros(FConfigServidorPermisosOtros fConfigServidorPermisosOtros) {
		this.fConfigServidorPermisosOtros = fConfigServidorPermisosOtros;
	}

	public FConfServidorWindows getfConfServidorWindows() {
		return fConfServidorWindows;
	}

	public void setfConfServidorWindows(FConfServidorWindows fConfServidorWindows) {
		this.fConfServidorWindows = fConfServidorWindows;
	}

	public FCopiaArchivosWindows getfCopiaArchivosWindows() {
		return fCopiaArchivosWindows;
	}

	public void setfCopiaArchivosWindows(FCopiaArchivosWindows fCopiaArchivosWindows) {
		this.fCopiaArchivosWindows = fCopiaArchivosWindows;
	}

	public FEjecucionScriptCc getfEjecucionScriptCc() {
		return fEjecucionScriptCc;
	}

	public void setfEjecucionScriptCc(FEjecucionScriptCc fEjecucionScriptCc) {
		this.fEjecucionScriptCc = fEjecucionScriptCc;
	}

	public FTablaOtrasConfiguracionesBD getfTablaOtrasConfiguracionesBD() {
		return fTablaOtrasConfiguracionesBD;
	}

	public void setfTablaOtrasConfiguracionesBD(FTablaOtrasConfiguracionesBD fTablaOtrasConfiguracionesBD) {
		this.fTablaOtrasConfiguracionesBD = fTablaOtrasConfiguracionesBD;
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

	public FAsignacionCarpetasOtros getfAsignacionCarpetasOtros() {
		return fAsignacionCarpetasOtros;
	}

	public void setfAsignacionCarpetasOtros(FAsignacionCarpetasOtros fAsignacionCarpetasOtros) {
		this.fAsignacionCarpetasOtros = fAsignacionCarpetasOtros;
	}

	public FCreacionNTFS getfCreacionNTFS() {
		return fCreacionNTFS;
	}

	public void setfCreacionNTFS(FCreacionNTFS fCreacionNTFS) {
		this.fCreacionNTFS = fCreacionNTFS;
	}

	public FInstCertDigital getfInstCertDigital() {
		return fInstCertDigital;
	}

	public void setfInstCertDigital(FInstCertDigital fInstCertDigital) {
		this.fInstCertDigital = fInstCertDigital;
	}

	public FCreacionDirectorioNTFS getfCreacionDirectorioNTFS() {
		return fCreacionDirectorioNTFS;
	}

	public void setfCreacionDirectorioNTFS(FCreacionDirectorioNTFS fCreacionDirectorioNTFS) {
		this.fCreacionDirectorioNTFS = fCreacionDirectorioNTFS;
	}
		
}
