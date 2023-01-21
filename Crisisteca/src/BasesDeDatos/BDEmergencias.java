package BasesDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.SwingUtilities;
import Entidades.Emergencias;

public class BDEmergencias {
	
//Tenemos esto para cargar BDEmergencias		
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new BDEmergencias();
			}
		});
	}

	/* Crea una sentencia de base de datos
	 * return: st (sentencia de trabajo si se crea correctamente), en caso de error devuelve null
	 */
	public static Statement initBD() {
		try {
	 		Class.forName("org.sqlite.JDBC");
			String dburl = "jdbc:sqlite:res/bds/bdFinal.db";
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
	
	/* Funcion que sirve para insertar valores (emergencias) en la base de datos
	 * param: emergencia (Emergencia creada que cumpla con las caracteristicas de la entidad Emergencias)
	 * return: true si se ha añadido la emergencia, false si ha habido un error y no se ha añadido
	 */
	public static boolean InsertarEmergencia( Emergencias emergencia) {
		try 
		{
			Statement st = initBD();		
			st.executeUpdate("create table if not exists Emergencias (  Codigo Postal integer, Calle y numero string,  Tipo Emergencia string,Tlf del Usuario integer, Reportar boolean, Detalles e Información string, Fecha date);");
			String sentSQL ="";
			sentSQL = "insert into Emergencias values(" + emergencia.geteCodigoPostal() + "," +
					"'"+emergencia.geteCalleYNumero()+"',"+
                    "'" + emergencia.geteTipoEmergencia() + "'," +
					+ emergencia.geteUsuario()+","+
                    "'" + emergencia.iseReportar() + "'," +
                    "'" + emergencia.geteDetalles()+"',"+
                    "'"+emergencia.geteFechaYHora()+"');";
			st.executeUpdate( sentSQL );
			cerrarBD(initBD().getConnection(), st);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}  
	}
	
	// Prueba para ver si realmente instertamos Emergencias dentro del database
		public void Insertar() throws SQLException {
			try {
				Statement st = initBD();
				st.executeUpdate("create table if not exists Emergencia (Codigo Postal integer, Calle y numero string,  Tipo Emergencia string,Tlf del Usuario integer, Reportar boolean, Detalles e Información string, Fecha y Hora string)");
				Emergencias em1 = new Emergencias( 48001, "Amistad", "Robo",000000001, true, "Asaltante: Hombre de 1,65 aprox, moreno","22/01/2023-12:23");
	//			Emergencias em2 = new Emergencias( "Bilbo", "Robo", false, "Asaltante: Mujer de 1,60 aprox, rubia");
				String sentSQL = "";
				sentSQL = "Insert into Emergencias values(" +
						+ em1.geteCodigoPostal() + ","+
						"'" + em1.geteCalleYNumero() + "'," +
						"'" + em1.geteTipoEmergencia() + "'," +
						em1.geteUsuario()+
						"'" + em1.iseReportar() + "'," +
						"'" + em1.geteDetalles() + "',"+
						"'"+	em1.geteFechaYHora()+"';";
				st.executeUpdate( sentSQL );
				
			} catch (Exception e) {
				System.out.println("no ha funcionao insertar ");
				e.printStackTrace();
			}
		}
	
// Prueba para ver si realmente seleccionamos emergencias dentro del database
	public void selectPrueba() throws SQLException {
		try {
		Class.forName("org.sqlite.JDBC");
		String dburl = "jdbc:sqlite:res/bds/bdFinal.db";
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

