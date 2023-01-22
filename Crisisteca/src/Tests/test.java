package Tests;

import static org.junit.Assert.*;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import BasesDeDatos.BDCiudadano;
import BasesDeDatos.BDEmergencias;
import BasesDeDatos.BDInstitucion;
import Entidades.Ciudadano;
import Entidades.Emergencias;
import Entidades.Institucion;
import Principal.FuncionesEspeciales;

public class test {

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
		borrarTodoTest();
	}

	@Test
	public void test() throws SQLException, ClassNotFoundException {
		// Inserta ciudadano correctamente
//		Ciudadano ciudadano1 = new Ciudadano("Prueba", "Garcia", "19273287N", "Palomar Azul", 48003, 987216261,
//				"Ahas79SAhAjasdash7ASH");
		Ciudadano ciudadano1 = new Ciudadano("Prueba", null, "Prueba", null, 0, 0, "Prueba");
		int valorAntesInsertarCiudadano = contarFilasCiudadano();
		BDCiudadano.InsertarCiudadano(ciudadano1);
		int valorDespuesInsertarCiudadano = contarFilasCiudadano();
		assertEquals(valorDespuesInsertarCiudadano, valorAntesInsertarCiudadano + 1);

		// Inserta institucion correctamente
		Institucion institucion1 = new Institucion("Prueba", null, null, 0, "Prueba");
		int valorAntesInsertarInstitucion = contarFilasInstitucion();
		BDInstitucion.InsertarInstitucion(institucion1);
		int valorDespuesInsertarInstitucion = contarFilasInstitucion();
		assertEquals(valorDespuesInsertarInstitucion, valorAntesInsertarInstitucion + 1);

		// Inserta emergencia correctamente
		Emergencias emergencia1 = new Emergencias(null, null, null, 0, false, null, null);
		int valorAntesInsertarEmergencia = contarFilasEmergencias();
		BDEmergencias.InsertarEmergencia(emergencia1);
		int valorDespuesInsertarEmergencia = contarFilasEmergencias();
		assertEquals(valorDespuesInsertarEmergencia, valorAntesInsertarEmergencia + 1);
		
		//ExisteUsuario() funciona
		assertEquals(FuncionesEspeciales.ExisteUsuario("0", "Prueba"), 0);
		assertEquals(FuncionesEspeciales.ExisteUsuario("Prueba", "Prueba"), 1);
		assertEquals(FuncionesEspeciales.ExisteUsuario("NoExiste", "NoExiste"), -1);
		
		//DuplicadoTelefono() funciona
		assertTrue(FuncionesEspeciales.DuplicadoTelefono(0));
		assertFalse(FuncionesEspeciales.DuplicadoTelefono(-1));
		//Se reconoce lo que está duplicado
		assertTrue(FuncionesEspeciales.DuplicadoUsuario("Prueba"));
		assertFalse(FuncionesEspeciales.DuplicadoUsuario("Prueba2"));

		//puedeSerNumero() funciona
		assertTrue(FuncionesEspeciales.puedeSerNumero("123123"));
		assertFalse(FuncionesEspeciales.puedeSerNumero("123123O"));
		assertFalse(FuncionesEspeciales.puedeSerNumero("aAaA"));

		//Devuelve Ciudadano correctamnte
		assertEquals(FuncionesEspeciales.devolverCiudadano(0).getaNombre().toString(), "Prueba");
		
		//Devuelve Institución correctamente
		assertEquals(FuncionesEspeciales.devolverInstitucion("Prueba").getaTelefono(), 0);

	}

	public int contarFilasCiudadano() throws SQLException {
		Statement st = BDCiudadano.initBD();
		ResultSet rs = st.executeQuery("Select count(*) From Ciudadano");
		int valor = (int) rs.getObject(1);
		BDCiudadano.cerrarBD(BDCiudadano.initBD().getConnection(), st);
		return valor;
	}

	public int contarFilasInstitucion() throws SQLException {
		Statement st = BDInstitucion.initBD();
		ResultSet rs = st.executeQuery("Select count(*) From Institucion");
		int valor = (int) rs.getObject(1);
		BDInstitucion.cerrarBD(BDInstitucion.initBD().getConnection(), st);
		return valor;
	}

	public int contarFilasEmergencias() throws SQLException {
		Statement st = BDEmergencias.initBD();
		ResultSet rs = st.executeQuery("Select count(*) From Emergencias");
		int valor = (int) rs.getObject(1);
		BDEmergencias.cerrarBD(BDEmergencias.initBD().getConnection(), st);
		return valor;
	}
	
	public void borrarTodoTest() throws SQLException {
		Statement st = BDEmergencias.initBD();
		int rs1 = st.executeUpdate("Delete From Ciudadano where Nombre ='Prueba'");
		int rs2 = st.executeUpdate("Delete From Institucion where Codigo ='Prueba'");
		int rs3 = st.executeUpdate("Delete From Emergencias where Telefono =0");

		BDEmergencias.cerrarBD(BDEmergencias.initBD().getConnection(), st);
	}

}
