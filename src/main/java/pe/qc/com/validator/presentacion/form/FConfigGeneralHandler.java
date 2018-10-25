package pe.qc.com.validator.presentacion.form;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FConfigGeneralHandler {

	private FConfiguracionGeneral fConfiguracionGeneral;
	private FSeccionConfiguracionGeneral fSeccionConfiguracionGeneral;
	private FGrupoDominios fGrupoDominios;
	private FDirectoryCreacionUsuario fDirectoryCreacionUsuario;
	private List<FSeccionConfiguracionGeneral> listaFSeccionConfiguracionGeneral;
	private List<FGrupoDominios> listaFGrupoDominios;
	private List<FDirectoryCreacionUsuario> listaFDirectoryCreacionUsuario;
	public FConfiguracionGeneral getfConfiguracionGeneral() {
		return fConfiguracionGeneral;
	}

	public void setfConfiguracionGeneral(FConfiguracionGeneral fConfiguracionGeneral) {
		this.fConfiguracionGeneral = fConfiguracionGeneral;
	}

	public void convertirHandler(File f) {
		fConfiguracionGeneral = new FConfiguracionGeneral();
		listaFSeccionConfiguracionGeneral = null;
		
		try {
			// Obtenir la configuration du sax parser
			SAXParserFactory spfactory = SAXParserFactory.newInstance();
			// Obtenir une instance de l'objet parser
			SAXParser saxParser = spfactory.newSAXParser();

			/*
			* les trois méthodes sont déclarées dans le corp du DefaltHandler
			*/
			DefaultHandler handler = new DefaultHandler() {
				
				int comenzarCarga = 0;
				
				boolean inicioLista = false;
				boolean idSeccionConfiguracionGeneral = false;
				boolean nombreSeccionConfiguracionGeneral = false;
				boolean palabra = false;
				
				boolean loginProd = false;
				boolean loginCert = false;
				boolean loginDesa = false;
				boolean usuarioProd = false;
				boolean usuarioCert = false;
				boolean usuarioDesa = false;
				boolean descripcionProd = false;
				boolean descripcionCert = false;
				boolean descripcionDesa = false;
				
				
				boolean nombreGrupo = false;
				boolean descripcion = false;
				boolean liderUsuario = false;
				boolean usuariosAutorizados = false;
				boolean notasAdicionales = false;
				
				
				boolean cierreSeccion = false;
				
				int inicio = 0;
				
				/*
				 * cette méthode est invoquée à chaque fois que parser rencontre
				 * une balise ouvrante '<'
				 */
				public void startElement(String uri, String localName, String qName, Attributes attributes)
						throws SAXException {
					
					if (qName.equalsIgnoreCase("my:ListaConfGen")) {
						inicioLista = true;
					}
					
					if (qName.equalsIgnoreCase("my:idConDom")) {
						idSeccionConfiguracionGeneral = true;
					}

					if (qName.equalsIgnoreCase("my:cmbConDomCon")) {
						nombreSeccionConfiguracionGeneral = true;
					}

					/*palabras*/
					if (qName.equalsIgnoreCase("font") || qName.equalsIgnoreCase("strong") || qName.equalsIgnoreCase("div")) {
						palabra = true;
					}

					
					
					/*----------------------------------------*/
					if (qName.equalsIgnoreCase("my:txtConActPro1")) {
						loginProd = true;
					}
					
					if (qName.equalsIgnoreCase("my:txtConActCer1")) {
						loginCert = true;
					}

					if (qName.equalsIgnoreCase("my:txtConActDes1")) {
						loginDesa = true;
					}

					if (qName.equalsIgnoreCase("my:txtConActPro2")) {
						usuarioProd = true;
					}
					
					if (qName.equalsIgnoreCase("my:txtConActCer2")) {
						usuarioCert = true;
					}
					
					if (qName.equalsIgnoreCase("my:txtConActDes2")) {
						usuarioDesa = true;
					}
					
					if (qName.equalsIgnoreCase("my:txtConActPro3")) {
						descripcionProd = true;
					}
					if (qName.equalsIgnoreCase("my:txtConActCer3")) {
						descripcionCert = true;
					}
					if (qName.equalsIgnoreCase("my:txtConActDes3")) {
						descripcionDesa = true;
					}
					
					
					/*-----------------------------------------------------*/
					
					if (qName.equalsIgnoreCase("my:txtConGrpNom")) {
						nombreGrupo = true;
					}
					
					if (qName.equalsIgnoreCase("my:txtConGrpDes")) {
						descripcion = true;
					}
					if (qName.equalsIgnoreCase("my:txtConGrpLid")) {
						liderUsuario = true;
					}
					if (qName.equalsIgnoreCase("my:txtConGrpAut")) {
						usuariosAutorizados = true;
					}
					if (qName.equalsIgnoreCase("my:txtConGrpNot")) {
						notasAdicionales = true;
					}
					
					
					if (qName.equalsIgnoreCase("my:version")) {
						cierreSeccion = true;
					}
					
				}
				
				/*
				 * cette méthode est invoquée à chaque fois que parser rencontre
				 * une balise fermante '>'
				 */
				
				public void endElement(String uri, String localName, String qName) throws SAXException {
					
					if (qName.equalsIgnoreCase("my:ListaConfGen")) {
						inicioLista = false;
					}
					
					if (qName.equalsIgnoreCase("my:idConDom")) {
						idSeccionConfiguracionGeneral = false;
					}

					if (qName.equalsIgnoreCase("my:cmbConDomCon")) {
						nombreSeccionConfiguracionGeneral = false;
					}

					/*palabras*/
					if (qName.equalsIgnoreCase("font") || qName.equalsIgnoreCase("strong") || qName.equalsIgnoreCase("div")) {
						palabra = false;
					}

					
					
					/*----------------------------------------*/
					if (qName.equalsIgnoreCase("my:txtConActPro1")) {
						loginProd = false;
					}
					
					if (qName.equalsIgnoreCase("my:txtConActCer1")) {
						loginCert = false;
					}

					if (qName.equalsIgnoreCase("my:txtConActDes1")) {
						loginDesa = false;
					}

					if (qName.equalsIgnoreCase("my:txtConActPro2")) {
						usuarioProd = false;
					}
					
					if (qName.equalsIgnoreCase("my:txtConActCer2")) {
						usuarioCert = false;
					}
					
					if (qName.equalsIgnoreCase("my:txtConActDes2")) {
						usuarioDesa = false;
					}
					
					if (qName.equalsIgnoreCase("my:txtConActPro3")) {
						descripcionProd = false;
					}
					if (qName.equalsIgnoreCase("my:txtConActCer3")) {
						descripcionCert = false;
					}
					if (qName.equalsIgnoreCase("my:txtConActDes3")) {
						descripcionDesa = false;
					}
					
					
					/*-----------------------------------------------------*/
					
					if (qName.equalsIgnoreCase("my:txtConGrpNom")) {
						nombreGrupo = false;
					}
					
					if (qName.equalsIgnoreCase("my:txtConGrpDes")) {
						descripcion = false;
					}
					if (qName.equalsIgnoreCase("my:txtConGrpLid")) {
						liderUsuario = false;
					}
					if (qName.equalsIgnoreCase("my:txtConGrpAut")) {
						usuariosAutorizados = false;
					}
					if (qName.equalsIgnoreCase("my:txtConGrpNot")) {
						notasAdicionales = false;
					}
					
					
					if (qName.equalsIgnoreCase("my:version")) {
						cierreSeccion = false;
					}	
				}
				
				/* imprime les données stockées entre '<' et '>' */
				public void characters(char ch[], int start, int length) throws SAXException {

					if(inicioLista) {
						comenzarCarga = 1;
						System.out.println("inicioLista : " + new String(ch, start, length));
						if(listaFSeccionConfiguracionGeneral==null) {
							fSeccionConfiguracionGeneral = new  FSeccionConfiguracionGeneral();
							listaFSeccionConfiguracionGeneral = new ArrayList<>();
							inicio = 1;
						}else {
							fSeccionConfiguracionGeneral.setListaFDirectoryCreacionUsuario(listaFDirectoryCreacionUsuario);
							fSeccionConfiguracionGeneral.setListaFGrupoDominios(listaFGrupoDominios);
							listaFSeccionConfiguracionGeneral.add(fSeccionConfiguracionGeneral);
							fSeccionConfiguracionGeneral = new FSeccionConfiguracionGeneral();
						}
						
						inicioLista = false;
					}
					
					if (idSeccionConfiguracionGeneral) {
						System.out.println("idSeccionConfiguracionGeneral : " + new String(ch, start, length));
						listaFDirectoryCreacionUsuario = new ArrayList<>();
						listaFGrupoDominios = new ArrayList<>();
						fSeccionConfiguracionGeneral.setIdSeccionConfiguracionGeneral(new String(ch, start, length));
						idSeccionConfiguracionGeneral = false;
					}
					if (nombreSeccionConfiguracionGeneral) {
						System.out.println("nombreSeccionConfiguracionGeneral : " + new String(ch, start, length));
						fSeccionConfiguracionGeneral.setNombreSeccionConfiguracionGeneral(new String(ch, start, length));
						nombreSeccionConfiguracionGeneral = false;
					}
					if (palabra && new String(ch, start, length).length()>2) {
						System.out.println("palabra : " + new String(ch, start, length));
						if(comenzarCarga!=0) {
							if(inicio==1) {
								fSeccionConfiguracionGeneral.setPalabras(new String(ch, start, length));
							}
						}
						palabra = false;
					}else{
						palabra = false;
					}
					if (loginProd) {
						System.out.println("loginProd : " + new String(ch, start, length));
						fDirectoryCreacionUsuario = new FDirectoryCreacionUsuario();
						fDirectoryCreacionUsuario.setLoginProd(new String(ch, start, length));
						loginProd = false;
					}
					if (loginCert) {
						System.out.println("loginCert : " + new String(ch, start, length));
						fDirectoryCreacionUsuario.setLoginCert(new String(ch, start, length));
						loginCert = false;
					}
					if (loginDesa) {
						System.out.println("loginDesa : " + new String(ch, start, length));
						fDirectoryCreacionUsuario.setLoginDesa(new String(ch, start, length));
						loginDesa = false;
					}
					if (usuarioProd) {
						System.out.println("usuarioProd : " + new String(ch, start, length));
						fDirectoryCreacionUsuario.setUsuarioProd(new String(ch, start, length));
						usuarioProd = false;
					}
					if (usuarioCert) {
						System.out.println("usuarioCert : " + new String(ch, start, length));
						fDirectoryCreacionUsuario.setUsuarioCert(new String(ch, start, length));
						usuarioCert = false;
					}
					if (usuarioDesa) {
						System.out.println("usuarioDesa : " + new String(ch, start, length));
						fDirectoryCreacionUsuario.setUsuarioDesa(new String(ch, start, length));
						usuarioDesa = false;
					}
					if (descripcionProd) {
						System.out.println("descripcionProd : " + new String(ch, start, length));
						fDirectoryCreacionUsuario.setDescripcionProd(new String(ch, start, length));
						descripcionProd = false;
					}
					if (descripcionCert) {
						System.out.println("descripcionCert : " + new String(ch, start, length));
						fDirectoryCreacionUsuario.setDescripcionCert(new String(ch, start, length));
						descripcionCert = false;
					}
					if (descripcionDesa) {
						System.out.println("descripcionDesa : " + new String(ch, start, length));
						fDirectoryCreacionUsuario.setDescripcionDesa(new String(ch, start, length));
						listaFDirectoryCreacionUsuario.add(fDirectoryCreacionUsuario);
						descripcionDesa = false;
					}
					
					if (nombreGrupo) {
						fGrupoDominios = new FGrupoDominios();
						System.out.println("nombreGrupo : " + new String(ch, start, length));
						fGrupoDominios.setNombreGrupo(new String(ch, start, length));
						nombreGrupo = false;
					}
					if (descripcion) {
						System.out.println("descripcion : " + new String(ch, start, length));
						fGrupoDominios.setDescripcion(new String(ch, start, length));
						descripcion = false;
					}
					if (liderUsuario) {
						System.out.println("liderUsuario : " + new String(ch, start, length));
						fGrupoDominios.setLiderUsuario(new String(ch, start, length));
						liderUsuario = false;
					}
					if (usuariosAutorizados) {
						System.out.println("usuariosAutorizados : " + new String(ch, start, length));
						fGrupoDominios.setUsuariosAutorizados(new String(ch, start, length));
						usuariosAutorizados = false;
					}
					if (notasAdicionales) {
						System.out.println("notasAdicionales : " + new String(ch, start, length));
						fGrupoDominios.setNotasAdicionales(new String(ch, start, length));
						listaFGrupoDominios.add(fGrupoDominios);
						notasAdicionales = false;
					}
					
					if (cierreSeccion) {
						if(comenzarCarga!=0){
							System.out.println("cierreSeccionAAAAAAAAAAAAAAAA : " + new String(ch, start, length));
							fSeccionConfiguracionGeneral.setListaFDirectoryCreacionUsuario(listaFDirectoryCreacionUsuario);
							fSeccionConfiguracionGeneral.setListaFGrupoDominios(listaFGrupoDominios);
							listaFSeccionConfiguracionGeneral.add(fSeccionConfiguracionGeneral);
							fConfiguracionGeneral.setListaFSeccionConfiguracionGeneral(listaFSeccionConfiguracionGeneral);
						}
						cierreSeccion = false;
					}
					
				}
			};
			saxParser.parse(f, handler);
//			saxParser.parse("C:\\Users\\achapona\\Desktop\\MIS-PLANTILLA.xml", handler);
//			System.out.println(fConfiguracionGeneral);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
