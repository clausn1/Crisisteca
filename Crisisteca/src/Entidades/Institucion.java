package Entidades;

public class Institucion {
	
	private String aCodigo;
	private String aNombre;
	private String aEmail;
	private int aTelefono;
	private String aContrasenya;
	
	public Institucion (String aCodigo, String aNombre, String aEmail, int aTelefono, String aContrasenya) {
		this.aCodigo = aCodigo;
		this.aNombre = aNombre;
		this.aEmail = aEmail;
		this.aTelefono = aTelefono;
		this.aContrasenya = aContrasenya;
	}

	/* return: aCodigo (Codigo propio de la institucion)
	 */
	public String getaCodigo() {
		return aCodigo;
	}

	/* return: aCodigo (Codigo propio de la institucion)
	 */
	public void setaCodigo(String aCodigo) {
		this.aCodigo = aCodigo;
	}

	/* return: aNombre (Nombre de la institucion)
	 */
	public String getaNombre() {
		return aNombre;
	}

	/* return: aNombre (Nombre de la institucion)
	 */
	public void setaNombre(String aNombre) {
		this.aNombre = aNombre;
	}

	/* return: aEmail (Email de la Institucion)
	 */
	public String getaEmail() {
		return aEmail;
	}

	/* return: aEmail (Email de la Institucion)
	 */
	public void setaEmail(String aEmail) {
		this.aEmail = aEmail;
	}

	/* return: aTelefono (Telefono de la Institucion)
	 */
	public int getaTelefono() {
		return aTelefono;
	}

	/* return: aTelefono (Telefono de la Institucion)
	 */
	public void setaTelefono(int aTelefono) {
		this.aTelefono = aTelefono;
	}

	/* return: aContrasenya (Contraseña de la Institucion)
	 */
	public String getaContrasenya() {
		return aContrasenya;
	}

	/* return: aContrasenya (Contraseña de la Institucion)
	 */
	public void setaContrasenya(String aContrasenya) {
		this.aContrasenya = aContrasenya;
	}

	/* return: String con todos los parametros de la Institucion
	 */
	@Override
	public String toString() {
		return "Institucion [aCodigo=" + aCodigo + ", aNombre=" + aNombre + ", aEmail=" + aEmail + ", aTelefono="
				+ aTelefono + ", aContrasenya=" + aContrasenya + "]";
	}
}