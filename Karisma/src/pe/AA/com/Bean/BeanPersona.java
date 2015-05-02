package pe.AA.com.Bean;

import java.io.Serializable;

public class BeanPersona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BeanPersona() {
		// TODO Auto-generated constructor stub
	}
	private int idpersona;
	private String nom;
	private String apePat;
	private String apeMat;
	private String fecNac;
	private String domicilio;
	private String telefono;
	private String sexo;
	private String email;
	private String dni;
	private BeanDistrito distrito;
	
	public int getIdpersona() {
		return idpersona;
	}
	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getApePat() {
		return apePat;
	}
	public void setApePat(String apePat) {
		this.apePat = apePat;
	}
	public String getApeMat() {
		return apeMat;
	}
	public void setApeMat(String apeMat) {
		this.apeMat = apeMat;
	}
	public String getFecNac() {
		return fecNac;
	}
	public void setFecNac(String fecNac) {
		this.fecNac = fecNac;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public BeanDistrito getDistrito() {
		return distrito;
	}
	public void setDistrito(BeanDistrito distrito) {
		this.distrito = distrito;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BeanPersona [idpersona=" + idpersona + ", nom=" + nom
				+ ", apePat=" + apePat + ", apeMat=" + apeMat + ", fecNac="
				+ fecNac + ", domicilio=" + domicilio + ", telefono="
				+ telefono + ", sexo=" + sexo + ", email=" + email + ", dni="
				+ dni + ", distrito=" + distrito + "]";
	}
	
	
	
}
