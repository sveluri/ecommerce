package com.ecommerce.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class DBCPDataSourceFactory {
	private static String USER_NAME = "root";
	private static String PASSWORD = "root";
	private static String DB_NAME = "ecommerce";

	private static String SERVER_NAME = "localhost";
	private static String PORT_NUMBER = "3306";

	public static DataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();

		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/" + DB_NAME);
		ds.setUsername(USER_NAME);
		ds.setPassword(PASSWORD);

		return ds;
	}
}