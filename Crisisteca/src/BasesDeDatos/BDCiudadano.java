package BasesDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import javax.swing.SwingUtilities;

import Entidades.Ciudadano;
import Principal.Servicio;
import Ventanas.VentanaInicio;



public class BDCiudadano implements Servicio{

	private static Exception lastError = null;
	
//	private String dbName = "dbCiudadano_guntaxmeal";
//	private String server ="mysql://dbCiudadano_guntaxmeal:444f27bd00d34d770a5894007a46b43db133c8d1@mxy.h.filess.io:3307/dbCiudadano_guntaxmeal";
//	private String user="dbCiudadano_guntaxmeal";
//	private String pass="444f27bd00d34d770a5894007a46b43db133c8d1";
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new BDCiudadano();
			}
		});
	}
	
	

	@Override
	public Statement initBD() {
		try {
			Class.forName("org.sqlite.JDBC");
			String dburl = "jdbc:s	qlite:C:\\Users\\jorge\\Documents\\deusto\\eclipse\\basesdeedatos\\proyecto\\bdUsuario.db";
			Connection conexion = DriverManager.getConnection(dburl);
			Statement st = conexion.createStatement();
			return st;
						
			} 
		catch (Exception e) {
			return null;
		}
	}
	
	public void Insertar()throws SQLException	{
		try 
		{
			Class.forName("org.sqlite.JDBC");
			String dburl = "jdbc:sqlite:C:\\Users\\jorge\\Documents\\deusto\\eclipse\\basesdeedatos\\proyecto\\bdUsuario.db";
			Connection conexion = DriverManager.getConnection(dburl);
			Statement st = conexion.createStatement();
			
			Ciudadano ciudadano1 = new Ciudadano("Héctor", "Paramio García", "71474157R", "Mi casa", 489001, 646011211);
			Ciudadano ciudadano2 = new Ciudadano("Jorge", "Clausen", "79124721Y", "casa2", 48100, 61234431); 
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	    public boolean InsertarCiudadano(Ciudadano ciudadano) {
	        //Código para insertar ciudadanos
	        String sentSQL = "";
	        try {
	        	
	            sentSQL = "insert into Ciudadano values(" +
	                    ""+ ciudadano.getaNombre() + "," +
	                    "'" + ciudadano.getaApellidos() + "'," +
	                    "'" + ciudadano.getaDNI() + "'," +
	                    "'" + ciudadano.getaDireccion() + "'," +
	                    "" + ciudadano.getaCodigoPostal() + "," +
	                    "'" + ciudadano.getaTelefono() + ")";
	            
	            Statement st = initBD();
	            int val = st.executeUpdate( sentSQL );
	           
	            if (val!=1) {  // Se tiene que a�adir 1 - error si no
	               
	                return false;  
	            }
	            return true;
	        } catch (SQLException e) {
	           
	            lastError = e;
	            e.printStackTrace();
	            return false;
	        }        
	    }
		
	}
	
	


