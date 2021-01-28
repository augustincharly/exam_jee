package augustin_charly_jee.jee.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnect {
	private static DataConnect INSTANCE;
	private Connection connection;

	private DataConnect() throws ClassNotFoundException {

		String url = "jdbc:mysql://localhost:3306/augustin_charly_jee?serverTimezone=Europe/Paris";
		String user = "root";
		String password = "";

		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			this.connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.exit(0);
		}
	}

	public static DataConnect getInstance() {
		if (INSTANCE == null) {
			try {
				INSTANCE = new DataConnect();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		return INSTANCE;
	}

	public Connection getConnection() {
		return this.connection;
	}

	public void closeConnection() {
		try {
			this.connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}