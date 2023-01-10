package Principal;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import BasesDeDatos.BDCiudadano;

public class FuncionesEspeciales {

	/** Genera un serie de 20 caracteres aleatorios (formado por letras mayúsculas, minúsculas y números)
	 *	para ser usados como contraseña
	 *	@return String generado aleatoriamente
	 */
	public static String crearContraseña()
	    {
	        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        SecureRandom sr = new SecureRandom();
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < 20; i++)
	        {
	            int ir = sr.nextInt(chars.length());
	            sb.append(chars.charAt(ir));
	        }
	        return sb.toString();
	    }
	
	/** Genera un serie de caracteres que consiste en un String que recibe como para parámetro pero en mayúscula
	 *	y sin espacios seguido por 4 números aleatorios para ser usado como código de una institución
	 *	@param nombre	Nombre de la institución
	 *	@return String generado aleatoriamente
	 */
	public static String crearCodigo(String nombre)
    {
        final String chars = "0123456789";
        SecureRandom sr = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        sb.append(nombre.replaceAll(" ","").toUpperCase());
        for (int i = 0; i < 4; i++)
        {
            int ir = sr.nextInt(chars.length());
            sb.append(chars.charAt(ir));
        }
        return sb.toString();
    }
	
	/** Permite saber si un usuario en concreto existe en la base de datos y si es un ciudadano o una instituación
	 *	@param usuarioQueBuscamos	Nombre del usuario que buscamos en la base de datos
	 *	@param contrasenyaQueBuscamos	Contraseña del usuario que buscamos en la base de datos
	 *	@return Devuelve 0 si es ciudadano, devuelve 1 si es una institución y devuelve -1 en caso de no existir en la base de datos
	 */
	public static Integer ExisteUsuario(String usuarioQueBuscamos, String contrasenyaQueBuscamos) {
			
			try{
				//Conectarnos
			 	Class.forName("org.sqlite.JDBC");
				String dburl = "jdbc:sqlite:res/bds/bdUsuario.db";
				Connection conexion = DriverManager.getConnection(dburl);
				
				
				if (puedeSerNumero(usuarioQueBuscamos)== true){
					//Buscar el ciudadano
					String sqlCiudadano ="select * from Ciudadano where Telefono = ? and Contrasenya = ?";
					PreparedStatement stC = conexion.prepareStatement(sqlCiudadano);
					stC.setInt(1,Integer.parseInt(usuarioQueBuscamos) );
					stC.setString(2, contrasenyaQueBuscamos);
					ResultSet rsC = stC.executeQuery();
					
					//Si existe el ciudadano devuelve 0
					boolean valorPaCerrar = rsC.next();
				    BDCiudadano.cerrarBD(BDCiudadano.initBD().getConnection(), stC);
					if(valorPaCerrar)return 0;
			

					
				}
				else {
					//Buscar la institución
					String sqlInstitucion = "select * from Institucion where Codigo = ? and Contrasenya = ?";		
					PreparedStatement stI = conexion.prepareStatement(sqlInstitucion);
					stI.setString(1, usuarioQueBuscamos );
					stI.setString(2, contrasenyaQueBuscamos);
					ResultSet rsI = stI.executeQuery();
					
					//Si existe la institucion devuelve 1
					boolean valorPaCerrar = rsI.next();
				    BDCiudadano.cerrarBD(BDCiudadano.initBD().getConnection(), stI);
					if(valorPaCerrar)return 1;			
				}
	
				
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
			return -1;
			
		}
	
	/** Permite saber si un String está formado por solo números o no
	 *	@param palabra	String del que queremos saber si todos sus caracteres son números
	 *	@return Si es o no un String formado por solo números
	 */
	public static boolean puedeSerNumero(String palabra) {
		    try {
		        int num = Integer.parseInt(palabra);
		    } catch (Exception e) {
		    	e.printStackTrace();
		        return false;
		    }
		    return true;
		}

	/** Permite saber si un Ciudadano ya ha sido insertado en la base de datos según su DNI
	 *	@param dniQuizasDuplicado	DNI que se compara con los que hay dentro de la base de datos
	 *	@return Si existe o no un Ciudadano en la base de datos con el DNI recibido
	 */
	public static boolean DuplicadoUsuario (String dniQuizasDuplicado) {
			try {
				Statement st = BDCiudadano.initBD();
				String sql ="select * from Ciudadano where DNI = '" + dniQuizasDuplicado +"'";
				ResultSet rs = st.executeQuery(sql);
				boolean valorPaCerrar = rs.next();
			    BDCiudadano.cerrarBD(BDCiudadano.initBD().getConnection(), st);
				return valorPaCerrar;
				
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}	
		}
	
	/** Permite saber si un Ciudadano ya ha sido insertado en la base de datos según su número de teléfono
	 *	@param telefonoQuizasDuplicado	Número de teléfono que se compara con los que hay dentro de la base de datos
	 *	@return Si existe o no un Ciudadano en la base de datos con el número de teléfono recibido
	 */
	public static boolean DuplicadoTelefono (int telefonoQuizasDuplicado) {
		try {
			Statement st = BDCiudadano.initBD();
			String sql ="select * from Ciudadano where Telefono = " + telefonoQuizasDuplicado;
			ResultSet rs = st.executeQuery(sql);
			boolean valorPaCerrar = rs.next();
		    BDCiudadano.cerrarBD(BDCiudadano.initBD().getConnection(), st);
			return valorPaCerrar;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}	
	}
	
}
