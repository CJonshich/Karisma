package pe.AA.com.Factory.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pe.AA.com.Bean.BeanCita;
import pe.AA.com.Bean.BeanDistrito;
import pe.AA.com.Bean.BeanPaciente;
import pe.AA.com.Bean.BeanPersona;

import pe.AA.com.Factory.MySQLDaoFactory;
import pe.AA.com.Factory.Interface.I_Paciente;
import pe.AA.com.Util.DBConnection;

public class MySQLPacienteDao extends MySQLDaoFactory implements I_Paciente {

	public MySQLPacienteDao() {
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public List<BeanPaciente> listar() {
		// TODO Auto-generated method stub
		List<BeanPaciente> lista = new ArrayList<BeanPaciente>();
		Connection con=null;
		try{
			con=DBConnection.getConnection();
			String sql="SELECT * FROM persona P INNER JOIN paciente PA ON PA.idpaciente=P.idpersona INNER JOIN distrito D ON P.iddistrito=D.iddistrito WHERE estado=1";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			BeanPaciente paciente;
			
			while(rs.next()){
				
				BeanDistrito distrito = new BeanDistrito();
				distrito.setIddistrito(rs.getInt("iddistrito"));
				distrito.setNomdistrito(rs.getString("nomdistrito"));
				
				BeanPersona persona = new BeanPersona();
				persona.setIdpersona(rs.getInt("idpersona"));
				persona.setDni(rs.getString("dni"));
				persona.setNom(rs.getString("nom"));
				persona.setApePat(rs.getString("apePat"));
				persona.setApeMat(rs.getString("apeMat"));
				persona.setDomicilio(rs.getString("domicilio"));
				persona.setTelefono(rs.getString("telefono"));
				persona.setSexo(rs.getString("sexo"));
				persona.setEmail(rs.getString("email"));
				persona.setFecNac(rs.getString("fecNac"));
				persona.setDistrito(distrito);
				
				paciente= new BeanPaciente();
				paciente.setIdpaciente(rs.getInt("idpaciente"));
				paciente.setTalla(rs.getDouble("talla"));
				paciente.setPeso(rs.getDouble("peso"));
				paciente.setTipoSangre(rs.getString("gruposangre"));
				paciente.setPersona(persona);
				
				lista.add(paciente);
			}
			
		}catch(Exception e){
			System.out.println("Error al listar pacientes: "+e);
		}
		return lista;
	}

	@Override
	public int ingresarPaciente(BeanPaciente paciente) {
		// TODO Auto-generated method stub
		int id=0;
		Connection con = null;
		try{
			con=DBConnection.getConnection();
			Statement stmt=con.createStatement();
			String query="INSERT INTO persona(nom,apePat,apeMat,fecNac,iddistrito,domicilio,telefono,sexo,email,dni)"
					+ "VALUES('"+paciente.getPersona().getNom()+"','"+paciente.getPersona().getApePat()+"','"+paciente.getPersona().getApeMat()+"','"+paciente.getPersona().getFecNac()+"','"+paciente.getPersona().getDistrito().getIddistrito()+"','"+paciente.getPersona().getDomicilio()+"','"+paciente.getPersona().getTelefono()+"','"+paciente.getPersona().getSexo()+"','"+paciente.getPersona().getEmail()+"','"+paciente.getPersona().getDni()+"')";
			id = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			if(id>0){
				ResultSet rs=null;
				rs=stmt.getGeneratedKeys();
				rs.next();
				id=rs.getInt(1);
				
				String sql="INSERT INTO paciente (idpaciente,talla,peso,gruposangre)" +
					"VALUES('"+id+"','"+paciente.getTalla()+"','"+paciente.getPeso()+"','"+paciente.getTipoSangre()+"')";
				int filas = stmt.executeUpdate(sql);
					if(filas>0){
						paciente.setIdpaciente(id);
					}
			}
			
		}catch(Exception e){
			System.out.println("Error al ingresar paciente: "+e);
		}
		return id;
	}

	@Override
	public boolean eliminarPaciente(int idpaciente) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connection con = null;
		
			try {
				con=DBConnection.getConnection();
				String sql="UPDATE paciente SET estado=0 WHERE idpaciente='"+idpaciente+"' ";
				Statement stmt = con.createStatement();
				
				int resultado=stmt.executeUpdate(sql);
					if(resultado==1){
						flag = true;
					}
					
			} catch (Exception e) {
			// TODO: handle exception
				System.out.println("Error en eliminar paciente SQL: "+e+" Message: "+e.getMessage());
		}
		return flag;
	}

