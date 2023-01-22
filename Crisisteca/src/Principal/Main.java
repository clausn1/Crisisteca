package Principal;



import java.sql.SQLException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import BasesDeDatos.BDCiudadano;
import BasesDeDatos.BDInstitucion;
import Entidades.Ciudadano;
import Entidades.Institucion;
import Ventanas.VentanaInicio;

public class Main {

	static Logger log;
	
	public static void main(String[] args) throws SQLException {
		log = Logger.getLogger("programLogger");
		try {
		Handler h = new FileHandler("res/informacionPrograma.xml", false);
		Handler herror = new FileHandler("res/erroresdelPrograma.xml", false);
		log.addHandler(h);
		log.addHandler(herror);
		h.setLevel(Level.FINEST);
		herror.setLevel(Level.WARNING);
		}catch (Exception e) {
			log.log(Level.WARNING, "Error al crear los handlers del logger");
		}
		log.setUseParentHandlers(false);
		try {
//		BDInstitucion bdin = new BDInstitucion();
//		BDCiudadano bdciu = new BDCiudadano();
//		Institucion institucion1 = new Institucion("AAA","Nombre 1", "institucion1@gmail.com", 32000, FuncionesEspeciales.crearContraseña());
//		Institucion institucion2 = new Institucion("AAB", "Nombre 2", "institucion2@gmail.com", 32001, FuncionesEspeciales.crearContraseña()); 

//		bdin.InsertarInstitucion(institucion2);
		
		VentanaInicio ventanaInicio = new VentanaInicio();
		ventanaInicio.setVisible(true);

//		System.out.println(bdin);
		
		} catch (Exception e) {
			log.log(Level.SEVERE, "Error en el Main", e);
			JOptionPane.showMessageDialog(null, "Error grave contacta con el equipo de soporte de Crisisteca", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
