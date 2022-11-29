package BasesDeDatos;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;

import javax.swing.SwingUtilities;

import Entidades.Ciudadano;
import Principal.FuncionesEspeciales;
import Ventanas.VentanaInicio;



public class BDCiudadano {

private static final String String = null;





//Tenemos esto para cargar BDCiudadano		
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new BDCiudadano();
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
	

	
//Función que permite insertar ciudadanos detro del database
	    public static boolean InsertarCiudadano(Ciudadano ciudadano) {
	        
	    	
	    	try 
			{
				Statement st = initBD();		
				st.executeUpdate("create table if not exists Ciudadano (  Nombre string, Apellidos string, DNI string, Direccion string, CodigoPostal integer, Telefono integer, Contrasenya string)");
				String sentSQL ="";
				sentSQL = "insert into Ciudadano values(" +
	                    "'"+ ciudadano.getaNombre() + "'," +
	                    "'" + ciudadano.getaApellidos() + "'," +
	                    "'" + ciudadano.getaDNI() + "'," +
	                    "'" + ciudadano.getaDireccion() + "'," +
	                    "" + ciudadano.getaCodigoPostal() + "," +
	                    "" + ciudadano.getaTelefono() + "," + 
	                    "'" + ciudadano.getaContrasenya() + "')";

				st.executeUpdate( sentSQL );
				return true;
			}catch (Exception e) {
				return false;
			}  
	    }
	
 // Prueba para ver si realmente seleccionamos ciudadanos dentro del database

	public void selectPrueba() throws SQLException {
		try {
		Class.forName("org.sqlite.JDBC");
		String dburl = "jdbc:sqlite:res/bds/bdUsuario.db";
		Connection conexion = DriverManager.getConnection(dburl);
		Statement st = conexion.createStatement();
		String sql ="select * from Ciudadano";
		
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			String ciudadano= rs.getString(1);
			System.out.println(ciudadano);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
					
	}
	
	//F
	public static boolean DuplicadoUsuario (String dniQuizasDuplicado) {
		try {
			Statement st = initBD();
			String sql ="select * from Ciudadano where DNI =" + dniQuizasDuplicado;
			ResultSet rs = st.executeQuery(sql);
			
			return rs.next();

		}catch(Exception e){
			return false;
		}

	}
	
	
	
	
	



		
	}
	
	


