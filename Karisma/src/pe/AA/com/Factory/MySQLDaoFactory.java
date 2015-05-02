package pe.AA.com.Factory;

import pe.AA.com.Factory.Interface.*;
import pe.AA.com.Factory.MySQL.*;

public class MySQLDaoFactory extends DaoFactory{

	@Override
	public I_Usuario getUsuarioDao() {
		// TODO Auto-generated method stub
		return new MySQLUsuarioDao();
	}

	@Override
	public I_Cita getCitaDao() {
		// TODO Auto-generated method stub
		return new MySQLCitaDao();
	}

	@Override
	public I_Paciente getPacienteDao() {
		// TODO Auto-generated method stub
		return new MySQLPacienteDao();
	}

	@Override
	public I_Odontologo getOdontologoDao() {
		// TODO Auto-generated method stub
		return new MySQLOdontologoDao();
	}

	@Override
	public I_HistorialClinico getHistorialClinicoDao() {
		// TODO Auto-generated method stub
		return new MySQLHistorialClinicoDao();
	}

	@Override
	public I_Servicio getServicioDao() {
		// TODO Auto-generated method stub
		return new MySQLServicioDao();
	}

	@Override
	public I_DetalleHClinico getDetalleHClinicoDao() {
		// TODO Auto-generated method stub
		return new MySQLDetalleHClinicoDao();
	}

	@Override
	public I_Persona getPersonaDao() {
		// TODO Auto-generated method stub
		return new MySQLPersonaDao();
	}

	@Override
	public I_Distrito getDistritoDao() {
		// TODO Auto-generated method stub
		return new MySQLDistritoDao();
	}

	@Override
	public I_Horario getHorarioDao() {
		// TODO Auto-generated method stub
		return new MySQLHorarioDao();
	}



	
}
