package pe.AA.com.Bean;



public class BeanHistorialClinico {

	public BeanHistorialClinico() {
		// TODO Auto-generated constructor stub
	}
	private int idhistorialclinico;
	private int idpaciente;
	private String observaciones;
	private String alergias;
	private String fechaCreacion;
	private String hora;
	private BeanPaciente paciente;
	private BeanPersona persona;
	private BeanDistrito distrito;
	
	public BeanPersona getPersona() {
		return persona;
	}
	public void setPersona(BeanPersona persona) {
		this.persona = persona;
	}
	public BeanDistrito getDistrito() {
		return distrito;
	}
	public void setDistrito(BeanDistrito distrito) {
		this.distrito = distrito;
	}
	/**
	 * @return the paciente
	 */
	public BeanPaciente getPaciente() {
		return paciente;
	}
	/**
	 * @param paciente the paciente to set
	 */
	public void setPaciente(BeanPaciente paciente) {
		this.paciente = paciente;
	}
	/**
	 * @return the idhistorialclinico
	 */
	public int getIdhistorialclinico() {
		return idhistorialclinico;
	}
	/**
	 * @param idhistorialclinico the idhistorialclinico to set
	 */
	public void setIdhistorialclinico(int idhistorialclinico) {
		this.idhistorialclinico = idhistorialclinico;
	}
	/**
	 * @return the idpaciente
	 */
	public int getIdpaciente() {
		return idpaciente;
	}
	/**
	 * @param idpaciente the idpaciente to set
	 */
	public void setIdpaciente(int idpaciente) {
		this.idpaciente = idpaciente;
	}
	/**
	 * @return the contraindicaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}
	/**
	 * @param contraindicaciones the contraindicaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	/**
	 * @return the fechaCreacion
	 */
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getAlergias() {
		return alergias;
	}
	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}
	
	
}
