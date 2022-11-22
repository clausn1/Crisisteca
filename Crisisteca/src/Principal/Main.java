package Principal;

import java.sql.SQLException;

import BasesDeDatos.BDCiudadano;
import Entidades.Ciudadano;
import Ventanas.VentanaInicio;

public class Main {

	public static void main(String[] args) throws SQLException {

		
		
		
		BDCiudadano bdciudadano = new BDCiudadano();
		bdciudadano.initBD();
		bdciudadano.Insertar();
	
		VentanaInicio ventanaInicio = new VentanaInicio();
		ventanaInicio.setVisible(true);
		

		
	}
	

	
	
	
	
	
	

}
