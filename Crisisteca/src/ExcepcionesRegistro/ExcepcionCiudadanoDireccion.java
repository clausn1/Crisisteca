package ExcepcionesRegistro;

public class ExcepcionCiudadanoDireccion extends Exception{
	
	public ExcepcionCiudadanoDireccion(String mensaje) {
		super(mensaje);
	}
	
	public ExcepcionCiudadanoDireccion() {
		super("Dirección no válido");
	}		
}
//a