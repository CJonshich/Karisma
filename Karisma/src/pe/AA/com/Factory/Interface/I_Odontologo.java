package pe.AA.com.Factory.Interface;

import java.util.List;

import pe.AA.com.Bean.BeanCita;
import pe.AA.com.Bean.BeanOdontologo;

public interface I_Odontologo {
	
	public List<BeanOdontologo> buscarOdontologos();
	public List<BeanOdontologo>buscarOdontologosLibres(); 
	public String buscarOdontologosxCita(BeanCita objcita);
	public boolean actualizarEstado(int idodontologo, String estado);
	public String buscarOdontologo(int idodontologo);
	
	/*El metodo busca los odontologos que están reservados según la fecha y hora
	 * Retorna la respuesta en una lista que luego nos servirá para evaluar la disponibilidad*/
	public List<BeanOdontologo> buscarReservados(String fecha, String idhorario);
	
	/*Filtra los odontologos que no están disponibles para una cita según la fecha y hora seleccionada.
	 * El filtro que se envía es una fracción del WHERE que se ejecuta para compara los ids de odontologos que no se quieren tomar*/
	public List<BeanOdontologo> filtrarOdontologos(String filtro);
}
