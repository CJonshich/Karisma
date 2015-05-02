package pe.AA.com.Factory.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import pe.AA.com.Bean.BeanPersona;
import pe.AA.com.Factory.MySQLDaoFactory;
import pe.AA.com.Factory.Interface.I_Persona;
import pe.AA.com.Util.DBConnection;

public class MySQLPersonaDao extends MySQLDaoFactory implements I_Persona {

	public MySQLPersonaDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validarPersona(String dni) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int insert(BeanPersona objpersona) {
		// TODO Auto-generated method stub
		int id=0;
		Connection con=null;
		try{
			con=DBConnection.getConnection();
			String sql="INSERT INTO persona (nom,apePat,apeMat,fecNac,iddistrito,domicilio,telefono,sexo,email,dni)"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, objpersona.getNom());
			ps.setString(2, objpersona.getApePat());
			ps.setString(3, objpersona.getApeMat());
			ps.setString(4, objpersona.getFecNac());
			ps.setInt(5, objpersona.getDistrito().getIddistrito());
			ps.setString(6, objpersona.getDomicilio());
			ps.setString(7, objpersona.getTelefono());
			ps.setString(8, objpersona.getSexo());
			ps.setString(9,objpersona.getEmail());
			ps.setString(10, objpersona.getDni());
			ps.executeUpdate();
			
			ResultSet rs=ps.getGeneratedKeys();
			if(rs.next()){
				id=rs.getInt(1);
				objpersona.setIdpersona(id);
			}else{
				id=-1;
			}
			
		}catch(Exception e){
			System.out.println("Error al ingresar Persona: "+e);
		}
		return id;
	}

}
