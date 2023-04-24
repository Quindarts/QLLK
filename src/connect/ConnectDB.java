package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	public ConnectDB() {
		
	}
	public Connection getConnect() {
		Connection con = null;
		String  url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyLinhKien";
		try {
			con = DriverManager.getConnection(url, "sa", "12");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
}
