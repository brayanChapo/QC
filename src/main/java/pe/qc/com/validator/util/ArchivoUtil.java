package pe.qc.com.validator.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

public class ArchivoUtil {
	public static File obtenerArchivoDelProyecto(String rutaRealArchivo){
		File archivo = null;
		try{
			archivo = new File(obtenerRutaAbsolutaArchivo(rutaRealArchivo));
		}catch(Exception e){
			e.printStackTrace();
		}
		return archivo;
	}
	
	/**
	 * Obtiene la ruta absoluta a partir de una ruta relativa de archivo.
	 */
	public static String obtenerRutaAbsolutaArchivo(String rutaRelativa) {
		String rutaAbsoluta = null;
		try{
			rutaAbsoluta =  FacesContext.getCurrentInstance().getExternalContext().getRealPath(rutaRelativa);
		}catch(Exception e){
			e.printStackTrace();
		}
		return rutaAbsoluta;
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
	
	public static void convertirByteToFile(byte[] entrada, File destino){
		try(FileOutputStream fos = new FileOutputStream(destino)){
			fos.write(entrada);
			fos.close();
		}catch(IOException e){
			System.out.println("Error al convertir");
		}
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
	
	
}
