package BasesDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;

import Ventanas.CiudadanoOInstitucion;


public class BDCiudadano {

	private static Exception lastError = null;
	
//	private String dbName = "dbCiudadano_guntaxmeal";
//	private String server ="mysql://dbCiudadano_guntaxmeal:444f27bd00d34d770a5894007a46b43db133c8d1@mxy.h.filess.io:3307/dbCiudadano_guntaxmeal";
//	private String user="dbCiudadano_guntaxmeal";
//	private String pass="444f27bd00d34d770a5894007a46b43db133c8d1";
	
	
	

	
	public static void initBD( ) {
		try 
		{
			Class.forName("org.sqlite.JDBC");
			String dburl = "jdbc:sqlite:E:\\Programas\\SQlite Setup\\bases de datos\\bdUsuario";
			Connection conexion = DriverManager.getConnection(dburl);
				 
						
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
	}
	
	public static void Insertar()throws SQLException	{
		try 
		{
			Class.forName("org.sqlite.JDBC");
			String dburl = "jdbc:sqlite:C:\\Users\\Robe\\Empleados.db";
			Connection conexion = DriverManager.getConnection(dburl);
				 
			Statement Consulta = conexion.createStatement();
			
			C objEmp = new Empleado(4,"Mabel", "Bilbao 178");
			
			String strInsert = "Insert into empleado Values(" + 
							   "" + objEmp.getaId() + ", " +
							   "'" + objEmp.getaNombre() + "', " +
							   "'" + objEmp.getaSector() + "')";
							   
			int aux = Consulta.executeUpdate(strInsert);
			
			
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		
	}
	
	
	
	
	
	

}
