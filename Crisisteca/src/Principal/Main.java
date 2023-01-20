package Principal;

import java.sql.SQLException;

import BasesDeDatos.BDCiudadano;
import BasesDeDatos.BDInstitucion;
import Entidades.Ciudadano;
import Entidades.Institucion;
import Ventanas.VentanaInicio;

public class Main {

	public static void main(String[] args) throws SQLException {

		

		
		
		BDInstitucion bdin = new BDInstitucion();
		BDCiudadano bdciu = new BDCiudadano();
//		Institucion institucion1 = new Institucion("AAA","Nombre 1", "institucion1@gmail.com", 32000, FuncionesEspeciales.crearContraseña());
		Institucion institucion2 = new Institucion("AAB", "Nombre 2", "institucion2@gmail.com", 32001, FuncionesEspeciales.crearContraseña()); 

		bdin.InsertarInstitucion(institucion2);
		
		VentanaInicio ventanaInicio = new VentanaInicio();
		ventanaInicio.setVisible(true);

		System.out.println(bdin);
	}
	

	
	
	
	
	
	

}
