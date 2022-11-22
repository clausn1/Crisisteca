package Entidades;

public class Institucion {
	
	private String iCodigo;
	private String iNombre;
	private String iEmail;
	private int iTelefono;
	
	
	public Institucion (String iCodigo, String iNombre, String iEmail, int iTelefono) {
		this.iCodigo = iCodigo;
		this.iNombre = iNombre;
		this.iEmail = iEmail;
		this.iTelefono = iTelefono;
	}

	
	
	public String getiCodigo() {
		return iCodigo;
	}

	public void setiCodigo(String iCodigo) {
		this.iCodigo = iCodigo;
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
		return "Institucion [iCodigo=" + iCodigo + ", iNombre=" + iNombre + ", iEmail=" + iEmail + ", iTelefono="
				+ iTelefono + "]";
	}
}
