package pe.AA.com.Bean;

public class BeanUsuario {

	
	private int idUsuario;
	private String usuario;
	private String clave;
	private String rol;
	private int estado;
	private BeanPersona persona;
	
	public BeanUsuario() {
		// TODO Auto-generated constructor stub
	}
	
	


	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
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
