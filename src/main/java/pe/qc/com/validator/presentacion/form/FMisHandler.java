package pe.qc.com.validator.presentacion.form;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FMisHandler extends DefaultHandler {

	private final ArrayList<FArchivoMis> fArchivosMis = new ArrayList<>();
	private FArchivoMis fArchivoMis;
	private final StringBuilder buffer = new StringBuilder();
	private String servidor;

	public ArrayList<FArchivoMis> getfArchivosMis() {
		return fArchivosMis;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		buffer.append(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		try {
			switch (qName) {
			case "my:NumReq":
				fArchivoMis.setSn(buffer.toString());
				break;
			case "my:TipoEP":
				fArchivoMis.setEp(buffer.toString());
				break;
			case "my:TipoCPT":
				fArchivoMis.setCpt(buffer.toString());
				break;
			case "my:TipoOpt":
				fArchivoMis.setOpt(buffer.toString());
				break;
			case "my:CódigoAPT":
				fArchivoMis.setCodigoAplicativo(buffer.toString());
				break;
			case "my:SolTecnico":
				fArchivoMis.setSt(buffer.toString());
				break;
			case "my:txtSolServicio":
				fArchivoMis.setSs(buffer.toString());
				break;
			case "my:CQ":
				fArchivoMis.setTk(buffer.toString());
				break;
			case "my:txtSerInvNom":
				fArchivoMis.setServidorProduccion(buffer.toString());
				break;
			case "my:txtEquSerCer":
				fArchivoMis.setServidorCerticacion(buffer.toString());
				break;
			case "my:cmbConSerNom":
				fArchivoMis.setServidoresConfiguracion(buffer.toString());
				servidor = buffer.toString();
				break;
			case "my:cmbProRevSer":
				fArchivoMis.setServidoresReversion(buffer.toString());
				break;
			case "my:txtServInvBD":
				fArchivoMis.setServidoresNombreBD(buffer.toString());
				break;
			case "my:idConSerSec":
				fArchivoMis.setSeccionesConfiguracion(buffer.toString());
				break;
			case "my:cmbConSerSec":
				fArchivoMis.setSeccionesConfiguracionDescripcion(buffer.toString());
				break;
			case "my:idConSerTar":
				fArchivoMis.setTareasConfiguracion(buffer.toString());
				break;
			case "my:cmbConSerTar":
				fArchivoMis.setTareasConfiguracionDescripcion(buffer.toString());
				break;
			case "my:cmbConSerTarSub":
				fArchivoMis.setSubtareasConfiguracionDescripcion(buffer.toString());
				break;
			case "my:txtConSerDep":
				fArchivoMis.setConfiguracionDepartamentosRealease(buffer.toString());
				break;
			case "my:idConRevSec":
				fArchivoMis.setSeccionesReversion(buffer.toString());
				break;
			case "my:cmbProRevSec":
				fArchivoMis.setSeccionesReversionDescripcion(buffer.toString());
				break;
			case "my:campo64":
				fArchivoMis.setTareasReversion(buffer.toString());
				break;
			case "my:cmbRevTarea":
				fArchivoMis.setTareasReversionDescripcion(buffer.toString());
				break;
			case "my:txtConCreRut_2":
				FRutaMis r = new FRutaMis();
				r.setServidor(servidor);
				r.setRuta(buffer.toString());
				fArchivoMis.setfRutasMis(r);
				break;
			}
			
		} catch (Exception e) {
			System.out.println("Error en el documento");
		}
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch (qName) {
		case "my:NumReq":
			fArchivoMis = new FArchivoMis();
			fArchivosMis.add(fArchivoMis);
			buffer.delete(0, buffer.length());
			break;
		case "my:TipoEP":
			buffer.delete(0, buffer.length());
			break;
		case "my:TipoCPT":
			buffer.delete(0, buffer.length());
			break;
		case "my:TipoOpt":
			buffer.delete(0, buffer.length());
			break;
		case "my:CódigoAPT":
			buffer.delete(0, buffer.length());
			break;
		case "my:SolTecnico":
			buffer.delete(0, buffer.length());
			break;
		case "my:txtSolServicio":
			buffer.delete(0, buffer.length());
			break;
		case "my:CQ":
			buffer.delete(0, buffer.length());
			break;
		case "my:txtSerInvNom":
			buffer.delete(0, buffer.length());
			break;
		case "my:txtEquSerCer":
			buffer.delete(0, buffer.length());
			break;
		case "my:cmbConSerNom":
			buffer.delete(0, buffer.length());
			break;
		case "my:cmbProRevSer":
			buffer.delete(0, buffer.length());
			break;
		case "my:txtServInvBD":
			buffer.delete(0, buffer.length());
			break;
		case "my:idConSerSec":
			buffer.delete(0, buffer.length());
			break;
		case "my:cmbConSerSec":
			buffer.delete(0, buffer.length());
			break;
		case "my:idConSerTar":
			buffer.delete(0, buffer.length());
			break;
		case "my:cmbConSerTar":
			buffer.delete(0, buffer.length());
			break;
		case "my:cmbConSerTarSub":
			buffer.delete(0, buffer.length());
			break;
		case "my:txtConSerDep":
			buffer.delete(0, buffer.length());
			break;
		case "my:idConRevSec":
			buffer.delete(0, buffer.length());
			break;
		case "my:cmbProRevSec":
			buffer.delete(0, buffer.length());
			break;
		case "my:campo64":
			buffer.delete(0, buffer.length());
			break;
		case "my:cmbRevTarea":
			buffer.delete(0, buffer.length());
			break;
		// final rutas
		case "my:txtConCreRut_2":
			buffer.delete(0, buffer.length());
			break;
		}
	}

	public FArchivoMis getfArchivoMis() {
		return fArchivoMis;
	}

	public void setfArchivoMis(FArchivoMis fArchivoMis) {
		this.fArchivoMis = fArchivoMis;
	}

}
