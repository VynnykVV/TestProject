package util;

//STEP 1. Import required packages
import java.sql.*;

public class JDBCConnection {

  	static final String DB_URL = "jdbc:hsqldb:data/project;hsqldb.lock_file=false";

	static final String USER = "dbUser";
	static final String PASS = "userPassword";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			return conn;
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return null;
	}
}