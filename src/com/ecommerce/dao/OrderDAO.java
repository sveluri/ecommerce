package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ecommerce.dao.entity.Order;
import com.ecommerce.dao.entity.OrderItem;
import com.ecommerce.dao.entity.Product;

public class OrderDAO {
	
	public void createOrder(List<OrderItem> orderItems, String username) {
		ResultSet resultSet = null;

		Connection connection;
		try {
			connection = DBCPDataSourceFactory.getDataSource().getConnection();

			PreparedStatement orderStatement = connection
					.prepareStatement(Queries.CREATE_ORDER);

			orderStatement.setString(1, username);
			orderStatement.execute();

			orderStatement = connection.prepareStatement(Queries.GET_ORDER);
			ResultSetMapper<Order> orderResultSetMapper = new ResultSetMapper<Order>();
			orderStatement.setString(1, username);
			
			resultSet = orderStatement.executeQuery();
			List<Order> pojoList = orderResultSetMapper.mapRersultSetToObject(
					resultSet, Order.class);

			
			if (pojoList != null) {

				Order order = pojoList.get(0);
				

				PreparedStatement statement = connection
						.prepareStatement(Queries.CREATE_ORDER_ITEM);

				ProductDAO productDAO = new ProductDAO();
				List<Product> products;
				Product product;
				for (OrderItem orderItem : orderItems) {
					products = productDAO.getProductByName(orderItem.getProductName());
					product = products.get(0);
					if((product .getAvailableQuantity() > orderItem.getQuantity())) {

						orderStatement = connection
								.prepareStatement(Queries.REDUCE_QUANTITY);

						orderStatement.setInt(1, product .getAvailableQuantity() - orderItem.getQuantity());
						orderStatement.setString(2, orderItem.getProductName());
						orderStatement.execute();
						
						statement.setInt(1, order.getId());
						statement.setString(2, orderItem.getProductName());
						statement.setInt(3, orderItem.getQuantity());
						
						statement.setInt(4, orderItem.getQuantity() * products.get(0).getPrice());
						statement.execute();
					}
					
										
				}
				orderStatement = connection
						.prepareStatement(Queries.REMOVE_CART);

				orderStatement.setString(1, username);
				orderStatement.execute();

			} else {
				System.out
						.println("ResultSet is empty. Please check if database table is empty");
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<OrderItem> getOrders(String username, int orderId) {
		ResultSet resultSet = null;
		List<OrderItem> pojoList = null;
		Connection connection;
		try {
			connection = DBCPDataSourceFactory.getDataSource().getConnection();

			PreparedStatement orderStatement = connection
					.prepareStatement(Queries.GET_ORDER_ITEMS);

			orderStatement.setInt(1, orderId);
			ResultSetMapper<OrderItem> orderResultSetMapper = new ResultSetMapper<OrderItem>();

			resultSet = orderStatement.executeQuery();
			pojoList = orderResultSetMapper.mapRersultSetToObject(
					resultSet, OrderItem.class);

			if (pojoList != null) {

				

			} else {
				System.out
						.println("ResultSet is empty. Please check if database table is empty");
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pojoList;
	}

	public List<Order> getOrders(String username) {
		ResultSet resultSet = null;
		List<Order> pojoList = null;
		Connection connection;
		try {
			connection = DBCPDataSourceFactory.getDataSource().getConnection();

			PreparedStatement orderStatement = connection
					.prepareStatement(Queries.GET_ORDER);

			orderStatement.setString(1, username);
			ResultSetMapper<Order> orderResultSetMapper = new ResultSetMapper<Order>();

			resultSet = orderStatement.executeQuery();
			pojoList = orderResultSetMapper.mapRersultSetToObject(
					resultSet, Order.class);

			if (pojoList != null) {

				

			} else {
				System.out
						.println("ResultSet is empty. Please check if database table is empty");
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pojoList;
	}
}
