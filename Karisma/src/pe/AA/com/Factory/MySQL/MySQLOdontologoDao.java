package pe.AA.com.Factory.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pe.AA.com.Bean.BeanCita;
import pe.AA.com.Bean.BeanOdontologo;
import pe.AA.com.Bean.BeanPersona;
import pe.AA.com.Factory.MySQLDaoFactory;
import pe.AA.com.Factory.Interface.I_Odontologo;
import pe.AA.com.Util.DBConnection;

public class MySQLOdontologoDao extends MySQLDaoFactory implements I_Odontologo {

	public MySQLOdontologoDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<BeanOdontologo> buscarOdontologosLibres() {
		// TODO Auto-generated method stub
		List<BeanOdontologo> lista=new ArrayList<BeanOdontologo>();
		Connection con =null;
		try{
			con=DBConnection.getConnection();
			String sql="SELECT concat('Dr. ',nom,' ',apeMat,' ',apePat) AS odontologo,idodontologo FROM persona P, odontologo O WHERE P.idpersona=O.idpersona AND O.estado='L'";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			BeanOdontologo odontologo=null;
			
			while(rs.next()){
				odontologo=new BeanOdontologo();
				odontologo.setNombreOdontologo(rs.getString("odontologo"));
				odontologo.setIdodontologo(rs.getInt("idodontologo"));
				lista.add(odontologo);
			}
			
		}catch(Exception e){
			System.out.println("Error en Buscar Odontologo: "+e);
		}
		
		
		return lista;
	}

	@Override
	public boolean actualizarEstado(int idodontologo,String estado) {
		// TODO Auto-generated method stub
		boolean flag=false;
		int filas = 0;
		Connection con=null;
		try{
			con=DBConnection.getConnection();
			Statement stmt=con.createStatement();
			
			String sql="UPDATE odontologo " +
					"SET estado ='"+estado+"' WHERE idodontologo='"+idodontologo+"'";
			
			//PreparedStatement ps=con.prepareStatement(sql);
			
			filas=stmt.executeUpdate(sql);
			
			if(filas!=0){
				flag = true;
			}
		}catch(Exception e){
			System.out.println("Error: "+e);
		}
		return flag;
	}

	@Override
	public String buscarOdontologo(int idodontologo) {
		// TODO Auto-generated method stub
		String odontologo="";
		Connection con=null;
		try{
			con=DBConnection.getConnection();
			String sql="SELECT concat('Dr. ',nom,' ',apeMat,' ',apePat) AS odontologo FROM persona P, odontologo O WHERE P.idpersona=O.idpersona AND O.idodontologo=?";
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setInt(1, idodontologo);;
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				odontologo=rs.getString("odontologo");
			}
		}catch(Exception e){
			System.out.println("Error: "+e);
			
		}
		return odontologo;
	}

	@Override
	public String buscarOdontologosxCita(BeanCita objcita) {
			
			String cadena="";
			Connection con =null;
			try{
				con=DBConnection.getConnection();
				String sql="SELECT nom,apePat,apeMat FROM persona P, odontologo O WHERE  O.idpersona=P.idpersona and O.idodontologo='"+objcita.getOdontologo().getIdodontologo()+"'";
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(sql);
				
				
				while(rs.next()){
					BeanPersona persona = new BeanPersona();
					persona.setNom(rs.getString("nom"));
					persona.setApePat(rs.getString("apePat"));
					persona.setApeMat(rs.getString("apeMat"));
					//Agregar persona a odontologo
					BeanOdontologo odontologo = new BeanOdontologo();
					odontologo.setPersona(persona);
					
					cadena="Dr: "+persona.getNom()+" "+persona.getApePat()+" "+persona.getApeMat();
					
				}
			
			}catch(Exception e){
				System.out.println("Error en Buscar Odontologo x Cita SQL: "+e);
				}
			return cadena ;
			}

	@Override
	public List<BeanOdontologo> buscarOdontologos() {
		// TODO Auto-generated method stub
		return null;
	}

	


}
