package pe.qc.com.validator.presentacion.form;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import pe.qc.com.validator.util.ArchivoUtil;

public class FArchivoRutas implements Serializable {

	private static final long serialVersionUID = 1L;

	private UploadedFile archivoTXT;
	private String nombreArchivoTXT;
	private StreamedContent archivoTXTStreamed;
	private byte[] archivoTXTBytes;
	private File archivoTXTFile;
	private String nombreArchivo;
	private String ruta;

	public FArchivoRutas() {

	}

	public void cargarArchivoTXT(FileUploadEvent event) {
		archivoTXT = event.getFile();
		nombreArchivoTXT = ArchivoUtil.obtenerNombreDeArchivo(archivoTXT.getFileName());
		transfromarArchivoFileTXT();
		try {
			archivoTXTStreamed = new DefaultStreamedContent(archivoTXT.getInputstream());
			System.out.println("Archivo Cargado con exito" + nombreArchivoTXT);
			String a = nombreArchivoTXT.split("_")[3];
			nombreArchivo = a.substring(0, a.length()-4);
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
		archivoTXTFile = new File("C:\\tmp\\texto.txt");//especificar
		try {
			FileOutputStream fos = new FileOutputStream(archivoTXTFile);
			fos.write(archivoTXTBytes);
			fos.close();
		} catch (IOException e) {
			System.out.println("Error al convertir");
		}
		System.out.println("componente: " + archivoTXTFile.toString());
	}

	public void transformarArchivoTXT() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		ruta = "";
		int i = 1;
//		listaClearCase = new ArrayList<>();
		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = archivoTXTFile;
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null) {
				if(i ==1) {
					ruta = linea;
				}
				i++;
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
//		System.out.println(ruta);
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

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
}
