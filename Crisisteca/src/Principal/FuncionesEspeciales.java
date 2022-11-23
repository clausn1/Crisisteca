package Principal;

import java.security.SecureRandom;

public class FuncionesEspeciales {

	
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
	
	
	
	
	
	
	
	
	
	
	
}
