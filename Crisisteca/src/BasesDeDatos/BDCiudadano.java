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
	
	
	
	
	
	//Función que permite saber si existe un usuario al iniciar sesion, al usar la contraseña preferimos usar un prepared statement
	public static Integer ExisteUsuario(String usuarioQueBuscamos, String contrasenyaQueBuscamos) {
		
		try{
			//Conectarnos
		 	Class.forName("org.sqlite.JDBC");
			String dburl = "jdbc:sqlite:res/bds/bdUsuario.db";
			Connection conexion = DriverManager.getConnection(dburl);
			
			
			//Buscar el ciudadano
			String sqlCiudadano ="select * from Ciudadano where Telefono = ? and Contrasenya = ?";
			PreparedStatement stC = conexion.prepareStatement(sqlCiudadano);
			stC.setInt(1,Integer.parseInt(usuarioQueBuscamos) );
			stC.setString(2, contrasenyaQueBuscamos);
			ResultSet rsC = stC.executeQuery();
			
			//Buscar la institución
			String sqlInstitucion = "select * from Institucion where Codigo = ? and Contrasenya = ?";		
			PreparedStatement stI = conexion.prepareStatement(sqlInstitucion);
			stI.setString(1, usuarioQueBuscamos );
			stI.setString(2, contrasenyaQueBuscamos);
			ResultSet rsI = stI.executeQuery();
			//Si existe el ciudadano devuelve 0
			if( rsC.next())return 0;
			
			//Si existe la institucion devuelve 1
			else if (rsI.next()) {
				return 1;
			}	
			
			//Si no existe ni en la tabla Ciudadano ni en la tabla Institución devuelve -1
			else return -1;
			
		}catch(Exception e){
			System.out.println("Error en ExisteUsuario");
			return null;
		}
		
	}


		
	}
	
	


