package Entidades;

public class Ciudadano extends Usuario{
	
//	String aNombre;
	String aApellidos;
	String aDNI;
	String aDireccion;
	int aCodigoPostal;
//	int aTelefono;
//	String aContrasenya;


	public Ciudadano(String aNombre, String aApellidos, String aDNI, String aDireccion, int aCodigoPostal, int aTelefono, String aContrasenya) {
		super(aNombre, aTelefono, aContrasenya);
//		this.aNombre = aNombre;
		this.aApellidos = aApellidos;
		this.aDNI = aDNI;
		this.aDireccion = aDireccion;
		this.aCodigoPostal = aCodigoPostal;
//		this.aTelefono = aTelefono;
//		this.aContrasenya = aContrasenya;
	}
	
	/* return: aNombre (Nombre del ciudadano)
	 */
//	public String getaNombre() {
//		return aNombre;
//	}
//	
//	/* return: aNombre (Nombre del ciudadano)
//	 */
//	public void setaNombre(String aNombre) {
//		this.aNombre = aNombre;
//	}
	
	/* return: aApellidos (Apellidos del ciudadano)
	 */
	public String getaApellidos() {
		return aApellidos;
	}
	
	/* return: aApellidos (Apellidos del ciudadano)
	 */
	public void setaApellidos(String aApellidos) {
		this.aApellidos = aApellidos;
	}
	
	/* return: aDNI (DNI del ciudadano)
	 */
	public String getaDNI() {
		return aDNI;
	}
	
	/* return: aDNI (DNI del ciudadano)
	 */
	public void setaDNI(String aDNI) {
		this.aDNI = aDNI;
	}
	
	/* return: aDireccion (Direccion del ciudadano)
	 */
	public String getaDireccion() {
		return aDireccion;
	}
	
	/* return: aDireccion (Direccion del ciudadano)
	 */
	public void setaDireccion(String aDireccion) {
		this.aDireccion = aDireccion;
	}
	
	/* return: aCodigoPostal (Codigo Postal del ciudadano)
	 */
	public int getaCodigoPostal() {
		return aCodigoPostal;
	}
	
	/* return: aCodigoPostal (Codigo Postal del ciudadano)
	 */
	public void setaCodigoPostal(int aCodigoPostal) {
		this.aCodigoPostal = aCodigoPostal;
	}
	
	/* return: aTelefono (Telefono del ciudadano)
	 */
//	public int getaTelefono() {
//		return aTelefono;
//	}
//	
//	/* return: aTelefono (Telefono del ciudadano)
//	 */
//	public void setaTelefono(int aTelefono) {
//		this.aTelefono = aTelefono;
//	}
	
	/* return: aContasenya (Contraseña del ciudadano)
	 */
//	public String getaContrasenya() {
//		return aContrasenya;
//	}
//	
//	/* return: aContasenya (Contraseña del ciudadano)
//	 */
//	public void setaContrasenya(String aContrasenya) {
//		this.aContrasenya = aContrasenya;
//	}
//	
	/* return: String con todos los parametros del ciudadano
	 */
	@Override
	public String toString() {
		return "Ciudadano [aNombre=" + aNombre + ", aApellidos=" + aApellidos + ", aDNI=" + aDNI + ", aDireccion="
				+ aDireccion + ", aCodigoPostal=" + aCodigoPostal + ", aTelefono=" + aTelefono + "]";
	}
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}