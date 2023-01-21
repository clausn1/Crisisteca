package Principal;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EscrituraLecturaPropiedades {
	
//	public static final String ARCHIVO = "/res/propiedades.properties";
	
	public static void main(String[] args) throws IOException {
		
		
		FileInputStream file = new FileInputStream("res/propiedades.properties");
		Properties properties = new Properties();
		properties.load(file);
		
		String version = properties.getProperty("version");
		String nombreBD = properties.getProperty("nombreBD");
		String numPaises = properties.getProperty("nombreBD");
		String numCiudades = properties.getProperty("numCiudades");
		String numCP = properties.getProperty("numCP");

	}


	
	
	
	
	
	
	
	
	
	
	
	
}
