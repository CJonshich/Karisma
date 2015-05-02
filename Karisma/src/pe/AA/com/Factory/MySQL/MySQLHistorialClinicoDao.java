package pe.AA.com.Factory.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import pe.AA.com.Bean.BeanHistorialClinico;
import pe.AA.com.Factory.MySQLDaoFactory;
import pe.AA.com.Factory.Interface.I_HistorialClinico;
import pe.AA.com.Util.DBConnection;

public class MySQLHistorialClinicoDao extends MySQLDaoFactory implements I_HistorialClinico {

	public MySQLHistorialClinicoDao()  {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int generarHClinico(BeanHistorialClinico objHC) {
		// TODO Auto-generated method stub
		int id=0;
		
		Connection con=null;
		try{
			
			con=DBConnection.getConnection();
			Statement stmt=con.createStatement();
			
			String sql="INSERT INTO historialclinico " +
					"(fechaCreacion,horaCreacion,observaciones,alergias,idpaciente) " +
					"VALUES((SELECT current_date()),(SELECT current_time()),'"+objHC.getObservaciones()+"','"+objHC.getAlergias()+"','"+objHC.getPaciente().getIdpaciente()+"')";

			id=stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			
		}catch(Exception e)
		{
			System.out.println("Error en agregar historial clinico: "+e);
		}
		return id;
	}

	@Override
	public int buscarHClinicoxid(int idpaciente) {
		// TODO Auto-generated method stub
		int id=0;
		Connection con=null;
		try{
			con=DBConnection.getConnection();
			
			String sql="SELECT idhistorialclinico FROM historialclinico WHERE idpaciente=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, idpaciente);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				id=rs.getInt("idhistorialclinico");
			}
			
		}catch(Exception e){
			System.out.println("Error: "+e);
		}
		return id;
	}

	


}
