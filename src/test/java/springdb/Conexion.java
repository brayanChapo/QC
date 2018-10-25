package springdb;

import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import java.sql.Connection;

public class Conexion {

	public static void main(String[] args) {
		 
		String url = null;
        Connection  con = null;
		try {
	            url = "jdbc:jtds:sqlserver://PAUTGSQLP07:1433/GestionCMDB_Prod";
	            Class.forName("net.sourceforge.jtds.jdbc.Driver");
	            try {
	               con = DriverManager.getConnection(url, "UserRead_CMDB", "G3$t10nCMDB2018");
	            } catch (Exception ex) {
	                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
	                JOptionPane.showMessageDialog(null,"Error al conectarse al servidor de base de datos. Consultar con el proveedor del programa\n"+ex.toString(), "Error al conectarse a la base de datos", JOptionPane.ERROR_MESSAGE);
	            }
	        } catch (ClassNotFoundException ex) {
	            JOptionPane.showMessageDialog(null,"Error al conectarse al servidor de base de datos. Consultar con el proveedor del programa\n"+ex.toString(), "Error al conectarse a la base de datos", JOptionPane.ERROR_MESSAGE);
	            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
	        }
		System.out.println(con);
	}

}
