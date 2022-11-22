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
			String dburl = "jdbc:sqlite:res/bds/bdUsuario.db";
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
			
			Statement st = initBD();
			
			
			st.executeUpdate("create table if not exists Institucion ( Codigo string, Nombre string, Email string,Telefono integer)");
			Institucion institucion1 = new Institucion("AAA","Nombre 1", "institucion1@gmail.com", 32000);
			Institucion institucion2 = new Institucion("AAB", "Nombre 2", "institucion2@gmail.com", 32001); 
			String sentSQL ="";
			sentSQL = "insert into Ciudadano values(" +
                    "'"+ institucion1.getiCodigo() + "'," +
                    "'" + institucion1.getiNombre() + "'," +
                    "'" + institucion1.getiEmail() + "'," +
                    "" + institucion1.getiTelefono() + ")";
			st.executeUpdate( sentSQL );
		

		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	    public static boolean InsertarInstitucion(Institucion institucion) {
	        //Código para insertar ciudadanos
	        try {
	        	
				Statement st = initBD();		
				st.executeUpdate("create table if not exists Institucion ( Codigo string, Nombre string, Email string,Telefono integer)");
		        String sentSQL = "";
	            sentSQL = "insert into Institucion values(" +
	            		"'" + institucion.getiCodigo()+ "'," +
	                    "'"+ institucion.getiNombre() + "," +
	                    "'" + institucion.getiEmail() + "'," +
	                    "" + institucion.getiTelefono();
	            
	           st.executeUpdate( sentSQL );
	           return true;  
	            
	        } catch (SQLException e) {
	           return false;
	        }        
	    }
		
	}
