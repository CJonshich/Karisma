package pe.AA.com.Bean;



public class BeanDetalleHClinico {

	public BeanDetalleHClinico() {
		// TODO Auto-generated constructor stub
	}
	private int idhistorialclinico;
	private int iddetalle_historial;
	private String diagnostico;
	private String observacion;
	private String horaActualizado;
	private String fechaActualizacion;
	private int idodontologo;
	private int idservicio;
	private int cantidadservicio;
	
	//Objetos que contiene
	private BeanServicio objservicio;
	private BeanHistorialClinico objhistorial;
	
	public int getIdhistorialclinico() {
		return idhistorialclinico;
	}
	public void setIdhistorialclinico(int idhistorialclinico) {
		this.idhistorialclinico = idhistorialclinico;
	}
	public int getIddetalle_historial() {
		return iddetalle_historial;
	}
	public void setIddetalle_historial(int iddetalle_historial) {
		this.iddetalle_historial = iddetalle_historial;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(String fecha) {
		this.fechaActualizacion = fecha;
	}
	public int getIdodontologo() {
		return idodontologo;
	}
	public void setIdodontologo(int idodontologo) {
		this.idodontologo = idodontologo;
	}
	public int getIdservicio() {
		return idservicio;
	}
	public void setIdservicio(int idservicio) {
		this.idservicio = idservicio;
	}
	public int getCantidadservicio() {
		return cantidadservicio;
	}
	public void setCantidadservicio(int cantidadservicio) {
		this.cantidadservicio = cantidadservicio;
	}
	public String getHoraActualizado() {
		return horaActualizado;
	}
	public void setHoraActualizado(String horaActualizado) {
		this.horaActualizado = horaActualizado;
	}
	public BeanHistorialClinico getObjhistorial() {
		return objhistorial;
	}
	public void setObjhistorial(BeanHistorialClinico objhistorial) {
		this.objhistorial = objhistorial;
	}
	public BeanServicio getObjservicio() {
		return objservicio;
	}
	public void setObjservicio(BeanServicio objservicio) {
		this.objservicio = objservicio;
	}
	
	
}
