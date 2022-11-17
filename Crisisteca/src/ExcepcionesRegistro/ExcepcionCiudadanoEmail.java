package ExcepcionesRegistro;

public class ExcepcionCiudadanoEmail extends Exception{
	
	public ExcepcionCiudadanoEmail(String mensaje) {
		super(mensaje);
	}
	
	public ExcepcionCiudadanoEmail() {
		super("Email no válido");
	}		
}