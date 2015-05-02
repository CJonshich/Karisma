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
}
