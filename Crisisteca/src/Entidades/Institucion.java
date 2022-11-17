package Entidades;

public class Institucion {
	
	private String iNombre;
	private String iEmail;
	private int iTelefono;
	
	public Institucion() {}
	
	public Institucion (String iNombre, String iEmail, int iTelefono) {
		this.iNombre = iNombre;
		this.iEmail = iEmail;
		this.iTelefono = iTelefono;
	}

	public String getiNombre() {
		return iNombre;
	}

	public void setiNombre(String iNombre) {
		this.iNombre = iNombre;
	}

	public String getiEmail() {
		return iEmail;
	}

	public void setiEmail(String iEmail) {
		this.iEmail = iEmail;
	}

	public int getiTelefono() {
		return iTelefono;
	}

	public void setiTelefono(int iTelefono) {
		this.iTelefono = iTelefono;
	}

	@Override
	public String toString() {
		return "Institucion [iNombre=" + iNombre + ", iEmail=" + iEmail + ", iTelefono=" + iTelefono + "]";
	}
}
