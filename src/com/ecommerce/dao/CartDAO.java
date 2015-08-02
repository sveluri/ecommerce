package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ecommerce.dao.entity.Cart;

public class CartDAO {

	public List<Cart> createCart(Cart cart) {

		List<Cart> newCart = null;

		ConnectionUtils connectionUtils = new ConnectionUtils();
		Connection connection = connectionUtils.getConnection();

		if (connection == null) {
			return newCart;
		}
		try {
			PreparedStatement statement = connection
					.prepareStatement(Queries.INSERT_INTO_CART_BY_USERNAME);

			statement.setString(1, cart.getUsername());
			statement.setString(2, cart.getName());

			statement.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return getCart(cart.getUsername());
	}

	public List<Cart> getCart(String username) {

		List<Cart> carts = null;

		Connection connection;
		try {
			connection = DBCPDataSourceFactory.getDataSource().getConnection();

			ResultSet resultSet = null;
			ResultSetMapper<Cart> resultSetMapper = new ResultSetMapper<Cart>();
			PreparedStatement statement = connection
					.prepareStatement(Queries.GET_CART_BY_USERNAME);

			statement.setString(1, username);

			resultSet = statement.executeQuery();
			List<Cart> pojoList = resultSetMapper.mapRersultSetToObject(
					resultSet, Cart.class);

			if (pojoList != null) {
				carts = pojoList;
			} else {
				System.out
						.println("ResultSet is empty. Please check if database table is empty");
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return carts;
	}

	public List<Cart> removeFromCart(Cart cart) {

		List<Cart> newCart = null;

		ConnectionUtils connectionUtils = new ConnectionUtils();
		Connection connection = connectionUtils.getConnection();

		if (connection == null) {
			return newCart;
		}
		try {
			PreparedStatement statement = connection
					.prepareStatement(Queries.REMOVE_FROM_CART);

			statement.setString(1, cart.getUsername());
			statement.setString(2, cart.getName());

			statement.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return getCart(cart.getUsername());
	}
}
