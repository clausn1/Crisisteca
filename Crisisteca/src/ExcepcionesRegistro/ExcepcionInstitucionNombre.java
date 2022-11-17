package ExcepcionesRegistro;

public class ExcepcionInstitucionNombre extends Exception{
	
	public ExcepcionInstitucionNombre(String mensaje) {
		super(mensaje);
	}
	
	public ExcepcionInstitucionNombre() {
		super("Nombre de la Institución no válido");
	}
		
}
