package pe.qc.com.validator.negocio.bo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import pe.qc.com.validator.util.ArchivoUtil;

public class BOClearCase implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private String elemento;
	private String carpeta;
	private String ruta;
	private String ambiente;
	private String fecha;
	private String validacion;
	private String validacion2;
	private String nomenclaturaCorrecta;
	
	private UploadedFile archivoTXT;
	private String nombreArchivoTXT;
	private StreamedContent archivoTXTStreamed;
	private byte[] archivoTXTBytes;
	private File archivoTXTFile;

	public BOClearCase() {

	}
	
	public void cargarArchivoTXT(FileUploadEvent event) {
		archivoTXT = event.getFile();
		nombreArchivoTXT = ArchivoUtil.obtenerNombreDeArchivo(archivoTXT.getFileName());
		transfromarArchivoFileTXT();
		try {
			archivoTXTStreamed = new DefaultStreamedContent(archivoTXT.getInputstream());
			System.out.println("Archivo Cargado con exito" + nombreArchivoTXT);
		} catch (IOException e) {
			archivoTXTStreamed = null;
		}
	}
	
	public void transformarArchivoByteTXT() {
		if (archivoTXT != null) {
			archivoTXTBytes = archivoTXT.getContents();
		} else {
			archivoTXTBytes = null;
		}
		System.out.println("Archivo bytes: " + archivoTXTBytes);
	}
	
	public void transfromarArchivoFileTXT() {
		transformarArchivoByteTXT();
		archivoTXTFile = new File("C:\\tmp\\textoCc.txt");//especificar
		try {
			FileOutputStream fos = new FileOutputStream(archivoTXTFile);
			fos.write(archivoTXTBytes);
			fos.close();
		} catch (IOException e) {
			System.out.println("Error al convertir");
		}
		System.out.println("componente: " + archivoTXTFile.toString());
	}
	
	public List<BOClearCase> transformarArchivoTXT() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		List<BOClearCase> lista = new ArrayList<>();
		BOClearCase Cc;
		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = archivoTXTFile;
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null) {
				Cc = new BOClearCase();
				String [] arreglo = linea.split(";");
	        	 for(int i=0; i<arreglo.length;i++) {
	        		 if(i==0) {
	        			 Cc.setElemento(arreglo[i]);
	        		 }else if(i==1){
	        			 Cc.setAmbiente(arreglo[i]);
	        		 }else if(i==2){
	        			 Cc.setRuta(arreglo[i]);
	        		 }else if(i==3){
	        			 Cc.setFecha(arreglo[i]);
	        		 }else if(i==4){
	        			 Cc.setCarpeta(arreglo[i]);
	        		 }
	        	 }
	        	 lista.add(Cc);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		archivoTXTFile.delete();
		return lista;
	}
	
	public String getValidacion() {
		return validacion;
	}
	public void setValidacion(String validacion) {
		this.validacion = validacion;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public String getCarpeta() {
		return carpeta;
	}

	public void setCarpeta(String carpeta) {
		this.carpeta = carpeta;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNomenclaturaCorrecta() {
		return nomenclaturaCorrecta;
	}

	public void setNomenclaturaCorrecta(String nomenclaturaCorrecta) {
		this.nomenclaturaCorrecta = nomenclaturaCorrecta;
	}

	public String getValidacion2() {
		return validacion2;
	}

	public void setValidacion2(String validacion2) {
		this.validacion2 = validacion2;
	}
	
	public UploadedFile getArchivoTXT() {
		return archivoTXT;
	}

	public void setArchivoTXT(UploadedFile archivoTXT) {
		this.archivoTXT = archivoTXT;
	}

	public String getNombreArchivoTXT() {
		return nombreArchivoTXT;
	}

	public void setNombreArchivoTXT(String nombreArchivoTXT) {
		this.nombreArchivoTXT = nombreArchivoTXT;
	}

	public StreamedContent getArchivoTXTStreamed() {
		return archivoTXTStreamed;
	}

	public void setArchivoTXTStreamed(StreamedContent archivoTXTStreamed) {
		this.archivoTXTStreamed = archivoTXTStreamed;
	}

	public byte[] getArchivoTXTBytes() {
		return archivoTXTBytes;
	}

	public void setArchivoTXTBytes(byte[] archivoTXTBytes) {
		this.archivoTXTBytes = archivoTXTBytes;
	}

	public File getArchivoTXTFile() {
		return archivoTXTFile;
	}

	public void setArchivoTXTFile(File archivoTXTFile) {
		this.archivoTXTFile = archivoTXTFile;
	}

	@Override
	public String toString() {
		return "BOClearCase [elemento=" + elemento + ", carpeta=" + carpeta + ", ruta=" + ruta + ", ambiente="
				+ ambiente + ", fecha=" + fecha + ", validacion=" + validacion + ", validacion2=" + validacion2
				+ ", nomenclaturaCorrecta=" + nomenclaturaCorrecta + "]";
	}

}
