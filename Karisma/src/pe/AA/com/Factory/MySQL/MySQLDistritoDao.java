package pe.AA.com.Factory.MySQL;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pe.AA.com.Bean.BeanDistrito;
import pe.AA.com.Factory.MySQLDaoFactory;
import pe.AA.com.Factory.Interface.I_Distrito;
import pe.AA.com.Util.DBConnection;

public class MySQLDistritoDao extends MySQLDaoFactory implements I_Distrito  {

	@Override
	public List<BeanDistrito> listar() {
		// TODO Auto-generated method stub
		List<BeanDistrito> lista = new ArrayList<BeanDistrito>();
		Connection con=null;
		try{
			con=DBConnection.getConnection();
			String sql="SELECT * FROM distrito";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			BeanDistrito distrito;
			while(rs.next()){
				distrito = new BeanDistrito();
				distrito.setIddistrito(rs.getInt("iddistrito"));
				distrito.setNomdistrito(rs.getString("nomdistrito"));
				lista.add(distrito);
			}
			
			
		}catch(Exception e){
			System.out.println("Error al listar los distritos: "+e);
		}
		
		return lista;
	}

}
