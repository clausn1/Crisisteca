package Principal;

import java.sql.SQLException;

import BasesDeDatos.BDCiudadano;
import Entidades.Ciudadano;
import Ventanas.VentanaInicio;

public class Main {

	public static void main(String[] args) throws SQLException {

		
		Ciudadano ciudadano1 = new Ciudadano("Héctor", "Paramio García", "71474157R", "Mi casa", 489001, 646011211);
		
		BDCiudadano bdciudadano = new BDCiudadano();
		bdciudadano.initBD();
		bdciudadano.Insertar();
		bdciudadano.InsertarCiudadano(ciudadano1);
		
		VentanaInicio ventanaInicio = new VentanaInicio();
		ventanaInicio.setVisible(true);
		

		
	}
	

	
	
	
	
	
	

}
