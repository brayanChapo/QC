package springdb;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PRUEBAJAVA {
	
	public static void main(String[] args){
		
		
		List<ClearCase> lista = new ArrayList<>();
		
		
		ClearCase Cc;
        
        String linea = null;
        try {
            
            long startTime = System.nanoTime();
            Process p = Runtime.getRuntime().exec("cleartool find -all -version \"{lbtype_sub("+"TK000089547"+")}\" -print", null,
                    new File("M:\\"+"s66202"+"_TK_cons_dv" + File.separator + "PESmex"));
                    BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
           
            
            String [] rutaYArchivo;
            String [] elemntoYVersion;
            String [] caracteres;
            int longitud =0;
			int vob = 2;
            String archivo;
            String ambiente;
            String carpeta;
            String ruta;
            String fecha;
            int rep;
            
            while((linea = in.readLine()) != null){
            	
            	if(linea.contains(".")){
            		if(!linea.contains(".@@")){
            			String nombre;
            			String doc;
            			ruta = "";
            			rep = 0;
            			Cc = new ClearCase();
            			System.out.println(linea);
            			caracteres = linea.split("\\\\");
            			carpeta = caracteres[3];
            			ambiente = caracteres[caracteres.length-2];
            			elemntoYVersion = linea.split("@@");
                        rutaYArchivo = elemntoYVersion[0].split("\\\\");
                        longitud=rutaYArchivo.length;
                        archivo = rutaYArchivo[rutaYArchivo.length - 1];
                        doc = archivo.split("-")[1];
                        System.err.println(doc);
                        
                        fecha = getFecha(elemntoYVersion[0]);
                        for(int x=vob; x<longitud ;x++) {
                        	if(x == longitud -1) {
                        		nombre = rutaYArchivo[x];
                            	ruta = ruta + nombre;
                        	}else {
                        		nombre = rutaYArchivo[x]+"\\";
                            	ruta = ruta + nombre;
                        	}
                        }
                        
                        Cc.setElemento(archivo);
                    	Cc.setAmbiente(ambiente);
                    	Cc.setRuta(ruta);
                    	Cc.setFecha(fecha);
                    	Cc.setCarpeta(carpeta);
                        if(lista.isEmpty()) {
                        	lista.add(Cc);
                        	
                        }else {
                        	for (ClearCase clearCase : lista) {
								if(clearCase.getElemento().equals(Cc.getElemento())) {
									rep = 1;
								}
							}
                        	if(!(rep==1)) {
                            	lista.add(Cc);               
                        	}
                        }
            		}
                } 
               
            }
            long endTime = System.nanoTime();
            System.out.println("Duración: " + (endTime-startTime)/1e6 + " ms");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("AWDWADAW" + lista.toString());
        
		
	
	}
	
	static String getFecha(String archivo){
        Date d = new Date((new File(archivo).lastModified()));
        return d.toLocaleString();
    }
	

}
