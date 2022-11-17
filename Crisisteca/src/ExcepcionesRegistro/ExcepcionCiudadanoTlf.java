package ExcepcionesRegistro;

public class ExcepcionCiudadanoTlf extends Exception{
	
	public ExcepcionCiudadanoTlf(String mensaje) {
		super(mensaje);
	}
	
	public ExcepcionCiudadanoTlf() {
		super("Teléfono no válido");
	}	
}