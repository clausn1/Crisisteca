package BasesDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;
import Entidades.Institucion;
import Principal.FuncionesEspeciales;

public class BDInstitucion {
	static Logger log;

	// Tenemos esto para cargar BDInstitucion
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new BDInstitucion();
			}
		});
	}

	/*
	 * Crea una sentencia de base de datos return: st (sentencia de trabajo si se
	 * crea correctamente), en caso de error devuelve null
	 */

	public static Statement initBD() {
		try {
			Class.forName("org.sqlite.JDBC");
			String dburl = "jdbc:sqlite:res/bds/bdFinal.db";
			Connection conexion = DriverManager.getConnection(dburl);
			Statement st = conexion.createStatement();
			return st;

		} catch (Exception e) {
			log = Logger.getLogger("programLogger");
			log.log(Level.SEVERE, "Error creando una sentencia al iniciar la base de datos", e);
			return null;
		}
	}

	/*
	 * Cierra la base de datos abierta param: con (conexion abierta con la base de
	 * datos), st (sentencia abierta de la base de datos)
	 */
	public static void cerrarBD(Connection con, Statement st) {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			log = Logger.getLogger("programLogger");
			log.log(Level.SEVERE, "Error al cerrar la base de datos", e);
		}
	}

	/*
	 * Funcion que sirve para insertar valores (instituciones) en la base de datos
	 * param: institucion (Emergencia creada que cumpla con las caracteristicas de
	 * la entidad Institucion) return: true si se ha añadido la institucion, false
	 * si ha habido un error y no se ha añadido
	 */
	public static boolean InsertarInstitucion(Institucion institucion) {
		// Código para insertar instituciones
		try {
			Statement st = initBD();
			st.executeUpdate(
					"create table if not exists Institucion ( Codigo string, Nombre string, Email string,Telefono integer, Contrasenya string)");
			String sentSQL = "";
			sentSQL = "insert into Institucion values(" + "'" + institucion.getaCodigo() + "'," + "'"
					+ institucion.getaNombre() + "'," + "'" + institucion.getaEmail() + "'," + ""
					+ institucion.getaTelefono() + "," + "'" + institucion.getaContrasenya() + "')";

			st.executeUpdate(sentSQL);
			cerrarBD(initBD().getConnection(), st);
			return true;

		} catch (SQLException e) {
			log = Logger.getLogger("programLogger");
			log.log(Level.WARNING, "Error al Insertar valores en la tabla institucion", e);
			return false;
		}
	}

}