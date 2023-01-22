package Entidades;

public class Ciudadano extends Usuario {

	String aApellidos;
	String aDNI;
	String aDireccion;
	int aCodigoPostal;

	public Ciudadano(String aNombre, String aApellidos, String aDNI, String aDireccion, int aCodigoPostal,
			int aTelefono, String aContrasenya) {
		super(aNombre, aTelefono, aContrasenya);

		this.aApellidos = aApellidos;
		this.aDNI = aDNI;
		this.aDireccion = aDireccion;
		this.aCodigoPostal = aCodigoPostal;

	}

	/*
	 * return: aApellidos (Apellidos del ciudadano)
	 */
	public String getaApellidos() {
		return aApellidos;
	}

	/*
	 * return: aApellidos (Apellidos del ciudadano)
	 */
	public void setaApellidos(String aApellidos) {
		this.aApellidos = aApellidos;
	}

	/*
	 * return: aDNI (DNI del ciudadano)
	 */
	public String getaDNI() {
		return aDNI;
	}

	/*
	 * return: aDNI (DNI del ciudadano)
	 */
	public void setaDNI(String aDNI) {
		this.aDNI = aDNI;
	}

	/*
	 * return: aDireccion (Direccion del ciudadano)
	 */
	public String getaDireccion() {
		return aDireccion;
	}

	/*
	 * return: aDireccion (Direccion del ciudadano)
	 */
	public void setaDireccion(String aDireccion) {
		this.aDireccion = aDireccion;
	}

	/*
	 * return: aCodigoPostal (Codigo Postal del ciudadano)
	 */
	public int getaCodigoPostal() {
		return aCodigoPostal;
	}

	/*
	 * return: aCodigoPostal (Codigo Postal del ciudadano)
	 */
	public void setaCodigoPostal(int aCodigoPostal) {
		this.aCodigoPostal = aCodigoPostal;
	}

	/*
	 * return: String con todos los parametros del ciudadano
	 */
	@Override
	public String toString() {
		return "Ciudadano [aNombre=" + aNombre + ", aApellidos=" + aApellidos + ", aDNI=" + aDNI + ", aDireccion="
				+ aDireccion + ", aCodigoPostal=" + aCodigoPostal + ", aTelefono=" + aTelefono + "]";
	}

}