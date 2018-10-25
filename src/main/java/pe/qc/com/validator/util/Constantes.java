package pe.qc.com.validator.util;

public class Constantes {

	public static final int INFORMACION = 1;
	public static final int ADVERTENCIA = 2;
	public static final int ERROR = 3;

	public static final String ERROR_ACCESO_DATOS_NO_CATEGORIZADO = "Error de acceso a datos no categorizado";
	public static final String ERROR_ACCESO_DATOS = "Error de acceso a datos";
	public static final String ERROR_GENERAL_LOGICA_NEGOCIO = "Error en el documento";
	public static final String ERROR_GENERAL_CARGA_ARCHIVO = "Error general de lógica de negocio";
	public static final String ERROR_NEGOCIO_CONSULTA_REGISTRO = "Error al consultar registro";
	public static final String ERROR_NEGOCIO_MODIFICACION_REGISTRO = "Error al modificar registro";
	public static final String ERROR_NEGOCIO_INSERCION_REGISTRO = "Error al registrar";
	public static final String ERROR_NEGOCIO_ELIMINACION_REGISTRO = "Error al eliminar registro";
	public static final String ERROR_LOGICA_NEGOCIO_OTRO = "Otro error de lógica de negocio";
	
	public static final int FORMATO_FECHA_HORA = 1;
	public static final int FORMATO_FECHA = 2;
	public static final int FORMATO_FECHA_BD = 3;
	
	public static final char VALOR_ESTADO_ACTIVO = '1';
	public static final String ESTADO_ACTIVO = "ACTIVO";
	public static final char VALOR_ESTADO_INACTIVO = '0';
	public static final String ESTADO_INACTIVO = "INACTIVO";
	
	public static final char VALOR_ESTADO_HISTORICO = '1';
	public static final String ESTADO_HISTORICO = "HISTORICO";
	public static final char VALOR_ESTADO_NO_HISTORICO = '0';
	public static final String ESTADO_NO_HISTORICO = "NO HISTORICO";
	
	public static final int VALOR_HISTORICO = 1;
	public static final int VALOR_NO_HISTORICO = 0;
	
	public static final int ESTADO_REGISTRADO = 1;
	public static final int ESTADO_CREADO = 7;
	
	
	public static final String ERROR_PRODUCCION = "ERROR EN PRODUCCION";
	public static final String CAMBIOS_P_T = "CAMBIOS DE PARAMETROS/TASAS";
	public static final String OPTIMIZACIONES = "OPTIMIZACIONES";
	
	public static final String ERROR_ACCESO_DATOS_OTRO= "Otro error de acceso a datos";
	
	public static final String VALIDACION_TK = "TK";
	public static final String VALIDACION_TK_INCORRECTO = "N° de TK Incorrecto";
	public static final String VALIDACION_SN = "SN";
	public static final String VALIDACION_SN_INCORRECTO = "N° de SN Incorrecto";
	public static final String VALIDACION_ST = "ST";
	public static final String VALIDACION_ST_INCORRECTO = "N° de ST Incorrecto";
	public static final String VALIDACION_SS = "SS";
	public static final String VALIDACION_SS_INCORRECTO = "N° de SS Incorrecto";
	public static final String VALIDACION_COD = "CODIGO APLICATIVO";
	public static final String VALIDACION_COD_INCORRECTO = "Nombre de Codigo de Aplicativo Incorrecto";
	public static final String VALIDACION_TIPO_CAMBIO = "TIPO DE CAMBIO";
	public static final String VALIDACION_TIPO_CAMBIO_INCORRECTO = "Nombre Tipo de Cambio Incorrecto";
	
	public static final String HOMOLOGACION = "HOMOLOGACIÓN";
	public static final String SERVIDOR_PRODUCCION = "SERVIDORES DE PRODUCCIÓN EN EL CMDB";
	public static final String SERVIDOR_CERTIFICACION = "SERVIDORES DE CERTIFICACIÓN EN EL CMDB";
	
	public static final String VALIDACION_OK = "OK";
	public static final String VALIDACION_ERROR = "ERROR";
	
	public static final int USUARIO_ADMINISTRADOR = 1;
	public static final int USUARIO_DIGITADOR = 2;
	public static final int USUARIO_CONSULTOR = 3;
	
	public static final int ESTADO_NULL_ETAPA =5;
	public static final int ESTADO_NULL_EQUIPO =7;
	
	public static final int SOL_NEGOCIO = 1;
	public static final int SOL_SERVICIO = 2;
	public static final int ERROR_EN_PRODUCCION = 3;
	
}
