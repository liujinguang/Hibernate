package xyyj.chapter01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class BusinessService2 {
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/db_hibernate";
		String user = "root";
		String password = "infinera";
		
		Properties properties = new Properties();
		
		properties.setProperty("user", "root");
		properties.setProperty("password", "infinera");
		properties.setProperty("useSSL", "false");
		properties.setProperty("verifyServerCertificate", "false");
		
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
