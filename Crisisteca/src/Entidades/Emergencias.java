package Entidades;
public class Emergencias {
	
	private Integer eCodigoPostal;
	private String eCalleYNumero;
	private String eTipoEmergencia;
	private Integer eUsuario;
	private boolean eReportar;
	private String eDetalles;
	private String eFechaYHora;
	
	
	public Emergencias (){}
	
	public Emergencias (Integer eCodigoPostal, String eCalleYNumero, String eTipoEmergencia,Integer eUsuario, boolean eReportar, String eDetalles,String eFechaYHora) {
		this.eCodigoPostal = eCodigoPostal;
		this.eCalleYNumero = eCalleYNumero;
		this.eTipoEmergencia = eTipoEmergencia;
		this.eUsuario= eUsuario;
		this.eReportar = eReportar;
		this.eDetalles = eDetalles;
		this.eFechaYHora=eFechaYHora;
	}
	
	/* return: eCodigoPostal (Codigo postal de donde ocurre la emergencia)
	 */
	public Integer geteCodigoPostal() {
		return eCodigoPostal;
	}
	
	/* return: eCodigoPostal (Codigo postal de donde ocurre la emergencia)
	 */
	public void seteCodigoPostal(Integer eCodigoPostal) {
		this.eCodigoPostal = eCodigoPostal;
	}
	/*
	 * return: eCalleYNumero:(La calle y el nº de donde ocurre la emergencia)
	 */
	public String geteCalleYNumero() {
		return eCalleYNumero;
	}
	/*
	 * return: eCalleYNumero:(La calle y el nº de donde ocurre la emergencia)
	 */
	public void seteCalleYNumero(String eCalleYNumero) {
		this.eCalleYNumero = eCalleYNumero;
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
	/*
	 * return: eUsuario (El telefono del usuario que ha reportado la emergencia)
	 */
	public Integer geteUsuario() {
		return eUsuario;
	}
	/*
	 * return: eUsuario (El telefono del usuario que ha reportado la emergencia)
	 */
	public void seteUsuario(Integer eUsuario) {
		this.eUsuario = eUsuario;
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
	
	/*
	 * return: eFechaYHora ( La fecha y la hora a la que se ha reportado la emergencia)
	 */
	public String geteFechaYHora() {
		return eFechaYHora;
	}
	/*
	 * return: eFechaYHora ( La fecha y la hora a la que se ha reportado la emergencia)
	 */
	public void seteFechaYHora(String eFechaYHora) {
		this.eFechaYHora = eFechaYHora;
	}
	/* return: String con todos los parametros de la emergencia
	 */
	@Override
	public String toString() {
		return "Emergencias [eCodigoPostal=" + eCodigoPostal + ",eCalleYNumero=" +eCalleYNumero+ " , eTipoEmergencia=" + eTipoEmergencia +", eUsuario="+eUsuario +", eReportar=" + eReportar
				+ ", eDetalles=" + eDetalles +", eFechaYHora = "+eFechaYHora+ "]";
	}
}
