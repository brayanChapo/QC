package pe.qc.com.validator.presentacion.form;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.xml.sax.SAXException;

import pe.qc.com.validator.negocio.servicio.NArchivoRutas;
import pe.qc.com.validator.negocio.servicio.NSOServidor;
import pe.qc.com.validator.negocio.servicio.NServidor;
import pe.qc.com.validator.negocio.servicio.NUnidades;
import pe.qc.com.validator.negocio.servicio.NUsuarioAIX;
import pe.qc.com.validator.presentacion.form.formReversion.FMisReversionHandler;
import pe.qc.com.validator.util.ArchivoUtil;
import pe.qc.com.validator.util.Constantes;

public class FArchivoMisHandler implements Serializable {

	private static final long serialVersionUID = 1L;

	private UploadedFile archivoMIS;
	private String nombreArchivoMIS;
	private StreamedContent archivoMISStreamed;
	private byte[] archivoMISBytes;
	private File archivoMisFile;

	private UploadedFile archivoTXT;
	private String nombreArchivoTXT;
	private StreamedContent archivoTXTStreamed;
	private byte[] archivoTXTBytes;
	private File archivoTXTFile;

	private FMisHandler fMisHandler;
	private FMisConfiguracionHandler fMisConfiguracionHandler;
	private FDatosMis fDatosMis;
	private FDatosServidor fDatosServidor;
	private FDatosConfiguracion fDatosConfiguracion;
	private FMisReversionHandler fMisReversionHandler;
	private FDatosReversion fDatosReversion;
	private FConfigGeneralHandler fConfigGeneralHandler;

	private List<String> listaClearCase;
	
	private int cantidadTotal;
	private int cantidadCorrectas;
	private int cantidadIncorrectas;

	@Autowired
	private NUnidades nUnidades;
	@Autowired
	private NServidor nServidor;
	@Autowired
	private NSOServidor nSOServidor;
	@Autowired
	private NUsuarioAIX nUsuarioAIX;
	@Autowired
	private NArchivoRutas nArchivoRutas;

	public FArchivoMisHandler() {

	}

	public FArchivoMisHandler(NUnidades nUnidades, NServidor nServidor, NSOServidor nSOServidor, NUsuarioAIX nUsuarioAIX, NArchivoRutas nArchivoRutas) {
		this.nUnidades = nUnidades;
		this.nServidor = nServidor;
		this.nSOServidor = nSOServidor;
		this.nUsuarioAIX = nUsuarioAIX;
		this.nArchivoRutas = nArchivoRutas;
	}

	public void setnUnidades(NUnidades nUnidades) {
		this.nUnidades = nUnidades;
	}

	public void setnServidor(NServidor nServidor) {
		this.nServidor = nServidor;
	}

	public void setnSOServidor(NSOServidor nSOServidor) {
		this.nSOServidor = nSOServidor;
	}
	
	public void setnUsuarioAIX(NUsuarioAIX nUsuarioAIX) {
		this.nUsuarioAIX = nUsuarioAIX;
	}
	
	public void setnArchivoRutas(NArchivoRutas nArchivoRutas) {
		this.nArchivoRutas = nArchivoRutas;
	}

