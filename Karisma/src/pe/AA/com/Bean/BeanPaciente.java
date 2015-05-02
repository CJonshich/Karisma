package pe.AA.com.Bean;

public class BeanPaciente {

	public BeanPaciente() {
		// TODO Auto-generated constructor stub
	}
	private int idpaciente;
	private double talla;
	private double peso;
	private String tipoSangre;
	private int estado;
	
	//Bean externos
	private BeanPersona persona;
	private BeanDistrito distrito;
	
	public BeanDistrito getDistrito() {
		return distrito;
	}
	public void setDistrito(BeanDistrito distrito) {
		this.distrito = distrito;
	}
	//Getters and Setters
	public int getIdpaciente() {
		return idpaciente;
	}
	public void setIdpaciente(int idpaciente) {
		this.idpaciente = idpaciente;
	}
	
	public double getTalla() {
		return talla;
	}
	public void setTalla(double talla) {
		this.talla = talla;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getTipoSangre() {
		return tipoSangre;
	}
	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}
	
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public BeanPersona getPersona() {
		return persona;
	}
	public void setPersona(BeanPersona persona) {
		this.persona = persona;
	}
	
	
}
