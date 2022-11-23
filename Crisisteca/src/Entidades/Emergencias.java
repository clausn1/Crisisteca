package Entidades;

public class Emergencias {
	
	private String eLugar;
	private String eTipoEmergencia;
	private boolean eReportar;
	private String eDetalles;
	
	public Emergencias (){}
	
	public Emergencias (String eLugar, String eTipoEmergencia, boolean eReportar, String eDetalles) {
		this.eLugar = eLugar;
		this.eTipoEmergencia = eTipoEmergencia;
		this.eReportar = eReportar;
		this.eDetalles = eDetalles;
	}

	public String geteLugar() {
		return eLugar;
	}

	public void seteLugar(String eLugar) {
		this.eLugar = eLugar;
	}

	public String geteTipoEmergencia() {
		return eTipoEmergencia;
	}

	public void seteTipoEmergencia(String eTipoEmergencia) {
		this.eTipoEmergencia = eTipoEmergencia;
	}

	public boolean iseReportar() {
		return eReportar;
	}

	public void seteReportar(boolean eReportar) {
		this.eReportar = eReportar;
	}

	public String geteDetalles() {
		return eDetalles;
	}

	public void seteDetalles(String eDetalles) {
		this.eDetalles = eDetalles;
	}

	@Override
	public String toString() {
		return "Emergencias [eLugar=" + eLugar + ", eTipoEmergencia=" + eTipoEmergencia + ", eReportar=" + eReportar
				+ ", eDetalles=" + eDetalles + "]";
	}
}