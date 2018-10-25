package pe.qc.com.validator.util;

import java.util.HashMap;
import java.util.Map;

public class ConstantesServicios {

	public final static String ROL_PRINCIPAL = "ROL_PRINCIPAL";

	// Gestion de donacion
	public final static String ROL_MANTENER_VOB = "ROL_MANTENER_VOB";
	public final static String ROL_MANTENER_DOMINIO = "ROL_MANTENER_DOMINIO";
	public final static String ROL_MANTENER_USUARIO = "ROL_MANTENER_USUARIO";
	public final static String ROL_MANTENER_APLICATIVO = "ROL_MANTENER_APLICATIVO";
	
	public final static String ROL_CONSULTAR_APLICATIVO = "ROL_CONSULTAR_APLICATIVO";
	public final static String ROL_CONSULTAR_DOMINIO = "ROL_CONSULTAR_DOMINIO";
	public final static String ROL_CONSULTAR_CMDB = "ROL_CONSULTAR_CMDB";
	public final static String ROL_CONSULTAR_VOB = "ROL_CONSULTAR_VOB";
	
	public final static String ROL_VALIDAR_RUTAS = "ROL_VALIDAR_RUTAS";
	public final static String ROL_VALIDAR_SOLICITUD = "ROL_VALIDAR_SOLICITUD";
	public final static String ROL_VALIDAR_MIS = "ROL_VALIDAR_MIS";
	public final static String ROL_VALIDAR_CLEARCASE = "ROL_VALIDAR_CLEARCASE";
	public final static String ROL_TAS = "ROL_TAS";
	
	
	public final static String ROL_REVISAR_SOLICITUD = "ROL_REVISAR_SOLICITUD";
	public final static String ROL_REVISAR_MIS = "ROL_REVISAR_MIS";

	public final static String ROL_REPORTE_MIS = "ROL_REPORTE_MIS";
	public final static String ROL_REPORTE_TAS = "ROL_REPORTE_TAS";

	public final static Map<String, String> OPCION_ROL = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{	
			put("00S", ROL_PRINCIPAL);
			put("01S", ROL_MANTENER_VOB);//Permiso para el menu
			put("02S", ROL_MANTENER_DOMINIO);
			put("03S", ROL_MANTENER_USUARIO);
			put("04S", ROL_MANTENER_APLICATIVO);
			put("05S", ROL_CONSULTAR_APLICATIVO);
			put("06S", ROL_CONSULTAR_DOMINIO);
			put("07S", ROL_CONSULTAR_CMDB);
			put("08S", ROL_CONSULTAR_VOB);
			put("09S", ROL_VALIDAR_SOLICITUD);
			put("10S", ROL_VALIDAR_MIS);
			put("11S", ROL_VALIDAR_CLEARCASE);
			put("12S", ROL_TAS);
			put("13S", ROL_REVISAR_SOLICITUD);
			put("14S", ROL_REVISAR_MIS);
			put("15S", ROL_REPORTE_MIS);
			put("16S", ROL_REPORTE_TAS);
			put("17S",ROL_VALIDAR_RUTAS);

		}
	};

	/**
	 * Map que contiene a los usuarios para el acceso a los datos de las claves
	 * host, si es que el aumenta el numero de paginas entonces agregar un tramo
	 * mas.
	 * 
	 */

}
