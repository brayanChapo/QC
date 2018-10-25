package springdb;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PRUEBAJAVA2 {
	
	public static void main(String[] args){
		
		List<ClearCase> lista = new ArrayList<>();
		
		ClearCase Cc;
        
        String linea = null;
        try {
            
            long startTime = System.nanoTime();
            Process p = Runtime.getRuntime().exec("cleartool find -all -version \"{lbtype_sub("+"TK000089547"+")}\" -print", null,
            new File("M:\\"+"s66202"+"_TK_cons_dv" + File.separator + "PESmex"));
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
         
            while((linea = in.readLine()) != null){
            	
            			System.out.println(linea);

            		
            	
            }
            long endTime = System.nanoTime();
            System.out.println("Duración: " + (endTime-startTime)/1e6 + " ms");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
	}
	
}
