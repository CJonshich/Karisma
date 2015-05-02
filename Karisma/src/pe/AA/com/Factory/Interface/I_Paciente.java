package pe.AA.com.Factory.Interface;

import java.util.List;

import pe.AA.com.Bean.BeanCita;
import pe.AA.com.Bean.BeanPaciente;



public interface I_Paciente {

	//public String buscarPaciente(String dni);
	public BeanPaciente buscarPacientexId(int id);
	public BeanPaciente buscarPaciente(String dni);
	public BeanPaciente buscarPacienteXCita(BeanCita cita);
	public List<BeanPaciente> listar();
	public int ingresarPaciente(BeanPaciente paciente);
	public boolean eliminarPaciente(int idpaciente);
	public boolean actualizarPaciente(BeanPaciente objPaciente);
}
