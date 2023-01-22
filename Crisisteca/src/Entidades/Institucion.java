package Entidades;

public class Institucion extends Usuario {

	private String aCodigo;
	private String aEmail;

	public Institucion(String aCodigo, String aNombre, String aEmail, int aTelefono, String aContrasenya) {
		super(aNombre, aTelefono, aContrasenya);
		this.aCodigo = aCodigo;
		this.aNombre = aNombre;
		this.aEmail = aEmail;
		this.aTelefono = aTelefono;
		this.aContrasenya = aContrasenya;
	}

	/*
	 * return: aCodigo (Codigo propio de la institucion)
	 */
	public String getaCodigo() {
		return aCodigo;
	}

	/*
	 * return: aCodigo (Codigo propio de la institucion)
	 */
	public void setaCodigo(String aCodigo) {
		this.aCodigo = aCodigo;
	}

	/*
	 * return: aEmail (Email de la Institucion)
	 */
	public String getaEmail() {
		return aEmail;
	}

	/*
	 * return: aEmail (Email de la Institucion)
	 */
	public void setaEmail(String aEmail) {
		this.aEmail = aEmail;
	}

	/*
	 * return: String con todos los parametros de la Institucion
	 */
	@Override
	public String toString() {
		return "Institucion [aCodigo=" + aCodigo + ", aNombre=" + aNombre + ", aEmail=" + aEmail + ", aTelefono="
				+ aTelefono + ", aContrasenya=" + aContrasenya + "]";
	}
}