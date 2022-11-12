package BasesDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingUtilities;

import Entidades.Ciudadano;
import Ventanas.VentanaInicio;



public class BDCiudadano {

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
	
	

	
	public static Statement initBD( ) {
		try {
			Class.forName("org.sqlite.JDBC");
			String dburl = "jdbc:sqlite:E:\\Programas\\SQlite Setup\\bases de datos\\bdUsuario";
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
			String dburl = "jdbc:sqlite:E:\\Programas\\SQlite Setup\\bases de datos\\bdUsuario";
			Connection conexion = DriverManager.getConnection(dburl);
			Statement st = conexion.createStatement();
			
			Ciudadano ciudadano = new Ciudadano("Héctor", "Paramio García", "71474157R", "Mi casa", 489001, 646011211);
			
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		
	}
	
	
	
	
	
	

}
