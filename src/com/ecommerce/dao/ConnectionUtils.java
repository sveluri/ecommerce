package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class ConnectionUtils {

	private String userName = "root";
	private String password = "root";
	private String dbName = "ecommerce";
	private String dbms = "mysql";
	private String serverName = "localhost";
	private String portNumber = "3306";

	public Connection getConnection() {

		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);

		if (this.dbms.equals("mysql")) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:" + this.dbms + "://"
						+ this.serverName + ":" + this.portNumber + "/"
						+ this.dbName, connectionProps);
				System.out.println("Connected to database");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (this.dbms.equals("derby")) {
			try {
				conn = DriverManager.getConnection("jdbc:" + this.dbms + ":"
						+ this.dbName + ";create=true", connectionProps);
				System.out.println("Connected to database");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return conn;
	}

	public void releaseConnection(Connection conn) {

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Closing connection failed.");
			}
		}

	}
}
