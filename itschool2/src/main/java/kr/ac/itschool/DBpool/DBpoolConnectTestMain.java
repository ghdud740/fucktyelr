package kr.ac.itschool.DBpool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DBpoolConnectTestMain {
	public static void main(String[] args) throws Exception {
		DBConnectionManager db =  DBConnectionManager.getInstance();
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "Select * from student";
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getString("name"));
			}
		} catch (Exception e) {
			
		}
}
	
}