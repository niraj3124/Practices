package payment.com.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectivity {
	static Connection conn=null;
	public static Connection getConnected() throws SQLException{
		conn=DriverManager.getConnection("jdbc:oracle:thin:@10.219.34.3:1521:orcl","trg1124","training1124");
		return  conn;
	}

}
