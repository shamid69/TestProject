package jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class TestConn {
	
	 private final static String url = "jdbc:postgresql://dbs2.informatik.uni-halle.de:5435/";
	 private final static String user = "ahhuk";
	 private final static String pass = "4b570";
	
	 
	 public static void main(String arg[]){
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("connected!\n");
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		String ename;
		String query = "select city from city "
				     + "where city like 'Ber%';";
		
		Statement stm = null;
		ResultSet rs = null;
		int i=1;
		try {
			stm = conn.createStatement();
			rs = stm.executeQuery(query);
			while (rs.next()) {
				ename = rs.getString(1);
				System.out.println("City "+i+" : " + ename);
				i++;
			}
		} catch(SQLException e){
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null)
					rs.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
			
	 } 	
}
