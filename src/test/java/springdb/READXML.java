package springdb;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class READXML {
	public static void main(String argv[]) {

		try {
			// Obtenir la configuration du sax parser
			SAXParserFactory spfactory = SAXParserFactory.newInstance();
			// Obtenir une instance de l'objet parser
			SAXParser saxParser = spfactory.newSAXParser();

			/*
			 * les trois méthodes sont déclarées dans le corp du DefaltHandler
			 */
			DefaultHandler handler = new DefaultHandler() {

				boolean a = false;
				boolean b = false;
				boolean c = false;
				boolean d = false;
				boolean e = false;
				boolean f = false;
				boolean g = false;
				boolean h = false;
				boolean i = false;
				boolean j = false;
				boolean k = false;

				/*
				 * cette méthode est invoquée à chaque fois que parser rencontre
				 * une balise ouvrante '<'
				 */
				public void startElement(String uri, String localName, String qName, Attributes attributes)
						throws SAXException {

					if (qName.equalsIgnoreCase("my:idConSer")) {
						a = true;
					}

					if (qName.equalsIgnoreCase("my:cmbConSerNom")) {
						b = true;
					}

					if (qName.equalsIgnoreCase("my:idConSerSec")) {
						c = true;
					}

					if (qName.equalsIgnoreCase("my:cmbConSerSec")) {
						d = true;
					}
					
					if (qName.equalsIgnoreCase("my:cmbConSerObs")) {
						e = true;
					}
				
					if (qName.equalsIgnoreCase("font")) {
						f = true;
					}
			
					if (qName.equalsIgnoreCase("my:idConSerTar")) {
						g = true;
					}
					
					if (qName.equalsIgnoreCase("my:cmbConSerTar")) {
						h = true;
					}
					
					if (qName.equalsIgnoreCase("my:cmbConSerTarSub")) {
						i = true;
					}
					
					if (qName.equalsIgnoreCase("my:ServidorDatos")) {
						j = true;
					}
					
					if (qName.equalsIgnoreCase("my:ProReversion")) {
						k = true;
					}
					
				}

				/*
				 * cette méthode est invoquée à chaque fois que parser rencontre
				 * une balise fermante '>'
				 */
				public void endElement(String uri, String localName, String qName) throws SAXException {

					if (qName.equalsIgnoreCase("my:idConSer")) {
						a = false;
					}

					if (qName.equalsIgnoreCase("my:cmbConSerNom")) {
						b = false;
					}

					if (qName.equalsIgnoreCase("my:idConSerSec")) {
						c = false;
					}

					if (qName.equalsIgnoreCase("my:cmbConSerSec")) {
						d = false;
					}
					
					if (qName.equalsIgnoreCase("my:cmbConSerObs")) {
						e = false;
					}
					
//					if (qName.equalsIgnoreCase("strong")) {
//						e = false;
//					}
//					
					if (qName.equalsIgnoreCase("font")) {
						f = false;
					}
//					
					if (qName.equalsIgnoreCase("my:idConSerTar")) {
						g = false;
					}

					if (qName.equalsIgnoreCase("my:cmbConSerTar")) {
						h = false;
					}
					
					if (qName.equalsIgnoreCase("my:cmbConSerTarSub")) {
						i = false;
					}
					
					if (qName.equalsIgnoreCase("my:ServidorDatos")) {
						j = false;
					}
					
					if (qName.equalsIgnoreCase("my:ProReversion")) {
						k = false;
					}
					
				}

				/* imprime les données stockées entre '<' et '>' */
				public void characters(char ch[], int start, int length) throws SAXException {

					if (a) {
						System.out.println("ID : " + new String(ch, start, length));
						a = false;
					}

					if (b) {
						System.out.println("Servidor : " + new String(ch, start, length));
						b = false;
					}

					if (c) {
						System.out.println("idSeccion : " + new String(ch, start, length));
						c = false;
					}

					if (d) {
						System.out.println("Seccion : " + new String(ch, start, length));
						d = false;
					}
						
					if (f && new String(ch, start, length).length()>1) {
						System.out.println("Font : " + new String(ch, start, length));
						f = false;
					}else{
						f = false;
					}
				
					if (g) {
						System.out.println("idSubtarea : " + new String(ch, start, length));
						g = false;
					}

					if (h) {
						System.out.println("Descripcion sub tarea : " + new String(ch, start, length));
						h = false;
					}
					
					if (i) {
						System.out.println("Departamento : " + new String(ch, start, length));
						i = false;
					}
					
					if (j) {
						System.out.println("Secciones : " + new String(ch, start, length));
						j = false;
					}
					
					if (k) {
						System.out.println("Reversion : " + new String(ch, start, length));
						k = false;
					}
				}

			};

			saxParser.parse("C:\\Users\\achapona\\Desktop\\RCCL-MIS-SN000086459.xml", handler);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
