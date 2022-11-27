package BasesDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.SwingUtilities;
import Entidades.Institucion;

public class BDInstitucion {

	
	//Tenemos esto para cargar BDInstitucion		

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new BDInstitucion();
			}
		});
	}
	
	

	//Creamos esto para conectarse a la BD y no tenere que escribir lo mismo en cada funcion nueva que escribamos luego

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
	
	// Prueba para ver si realmente instertamos instituciones dentro del database
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
			System.out.println("no ha funcionao insertar ");
			e.printStackTrace();
		}
		
		
	}
	
	
	//Función que permite insertar instituciones detro del database

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
	    
	    // Prueba para ver si realmente seleccionamos una institución dentro del database

	    public void selectPrueba() throws SQLException {
			try {
			Class.forName("org.sqlite.JDBC");
			String dburl = "jdbc:sqlite:res/bds/bdInstitucion.db";
			Connection conexion = DriverManager.getConnection(dburl);
			Statement st = conexion.createStatement();
			String sql ="select * from Institucion";
			
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String institucion= rs.getString(1);
				System.out.println(institucion);
			}
			}catch(Exception e) {
				System.out.println("no ha funcionao");
				e.printStackTrace();
			}
						
		}
		
	}
