package Principal;

import BasesDeDatos.BDCiudadano;
import Ventanas.VentanaInicio;

public class Main {

	public static void main(String[] args) {

		Servicio servicio = null;
		
		
		servicio = new BDCiudadano();
		servicio.init("res/bds/bdCiudadano.dat");

		
//		VentanaInicio ventanaInicio = new VentanaInicio();

		
	}
	

	
	
	
	
	
	

}
