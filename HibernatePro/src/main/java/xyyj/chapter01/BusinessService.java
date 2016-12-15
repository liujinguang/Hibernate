package xyyj.chapter01;

import java.sql.DriverManager;

public class BusinessService {
	private String url = "jdbc:mysql://localhost:3306/db_hibernate";
	private String user = "root";
	private String password = "liuqi80";
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
