package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ecommerce.dao.entity.Customer;

public class CustomerDAO {

	public Customer getCustomer(String username, String password) {

		Customer customer = null;

		ConnectionUtils connectionUtils = new ConnectionUtils();
		Connection connection = connectionUtils.getConnection();

		if (connection == null) {
			return customer;
		}
		ResultSet resultSet = null;
		try {
			ResultSetMapper<Customer> resultSetMapper = new ResultSetMapper<Customer>();
			PreparedStatement statement = connection
					.prepareStatement(Queries.GET_CUSTOMER);
			
			statement.setString(1, username);
			statement.setString(2, password);
			
			resultSet = statement.executeQuery();
			List<Customer> pojoList = resultSetMapper.mapRersultSetToObject(
					resultSet, Customer.class);

			if (pojoList != null && pojoList.size() == 1) {
				customer = pojoList.get(0);
			} else {
				System.out
						.println("ResultSet is empty. Please check if database table is empty");
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customer;
	}

}
