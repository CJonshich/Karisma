package pe.AA.com.Factory.MySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pe.AA.com.Bean.BeanServicio;
import pe.AA.com.Factory.MySQLDaoFactory;
import pe.AA.com.Factory.Interface.I_Servicio;
import pe.AA.com.Util.DBConnection;

public class MySQLServicioDao extends MySQLDaoFactory implements I_Servicio {

	public MySQLServicioDao()  {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<BeanServicio> listar() {
		// TODO Auto-generated method stub
		List<BeanServicio> lista=new ArrayList<BeanServicio>();
		Connection con=null;
		
		try{
			con=DBConnection.getConnection();
			String sql="SELECT * FROM servicio WHERE estado=1";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			BeanServicio servicio;
			
			while(rs.next()){
				servicio=new BeanServicio();
				servicio.setIdservicio(rs.getInt("idservicio"));
				servicio.setNomservicio(rs.getString("nomservicio"));
				servicio.setDescripcion(rs.getString("descripcion"));
				servicio.setCosto(rs.getDouble("costo"));
				lista.add(servicio);
			}
			
		}catch(Exception e){
			System.out.println("Error al listar servicios SQL: "+e);
		}
		return lista;
	}

	@Override
	public boolean eliminarServicio(int idservicio) {
		// TODO Auto-generated method stub
		boolean flag=false;
		Connection con = null;
		try{
		con = DBConnection.getConnection();
		String sql="UPDATE servicio SET estado=0 WHERE idservicio='"+idservicio+"'";
		Statement st=con.createStatement();
		int resultado=st.executeUpdate(sql);
		
		if(resultado==1){
			flag=true;
		}
	
		}catch(Exception e){
			System.out.println("Error al eliminar el servicio: "+e);
		}
		return flag;
	}

	@Override
	public BeanServicio buscarxId(int id) {
		// TODO Auto-generated method stub
		BeanServicio servicio=null;
		Connection con=null;
		
		try{
			con=DBConnection.getConnection();
			Statement stmt = con.createStatement();
			String sql="SELECT * FROM servicio WHERE idservicio='"+id+"'";
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				servicio=new BeanServicio();
				servicio.setIdservicio(rs.getInt("idservicio"));
				servicio.setNomservicio(rs.getString("nomservicio"));
				servicio.setDescripcion(rs.getString("descripcion"));
				servicio.setCosto(rs.getDouble("costo"));
			}
			
		}catch(Exception e){
			
			System.out.println("Erro al editar el servicio: "+e);
		}
		
		
		return servicio;
	}

	@Override
	public int agregar(BeanServicio servicio) {
		// TODO Auto-generated method stub
		int id=0;
		Connection con=null;
		try{
			con=DBConnection.getConnection();
			Statement stmt=con.createStatement();
			String sql="INSERT INTO servicio (nomservicio,descripcion,costo) " +
					"VALUES('"+servicio.getNomservicio()+"','"+servicio.getDescripcion()+"','"+servicio.getCosto()+"')";
			
			id=stmt.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
			
			if(id!=0){
				ResultSet rs=null;
				rs=stmt.getGeneratedKeys();
				rs.next();
				id=rs.getInt(1);
				System.out.println("El id con el que ingreso el servicio es: "+id);
			}
			servicio.setIdservicio(id);
		}catch(Exception e){
			System.out.println("Error al ingresar servicio: "+e);
		}
		
		return id;
	}

	@Override
	public boolean editar(BeanServicio servicio) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connection con = null;
		
		try{
			con=DBConnection.getConnection();
			Statement stmt = con.createStatement();
			String sql="UPDATE servicio " +
					"SET nomservicio='"+servicio.getNomservicio()+"'" +
					", descripcion='"+servicio.getDescripcion()+"'" +
					",costo='"+servicio.getCosto()+"'" +
					"WHERE idservicio='"+servicio.getIdservicio()+"' ";
			
			int filas = stmt.executeUpdate(sql);
			if(filas==1){
				flag = true;
			}
			
		}catch(Exception e){
			System.out.println("Error en editar el servicio: "+e);
		}
		
		return flag;
	}

}
