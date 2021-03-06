package xyyj.chapter01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BusinessService {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/db_hibernate?verifyServerCertificate=false&useSSL=false";
		String user = "root";
		String password = "infinera";
		
		return DriverManager.getConnection(url, user, password);
	}
	
	public void saveMonkey(Monkey monkey) {
		Connection conn = null;
		
		try {
			conn = getConnection();
			Statement stat = conn.createStatement();
					
			stat.execute("INSERT INTO MONKEYS(NAME, AGE, GENDER) VALUES(" + "'" + 
					monkey.getName() + "'," + monkey.getAge() + ",'" + monkey.getGender() + "')");
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
			}
		}
	}
}
