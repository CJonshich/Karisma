package pe.AA.com.Factory.Interface;

import java.util.List;

import pe.AA.com.Bean.BeanCita;

public interface I_Cita {

	public int registrarCita(BeanCita objcita);
	public List<BeanCita> buscarCitasA();
	public int actualizar(BeanCita objcita);
}
