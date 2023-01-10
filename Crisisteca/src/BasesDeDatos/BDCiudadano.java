package BasesDeDatos;

import java.io.Closeable;
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

private static Connection connected = null;

	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new BDCiudadano();
			}
		});
	}
	
	/* Crea una sentencia de base de datos
	 * return: st (sentencia de trabajo si se crea correctamente), en caso de error devuelve null
	 */
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
	
	/* Cierra la base de datos abierta
	 * param: con (conexion abierta con la base de datos), st (sentencia abierta de la base de datos)
	 */
	public static void cerrarBD( Connection con, Statement st ) {
		try {
			if (st!=null) st.close();
			if (con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//public static Connection getConn() throws Exception{
//	    if(connected == null){
//	    Class.forName("org.sqlite.JDBC");
//	    connected = DriverManager.getConnection("jdbc:sqlite:res/bds/bdUsuario.db");
//	    }
//	    return connected;
//}
	
		/* Funcion que sirve para insertar valores (ciudadanos) en la base de datos
		 * param: ciudadano (Ciudadano creado que cumpla con las caracteristicas de la entidad Ciudadano)
		 * return: true si se ha añadido el ciudadano, false si ha habido un error y no se ha añadido
		 */
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
			    cerrarBD(initBD().getConnection(), st);
				return true;
			}catch (Exception e) {
				e.printStackTrace();
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
	    cerrarBD(initBD().getConnection(), st);

		}catch(Exception e) {
			e.printStackTrace();
		}			
	}
	
}