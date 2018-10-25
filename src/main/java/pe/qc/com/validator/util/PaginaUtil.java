package pe.qc.com.validator.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

public class PaginaUtil {

	public static void mensajeJSF(int severidad, String mensaje) {

		switch (severidad) {
		case Constantes.INFORMACION:
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje,
							mensaje));
			break;
		case Constantes.ADVERTENCIA:
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, mensaje,
							mensaje));
			break;
		case Constantes.ERROR:
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje,
							mensaje));
			break;
		default:
			break;
		}

	}

	public static void ejecutar(String sentencia) {
		RequestContext.getCurrentInstance().execute(sentencia);
	}

	public static void redireccionar(String pagina) throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect(pagina);
	}

	public static boolean existeSesionIniciada() {
		boolean existe = false;
		FacesContext faceContext = FacesContext.getCurrentInstance();
		HttpServletRequest httpServletRequest = (HttpServletRequest) faceContext
				.getExternalContext().getRequest();
		if (httpServletRequest.getSession().getAttribute("sesionUsuario") != null) {
			existe = true;
		}

		return existe;
	}

	public static Date toDate(DateTime fecha) {
		Date date = null;
		if (fecha != null) {
			date = fecha.toDate();
		}
		return date;
	}

	public static DateTime toDateTime(Date fecha) {
		DateTime dateTime = null;
		if (fecha != null) {
			dateTime = new DateTime(fecha);
		}
		return dateTime;
	}

	public static String convertirAMayusculas(String texto) {
		String convertido = null;
		if (texto != null) {
			convertido = texto.toUpperCase().trim();
		}
		return convertido;
	}

	/**
	 * Obtiene solo el nombre del archivo de la ruta donde se ubica el archivo
	 * que se esta subiendo
	 * 
	 * @param rutaConNombre
	 * @return
	 */
	public static String obtenerNombreDeArchivo(String rutaConNombre) {
		String nombreArchivo = null;
		if (rutaConNombre != null) {
			int indiceDelUltimoSlash = rutaConNombre.lastIndexOf("\\");
			nombreArchivo = rutaConNombre.substring(indiceDelUltimoSlash + 1,
					rutaConNombre.length());
		}
		return nombreArchivo;
	}

	public static StreamedContent convertirAStreamed(byte[] archivo,
			String nombreArchivo) {
		StreamedContent streamedContent = null;
		if (archivo != null) {
			InputStream is = new ByteArrayInputStream(archivo);
			streamedContent = new DefaultStreamedContent(is, null,
					nombreArchivo);
		}
		return streamedContent;
	}

	/**
	 * Obtendremos el nombre de mes por indice y luego convertiremos la primera
	 * letra del nombre a mayuscula
	 * 
	 * @param anio
	 * @param mes
	 * @return String
	 */
	public static String obtenerNombreMes(Integer anio, Integer mes) {
		LocalDate localDate = new LocalDate(anio, mes, 1);
		DateTimeFormatter formato = DateTimeFormat.forPattern("MMMM");
		String nombreMes = formato.print(localDate);
		char primeraLetra = nombreMes.charAt(0);
		nombreMes = Character.toUpperCase(primeraLetra)
				+ nombreMes.substring(1, nombreMes.length());
		return nombreMes;
	}

	public static String formatearFecha(int tipoFormato, DateTime fecha) {
		String fechaFormateada = null;
		DateTimeFormatter formato = null;
		try {
			if (fecha != null) {
				switch (tipoFormato) {
				case Constantes.FORMATO_FECHA_HORA:
					formato = DateTimeFormat.forPattern("dd-MM-yyyy hh:mm:ss a");
					fechaFormateada = formato.print(fecha);
					break;
				case Constantes.FORMATO_FECHA:
					formato = DateTimeFormat.forPattern("dd-MM-yyyy");
					fechaFormateada = formato.print(fecha);
					break;
				case Constantes.FORMATO_FECHA_BD:
					formato = DateTimeFormat.forPattern("dd-MM-yy");
					fechaFormateada = formato.print(fecha);
					break;
				}
			}
		} catch (Exception e) {

		}
		return fechaFormateada;
	}

	public static void actualizarComponente(String id) {
		RequestContext.getCurrentInstance().update(id);
	}

	public static String obtenerNavegador() {
		String browser = ((HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest())
				.getHeader("User-Agent");
		return browser;
	}

	public static String obtenerIpCliente() {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			ipAddress = request.getRemoteAddr();
		}
		return ipAddress;
	}

	public static void actualizarComponenteMensaje(String idComponente,
			int severidad, String titulo, String mensaje) {
		RequestContext context = RequestContext.getCurrentInstance();
		context.update(idComponente);
		mensajeJSF(severidad, mensaje);
	}
}
