package ExcepcionesRegistro;

public class ExcepcionesCiudadanoNombre extends Exception{
	
	public ExcepcionesCiudadanoNombre(String mensaje) {
		super(mensaje);
	}
	
	public ExcepcionesCiudadanoNombre() {
		super("Nombre no válido");
	}
}