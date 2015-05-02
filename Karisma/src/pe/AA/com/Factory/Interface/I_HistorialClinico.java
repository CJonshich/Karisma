package pe.AA.com.Factory.Interface;

import pe.AA.com.Bean.BeanHistorialClinico;

public interface I_HistorialClinico {

	public int generarHClinico(BeanHistorialClinico objHC);
	
	public int buscarHClinicoxid(int idpaciente);
}
