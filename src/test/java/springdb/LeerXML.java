package springdb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LeerXML {

	static FConfiguracionServidor fConfiguracionServidor;
	static FSeccion fSeccion;
	static FSubSeccion fSubSeccion;
	static FSubTabla fSubTabla;
	static FBalanceCarga fBalanceCargaDes;
	static FBalanceCarga fBalanceCargaCer;
	static FBalanceCarga fBalanceCargaPro;
	static List<FConfiguracionServidor> listaConfiguracion;
	static List<FSeccion> listaSeccion;
	static List<FSubSeccion> listaSubSeccion;
	static List<FBalanceCarga> listaBalanceCargaDes;
	static List<FBalanceCarga> listaBalanceCargaCer;
	static List<FBalanceCarga> listaBalanceCargaPro;
	static List<FSubTabla> listaSubtabla;

	public static void main(String[] args) {

		listaConfiguracion = new ArrayList<>();

		try {
			// Obtenir la configuration du sax parser
			SAXParserFactory spfactory = SAXParserFactory.newInstance();
			// Obtenir une instance de l'objet parser
			SAXParser saxParser = spfactory.newSAXParser();

			/*
			 * les trois méthodes sont déclarées dans le corp du DefaltHandler
			 */
			DefaultHandler handler = new DefaultHandler() {

				boolean idConfiguracion = false;
				boolean listaServidor = false;
				boolean idSeccion = false;
				boolean nombreSeccion = false;
				
				boolean palabra = false;
				
				boolean idSubSeccion = false;
				boolean tareaSeccion = false;
				boolean subTareaSeccion = false;
				boolean departamentoSeccion = false;
				
				boolean rutaW = false;
				boolean descripcionW = false;
				boolean permisosNTFSW = false;
				boolean permisosExtendidosW = false;
				
				boolean rutaAL = false;
				boolean descripcionAL = false;
				boolean permisosExtendidosAIX = false;
				
				boolean rutaFisicaShyNF = false;
				boolean nombreCarpetaComShyNF = false;
				boolean descripcionShyNF = false;
				boolean usuarioAutorizadorShyNF = false;
				boolean permisosShyNF = false;
				
				boolean usuarioCL = false;
				boolean decripcionCL = false;
				boolean grupoPrimarioCL = false;
				boolean grupoSecundarioCL = false;
				boolean sentenciaCL = false;
				
				boolean puertoApliBL = false;
				boolean persistenciaBL = false;
				boolean tiempoPersBL = false;
				boolean nombreDes = false;
				boolean direccionDes = false;
				boolean urlDes = false;
				
				boolean nombreServidorDes = false;
				boolean direccionIpDes = false;
				boolean urlDesarrollo = false;
				
				boolean nombreCer = false;
				boolean direccionCer = false;
				boolean urlCer = false;
				
				boolean nombreServidorCer = false;
				boolean direccionIpCer = false;
				boolean urlCertificacion = false;
				
				boolean nombrePro = false;
				boolean direccionPro = false;
				boolean urlPro = false;
				
				boolean nombreServidorPro = false;
				boolean direccionIpPro = false;
				boolean urlProduccion = false;
				
				boolean numeroOT = false;
				boolean ordenTrabajoOT = false;
				boolean descripcionOT = false;
				boolean tipoOrdenOT = false;
				
				boolean ambienteEjecutarBD = false;
				boolean baseDatosBD = false;
				boolean usuarioBD = false;
				boolean comandoBD = false;
				boolean adecuacionesBD = false;
				
				boolean nombreWwbSite = false;
				boolean accionWebSite = false;
				
				boolean nombreAppPol = false;
				boolean accionAppPol = false;
				
				boolean comandoIIS = false;
				
				boolean nombreServicioIA = false;
				boolean usuarioIA = false;
				boolean estadoIA = false;
				
				boolean nombreServicioRA = false;
				boolean accionRA = false;
				
				boolean inicioTarea = false;
				boolean inicioListaSubTabla = false;
				boolean cierreListaSubTabla = false;
				boolean inicioListaBalanceDes= false;
				boolean inicioListaBalanceCer= false;
				boolean inicioListaBalancePro= false;
				boolean cierreSeccion = false;

				/*
				 * cette méthode est invoquée à chaque fois que parser rencontre
				 * une balise ouvrante '<'
				 */
				public void startElement(String uri, String localName, String qName, Attributes attributes)
						throws SAXException {

					if (qName.equalsIgnoreCase("my:idConSer")) {
						idConfiguracion = true;
					}

					if (qName.equalsIgnoreCase("my:cmbConSerNom")) {
						listaServidor = true;
					}

					if (qName.equalsIgnoreCase("my:idConSerSec")) {
						idSeccion = true;
					}

					if (qName.equalsIgnoreCase("my:cmbConSerSec")) {
						nombreSeccion = true;
					}
					
					if (qName.equalsIgnoreCase("my:Tareas")) {
						inicioTarea = true;
					}
					
					/*palabras*/
					if (qName.equalsIgnoreCase("font") || qName.equalsIgnoreCase("strong")) {
						palabra = true;
					}

					if (qName.equalsIgnoreCase("my:idConSerTar")) {
						idSubSeccion = true;
					}

					if (qName.equalsIgnoreCase("my:cmbConSerTar")) {
						tareaSeccion = true;
					}

					if (qName.equalsIgnoreCase("my:cmbConSerTarSub")) {
						subTareaSeccion = true;
					}
					
					if (qName.equalsIgnoreCase("my:txtConSerDep")) {
						departamentoSeccion = true;
					}
					
					if (qName.equalsIgnoreCase("my:BalanceoCargas")) {
						inicioListaSubTabla = true;
					}
					
					/*CREACION DE DIRECTORIOS WINDOWS*/
					if (qName.equalsIgnoreCase("my:txtConCreRut_2")) {
						rutaW = true;
					}
					if (qName.equalsIgnoreCase("my:txtConCreDes_2")) {
						descripcionW = true;
					}
					if (qName.equalsIgnoreCase("my:txtPermNTFS")) {
						permisosNTFSW = true;
					}
					if (qName.equalsIgnoreCase("my:txtConCreExt_2")) {
						permisosExtendidosW = true;
					}
					
					/*CREACION DE DIRECTORIOS AIX*/
					if (qName.equalsIgnoreCase("my:txtConCreRut")) {
						rutaAL = true;
					}
					if (qName.equalsIgnoreCase("my:txtConCreDes")) {
						descripcionAL = true;
					}
					if (qName.equalsIgnoreCase("my:txtConCreExt")) {
						permisosExtendidosAIX = true;
					}
					
					/*CREACION DE DIRECTORIOS SHARE*/
					if (qName.equalsIgnoreCase("my:txtConShaRut")) {
						rutaFisicaShyNF = true;
					}
					if (qName.equalsIgnoreCase("my:txtConShaNom")) {
						nombreCarpetaComShyNF = true;
					}
					if (qName.equalsIgnoreCase("my:txtConShaDes")) {
						descripcionShyNF = true;
					}
					if (qName.equalsIgnoreCase("my:txtConShaUsu")) {
						usuarioAutorizadorShyNF = true;
					}
					if (qName.equalsIgnoreCase("my:txtConShaPer")) {
						permisosShyNF = true;
					}
					
					/*CREACION DE CUENTAS LOCALES*/
					if (qName.equalsIgnoreCase("my:txtConLocUsu")) {
						usuarioCL = true;
					}
					if (qName.equalsIgnoreCase("my:txtConLocDes")) {
						decripcionCL = true;
					}
					if (qName.equalsIgnoreCase("my:txtConLocGrp")) {
						grupoPrimarioCL = true;
					}
					if (qName.equalsIgnoreCase("my:txtConLocSec")) {
						grupoSecundarioCL = true;
					}
					if (qName.equalsIgnoreCase("my:txtConLocSen")) {
						sentenciaCL = true;
					}
					
					/*BALANCE DE CARGAS*/
					if (qName.equalsIgnoreCase("my:txtConSerBalPrt")) {
						puertoApliBL = true;
					}
					if (qName.equalsIgnoreCase("my:cmbConSerBalPer")) {
						persistenciaBL = true;
					}
					if (qName.equalsIgnoreCase("my:txtConSerBalTmp")) {
						tiempoPersBL = true;
					}
					if (qName.equalsIgnoreCase("my:txtConSerBalDesBNom")) {
						nombreDes = true;
					}
					if (qName.equalsIgnoreCase("my:txtConSerBalDesBDir")) {
						direccionDes = true;
					}
					if (qName.equalsIgnoreCase("my:txtConSerBalDesBUrl")) {
						urlDes = true;
					}
					
					if (qName.equalsIgnoreCase("my:BDesa")) {
						inicioListaBalanceDes = true;
					}
					
					/*BALANCE DE CARGAS -- BALANCE DESARROLLO*/
					if (qName.equalsIgnoreCase("my:txtConSerBalDesNom")) {
						nombreServidorDes = true;
					}
					if (qName.equalsIgnoreCase("my:txtConSerBalDesDir")) {
						direccionIpDes = true;
					}
					if (qName.equalsIgnoreCase("my:txtConSerBalDesUrl")) {
						urlDesarrollo = true;
					}
					/*------------------------------------------*/
					
					
					if (qName.equalsIgnoreCase("my:txtConSerBalCerBNom")) {
						nombreCer = true;
					}
					if (qName.equalsIgnoreCase("my:txtConSerBalCerBDir")) {
						direccionCer = true;
					}
					if (qName.equalsIgnoreCase("my:txtConSerBalCerBUrl")) {
						urlCer = true;
					}
					
					if (qName.equalsIgnoreCase("my:BCert")) {
						inicioListaBalanceCer = true;
					}
					
					/*BALANCE DE CARGAS -- BALANCE CERTIFICACION*/
					if (qName.equalsIgnoreCase("my:txtConSerBalCerNom")) {
						nombreServidorCer = true;
					}
					if (qName.equalsIgnoreCase("my:txtConSerBalCerDir")) {
						direccionIpCer = true;
					}
					if (qName.equalsIgnoreCase("my:txtConSerBalCerUrl")) {
						urlCertificacion = true;
					}
					/*------------------------------------------*/
					
					
					if (qName.equalsIgnoreCase("my:txtConSerBalProBNom")) {
						nombrePro = true;
					}
					if (qName.equalsIgnoreCase("my:txtConSerBalProBDir")) {
						direccionPro = true;
					}
					if (qName.equalsIgnoreCase("my:txtConSerBalProBUrl")) {
						urlPro = true;
					}
					
					if (qName.equalsIgnoreCase("my:BProd")) {
						inicioListaBalancePro = true;
					}
					
					/*BALANCE DE CARGAS -- BALANCE PRODUCCION*/
					if (qName.equalsIgnoreCase("my:txtConSerBalProNom")) {
						nombreServidorPro = true;
					}
					if (qName.equalsIgnoreCase("my:txtConSerBalProDir")) {
						direccionIpPro = true;
					}
					if (qName.equalsIgnoreCase("my:txtConSerBalProUrl")) {
						urlProduccion = true;
					}
					/*------------------------------------------*/
					
					
					/*OT's*/
					if (qName.equalsIgnoreCase("my:txtNro")) {
						numeroOT = true;
					}
					if (qName.equalsIgnoreCase("my:txtNroOrden")) {
						ordenTrabajoOT = true;
					}
					if (qName.equalsIgnoreCase("my:campo40")) {
						descripcionOT = true;
					}
					if (qName.equalsIgnoreCase("my:campo41")) {
						tipoOrdenOT = true;
					}
					/*------------------------------------------------*/
					
					/*EJECUTAR BD*/
					if (qName.equalsIgnoreCase("my:cmbNombreServidor")) {
						ambienteEjecutarBD = true;
					}
					if (qName.equalsIgnoreCase("my:txtNombreBD")) {
						baseDatosBD = true;
					}
					if (qName.equalsIgnoreCase("my:txtUsuario")) {
						usuarioBD = true;
					}
					if (qName.equalsIgnoreCase("my:txtComando")) {
						comandoBD = true;
					}
					if (qName.equalsIgnoreCase("my:campo57")) {
						adecuacionesBD = true;
					}
					/*------------------------------------------------*/
					
					/*ADMINISTRACION DE SEVICIOS WEB - BAJA Y SUBIDA DE SERVICIOS*/
					if (qName.equalsIgnoreCase("my:campo42")) {
						nombreWwbSite = true;
					}
					if (qName.equalsIgnoreCase("my:campo54")) {
						accionWebSite = true;
					}
					/*------------------------------------------------*/
					
					/*ADMINISTRACION DE SEVICIOS WEB - BAJA Y SUBIDA POOL*/
					if (qName.equalsIgnoreCase("my:campo43")) {
						nombreAppPol = true;
					}
					if (qName.equalsIgnoreCase("my:campo55")) {
						accionAppPol = true;
					}
					/*------------------------------------------------*/
					
					
					/*ADMINISTRACION DE SEVICIOS WEB - IIS*/
					if (qName.equalsIgnoreCase("my:campo44")) {
						comandoIIS = true;
					}
					/*------------------------------------------------*/
					
					
					/*I - APLICACION - CONFIGURACION DEL SERVICIOL*/
					if (qName.equalsIgnoreCase("my:campo49")) {
						nombreServicioIA = true;
					}
					if (qName.equalsIgnoreCase("my:campo50")) {
						usuarioIA = true;
					}
					if (qName.equalsIgnoreCase("my:campo51")) {
						estadoIA = true;
					}
					/*------------------------------------------------*/
					
					
					/*I -APLICACION - SUBIR Y BAJAR SEVICIOS*/
					if (qName.equalsIgnoreCase("my:campo45")) {
						nombreServicioRA = true;
					}
					if (qName.equalsIgnoreCase("my:campo46")) {
						accionRA = true;
					}
					/*------------------------------------------------*/
					
					
					if (qName.equalsIgnoreCase("my:grupo17")) {
						cierreListaSubTabla = true;
					}
					if (qName.equalsIgnoreCase("my:campo29")) {
						cierreSeccion = true;
					}

				}

				/*
				 * cette méthode est invoquée à chaque fois que parser rencontre
				 * une balise fermante '>'
				 */
				public void endElement(String uri, String localName, String qName) throws SAXException {

					if (qName.equalsIgnoreCase("my:idConSer")) {
						idConfiguracion = false;
					}

					if (qName.equalsIgnoreCase("my:cmbConSerNom")) {
						listaServidor = false;
					}

					if (qName.equalsIgnoreCase("my:idConSerSec")) {
						idSeccion = false;
					}

					if (qName.equalsIgnoreCase("my:cmbConSerSec")) {
						nombreSeccion = false;
					}
					
					if (qName.equalsIgnoreCase("my:Tareas")) {
						inicioTarea = false;
					}
					
					/*palabras*/
					if (qName.equalsIgnoreCase("font") || qName.equalsIgnoreCase("strong")) {
						palabra = false;
					}

					if (qName.equalsIgnoreCase("my:idConSerTar")) {
						idSubSeccion = false;
					}

					if (qName.equalsIgnoreCase("my:cmbConSerTar")) {
						tareaSeccion = false;
					}

					if (qName.equalsIgnoreCase("my:cmbConSerTarSub")) {
						subTareaSeccion = false;
					}
					
					if (qName.equalsIgnoreCase("my:txtConSerDep")) {
						departamentoSeccion = false;
					}
					
					if (qName.equalsIgnoreCase("my:BalanceoCargas")) {
						inicioListaSubTabla = false;
					}
					
					/*CREACION DE DIRECTORIOS WINDOWS*/
					if (qName.equalsIgnoreCase("my:txtConCreRut_2")) {
						rutaW = false;
					}
					if (qName.equalsIgnoreCase("my:txtConCreDes_2")) {
						descripcionW = false;
					}					
					if (qName.equalsIgnoreCase("my:txtPermNTFS")) {
						permisosNTFSW = false;
					}					
					if (qName.equalsIgnoreCase("my:txtConCreExt_2")) {
						permisosExtendidosW = false;
					}
					
					/*CREACION DE DIRECTORIOS AIX*/
					if (qName.equalsIgnoreCase("my:txtConCreRut")) {
						rutaAL = false;
					}
					if (qName.equalsIgnoreCase("my:txtConCreDes")) {
						descripcionAL = false;
					}					
					if (qName.equalsIgnoreCase("my:txtConCreExt")) {
						permisosExtendidosAIX = false;
					}
					
					/*CREACION DE DIRECTORIOS SHARE*/
					if (qName.equalsIgnoreCase("my:txtConShaRut")) {
						rutaFisicaShyNF = false;
					}
					if (qName.equalsIgnoreCase("my:txtConShaNom")) {
						nombreCarpetaComShyNF = false;
					}					
					if (qName.equalsIgnoreCase("my:txtConShaDes")) {
						descripcionShyNF = false;
					}					
					if (qName.equalsIgnoreCase("my:txtConShaUsu")) {
						usuarioAutorizadorShyNF = false;
					}
					if (qName.equalsIgnoreCase("my:txtConShaPer")) {
						permisosShyNF = false;
					}
					
					/*CREACION DE CUENTAS LOCALES*/
					if (qName.equalsIgnoreCase("my:txtConLocUsu")) {
						usuarioCL = false;
					}
					if (qName.equalsIgnoreCase("my:txtConLocDes")) {
						decripcionCL = false;
					}					
					if (qName.equalsIgnoreCase("my:txtConLocGrp")) {
						grupoPrimarioCL = false;
					}					
					if (qName.equalsIgnoreCase("my:txtConLocSec")) {
						grupoSecundarioCL = false;
					}
					if (qName.equalsIgnoreCase("my:txtConLocSen")) {
						sentenciaCL = false;
					}
					
					/*BALANCE DE CARGAS*/
					if (qName.equalsIgnoreCase("my:txtConSerBalPrt")) {
						puertoApliBL = false;
					}
					if (qName.equalsIgnoreCase("my:cmbConSerBalPer")) {
						persistenciaBL = false;
					}					
					if (qName.equalsIgnoreCase("my:txtConSerBalTmp")) {
						tiempoPersBL = false;
					}					
					if (qName.equalsIgnoreCase("my:txtConSerBalDesBNom")) {
						nombreDes = false;
					}
					if (qName.equalsIgnoreCase("my:txtConSerBalDesBDir")) {
						direccionDes = false;
					}
					if (qName.equalsIgnoreCase("my:txtConSerBalDesBUrl")) {
						urlDes = false;
					}
					
					if (qName.equalsIgnoreCase("my:BDesa")) {
						inicioListaBalanceDes = false;
					}
					
					/*BALANCE DE CARGAS -- BALANCE DESARROLLO*/
					if (qName.equalsIgnoreCase("my:txtConSerBalDesNom")) {
						nombreServidorDes = false;
					}
					if (qName.equalsIgnoreCase("my:txtConSerBalDesDir")) {
						direccionIpDes = false;
					}
					if (qName.equalsIgnoreCase("my:txtConSerBalDesUrl")) {
						urlDesarrollo = false;
					}
					/*-------------------------------------------------*/
					
					if (qName.equalsIgnoreCase("my:txtConSerBalCerBNom")) {
						nombreCer = false;
					}
					if (qName.equalsIgnoreCase("my:txtConSerBalCerBDir")) {
						direccionCer = false;
					}
					if (qName.equalsIgnoreCase("my:txtConSerBalCerBUrl")) {
						urlCer = false;
					}
					
					if (qName.equalsIgnoreCase("my:BCert")) {
						inicioListaBalanceCer = false;
					}
					
					/*BALANCE DE CARGAS -- BALANCE CERTIFICACION*/
					if (qName.equalsIgnoreCase("my:txtConSerBalCerNom")) {
						nombreServidorCer = false;
					}
					if (qName.equalsIgnoreCase("my:txtConSerBalCerDir")) {
						direccionIpCer = false;
					}
					if (qName.equalsIgnoreCase("my:txtConSerBalCerUrl")) {
						urlCertificacion = false;
					}
					/*------------------------------------------*/
					
					
					if (qName.equalsIgnoreCase("my:txtConSerBalProBNom")) {
						nombrePro = false;
					}
					if (qName.equalsIgnoreCase("my:txtConSerBalProBDir")) {
						direccionPro = false;
					}
					if (qName.equalsIgnoreCase("my:txtConSerBalProBUrl")) {
						urlPro = false;
					}
					
					if (qName.equalsIgnoreCase("my:BProd")) {
						inicioListaBalancePro = false;
					}
					
					/*BALANCE DE CARGAS -- BALANCE PRODUCCION*/
					if (qName.equalsIgnoreCase("my:txtConSerBalProNom")) {
						nombreServidorPro = false;
					}
					if (qName.equalsIgnoreCase("my:txtConSerBalProDir")) {
						direccionIpPro = false;
					}
					if (qName.equalsIgnoreCase("my:txtConSerBalProUrl")) {
						urlProduccion = false;
					}
					/*------------------------------------------*/
					
					/*OT's*/
					if (qName.equalsIgnoreCase("my:txtNro")) {
						numeroOT = false;
					}
					if (qName.equalsIgnoreCase("my:txtNroOrden")) {
						ordenTrabajoOT = false;
					}
					if (qName.equalsIgnoreCase("my:campo40")) {
						descripcionOT = false;
					}
					if (qName.equalsIgnoreCase("my:campo41")) {
						tipoOrdenOT = false;
					}
					/*------------------------------------------------*/
					
					/*EJECUTAR BD*/
					if (qName.equalsIgnoreCase("my:cmbNombreServidor")) {
						ambienteEjecutarBD = false;
					}
					if (qName.equalsIgnoreCase("my:txtNombreBD")) {
						baseDatosBD = false;
					}
					if (qName.equalsIgnoreCase("my:txtUsuario")) {
						usuarioBD = false;
					}
					if (qName.equalsIgnoreCase("my:txtComando")) {
						comandoBD = false;
					}
					if (qName.equalsIgnoreCase("my:campo57")) {
						adecuacionesBD = false;
					}
					/*------------------------------------------------*/
					
					/*ADMINISTRACION DE SEVICIOS WEB - BAJA Y SUBIDA DE SERVICIOS*/
					if (qName.equalsIgnoreCase("my:campo42")) {
						nombreWwbSite = false;
					}
					if (qName.equalsIgnoreCase("my:campo54")) {
						accionWebSite = false;
					}
					/*------------------------------------------------*/
					
					
					/*ADMINISTRACION DE SEVICIOS WEB - BAJA Y SUBIDA POOL*/
					if (qName.equalsIgnoreCase("my:campo43")) {
						nombreAppPol = false;
					}
					if (qName.equalsIgnoreCase("my:campo55")) {
						accionAppPol = false;
					}
					/*------------------------------------------------*/
					
					/*ADMINISTRACION DE SEVICIOS WEB - IIS*/
					if (qName.equalsIgnoreCase("my:campo44")) {
						comandoIIS = false;
					}
					/*------------------------------------------------*/
					
					
					/*I - APLICACION - CONFIGURACION DEL SERVICIOS*/
					if (qName.equalsIgnoreCase("my:campo49")) {
						nombreServicioIA = false;
					}
					if (qName.equalsIgnoreCase("my:campo50")) {
						usuarioIA = false;
					}
					if (qName.equalsIgnoreCase("my:campo51")) {
						estadoIA = false;
					}
					/*------------------------------------------------*/
					
					
					/*I -APLICACION - SUBIR Y BAJAR SEVICIOS*/
					if (qName.equalsIgnoreCase("my:campo45")) {
						nombreServicioRA = false;
					}
					if (qName.equalsIgnoreCase("my:campo46")) {
						accionRA = false;
					}
					/*------------------------------------------------*/
					
					
					if (qName.equalsIgnoreCase("my:grupo17")) {
						cierreListaSubTabla = false;
					}
					if (qName.equalsIgnoreCase("my:campo29")) {
						cierreSeccion = false;
					}

				}

				/* imprime les données stockées entre '<' et '>' */
				public void characters(char ch[], int start, int length) throws SAXException {

					if (idConfiguracion) {
						System.out.println("idConfiguracion : " + new String(ch, start, length));
						fConfiguracionServidor = new FConfiguracionServidor();
						fConfiguracionServidor.setIdConfiguracionServidor(new String(ch, start, length));
						idConfiguracion = false;
					}

					if (listaServidor) {
						System.out.println("listaServidor : " + new String(ch, start, length));
						fConfiguracionServidor.setListaServidor(new String(ch, start, length));
						listaServidor = false;
					}

					if (idSeccion) {
						System.out.println("idSeccion : " + new String(ch, start, length));
						fSeccion = new FSeccion();
						fSeccion.setIdSeccion(new String(ch, start, length));
						idSeccion = false;
					}

					if (nombreSeccion) {
						System.out.println("nombreSeccion : " + new String(ch, start, length));
						fSeccion.setSeccion(new String(ch, start, length));
						fConfiguracionServidor.setListaSeccion(fSeccion);
						nombreSeccion = false;
					}
					
					if (inicioTarea) {
						fSubSeccion = new FSubSeccion();
						System.out.println("inicioTarea : " + new String(ch, start, length));
						inicioTarea = false;
					}
					
					if (palabra && new String(ch, start, length).length()>2) {
						System.out.println("Font : " + new String(ch, start, length));
						fSubSeccion.setPalabras(new String(ch, start, length));;
						palabra = false;
					}else{
						palabra = false;
					}

					if (idSubSeccion) {
						System.out.println("idSubSeccion : " + new String(ch, start, length));
//						fSubSeccion = new FSubSeccion();
						fSubSeccion.setIdSubseccion(new String(ch, start, length));
						idSubSeccion = false;
					}

					if (tareaSeccion) {
						System.out.println("tareaSeccion : " + new String(ch, start, length));
						fSubSeccion.setTarea(new String(ch, start, length));
						tareaSeccion = false;
					}

					if (subTareaSeccion) {
						System.out.println("subTareaSeccion : " + new String(ch, start, length));
						fSubSeccion.setSubtarea(new String(ch, start, length));
						subTareaSeccion = false;
					}
					
					if (departamentoSeccion) {
						System.out.println("departamentoSeccion : " + new String(ch, start, length));
						fSubSeccion.setDepartamento(new String(ch, start, length));
						fSubSeccion.setListasSubTabla(listaSubtabla);
						fSeccion.setListaSubseccion(fSubSeccion);
						subTareaSeccion = false;
					}
					
					if (inicioListaSubTabla) {
						listaSubtabla = new ArrayList<>();
						fSubTabla = new FSubTabla();
						System.out.println("inicioListaSubTabla : " + new String(ch, start, length));
						inicioListaSubTabla = false;
					}
					
					/*CREACION DE DIRECTORIOS WINDOWS*/
					if (rutaW) {
						System.out.println("rutaW : " + new String(ch, start, length));
						if(listaSubtabla.size()>0){
							fSubTabla = new FSubTabla();
						}
						if(fSubTabla.getRutaAL()==null){
							fSubTabla.setRutaW(new String(ch, start, length));
						}
						rutaW = false;
					}
					if (descripcionW) {
						System.out.println("descripcionW : " + new String(ch, start, length));
						if(fSubTabla.getRutaAL()==null){
							fSubTabla.setDescripcionW(new String(ch, start, length));
						}
						descripcionW = false;
					}					
					if (permisosNTFSW) {
						System.out.println("permisosNTFSW : " + new String(ch, start, length));
						fSubTabla.setPermisosNTFSW(new String(ch, start, length));
						permisosNTFSW = false;
					}					
					if (permisosExtendidosW) {
						System.out.println("permisosExtendidosW : " + new String(ch, start, length));
						fSubTabla.setPermisosExtendidosW(new String(ch, start, length));
						listaSubtabla.add(fSubTabla);
						permisosExtendidosW = false;
					}
					
					/*CREACION DE DIRECTORIOS AIX*/
					if (rutaAL) {
						System.out.println("rutaAL : " + new String(ch, start, length));
						if(listaSubtabla.size()>0){
							fSubTabla = new FSubTabla();
						}
						fSubTabla.setRutaAL(new String(ch, start, length));
						rutaAL = false;
					}
					if (descripcionAL) {
						System.out.println("descripcionAL : " + new String(ch, start, length));
						fSubTabla.setDescripcionAL(new String(ch, start, length));
						descripcionAL = false;
					}					
					if (permisosExtendidosAIX) {
						System.out.println("permisosExtendidosAIX : " + new String(ch, start, length));
						fSubTabla.setPermisosExtendidosAIX(new String(ch, start, length));
						listaSubtabla.add(fSubTabla);
						permisosExtendidosAIX = false;
					}					
					
					/*CREACION DE DIRECTORIOS SHARE*/
					if (rutaFisicaShyNF) {
						System.out.println("rutaFisicaShyNF : " + new String(ch, start, length));
						if(listaSubtabla.size()>0){
							fSubTabla = new FSubTabla();
						}
						fSubTabla.setRutaFisicaShyNF(new String(ch, start, length));
						rutaFisicaShyNF = false;
					}
					if (nombreCarpetaComShyNF) {
						System.out.println("nombreCarpetaComShyNF : " + new String(ch, start, length));
						fSubTabla.setNombreCarpetaComShyNF(new String(ch, start, length));
						nombreCarpetaComShyNF = false;
					}
					if (descripcionShyNF) {
						System.out.println("descripcionShyNF : " + new String(ch, start, length));
						fSubTabla.setDescripcionShyNF(new String(ch, start, length));
						descripcionShyNF = false;
					}
					if (usuarioAutorizadorShyNF) {
						System.out.println("usuarioAutorizadorShyNF : " + new String(ch, start, length));
						fSubTabla.setUsuarioAutorizadorShyNF(new String(ch, start, length));
						usuarioAutorizadorShyNF = false;
					}
					if (permisosShyNF) {
						System.out.println("permisosShyNF : " + new String(ch, start, length));
						fSubTabla.setPermisosShyNF(new String(ch, start, length));
						listaSubtabla.add(fSubTabla);
						permisosShyNF = false;
					}
					
					/*CREACION DE CUENTAS LOCALES*/
					if (usuarioCL) {
						System.out.println("usuarioCL : " + new String(ch, start, length));
						if(listaSubtabla.size()>0){
							fSubTabla = new FSubTabla();
						}
						fSubTabla.setUsuarioCL(new String(ch, start, length));
						usuarioCL = false;
					}
					if (decripcionCL) {
						System.out.println("decripcionCL : " + new String(ch, start, length));
						fSubTabla.setDecripcionCL(new String(ch, start, length));
						decripcionCL = false;
					}
					if (grupoPrimarioCL) {
						System.out.println("grupoPrimarioCL : " + new String(ch, start, length));
						fSubTabla.setGrupoPrimarioCL(new String(ch, start, length));
						grupoPrimarioCL = false;
					}
					if (grupoSecundarioCL) {
						System.out.println("grupoSecundarioCL : " + new String(ch, start, length));
						fSubTabla.setGrupoSecundarioCL(new String(ch, start, length));
						grupoSecundarioCL = false;
					}
					if (sentenciaCL) {
						System.out.println("sentenciaCL : " + new String(ch, start, length));
						fSubTabla.setSentenciaCL(new String(ch, start, length));
						listaSubtabla.add(fSubTabla);
						sentenciaCL = false;
					}
					
					
					/*BALANCE DE CARGAS*/
					if (puertoApliBL) {
						System.out.println("puertoApliBL : " + new String(ch, start, length));
						if(listaSubtabla.size()>0){
							fSubTabla = new FSubTabla();
						}
						fSubTabla.setPuertoApliBL(new String(ch, start, length));
						listaBalanceCargaDes = new ArrayList<>();
						listaBalanceCargaCer = new ArrayList<>();
						listaBalanceCargaPro = new ArrayList<>();
						puertoApliBL = false;
					}
					if (persistenciaBL) {
						System.out.println("persistenciaBL : " + new String(ch, start, length));
						fSubTabla.setPersistenciaBL(new String(ch, start, length));
						persistenciaBL = false;
					}
					if (tiempoPersBL) {
						System.out.println("tiempoPersBL : " + new String(ch, start, length));
						fSubTabla.setTiempoPersBL(new String(ch, start, length));
						tiempoPersBL = false;
					}
					if (nombreDes) {
						System.out.println("nombreDes : " + new String(ch, start, length));
						fSubTabla.setNombreDes(new String(ch, start, length));
						nombreDes = false;
					}
					if (direccionDes) {
						System.out.println("direccionDes : " + new String(ch, start, length));
						fSubTabla.setDireccionDes(new String(ch, start, length));
						direccionDes = false;
					}
					if (urlDes) {
						System.out.println("urlDes : " + new String(ch, start, length));
						fSubTabla.setUrlDes(new String(ch, start, length));
						fSubTabla.setListaBalanceDes(listaBalanceCargaDes);
						fSubTabla.setListaBalanceCer(listaBalanceCargaCer);
						fSubTabla.setListaBalancePro(listaBalanceCargaPro);
						listaSubtabla.add(fSubTabla);
						urlDes = false;
					}
					
					
					if (inicioListaBalanceDes) {
						fBalanceCargaDes = new FBalanceCarga();
						System.out.println("inicioListaBalanceDes : " + new String(ch, start, length));
						inicioListaBalanceDes = false;
					}
					
					/*BALANCE DE CARGAS -- BALANCE DESARROLLO*/
					if (nombreServidorDes) {
						System.out.println("nombreServidorDes : " + new String(ch, start, length));
						fBalanceCargaDes.setNombreServidor(new String(ch, start, length));
						nombreServidorDes = false;
					}
					if (direccionIpDes) {
						System.out.println("direccionIpDes : " + new String(ch, start, length));
						fBalanceCargaDes.setDireccionIp(new String(ch, start, length));
						direccionIpDes = false;
					}
					if (urlDesarrollo) {
						System.out.println("urlDesarrollo : " + new String(ch, start, length));
						fBalanceCargaDes.setUrl(new String(ch, start, length));
						listaBalanceCargaDes.add(fBalanceCargaDes);
						urlDesarrollo = false;
					}
					/*-----------------------------------------------------------------------------*/
					
					if (nombreCer) {
						System.out.println("nombreCer : " + new String(ch, start, length));
						fSubTabla.setNombreCer(new String(ch, start, length));
						nombreCer = false;
					}
					if (direccionCer) {
						System.out.println("direccionCer : " + new String(ch, start, length));
						fSubTabla.setDireccionCer(new String(ch, start, length));
						direccionCer = false;
					}
					if (urlCer) {
						System.out.println("urlCer : " + new String(ch, start, length));
						fSubTabla.setUrlCer(new String(ch, start, length));
						urlCer = false;
					}
					
					
					if (inicioListaBalanceCer) {
						fBalanceCargaCer = new FBalanceCarga();
						System.out.println("inicioListaBalanceCer : " + new String(ch, start, length));
						inicioListaBalanceCer = false;
					}
					
					/*BALANCE DE CARGAS -- BALANCE CERTIFICACION*/
					if (nombreServidorCer) {
						System.out.println("nombreServidorCer : " + new String(ch, start, length));
						fBalanceCargaCer.setNombreServidor(new String(ch, start, length));
						nombreServidorCer = false;
					}
					if (direccionIpCer) {
						System.out.println("direccionIpCer : " + new String(ch, start, length));
						fBalanceCargaCer.setDireccionIp(new String(ch, start, length));
						direccionIpCer = false;
					}
					if (urlCertificacion) {
						System.out.println("urlCertificacion : " + new String(ch, start, length));
						fBalanceCargaCer.setUrl(new String(ch, start, length));
						listaBalanceCargaCer.add(fBalanceCargaCer);
						urlCertificacion = false;
					}
					/*-----------------------------------------------------------------------------*/
					
					if (nombrePro) {
						System.out.println("nombrePro : " + new String(ch, start, length));
						fSubTabla.setNombrePro(new String(ch, start, length));
						nombrePro = false;
					}
					if (direccionPro) {
						System.out.println("direccionPro : " + new String(ch, start, length));
						fSubTabla.setDireccionPro(new String(ch, start, length));
						direccionPro = false;
					}
					if (urlPro) {
						System.out.println("urlPro : " + new String(ch, start, length));
						fSubTabla.setUrlPro(new String(ch, start, length));
						urlPro = false;
					}
					
					
					if (inicioListaBalancePro) {
						fBalanceCargaPro = new FBalanceCarga();
						System.out.println("inicioListaBalancePro : " + new String(ch, start, length));
						inicioListaBalancePro = false;
					}
					
					/*BALANCE DE CARGAS -- BALANCE PRODUCCION*/
					if (nombreServidorPro) {
						System.out.println("nombreServidorPro : " + new String(ch, start, length));
						fBalanceCargaPro.setNombreServidor(new String(ch, start, length));
						nombreServidorPro = false;
					}
					if (direccionIpPro) {
						System.out.println("direccionIpPro : " + new String(ch, start, length));
						fBalanceCargaPro.setDireccionIp(new String(ch, start, length));
						direccionIpPro = false;
					}
					if (urlProduccion) {
						System.out.println("urlProduccion : " + new String(ch, start, length));
						fBalanceCargaPro.setUrl(new String(ch, start, length));
						listaBalanceCargaPro.add(fBalanceCargaPro);
						urlProduccion = false;
					}
					/*-----------------------------------------------------------------------------*/
					
					/*OT's*/
					if (numeroOT) {
						System.out.println("numeroOT : " + new String(ch, start, length));
						if(listaSubtabla.size()>0){
							fSubTabla = new FSubTabla();
						}
						fSubTabla.setNumeroOT(new String(ch, start, length));
						numeroOT = false;
					}
					if (ordenTrabajoOT) {
						System.out.println("ordenTrabajoOT : " + new String(ch, start, length));
						fSubTabla.setOrdenTrabajoOT(new String(ch, start, length));
						ordenTrabajoOT = false;
					}
					if (descripcionOT) {
						System.out.println("descripcionOT : " + new String(ch, start, length));
						fSubTabla.setDescripcionOT(new String(ch, start, length));
						descripcionOT = false;
					}
					if (tipoOrdenOT) {
						System.out.println("tipoOrdenOT : " + new String(ch, start, length));
						fSubTabla.setTipoOrdenOT(new String(ch, start, length));
						listaSubtabla.add(fSubTabla);
						tipoOrdenOT = false;
					}
					/*-----------------------------------------------------------------------------*/
					
					/*EJECUTAR BD*/
					if (ambienteEjecutarBD) {
						System.out.println("ambienteEjecutarBD : " + new String(ch, start, length));
						if(listaSubtabla.size()>0){
							fSubTabla = new FSubTabla();
						}
						fSubTabla.setAmbienteEjecutarBD(new String(ch, start, length));
						ambienteEjecutarBD = false;
					}
					if (baseDatosBD) {
						System.out.println("baseDatosBD : " + new String(ch, start, length));
						fSubTabla.setBaseDatosBD(new String(ch, start, length));
						baseDatosBD = false;
					}
					if (usuarioBD) {
						System.out.println("usuarioBD : " + new String(ch, start, length));
						fSubTabla.setUsuarioBD(new String(ch, start, length));
						usuarioBD = false;
					}
					if (comandoBD) {
						System.out.println("comandoBD : " + new String(ch, start, length));
						fSubTabla.setComandoBD(new String(ch, start, length));
						listaSubtabla.add(fSubTabla);
						comandoBD = false;
					}
					if (adecuacionesBD) {
						System.out.println("adecuacionesBD : " + new String(ch, start, length));
						fSubTabla.setAdecuacionesBD(new String(ch, start, length));
						adecuacionesBD = false;
					}
					/*-----------------------------------------------------------------------------*/
					
					
					/*ADMINISTRACION DE SEVICIOS WEB - BAJA Y SUBIDA DE SERVICIOS*/
					if (nombreWwbSite) {
						if(listaSubtabla.size()>0){
							fSubTabla = new FSubTabla();
						}
						System.out.println("nombreWwbSite : " + new String(ch, start, length));
						fSubTabla.setNombreWwbSite(new String(ch, start, length));
						nombreWwbSite = false;
					}
					if (accionWebSite) {
						System.out.println("accionWebSite : " + new String(ch, start, length));
						fSubTabla.setAccionWebSite(new String(ch, start, length));
						listaSubtabla.add(fSubTabla);
						accionWebSite = false;
					}
					/*-------------------------------------------------------------------------------*/
					
					/*ADMINISTRACION DE SEVICIOS WEB - BAJA Y SUBIDA POOL*/
					if (nombreAppPol) {
						if(listaSubtabla.size()>0){
							fSubTabla = new FSubTabla();
						}
						System.out.println("nombreAppPol : " + new String(ch, start, length));
						fSubTabla.setNombreAppPol(new String(ch, start, length));
						nombreAppPol = false;
					}
					if (accionAppPol) {
						System.out.println("accionAppPol : " + new String(ch, start, length));
						fSubTabla.setAccionAppPol(new String(ch, start, length));
						listaSubtabla.add(fSubTabla);
						accionAppPol = false;
					}
					/*-------------------------------------------------------------------------------*/
					
					
					/*ADMINISTRACION DE SEVICIOS WEB - REINICIO IIS*/
					if (comandoIIS) {
						if(listaSubtabla.size()>0){
							fSubTabla = new FSubTabla();
						}
						System.out.println("comandoIIS : " + new String(ch, start, length));
						fSubTabla.setComandoIIS(new String(ch, start, length));
						listaSubtabla.add(fSubTabla);
						comandoIIS = false;
					}
					/*-------------------------------------------------------------------------------*/
					
					
					/*I - APLICACION - CONFIGURACION DEL SERVICIOS*/
					if (nombreServicioIA) {
						if(listaSubtabla.size()>0){
							fSubTabla = new FSubTabla();
						}
						System.out.println("nombreServicioIA : " + new String(ch, start, length));
						fSubTabla.setNombreServicioIA(new String(ch, start, length));
						nombreServicioIA = false;
					}
					if (usuarioIA) {
						System.out.println("usuarioIA : " + new String(ch, start, length));
						fSubTabla.setUsuarioIA(new String(ch, start, length));
						usuarioIA = false;
					}
					if (estadoIA) {
						System.out.println("estadoIA : " + new String(ch, start, length));
						fSubTabla.setEstadoIA(new String(ch, start, length));
						listaSubtabla.add(fSubTabla);
						estadoIA = false;
					}
					/*-------------------------------------------------------------------------------*/
					
					
					/*I - APLICACION - REINICIO DE SERVICIOS*/
					if (nombreServicioRA) {
						if(listaSubtabla.size()>0){
							fSubTabla = new FSubTabla();
						}
						System.out.println("nombreServicioRA : " + new String(ch, start, length));
						fSubTabla.setNombreServicioRA(new String(ch, start, length));
						nombreServicioRA = false;
					}
					if (accionRA) {
						System.out.println("accionRA : " + new String(ch, start, length));
						fSubTabla.setAccionRA(new String(ch, start, length));
						listaSubtabla.add(fSubTabla);
						accionRA = false;
					}
					/*-------------------------------------------------------------------------------*/
					
					
					if (cierreListaSubTabla) {
						System.out.println("cierreListaSubTablas : " + new String(ch, start, length));
						cierreListaSubTabla = false;
					}
					if (cierreSeccion) {
						System.out.println("cierreSeccion : " + new String(ch, start, length));
						listaConfiguracion.add(fConfiguracionServidor);
						cierreSeccion = false;
					}

				}

			};

			saxParser.parse("C:\\Users\\S66202\\Desktop\\RCCL-MIS-SN000086459.xml", handler);
//			saxParser.parse("C:\\Users\\achapona\\Desktop\\MIS-PLANTILLA.xml", handler);
			System.out.println(listaConfiguracion);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
