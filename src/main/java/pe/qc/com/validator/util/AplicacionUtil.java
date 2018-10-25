package pe.qc.com.validator.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class AplicacionUtil {

	public static Date toDate(DateTime fecha) {
		Date date = null;
		if (fecha != null) {
			date = fecha.toDate();
		}
		return date;
	}

	public static DateTime toDateTime(Date fecha) {
		DateTime dateTime = null;
		if (fecha != null) {
			dateTime = new DateTime(fecha);
		}
		return dateTime;
	}

	public static Integer obtenerAnio(Date fecha) {
		Integer anio = null;
		if (fecha != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
			anio = Integer.parseInt(dateFormat.format(fecha));
		}
		return anio;
	}
	
	public static String convertirAMayusculas(String texto) {
		String convertido = null;
		if (texto != null) {
			convertido = texto.toUpperCase().trim();
		}
		return convertido;
	}

	public static String convertirFechaFormatoExcelAFormatoJava(String fechaExcel) {
        String[] fechaEnPartes = fechaExcel.split("-");
        if (fechaEnPartes.length != 3) {
            return fechaExcel;
        } else {
            String fechaJava = fechaEnPartes[0] + "-";
            String mes = fechaEnPartes[1];
            String mesDigitos = "";
            
            if(mes.equals("ene")) {
            	mesDigitos = "01";
            } else if(mes.equals("feb")) {
            	mesDigitos = "02";
            } else if(mes.equals("mar")) {
            	mesDigitos = "03";
            } else if(mes.equals("abr")) {
            	mesDigitos = "04";
            } else if(mes.equals("may")) {
            	mesDigitos = "05";
            } else if(mes.equals("jun")) {
            	mesDigitos = "06";
            } else if(mes.equals("jul")) {
            	mesDigitos = "07";
            } else if(mes.equals("ago")) {
            	mesDigitos = "08";
            } else if(mes.equals("sep")) {
            	mesDigitos = "09";
            } else if(mes.equals("oct")) {
            	mesDigitos = "10";
            } else if(mes.equals("nov")) {
            	mesDigitos = "11";
            } else if(mes.equals("dic")) {
            	mesDigitos = "12";
            }
            fechaJava = fechaJava + mesDigitos + "-" + fechaEnPartes[2];
            return fechaJava;
        }
    }

	public static Integer obtenerDiferenciaDias(DateTime fechaInicio, DateTime fechaFinal){
		return Days.daysBetween(fechaInicio.toLocalDate(),fechaFinal.toLocalDate()).getDays();
	}
	
	
	
	
	/**
	 * Obtendremos el nombre de mes por indice y luego convertiremos la primera
	 * letra del nombre a mayuscula
	 * 
	 * @param anio
	 * @param mes
	 * @return String
	 */
	public static String obtenerNombreMes(Integer anio, Integer mes) {
		LocalDate localDate = new LocalDate(anio, mes, 1);
		DateTimeFormatter formato = DateTimeFormat.forPattern("MMMM");
		String nombreMes = formato.print(localDate);
		char primeraLetra = nombreMes.charAt(0);
		nombreMes = Character.toUpperCase(primeraLetra)
				+ nombreMes.substring(1, nombreMes.length());
		return nombreMes;
	}

	public static String formatearFecha(int tipoFormato, DateTime fecha) {
		String fechaFormateada = null;
		DateTimeFormatter formato = null;
		try {
			if (fecha != null) {
				switch (tipoFormato) {
				case Constantes.FORMATO_FECHA_HORA:
					formato = DateTimeFormat.forPattern("dd-MM-yyyy hh:mm:ss a");
					fechaFormateada = formato.print(fecha);
					break;
				case Constantes.FORMATO_FECHA:
					formato = DateTimeFormat.forPattern("dd-MM-yyyy");
					fechaFormateada = formato.print(fecha);
					break;
				case Constantes.FORMATO_FECHA_BD:
					formato = DateTimeFormat.forPattern("dd-MM-yy");
					fechaFormateada = formato.print(fecha);
					break;
				}
			}
		} catch (Exception e) {

		}
		return fechaFormateada;
	}
	
	public static List<TreeSet<String>> agruparListaPorId(String idPrincipal, String idValor, List<Map<String, Object>> lista){
		int idActual = 0, idAnterior = 0;
		Set<String> listaConcatenados = null;
		List<TreeSet<String>> listaAgrupada = null;
		if( lista != null && lista.size() > 0){
			listaAgrupada = new ArrayList<TreeSet<String>>();
			listaConcatenados = new TreeSet<String>();
			listaConcatenados.add(lista.get(0).get(idValor).toString());
			for (int i = 1;i < lista.size();i++){
				idActual = Integer.parseInt(lista.get(i).get(idPrincipal).toString());
				idAnterior = Integer.parseInt(lista.get(i-1).get(idPrincipal).toString());
				if(idActual != idAnterior){
					listaAgrupada.add((TreeSet<String>) listaConcatenados);
					listaConcatenados.clear();
				}
				listaConcatenados.add(lista.get(i).get(idValor).toString());
			}
			listaAgrupada.add((TreeSet<String>) listaConcatenados);
		}
		return listaAgrupada;
	}
	
	//Funcion para obtener nombres de departamentos u otros conceptos por medio de un id
	public static String obtenerNombrePorIdCatalogo(Integer id, String[] lista) {
		for (int i = 0 ; i < lista.length; i++){
			if(id == i){
				return lista[i]; 
			}
		}
		return null;
	}
	
	public static BigDecimal obtenerDivisionPorMaps(Map<String, Object> dividendo, Map<String, Object> divisor, String claveDividendo, String claveDivisor){
		BigDecimal cero = BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal valorDivisor = new BigDecimal(String.valueOf(divisor.get(claveDivisor))).setScale(2, BigDecimal.ROUND_HALF_UP);
		if(valorDivisor.equals(cero)){
			return cero;
		}else{
			return new BigDecimal(String.valueOf(dividendo.get(claveDividendo))).
					divide(new BigDecimal(String.valueOf(divisor.get(claveDivisor))), 2, RoundingMode.HALF_UP);
		}
	}
	
	public static BigDecimal obtenerPorcentajeParteTodo(BigDecimal parte, BigDecimal todo){
		BigDecimal cero = BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP);
		todo = todo.setScale(2, BigDecimal.ROUND_HALF_UP);
		if(todo.equals(cero)){
			return cero;
		}else{
			return parte.divide(todo, 2, RoundingMode.HALF_UP).multiply(new BigDecimal("100"));
		}
	}

	public static BigDecimal obtenerSumaPorMaps(Map<String, Object> primerSumando, Map<String, Object> segundoSumando, String clave){
		return new BigDecimal(String.valueOf(primerSumando.get(clave))).add(new BigDecimal(String.valueOf(segundoSumando.get(clave))).setScale(2, BigDecimal.ROUND_HALF_UP));
	}
	
	public static BigDecimal obtenerRestaPorMaps(Map<String, Object> primerNumero, Map<String, Object> segundoNumero, String primeraClave, String segundaClave){
		return new BigDecimal(String.valueOf(primerNumero.get(primeraClave))).subtract(new BigDecimal(String.valueOf(segundoNumero.get(segundaClave))).setScale(2, BigDecimal.ROUND_HALF_UP));
	}
}

