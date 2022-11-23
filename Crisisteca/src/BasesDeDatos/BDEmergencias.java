package BasesDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingUtilities;

import Entidades.Emergencias;

public class BDEmergencias {
	
	private static Exception lastError = null;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new BDEmergencias();
			}
		});
	}
	
	public static Statement initBD() {
		try {
	 		Class.forName("org.sqlite.JDBC");
			String dburl = "jdbc:sqlite:res/bds/bdEmergencias.db";
			Connection conexion = DriverManager.getConnection(dburl);
			Statement st = conexion.createStatement();

			return st;
						
			} 
		catch (Exception e) {
			return null;
		}
	}
	
	public void Insertar() throws SQLException {
		try {
			Statement st = initBD();
			st.executeUpdate("create table if not exists Emergencia (  Lugar string, Tipo Emergencia string, Reportar boolean, Detalles/Más Información String)");
			Emergencias em1 = new Emergencias( "Barakaldo", "Robo", true, "Asaltante: Hombre de 1,65 aprox, moreno");
			Emergencias em2 = new Emergencias( "Bilbo", "Robo", false, "Asaltante: Mujer de 1,60 aprox, rubia");
			String sentSQL = "";
			sentSQL = "Insert into Emergencias values(" + 
					"'" + em1.geteLugar() + "'," +
					"'" + em1.geteTipoEmergencia() + "'," +
					"'" + em1.iseReportar() + "'," +
					"'" + em1.geteDetalles() + "',";
			st.executeUpdate( sentSQL );
			
		} catch (Exception e) {
			System.out.println("no ha funcionao insertar ");
			e.printStackTrace();
		}
	}
	
	public static boolean InsertarEmergencia( Emergencias emergencia) {
		try 
		{
			Statement st = initBD();		
			st.executeUpdate("create table if not exists Emergencia (  Lugar string, Tipo Emergencia string, Reportar boolean, Detalles/Más Información String)");
			String sentSQL ="";
			sentSQL = "insert into Emergencias values(" +
                    "'"+ emergencia.geteLugar() + "'," +
                    "'" + emergencia.geteTipoEmergencia() + "'," +
                    "'" + emergencia.iseReportar() + "'," +
                    "'" + emergencia.geteDetalles();
			st.executeUpdate( sentSQL );
			return true;
		}catch (Exception e) {
			return false;
		}  
	}
	
	public void selectPrueba() throws SQLException {
		try {
		Class.forName("org.sqlite.JDBC");
		String dburl = "jdbc:sqlite:res/bds/bdEmergencias.db";
		Connection conexion = DriverManager.getConnection(dburl);
		Statement st = conexion.createStatement();
		String sql ="select * from Emergencia";
		
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			String emergencia= rs.getString(1);
			System.out.println(emergencia);
		}
		}catch(Exception e) {
			System.out.println("no ha funcionao");
			e.printStackTrace();
		}
					
	}
	

}
