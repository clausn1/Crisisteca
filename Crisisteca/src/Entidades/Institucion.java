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

	

	public String getaCodigo() {
		return aCodigo;
	}



	public void setaCodigo(String aCodigo) {
		this.aCodigo = aCodigo;
	}



	public String getaNombre() {
		return aNombre;
	}



	public void setaNombre(String aNombre) {
		this.aNombre = aNombre;
	}



	public String getaEmail() {
		return aEmail;
	}



	public void setaEmail(String aEmail) {
		this.aEmail = aEmail;
	}



	public int getaTelefono() {
		return aTelefono;
	}



	public void setaTelefono(int aTelefono) {
		this.aTelefono = aTelefono;
	}



	public String getaContrasenya() {
		return aContrasenya;
	}



	public void setaContrasenya(String aContrasenya) {
		this.aContrasenya = aContrasenya;
	}



	@Override
	public String toString() {
		return "Institucion [aCodigo=" + aCodigo + ", aNombre=" + aNombre + ", aEmail=" + aEmail + ", aTelefono="
				+ aTelefono + ", aContrasenya=" + aContrasenya + "]";
	}
}
