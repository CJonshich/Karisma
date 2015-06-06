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
	
	/*El metodo busca los odontologos que est�n reservados seg�n la fecha y hora
	 * Retorna la respuesta en una lista que luego nos servir� para evaluar la disponibilidad*/
	public List<BeanOdontologo> buscarReservados(String fecha, String idhorario);
	
	/*Filtra los odontologos que no est�n disponibles para una cita seg�n la fecha y hora seleccionada.
	 * El filtro que se env�a es una fracci�n del WHERE que se ejecuta para compara los ids de odontologos que no se quieren tomar*/
	public List<BeanOdontologo> filtrarOdontologos(String filtro);
}
