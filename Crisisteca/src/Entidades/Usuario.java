package Entidades;

public class Usuario {

	String aNombre;
	int aTelefono;
	String aContrasenya;

	public Usuario(String aNombre, int aTelefono, String aContrasenya) {
		this.aNombre = aNombre;
		this.aTelefono = aTelefono;
		this.aContrasenya = aContrasenya;
	}

	public String getaNombre() {
		return aNombre;
	}

	public void setaNombre(String aNombre) {
		this.aNombre = aNombre;
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
		return "Usuario [aNombre=" + aNombre + ", aTelefono=" + aTelefono + ", aContrasenya=" + aContrasenya + "]";
	}

}
