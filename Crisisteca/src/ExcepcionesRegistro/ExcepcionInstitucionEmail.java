package ExcepcionesRegistro;

public class ExcepcionInstitucionEmail extends Exception{
	
	public ExcepcionInstitucionEmail(String mensaje) {
		super(mensaje);
	}
	
	public ExcepcionInstitucionEmail() {
		super("Email no válido");
	}
}
