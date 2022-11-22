package BasesDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingUtilities;

import Entidades.Ciudadano;
import Entidades.Institucion;

public class BDInstitucion {

	private static Exception lastError = null;
	
//	private String dbName = "dbCiudadano_guntaxmeal";
//	private String server ="mysql://dbCiudadano_guntaxmeal:444f27bd00d34d770a5894007a46b43db133c8d1@mxy.h.filess.io:3307/dbCiudadano_guntaxmeal";
//	private String user="dbCiudadano_guntaxmeal";
//	private String pass="444f27bd00d34d770a5894007a46b43db133c8d1";
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new BDInstitucion();
			}
		});
	}
	
	

	
	public static Statement initBD() {
		try {
			Class.forName("org.sqlite.JDBC");
			//cambiar
			String dburl = "jdbc:sqlite:C:\\Users\\jorge\\Documents\\deusto\\eclipse\\basesdeedatos\\proyecto\\bdInstitucion.db";
			Connection conexion = DriverManager.getConnection(dburl);
			Statement st = conexion.createStatement();
			return st;
						
			} 
		catch (Exception e) {
			return null;
		}
	}
	
	public static void Insertar()throws SQLException	{
		try 
		{
			Class.forName("org.sqlite.JDBC");
			String dburl = "jdbc:sqlite:C:\\Users\\jorge\\Documents\\deusto\\eclipse\\basesdeedatos\\proyecto\\bdInstitucion.db";
			Connection conexion = DriverManager.getConnection(dburl);
			Statement st = conexion.createStatement();
			
			Institucion institucion1 = new Institucion("Nombre 1", "institucion1@gmail.com", 32000);
			Institucion institucion2 = new Institucion("Nombre 2", "institucion2@gmail.com", 32001);
			
			 
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	    public static boolean InsertarInstitucion(Institucion institucion) {
	        //Código para insertar ciudadanos
	        String sentSQL = "";
	        try {
	        	
	            sentSQL = "insert into Institucion values(" +
	                    ""+ institucion.getiNombre() + "," +
	                    "'" + institucion.getiEmail() + "'," +
	                    "'" + institucion.getiTelefono();
	            
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
