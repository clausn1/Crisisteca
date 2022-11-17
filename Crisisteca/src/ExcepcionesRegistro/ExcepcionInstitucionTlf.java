package ExcepcionesRegistro;

public class ExcepcionInstitucionTlf extends Exception{
	
	public ExcepcionInstitucionTlf(String mensaje) {
		super(mensaje);
	}
	
	public ExcepcionInstitucionTlf() {
		super("Teléfono no válido");
	}
}
//a