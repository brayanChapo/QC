package pe.qc.com.validator.presentacion.form.formReversion;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FMisReversionHandler {
	private FReversionServidor fReversionServidor;
	private FSeccionReversion fSeccionReversion;
	private FSubSeccionReversion fSubSeccionReversion;
	private List<FReversionServidor> listaReversion;
	
	
	public List<FReversionServidor> getListaReversion() {
		return listaReversion;
	}
	public void setListaReversion(List<FReversionServidor> listaReversion) {
		this.listaReversion = listaReversion;
	}
	
	public void convertirHandler(File f) {
		listaReversion = new ArrayList<>();

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
				int inicioReversion = 0;
				int inicioSeccion = 0;
				int inicioSubseccion =0;
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
						fReversionServidor = new FReversionServidor();
						inicioReversion = 1;
						fReversionServidor.setIdReversionServidor(new String(ch, start, length));
						idReversion = false;
					}

					if (listaServidor) {
						System.out.println("listaServidor : " + new String(ch, start, length));
						fReversionServidor.setListaServidor(new String(ch, start, length));
						listaServidor = false;
					}

					if (idSeccionReversion) {
						System.out.println("idSeccionReversion : " + new String(ch, start, length));
						fSeccionReversion.setIdSeccionReversion(new String(ch, start, length));
						idSeccionReversion = false;
					}

					if (nombreSeccion) {
						if(inicioSubseccion ==1) {
							fSeccionReversion.setListaSubseccion(fSubSeccionReversion);
							fReversionServidor.setListaSeccion(fSeccionReversion);
							System.out.println("nombreSeccion : " + new String(ch, start, length));
							fSeccionReversion = new FSeccionReversion();
							fSeccionReversion.setSeccion(new String(ch, start, length));
							inicioSeccion =0;
						}else {
							if(inicioSubseccion ==0) {
								System.out.println("nombreSeccion : " + new String(ch, start, length));
								fSeccionReversion = new FSeccionReversion();
								fSeccionReversion.setSeccion(new String(ch, start, length));
							}
						}
						nombreSeccion = false;
					}
					
					if (inicioTarea) {
						if(inicioSeccion == 0) {
							fSubSeccionReversion = new FSubSeccionReversion();
							System.out.println("inicioTarea : " + new String(ch, start, length));
							inicioSeccion=1;
						}else {
							if(inicioSeccion==1) {
								fSeccionReversion.setListaSubseccion(fSubSeccionReversion);
								fSubSeccionReversion = new FSubSeccionReversion();
								System.out.println("inicioTarea : " + new String(ch, start, length));
							}
						}
						inicioTarea = false;
					}
					
					
					if (idSubSeccionReversion) {
						System.out.println("idSubSeccionReversion : " + new String(ch, start, length));
						fSubSeccionReversion.setIdSubseccionReversion(new String(ch, start, length));
						idSubSeccionReversion = false;
					}

					if (tareaSubSeccion) {
						System.out.println("tareaSubSeccion : " + new String(ch, start, length));
						fSubSeccionReversion.setTarea(new String(ch, start, length));
						tareaSubSeccion = false;
					}

					if (palabra && new String(ch, start, length).length()>2 && inicioReversion == 1) {
						System.out.println("Font : " + new String(ch, start, length));
						fSubSeccionReversion.setPalabras(new String(ch, start, length));
						inicioSubseccion = 1;
						palabra = false;
					}
					else{
						palabra = false;
					}

			
					if (cierreSeccion) {
						fSeccionReversion.setListaSubseccion(fSubSeccionReversion);
						fReversionServidor.setListaSeccion(fSeccionReversion);
						listaReversion.add(fReversionServidor);
						System.out.println("cierreReversion : " + new String(ch, start, length));
						inicioReversion = 0;
						inicioSeccion = 0;
						inicioSubseccion =0;
						cierreSeccion = false;
					}

				}

			};

			saxParser.parse(f, handler);
//			saxParser.parse("C:\\Users\\achapona\\Desktop\\MIS-PLANTILLA.xml", handler); no incluir
//			System.out.println(listaReversion);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