	public void cargarArchivoMIS(FileUploadEvent event) {
		archivoMIS = event.getFile();
		nombreArchivoMIS = ArchivoUtil.obtenerNombreDeArchivo(archivoMIS.getFileName());
		transfromarArchivoFile();
		try {
			archivoMISStreamed = new DefaultStreamedContent(archivoMIS.getInputstream());
			System.out.println("ARchivo Cargado con exito" + nombreArchivoMIS);
		} catch (IOException e) {
			archivoMISStreamed = null;
		}
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

	public void transformarArchivoByte() {
		if (archivoMIS != null) {
			archivoMISBytes = archivoMIS.getContents();
		} else {
			archivoMISBytes = null;
		}
		System.out.println("Archivo bytes: " + archivoMISBytes);
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

	public void transfromarArchivoFile() {
		transformarArchivoByte();
		archivoMisFile = new File("C:\\tmp\\text.xml");
		try {
			FileOutputStream fos = new FileOutputStream(archivoMisFile);
			fos.write(archivoMISBytes);
			fos.close();
		} catch (IOException e) {
			System.out.println("Error al convertir");
		}
		System.out.println("componente: " + archivoMisFile.toString());
	}

	public void transformarArchivoTXT() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		listaClearCase = new ArrayList<>();
		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = archivoTXTFile;
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null) {
				listaClearCase.add(linea);
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
		
	}

	public void transformarArchivoMISXml() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = null;
		try {
			saxParser = factory.newSAXParser();
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		} catch (SAXException e1) {
			e1.printStackTrace();
		}
		fMisHandler = new FMisHandler();
		fMisConfiguracionHandler = new FMisConfiguracionHandler();
		fMisReversionHandler = new FMisReversionHandler();
		fConfigGeneralHandler = new FConfigGeneralHandler();
		try {
			saxParser.parse(archivoMisFile, fMisHandler);
			fConfigGeneralHandler.convertirHandler(archivoMisFile);
			fMisConfiguracionHandler.convertirHandler(archivoMisFile);
			fMisReversionHandler.convertirHandler(archivoMisFile);
			archivoMisFile.delete();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void validarFDatos() {
		fDatosMis = new FDatosMis();
		if (fMisHandler.getfArchivoMis().getTk().equals("TK000000000")) {
			fDatosMis.setTkMis(null);
		} else {
			fDatosMis.setTkMis(fMisHandler.getfArchivoMis().getSn());
		}
		if (fMisHandler.getfArchivoMis().getSn().equals("SN000000000")) {
			fDatosMis.setSnMIS(null);
		} else {
			fDatosMis.setSnMIS(fMisHandler.getfArchivoMis().getSn());
		}
		if (fMisHandler.getfArchivoMis().getSt().equals("ST000000000")) {
			fDatosMis.setStMIS(null);
		} else {
			fDatosMis.setStMIS(fMisHandler.getfArchivoMis().getSt());
		}
		if (fMisHandler.getfArchivoMis().getSs().equals("SS000000000")) {
			fDatosMis.setSsMIS(null);
		} else {
			fDatosMis.setSsMIS(fMisHandler.getfArchivoMis().getSs());
		}
		fDatosMis.setCodMIS(fMisHandler.getfArchivoMis().getCodigoAplicativo());
		if (fMisHandler.getfArchivoMis().getEp().equals("1")) {
			fDatosMis.setTipoCambio(Constantes.ERROR_PRODUCCION);
		} else if (fMisHandler.getfArchivoMis().getCpt().equals("1")) {
			fDatosMis.setTipoCambio(Constantes.CAMBIOS_P_T);
		} else if (fMisHandler.getfArchivoMis().getOpt().equals("1")) {
			fDatosMis.setTipoCambio(Constantes.OPTIMIZACIONES);
		} else {
			fDatosMis.setTipoCambio(null);
		}
		System.out.println("ClaseFdatos: " + fDatosMis.toString());
		fDatosMis.calcularCantidadValidaciones();
	}

	public void validarFDatosServidor() {
		fDatosServidor = new FDatosServidor(nServidor,nSOServidor);
		for (int x = 0; x < fMisHandler.getfArchivoMis().getServidorProduccion().size(); x++) {
			fDatosServidor.setServidorProd(fMisHandler.getfArchivoMis().getServidorProduccion().get(x));
		}

		for (int j = 0; j < fMisHandler.getfArchivoMis().getServidorCerticacion().size(); j++) {
			fDatosServidor.setServidorCert(fMisHandler.getfArchivoMis().getServidorCerticacion().get(j));
		}
		fDatosServidor.completaInformacion();
		fDatosServidor.validarHomomlogacion();
		fDatosServidor.validarServidoresProduccion();
		fDatosServidor.validarServidoresCertificacion();
		fDatosServidor.verTipo();
		System.out.println("HEEEEEEEEEEEEYY : " + fDatosServidor.getTipo());
	}

	public void validarFDatosConfiguracion(String vob, String tk, String matricula) {
		fDatosConfiguracion = new FDatosConfiguracion(nUnidades, nUsuarioAIX, nArchivoRutas);
		fDatosConfiguracion.extraerLista(fMisConfiguracionHandler.getListaConfiguracion(),fMisHandler.getfArchivoMis().getServidorProduccion(),fMisHandler.getfArchivoMis().getServidorCerticacion());
		fDatosConfiguracion.validarServidores();
		fDatosConfiguracion.validarSecciones();
		fDatosConfiguracion.validarTareas();
		fDatosConfiguracion.validarSubTareas();
		fDatosConfiguracion.listarSubSecciones();
		fDatosConfiguracion.validarUnidadC();
		fDatosConfiguracion.validarPalabraValidar();
		fDatosConfiguracion.validarPalabraVerificar();
		fDatosConfiguracion.validarPalabraSoloProduccion();
		/* lista2 */
		fDatosConfiguracion.generarRutasCc(listaClearCase);
//		fDatosConfiguracion.generarRutasClearCase(vob, tk, matricula);/* ARREGLAR PARAMETRO */
		fDatosConfiguracion.validarCuerpoConfiguracionMIS(fDatosServidor.getTipo());
	}

	public void validarFDatosReversion() {
		fDatosReversion = new FDatosReversion();
		fDatosReversion.extraerListas(fMisReversionHandler.getListaReversion(),
				fDatosConfiguracion.getListaRutasClearCase(), fMisHandler.getfArchivoMis().getServidorProduccion(),
				fMisHandler.getfArchivoMis().getServidorCerticacion());
		fDatosReversion.validarServidores();
		fDatosReversion.validarSecciones();
		fDatosReversion.validarTareas();
		fDatosReversion.listarSubSecciones();
		fDatosReversion.validarUnidadC();
		fDatosReversion.validarPalabraValidar();
		fDatosReversion.validarPalabraVerificar();
		fDatosReversion.validarPalabraSoloProduccion();
		/* lista2 */
		fDatosReversion.validarCuerpoReversionMIS();
	}
	
	public void cantidadValidacionesGeneral() {
		int contarCorrectas = 0;
		cantidadTotal = fDatosMis.getListaValidacion().size() + fDatosServidor.getListaValidacion().size() + 
				fDatosConfiguracion.getListaValidacion().size() + fDatosConfiguracion.getListaValidacion2().size() + 
				fDatosReversion.getListaValidacion1().size()+ fDatosReversion.getListaValidacion2().size();
		for (FValidacion fValidacion : fDatosMis.getListaValidacion()) {
			if(fValidacion.getEstado().equals(Constantes.VALIDACION_OK)) {
				contarCorrectas = contarCorrectas +1;
			}
		}
		for (FValidacion fValidacion1 : fDatosServidor.getListaValidacion()) {
			if(fValidacion1.getEstado().equals(Constantes.VALIDACION_OK)) {
				contarCorrectas = contarCorrectas +1;
			}
		}
		for (FValidacion fValidacion2 : fDatosConfiguracion.getListaValidacion()) {
			if(fValidacion2.getEstado().equals(Constantes.VALIDACION_OK)) {
				contarCorrectas = contarCorrectas +1;
			}
		}
		for (FValidacion fValidacion3 : fDatosConfiguracion.getListaValidacion2()) {
			if(fValidacion3.getEstado().equals(Constantes.VALIDACION_OK)) {
				contarCorrectas = contarCorrectas +1;
			}
		}
		for (FValidacion fValidacion4 : fDatosReversion.getListaValidacion1()) {
			if(fValidacion4.getEstado().equals(Constantes.VALIDACION_OK)) {
				contarCorrectas = contarCorrectas +1;
			}
		}
		for (FValidacion fValidacion5 : fDatosReversion.getListaValidacion2()) {
			if(fValidacion5.getEstado().equals(Constantes.VALIDACION_OK)) {
				contarCorrectas = contarCorrectas +1;
			}
		}
		
		cantidadCorrectas = contarCorrectas;
		cantidadIncorrectas = cantidadTotal - cantidadCorrectas;
		
		System.out.println("CAntidad Total: " + cantidadTotal + " , Cantidad Correcta: " + cantidadCorrectas +", Cantidad Incorrectas: "+ cantidadIncorrectas);
		
		
	}

	public UploadedFile getArchivoMIS() {
		return archivoMIS;
	}

	public void setArchivoMIS(UploadedFile archivoMIS) {
		this.archivoMIS = archivoMIS;
	}

	public String getNombreArchivoMIS() {
		return nombreArchivoMIS;
	}

	public void setNombreArchivoMIS(String nombreArchivoMIS) {
		this.nombreArchivoMIS = nombreArchivoMIS;
	}

	public StreamedContent getArchivoMISStreamed() {
		return archivoMISStreamed;
	}

	public void setArchivoMISStreamed(StreamedContent archivoMISStreamed) {
		this.archivoMISStreamed = archivoMISStreamed;
	}

	public byte[] getArchivoMISBytes() {
		return archivoMISBytes;
	}

	public void setArchivoMISBytes(byte[] archivoMISBytes) {
		this.archivoMISBytes = archivoMISBytes;
	}

	public File getArchivoMisFile() {
		return archivoMisFile;
	}

	public void setArchivoMisFile(File archivoMisFile) {
		this.archivoMisFile = archivoMisFile;
	}

	public FMisHandler getfMisHandler() {
		return fMisHandler;
	}

	public void setfMisHandler(FMisHandler fMisHandler) {
		this.fMisHandler = fMisHandler;
	}

	public FDatosMis getfDatosMis() {
		return fDatosMis;
	}

	public void setfDatosMis(FDatosMis fDatosMis) {
		this.fDatosMis = fDatosMis;
	}

	public FDatosServidor getfDatosServidor() {
		return fDatosServidor;
	}

	public void setfDatosServidor(FDatosServidor fDatosServidor) {
		this.fDatosServidor = fDatosServidor;
	}

	public FMisConfiguracionHandler getfMisConfiguracionHandler() {
		return fMisConfiguracionHandler;
	}

	public void setfMisConfiguracionHandler(FMisConfiguracionHandler fMisConfiguracionHandler) {
		this.fMisConfiguracionHandler = fMisConfiguracionHandler;
	}

	public FDatosConfiguracion getfDatosConfiguracion() {
		return fDatosConfiguracion;
	}

	public void setfDatosConfiguracion(FDatosConfiguracion fDatosConfiguracion) {
		this.fDatosConfiguracion = fDatosConfiguracion;
	}

	public FMisReversionHandler getfMisReversionHandler() {
		return fMisReversionHandler;
	}

	public void setfMisReversionHandler(FMisReversionHandler fMisReversionHandler) {
		this.fMisReversionHandler = fMisReversionHandler;
	}

	public FDatosReversion getfDatosReversion() {
		return fDatosReversion;
	}

	public void setfDatosReversion(FDatosReversion fDatosReversion) {
		this.fDatosReversion = fDatosReversion;
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

	public List<String> getListaClearCase() {
		return listaClearCase;
	}

	public void setListaClearCase(List<String> listaClearCase) {
		this.listaClearCase = listaClearCase;
	}

	public int getCantidadTotal() {
		return cantidadTotal;
	}

	public void setCantidadTotal(int cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}

	public int getCantidadCorrectas() {
		return cantidadCorrectas;
	}

	public void setCantidadCorrectas(int cantidadCorrectas) {
		this.cantidadCorrectas = cantidadCorrectas;
	}

	public int getCantidadIncorrectas() {
		return cantidadIncorrectas;
	}

	public void setCantidadIncorrectas(int cantidadIncorrectas) {
		this.cantidadIncorrectas = cantidadIncorrectas;
	}

	public FConfigGeneralHandler getfConfigGeneralHandler() {
		return fConfigGeneralHandler;
	}

	public void setfConfigGeneralHandler(FConfigGeneralHandler fConfigGeneralHandler) {
		this.fConfigGeneralHandler = fConfigGeneralHandler;
	}
	
}
