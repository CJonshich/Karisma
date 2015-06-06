package pe.AA.com.Factory.MySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pe.AA.com.Bean.BeanCita;
import pe.AA.com.Bean.BeanOdontologo;
import pe.AA.com.Bean.BeanPaciente;
import pe.AA.com.Bean.BeanPersona;
import pe.AA.com.Factory.MySQLDaoFactory;
import pe.AA.com.Factory.Interface.I_Cita;
import pe.AA.com.Util.DBConnection;

public class MySQLCitaDao extends MySQLDaoFactory implements I_Cita {

	public MySQLCitaDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int registrarCita(BeanCita objcita) {
		// TODO Auto-generated method stub
		
		int id=0;
		Connection con=null;
		System.out.println("El objeto a ingresar es: "+objcita);
		
		try{
			con=DBConnection.getConnection();
			Statement stmt=con.createStatement();
			String sql="INSERT INTO cita" +
					"(idpaciente,idodontologo,fecha,idhorario,motivo,estadoCita) " +
					"VALUES" +
					"('"+objcita.getIdpaciente()+"','"+objcita.getIdodontologo()+"','"+objcita.getFecha()+"','"+objcita.getHoraIni()+"','"+objcita.getMotivo()+"','"+objcita.getEstadoCita()+"') ";
			
			id = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

					if(id != 0){
						ResultSet rs = null;
						rs = stmt.getGeneratedKeys();
			            rs.next();
			            id = rs.getInt(1);
						System.out.print("El id es: "+id);
					}
			
			
			
			objcita.setIdcita(id);
		}catch(Exception e){
			System.out.println("Error Ingresar Cita SQL: "+e);
		}
		//Retorna el id de la fila que se ingresó.
		System.out.println("El retorno es: "+id);
		return id;
	}

	@Override
	public List<BeanCita> buscarCitasA() {
		// TODO Auto-generated method stub
		//Busca las citas Activas en el sistema
		List<BeanCita> lista = new ArrayList<BeanCita>();
		Connection con=null;
		
		try{
			con=DBConnection.getConnection();
			Statement stmt=con.createStatement();
			//Devuelve una lista con ids sacados de la tabla cita más los datos del paciente
			String sql="SELECT C.idpaciente,C.idodontologo,C.idcita, P.nom as nom,P.apePat as apePat,P.apeMat as apeMat,P.dni FROM cita C, persona P, paciente PA WHERE estadoCita='A'  AND C.idpaciente=PA.idpaciente  AND PA.idpersona=P.idpersona";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				
				BeanCita cita=new BeanCita();
				cita.setIdcita(rs.getInt("idcita"));
				//Comenzar por Persona por alguna razón que desconozco
				BeanPersona persona=new BeanPersona();
				persona.setNom(rs.getString("nom"));
				persona.setApePat(rs.getString("apePat"));
				persona.setApeMat(rs.getString("apeMat"));
				persona.setDni(rs.getString("dni"));
				//Añadir a paciente persona
				BeanPaciente paciente = new BeanPaciente();
				paciente.setIdpaciente(rs.getInt("idpaciente"));
				paciente.setPersona(persona);
				//Agregar a odontologo
				BeanOdontologo odontologo = new BeanOdontologo();
				odontologo.setIdodontologo(rs.getInt("idodontologo"));
				//Agregar paciente y odontologo a cita
				cita.setPaciente(paciente);
				cita.setOdontologo(odontologo);
				lista.add(cita);
				System.out.println("El resultado de buscar cita activa es: "+cita.getIdcita());
				
			}
			
		}catch(Exception e){
			System.out.println("Error en Buscar Cita SQL: "+e+" "+e.getMessage()+" "+e.getLocalizedMessage());
		}
		return lista;
	}

	@Override
	public int actualizar(BeanCita objcita) {
		// TODO Auto-generated method stub
		int rpta=-1;
		Connection con=null;
		try{
			con=DBConnection.getConnection();
			Statement stmt=con.createStatement();
			String sql="UPDATE cita " +
					"SET recomendacion='"+objcita.getRecomendacion()+"',horaFin=(SELECT current_time()),diagnostico='"+objcita.getDiagnostico()+"',estadoCita='"+objcita.getEstadoCita()+"'  " +
							"WHERE idcita='"+objcita.getIdcita()+"'";
			
			rpta=stmt.executeUpdate(sql);
			
		
		}catch(Exception e){
			System.out.println("Error en Actualizar Cita SQL: "+e);
		}
		return rpta;
	}

}
