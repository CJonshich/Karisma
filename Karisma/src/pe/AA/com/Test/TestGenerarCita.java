package pe.AA.com.Test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import pe.AA.com.Bean.*;
import pe.AA.com.Factory.DaoFactory;
import pe.AA.com.Factory.Interface.*;

import org.junit.Test;

public class TestGenerarCita {
	
	@Test 
	public void testDoPostBPacienteHttpServletRequestHttpServletResponse(){
		//Crear objpaciente
		BeanPaciente actual=new BeanPaciente();
		//Agregar variables a probar
		String dni="876543210";
		//DAO
		I_Paciente pacienteDao = DaoFactory.getFactory(DaoFactory.MYSQL).getPacienteDao();
		actual = pacienteDao.buscarPaciente(dni);
		//Valor no esperado
		BeanPaciente expected = null;
		//Comparar que no se retornó un null
		Assert.assertNotSame(expected, actual);
		
	}
	
	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() {
		//Crear objcita
		BeanCita cita=new BeanCita();
		//Agregar variables a probar
		cita.setIdpaciente(1);
		cita.setIdodontologo(1);
		cita.setMotivo("Dolor de Muelas");
		cita.setHoraIni("10:00:00");
		cita.setFecha("2015-03-21");
		cita.setEstadoCita("A");
		
		//Resultado esperado
		int expected=25;
		//Realizar el insert
		I_Cita citaDao=DaoFactory.getFactory(DaoFactory.MYSQL).getCitaDao();
		int actual=citaDao.registrarCita(cita);
		//Comparar resultado esperado con obtenido
		Assert.assertEquals(expected, actual);
	}

}
