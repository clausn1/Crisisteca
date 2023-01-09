package Principal;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import BasesDeDatos.BDCiudadano;

public class FuncionesEspeciales {

	//Crear una contraseña
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
	
	
	//Función que permite saber si existe un usuario al iniciar sesion, al usar la contraseña preferimos usar un prepared statement
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
				return null;
			}
			return -1;
			
		}
	
	//Funcion que permite saber si el String se puede volver numero o no (lo necesitamos para que no error el iniciar sesion)
	public static boolean puedeSerNumero(String palabra) {
		    try {
		        int num = Integer.parseInt(palabra);
		    } catch (Exception e) {
		        return false;
		    }
		    return true;
		}
	
	//Función que reconoce si dicho usuario existe
	public static boolean DuplicadoUsuario (String dniQuizasDuplicado) {
			try {
				Statement st = BDCiudadano.initBD();
				String sql ="select * from Ciudadano where DNI =" + dniQuizasDuplicado;
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
