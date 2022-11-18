package Principal;

import java.sql.SQLException;
import java.sql.Statement;

import Entidades.Ciudadano;

public interface Servicio {



	public void Insertar() throws SQLException;

	public boolean InsertarCiudadano(Ciudadano ciudadano);


	public void init(String string);



}