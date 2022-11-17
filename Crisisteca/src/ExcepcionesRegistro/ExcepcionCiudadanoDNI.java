package ExcepcionesRegistro;

public class ExcepcionCiudadanoDNI extends Exception{
	
	public ExcepcionCiudadanoDNI(String mensaje) {
		super(mensaje);
	}
	
	public ExcepcionCiudadanoDNI() {
		super("DNI no válido");
	}
}
//a