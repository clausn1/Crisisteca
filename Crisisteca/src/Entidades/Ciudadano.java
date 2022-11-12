package Entidades;

public class Ciudadano {
	
	String aNombre;
	String aApellidos;
	String aDNI;
	String aDireccion;
	int aCodigoPostal;
	int aTelefono;

	public Ciudadano(String aNombre, String aApellidos, String aDNI, String aDireccion, int aCodigoPostal, int aTelefono) {
		super();
		this.aNombre = aNombre;
		this.aApellidos = aApellidos;
		this.aDNI = aDNI;
		this.aDireccion = aDireccion;
		this.aCodigoPostal = aCodigoPostal;
		this.aTelefono = aTelefono;
	}

	public String getaNombre() {
		return aNombre;
	}
	public void setaNombre(String aNombre) {
		this.aNombre = aNombre;
	}
	public String getaApellidos() {
		return aApellidos;
	}
	public void setaApellidos(String aApellidos) {
		this.aApellidos = aApellidos;
	}
	public String getaDNI() {
		return aDNI;
	}
	public void setaDNI(String aDNI) {
		this.aDNI = aDNI;
	}
	public String getaDireccion() {
		return aDireccion;
	}
	public void setaDireccion(String aDireccion) {
		this.aDireccion = aDireccion;
	}
	public int getaCodigoPostal() {
		return aCodigoPostal;
	}
	public void setaCodigoPostal(int aCodigoPostal) {
		this.aCodigoPostal = aCodigoPostal;
	}
	public int getaTelefono() {
		return aTelefono;
	}
	public void setaTelefono(int aTelefono) {
		this.aTelefono = aTelefono;
	}

	@Override
	public String toString() {
		return "Ciudadano [aNombre=" + aNombre + ", aApellidos=" + aApellidos + ", aDNI=" + aDNI + ", aDireccion="
				+ aDireccion + ", aCodigoPostal=" + aCodigoPostal + ", aTelefono=" + aTelefono + "]";
	}
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