	@Override
	public boolean actualizarPaciente(BeanPaciente paciente) {
		// TODO Auto-generated method stub
		boolean flag=false;
		Connection con = null;
			try {
				con=DBConnection.getConnection();
				String sql="UPDATE persona SET nom='"+paciente.getPersona().getNom()+"', apePat='"+paciente.getPersona().getApePat()+"',apeMat='"+paciente.getPersona().getApeMat()+"', "
						+ "fecNac='"+paciente.getPersona().getFecNac()+"',iddistrito='"+paciente.getPersona().getDistrito().getIddistrito()+"',domicilio='"+paciente.getPersona().getDomicilio()+"', "
						+ "telefono='"+paciente.getPersona().getTelefono()+"', sexo='"+paciente.getPersona().getSexo()+"',email='"+paciente.getPersona().getEmail()+"',dni='"+paciente.getPersona().getDni()+"'"
						+ "WHERE idpersona='"+paciente.getIdpaciente()+"' ";
				Statement stmt = con.createStatement();
				int filas = stmt.executeUpdate(sql);
				if(filas>0){
					String query = "UPDATE paciente SET talla='"+paciente.getTalla()+"',peso='"+paciente.getPeso()+"',gruposangre='"+paciente.getTipoSangre()+"' WHERE idpaciente='"+paciente.getIdpaciente()+"' ";
					int respuesta = stmt.executeUpdate(query);
					
					if(respuesta>0){
						flag=true;
					}else{
						flag=false;
					}//Fin if respuesta
				}else{
					flag = false;
				}//Fin if filas
			} catch (Exception e) {
			// TODO: handle exception
				System.out.println("Error al editar paciente: "+e+" Message: "+e.getMessage());
			}
			
		return flag;
	}

	@Override
	public BeanPaciente buscarPacientexId(int id) {
		// TODO Auto-generated method stub
		BeanPaciente paciente=null;	
		Connection con=null;
		try{
			con=DBConnection.getConnection();
			String sql="SELECT * FROM persona P INNER JOIN paciente PA ON PA.idpaciente=P.idpersona INNER JOIN distrito D ON P.iddistrito=D.iddistrito WHERE idpaciente='"+id+"'";
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			
			if(rs.next()){
				BeanDistrito distrito = new BeanDistrito();
				distrito.setIddistrito(rs.getInt("iddistrito"));
				distrito.setNomdistrito(rs.getString("nomdistrito"));
				
				BeanPersona persona = new BeanPersona();
				persona.setIdpersona(rs.getInt("idpersona"));
				persona.setDni(rs.getString("dni"));
				persona.setNom(rs.getString("nom"));
				persona.setApePat(rs.getString("apePat"));
				persona.setApeMat(rs.getString("apeMat"));
				persona.setDomicilio(rs.getString("domicilio"));
				persona.setTelefono(rs.getString("telefono"));
				persona.setSexo(rs.getString("sexo"));
				persona.setEmail(rs.getString("email"));
				persona.setFecNac(rs.getString("fecNac"));
				persona.setDistrito(distrito);
				
				paciente= new BeanPaciente();
				paciente.setIdpaciente(rs.getInt("idpaciente"));
				paciente.setTalla(rs.getDouble("talla"));
				paciente.setPeso(rs.getDouble("peso"));
				paciente.setTipoSangre(rs.getString("gruposangre"));
				paciente.setPersona(persona);
			}
			System.out.println("Cadena: "+paciente.getPersona().getNom()+" "+paciente.getPersona().getDni());
		}catch(Exception e){
			System.out.println("Error en Buscar Paciente por ID SQL: "+e);
		}
		return paciente;
	}

	@Override
	public BeanPaciente buscarPaciente(String dni) {
		// TODO Auto-generated method stub
		BeanPaciente paciente = null;
		Connection con=null;
		try{
			con=DBConnection.getConnection();
			String sql="SELECT * FROM persona P INNER JOIN paciente PA ON PA.idpaciente=P.idpersona WHERE P.dni=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, dni);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				//Coger datos de clase padre
				BeanPersona persona = new BeanPersona();
	
				persona.setNom(rs.getString("nom"));
				persona.setApePat(rs.getString("apePat"));
				persona.setApeMat(rs.getString("apeMat"));
				persona.setFecNac(rs.getString("fecNac"));
				persona.setDni(rs.getString("dni"));
				persona.setSexo(rs.getString("sexo"));
				//Coger datos clase hija
				paciente=new BeanPaciente();
				paciente.setIdpaciente(rs.getInt("idpaciente"));
				paciente.setTipoSangre(rs.getString("gruposangre"));
				paciente.setTalla(rs.getDouble("talla"));
				paciente.setPeso(rs.getDouble("peso"));
				
				paciente.setPersona(persona);
			}
			
		}catch(Exception e){
			System.out.println("Error en Buscar Paciente SQL: "+e);
		}
		if(paciente!=null){
		System.out.println("Datos del Paciente encontrados con exito: "+paciente.getPersona().getNom());
		}else{
			System.out.println("No se encontró un paciente con dicho DNI");
		}
		return paciente;
	}


	@Override
	public BeanPaciente buscarPacienteXCita(BeanCita objcita) {
		// TODO Auto-generated method stub
		BeanPaciente paciente=null;	
		Connection con=null;
		try{
			con=DBConnection.getConnection();
			String sql="select nom,apeMat,apePat,dni from persona P, paciente PA where P.idpersona=PA.idpaciente and PA.idpaciente=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, objcita.getIdpaciente());
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				BeanPersona persona = new BeanPersona();

				persona.setNom(rs.getString("nom"));
				persona.setApePat(rs.getString("apePat"));
				persona.setApeMat(rs.getString("apeMat"));
				persona.setDni(rs.getString("dni"));
				
				paciente=new BeanPaciente();
			}
			System.out.println("Cadena: "+paciente.getPersona().getNom()+" "+paciente.getPersona().getDni());
		}catch(Exception e){
			System.out.println("Error en Buscar Paciente por Cita SQL: "+e);
		}
		return paciente;
	}

}
