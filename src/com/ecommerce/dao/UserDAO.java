package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ecommerce.dao.entity.User;

public class UserDAO {

	public User getUser(String username, String password) {

		User User = null;

		ConnectionUtils connectionUtils = new ConnectionUtils();
		Connection connection = connectionUtils.getConnection();

		if (connection == null) {
			return User;
		}
		ResultSet resultSet = null;
		try {
			ResultSetMapper<User> resultSetMapper = new ResultSetMapper<User>();
			PreparedStatement statement = connection
					.prepareStatement(Queries.GET_USER);

			statement.setString(1, username);
			statement.setString(2, password);

			resultSet = statement.executeQuery();
			List<User> pojoList = resultSetMapper.mapRersultSetToObject(
					resultSet, User.class);

			if (pojoList != null && pojoList.size() == 1) {
				User = pojoList.get(0);
			} else {
				System.out
						.println("ResultSet is empty. Please check if database table is empty");
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return User;
	}

	public User createUser(User user) {

		User User = null;

		ConnectionUtils connectionUtils = new ConnectionUtils();
		Connection connection = connectionUtils.getConnection();

		if (connection == null) {
			return User;
		}
		try {
			PreparedStatement statement = connection
					.prepareStatement(Queries.CREATE_USER);

			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());

			statement.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return getUser(user.getUsername(), user.getPassword());
	}

}
