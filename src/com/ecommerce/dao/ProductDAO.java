package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ecommerce.dao.entity.Product;

public class ProductDAO {

	public List<Product> searchProducts(String searchKey) {

		List<Product> products = null;

		ResultSet resultSet = null;

		Connection connection;
		try {
			connection = DBCPDataSourceFactory.getDataSource().getConnection();

			ResultSetMapper<Product> resultSetMapper = new ResultSetMapper<Product>();
			PreparedStatement statement = connection
					.prepareStatement(Queries.GET_PRODUCTS);

			statement.setString(1, "%" + searchKey + "%");
			statement.setString(2, "%" + searchKey + "%");
			statement.setString(3, "%" + searchKey + "%");

			resultSet = statement.executeQuery();
			List<Product> pojoList = resultSetMapper.mapRersultSetToObject(
					resultSet, Product.class);

			if (pojoList != null) {
				products = pojoList;
			} else {
				System.out
						.println("ResultSet is empty. Please check if database table is empty");
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}

	public List<Product> getProductByName(String productName) {

		List<Product> products = null;

		ResultSet resultSet = null;

		Connection connection;
		try {
			connection = DBCPDataSourceFactory.getDataSource().getConnection();

			ResultSetMapper<Product> resultSetMapper = new ResultSetMapper<Product>();
			PreparedStatement statement = connection
					.prepareStatement(Queries.GET_PRODUCT_BY_NAME);

			statement.setString(1, productName);

			resultSet = statement.executeQuery();
			List<Product> pojoList = resultSetMapper.mapRersultSetToObject(
					resultSet, Product.class);

			if (pojoList != null) {
				products = pojoList;
			} else {
				System.out
						.println("ResultSet is empty. Please check if database table is empty");
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}
}
