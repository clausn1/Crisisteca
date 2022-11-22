package BasesDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

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
	
	
public Statement initBD() {
		try {
	 		Class.forName("org.sqlite.JDBC");
			String dburl = "jdbc:sqlite:res/bds/bdUsuario.db";
			Connection conexion = DriverManager.getConnection(dburl);
			Statement st = conexion.createStatement();
//			ResultSet rs = st.executeQuery(dburl);
//			if(!rs.next()) {
//				Statement stCrearTabla = conexion.createStatement();
//				String create = "create table Ciudadano (  Nombre varchar(255), Apellidos varchar(255), DNI varchar(9) PRIMARY KEY, Direccion varchar(255), CodigoPostal int(5), Telefono int(9))";
//				stCrearTabla.executeUpdate(create);
//			}
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
			String dburl = "jdbc:sqlite:res/bds/bdUsuario.db";
			Connection conexion = DriverManager.getConnection(dburl);
			Statement st = conexion.createStatement();
		//	ResultSet rs = st.executeQuery(dburl);
////			if(!rs.next()) {
//				Statement stCrearTabla = conexion.createStatement();
//				String create = "create table Ciudadano (  Nombre varchar(255), Apellidos varchar(255), DNI varchar(9) PRIMARY KEY, Direccion varchar(255), CodigoPostal int(5), Telefono int(9))";
//				stCrearTabla.executeUpdate(create);
////			}
			st.executeUpdate("create table if not exists Ciudadano (  Nombre string, Apellidos string, DNI string, Direccion string, CodigoPostal integer, Telefono integer)");
			Ciudadano ciudadano1 = new Ciudadano("Héctor", "Paramio García", "71474157R", "Mi casa", 489001, 646011211);
			Ciudadano ciudadano2 = new Ciudadano("Jorge", "Clausen", "79124721Y", "casa2", 48100, 61234431); 
			String sentSQL ="";
			sentSQL = "insert into Ciudadano values(" +
                    "'"+ ciudadano1.getaNombre() + "'," +
                    "'" + ciudadano1.getaApellidos() + "'," +
                    "'" + ciudadano1.getaDNI() + "'," +
                    "'" + ciudadano1.getaDireccion() + "'," +
                    "" + ciudadano1.getaCodigoPostal() + "," +
                    "" + ciudadano1.getaTelefono() + ")";
			st.executeUpdate( sentSQL );
		}catch (Exception e) {
			System.out.println("no ha funcionao insertar ");
			e.printStackTrace();
		}
		
	}
	
//	    public boolean InsertarCiudadano(Ciudadano ciudadano) {
//	        //Código para insertar ciudadanos
//	        String sentSQL = "";
//	        try {
//	        	
//	            sentSQL = "insert into Ciudadano values(" +
//	                    ""+ ciudadano.getaNombre() + "," +
//	                    "'" + ciudadano.getaApellidos() + "'," +
//	                    "'" + ciudadano.getaDNI() + "'," +
//	                    "'" + ciudadano.getaDireccion() + "'," +
//	                    "" + ciudadano.getaCodigoPostal() + "," +
//	                    "'" + ciudadano.getaTelefono() + ")";
//	            
//	            Statement st = initBD();
//	            int val = st.executeUpdate( sentSQL );
//	           
//	            if (val!=1) {  // Se tiene que a�adir 1 - error si no
//	               
//	                return false;  
//	            }
//	            return true;
//	        } catch (SQLException e) {
//	           
//	            lastError = e;
//	            e.printStackTrace();
//	            return false;
//	        }        
//	    }
	
	
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
			System.out.println("no ha funcionao");
			e.printStackTrace();
		}
		
		
		
	}
		
		
	}
	
	


