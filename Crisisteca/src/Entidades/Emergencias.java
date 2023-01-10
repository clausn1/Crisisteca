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
	
	/* return: eLugar (Lugar donde ocurre la emergencia)
	 */
	public String geteLugar() {
		return eLugar;
	}
	
	/* return: eLugar (Lugar donde ocurre la emergencia)
	 */
	public void seteLugar(String eLugar) {
		this.eLugar = eLugar;
	}

	/* return: eTipoEmergencia (Tipo de emergencia que se reporta)
	 */
	public String geteTipoEmergencia() {
		return eTipoEmergencia;
	}

	/* return: eTipoEmergencia (Tipo de emergencia que se reporta)
	 */
	public void seteTipoEmergencia(String eTipoEmergencia) {
		this.eTipoEmergencia = eTipoEmergencia;
	}

	/* return: eReportar (Valor booleano que indica si se desea reportar la emergencia o no)
	 */
	public boolean iseReportar() {
		return eReportar;
	}

	/* return: eReportar (Valor booleano que indica si se desea reportar la emergencia o no)
	 */
	public void seteReportar(boolean eReportar) {
		this.eReportar = eReportar;
	}
	
	/* return: eDetalles (String con detalles sobre la emergencia que el usuario quiera añadir)
	 */
	public String geteDetalles() {
		return eDetalles;
	}
	
	/* return: eDetalles (String con detalles sobre la emergencia que el usuario quiera añadir)
	 */
	public void seteDetalles(String eDetalles) {
		this.eDetalles = eDetalles;
	}

	/* return: String con todos los parametros de la emergencia
	 */
	@Override
	public String toString() {
		return "Emergencias [eLugar=" + eLugar + ", eTipoEmergencia=" + eTipoEmergencia + ", eReportar=" + eReportar
				+ ", eDetalles=" + eDetalles + "]";
	}
}