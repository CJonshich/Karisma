package pe.AA.com.Factory.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import pe.AA.com.Bean.*;
import pe.AA.com.Util.*;
import pe.AA.com.Factory.MySQLDaoFactory;
import pe.AA.com.Factory.Interface.I_Usuario;

public class MySQLUsuarioDao extends MySQLDaoFactory implements I_Usuario {

	@Override
	public BeanUsuario acceder(String usuario, String clave) {
		// TODO Auto-generated method stub
		BeanUsuario objUsuario = null;
		Connection con=null;
		try{
			con=DBConnection.getConnection();
			Statement stmt=con.createStatement();
			String sql="SELECT * FROM usuario U INNER JOIN persona P ON U.idusuario=P.idpersona " +
					"WHERE U.usuario='"+usuario+"' AND U.clave='"+clave+"' AND U.estado=1";

			ResultSet rs= stmt.executeQuery(sql);			
			if(rs.next()){
				BeanPersona persona = new BeanPersona();
				persona.setIdpersona(rs.getInt("P.idpersona"));
				persona.setNom(rs.getString("P.nom"));
				persona.setApePat(rs.getString("P.apePat"));
				persona.setApeMat(rs.getString("P.apeMat"));
				persona.setDni(rs.getString("P.dni"));
				persona.setFecNac(rs.getString("P.fecNac"));
				persona.setEmail(rs.getString("P.email"));
				persona.setTelefono(rs.getString("P.telefono"));
				
				objUsuario = new BeanUsuario();
				objUsuario.setRol(rs.getString("U.rol"));
				objUsuario.setUsuario(rs.getString("U.usuario"));
				objUsuario.setClave(rs.getString("U.clave"));
				objUsuario.setIdUsuario(rs.getInt("U.idusuario"));
				
				objUsuario.setPersona(persona);
			}
			
			System.out.println("Se ha logueado el usuario: "+objUsuario.getUsuario()+" con Rol: "+objUsuario.getRol());
		}catch(Exception e){
			System.out.println("Error al loguearse y obtener los datos: "+e);
		}
		return objUsuario;
	}

	@Override
	public boolean validar(String usuario, String clave) {
		// TODO Auto-generated method stub
		boolean rpta=false;
		Connection con=null;
		try {
			con=DBConnection.getConnection();
			Statement stmt=con.createStatement();
			String sql="SELECT * FROM usuario U INNER JOIN persona P ON U.idusuario=P.idpersona " +
					"WHERE U.usuario='"+usuario+"' AND U.clave='"+clave+"' AND U.estado=1";

			ResultSet rs= stmt.executeQuery(sql);			
			if(rs.next()){
				rpta=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return rpta;
	}

}
