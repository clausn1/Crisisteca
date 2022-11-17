package ExcepcionesRegistro;

public class ExcepcionCiudadanoApellido extends Exception{
	
	public ExcepcionCiudadanoApellido(String mensaje) {
		super(mensaje);
	}
	
	public ExcepcionCiudadanoApellido() {
		super("Apellidos no válidos");
	}
		
	
}
//a