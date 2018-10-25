package springdb;

public class ejemplo {

	public static void main(String[] args) {
		
		String palabra = "ADDF_0_ContenidoDirectorio20180919_pportbtp02.log";
		String name = palabra.split("_")[3];
		String otro = name.substring(0, name.length()-4);
		System.out.println(otro);
		
		
	}

}
