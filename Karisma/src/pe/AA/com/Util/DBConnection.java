package pe.AA.com.Util;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String URL="jdbc:mysql://localhost:3306/bd_karisma";
	private static final String USER="root";
	private static final String PASSWORD="root";
	private static final String DRIVER="com.mysql.jdbc.Driver";
	
	static{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		Connection con=null;
		try {
			con=DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return con;
	}
	
	public static void closeConnection(Connection con){
		try{if(con!=null)con.close();}catch(Exception e){};
	}
}