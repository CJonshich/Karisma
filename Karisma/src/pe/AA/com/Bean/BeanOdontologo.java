package pe.AA.com.Bean;

public class BeanOdontologo {
 
	public BeanOdontologo(){
		
	}
	
	private int idodontologo;
	private String estado;
	private String nombreOdontologo;
	private String colegiatura;
	
	private BeanPersona persona;
	
	
	public String getNombreOdontologo() {
		return nombreOdontologo;
	}
	public void setNombreOdontologo(String nombreOdontologo) {
		this.nombreOdontologo = nombreOdontologo;
	}
	public int getIdodontologo() {
		return idodontologo;
	}
	public void setIdodontologo(int idodontologo) {
		this.idodontologo = idodontologo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}


	public BeanPersona getPersona() {
		return persona;
	}
	public void setPersona(BeanPersona persona) {
		this.persona = persona;
	}
	public String getColegiatura() {
		return colegiatura;
	}
	public void setColegiatura(String colegiatura) {
		this.colegiatura = colegiatura;
	}
	
	
}
