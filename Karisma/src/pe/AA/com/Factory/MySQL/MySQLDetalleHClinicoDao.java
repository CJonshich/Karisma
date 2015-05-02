package pe.AA.com.Factory.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import pe.AA.com.Bean.BeanDetalleHClinico;
import pe.AA.com.Factory.MySQLDaoFactory;
import pe.AA.com.Factory.Interface.I_DetalleHClinico;
import pe.AA.com.Util.DBConnection;

public class MySQLDetalleHClinicoDao extends MySQLDaoFactory implements I_DetalleHClinico{

	public MySQLDetalleHClinicoDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int actualizarHClinico(BeanDetalleHClinico objDHC) {
		// TODO Auto-generated method stub
		int id=0;
		Connection con=null;
		try{
			con=DBConnection.getConnection();
			String sql="INSERT detalle_historial(diagnostico,observacion,fechaActualizacion,horaActualizado,idodontologo,idservicio,cantidadServicio,idhistorialclinico)"
					+ "VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, objDHC.getDiagnostico());
			ps.setString(2, objDHC.getObservacion());
			ps.setObject(3, objDHC.getFechaActualizacion());
			ps.setString(4, objDHC.getHoraActualizado());
			ps.setInt(5, objDHC.getIdodontologo());
			ps.setInt(6, objDHC.getIdservicio());
			ps.setInt(7, objDHC.getCantidadservicio());
			ps.setInt(8,objDHC.getIdhistorialclinico());
			ps.executeUpdate();
			
			ResultSet rs=ps.getGeneratedKeys();
			if(rs.next()){
				id=rs.getInt(1);
			}
			objDHC.setIddetalle_historial(id);
			
		}catch(Exception e){
			System.out.println("Error: "+e);
		}
		return id;
	}

}
