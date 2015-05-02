package pe.AA.com.Factory;
import pe.AA.com.Factory.Interface.*;
public abstract class DaoFactory {

public static final int MYSQL=1;
	
	public static DaoFactory getFactory(int opcion){
		switch(opcion){
		case MYSQL:
			return new MySQLDaoFactory();
			
		default: break;
		}
		return null;
	}
	
	public abstract I_Usuario getUsuarioDao();
	public abstract I_Cita getCitaDao();
	public abstract I_Paciente getPacienteDao();
	public abstract I_Odontologo getOdontologoDao();
	public abstract I_HistorialClinico getHistorialClinicoDao();
	public abstract I_Servicio getServicioDao();
	public abstract I_DetalleHClinico getDetalleHClinicoDao();
	public abstract I_Persona getPersonaDao();
	public abstract I_Distrito getDistritoDao();
	public abstract I_Horario getHorarioDao();
}
