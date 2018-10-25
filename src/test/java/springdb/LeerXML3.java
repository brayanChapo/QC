package springdb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import pe.qc.com.validator.presentacion.form.formReversion.FReversionServidor;
import pe.qc.com.validator.presentacion.form.formReversion.FSeccionReversion;
import pe.qc.com.validator.presentacion.form.formReversion.FSubSeccionReversion;

public class LeerXML3 {

	

	public static void main(String[] args) {

		

		try {
			// Obtenir la configuration du sax parser
			SAXParserFactory spfactory = SAXParserFactory.newInstance();
			// Obtenir une instance de l'objet parser
			SAXParser saxParser = spfactory.newSAXParser();

			/*
			 * les trois méthodes sont déclarées dans le corp du DefaltHandler
			 */
			DefaultHandler handler = new DefaultHandler() {

				boolean idReversion = false;
				boolean listaServidor = false;
				boolean idSeccionReversion = false;
				boolean nombreSeccion = false;
				boolean palabra = false;
				boolean idSubSeccionReversion = false;
				boolean tareaSubSeccion = false;
				int inicio = 0;
				int i = 0;
				int j =0;
				boolean inicioTarea = false;
				boolean cierreSeccion = false;

				/*
				 * cette méthode est invoquée à chaque fois que parser rencontre
				 * une balise ouvrante '<'
				 */
				public void startElement(String uri, String localName, String qName, Attributes attributes)
						throws SAXException {

					if (qName.equalsIgnoreCase("my:idProRevs")) {
						idReversion = true;
					}

					if (qName.equalsIgnoreCase("my:cmbProRevSer")) {
						listaServidor = true;
					}

					if (qName.equalsIgnoreCase("my:idConRevSec")) {
						idSeccionReversion = true;
					}

					if (qName.equalsIgnoreCase("my:cmbProRevSec")) {
						nombreSeccion = true;
					}
					
					if (qName.equalsIgnoreCase("my:grupo45")) {
						inicioTarea = true;
					}
					
					if (qName.equalsIgnoreCase("my:campo64")) {
						idSubSeccionReversion = true;
					}

					if (qName.equalsIgnoreCase("my:cmbRevTarea")) {
						tareaSubSeccion = true;
					}
					
					/*palabras*/
					if (qName.equalsIgnoreCase("font") || qName.equalsIgnoreCase("strong") || qName.equalsIgnoreCase("div")) {
						palabra = true;
					}
					
					if (qName.equalsIgnoreCase("my:grupo39")) {
						cierreSeccion = true;
					}

				}

				/* imprime les données stockées entre '<' et '>' */
				public void characters(char ch[], int start, int length) throws SAXException {

					if (idReversion) {
						System.out.println("idReversion : " + new String(ch, start, length));
						
						inicio = 1;
						
						idReversion = false;
					}

					if (listaServidor) {
						System.out.println("listaServidor : " + new String(ch, start, length));
						
						listaServidor = false;
					}

					if (idSeccionReversion) {
						System.out.println("idSeccionReversion : " + new String(ch, start, length));
						
						idSeccionReversion = false;
					}

					if (nombreSeccion) {
						System.out.println("nombreSeccion : " + new String(ch, start, length));
						
						nombreSeccion = false;
					}
					
					if (inicioTarea) {
						
							
						System.out.println("inicioTarea : " + new String(ch, start, length));
						
						
						inicioTarea = false;
					}
					
					
					if (idSubSeccionReversion) {
						System.out.println("idSubSeccionReversion : " + new String(ch, start, length));
						
						idSubSeccionReversion = false;
					}

					if (tareaSubSeccion) {
						System.out.println("tareaSubSeccion : " + new String(ch, start, length));
						
						tareaSubSeccion = false;
					}

					if (palabra && new String(ch, start, length).length()>2 && inicio == 1) {
						System.out.println("Font : " + new String(ch, start, length));
						
						palabra = false;
					}
					else{
						palabra = false;
					}

			
					if (cierreSeccion) {
						
						System.out.println("cierreReversion : " + new String(ch, start, length));
						cierreSeccion = false;
					}

				}

			};

			saxParser.parse("C:\\Users\\S66202\\Desktop\\UAPR_SMEX-MIS-SN000082915Brayan.xml", handler);
//			saxParser.parse("C:\\Users\\achapona\\Desktop\\MIS-PLANTILLA.xml", handler);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
