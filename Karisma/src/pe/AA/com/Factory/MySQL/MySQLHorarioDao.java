package pe.AA.com.Factory.MySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pe.AA.com.Bean.*;

import pe.AA.com.Factory.MySQLDaoFactory;
import pe.AA.com.Factory.Interface.I_Horario;
import pe.AA.com.Util.DBConnection;

public class MySQLHorarioDao extends MySQLDaoFactory implements I_Horario {

	@Override
	public List<BeanHorario> listar() {
		// TODO Auto-generated method stub
		List<BeanHorario> lista = new ArrayList<BeanHorario>();  
		Connection con = null;
		try {
			con=DBConnection.getConnection();
			String sql="SELECT * FROM horario";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				BeanHorario horario = new BeanHorario();
				horario.setIdhorario(rs.getInt(1));
				horario.setHoraInicio(rs.getString(2));
				horario.setHoraFin(rs.getString(3));
				lista.add(horario);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return lista;
	}

}
