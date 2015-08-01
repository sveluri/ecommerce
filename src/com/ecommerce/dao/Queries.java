package com.ecommerce.dao;

public final class Queries {

	public static final String GET_USER = "select * from user where username = ? and password = ?";
	public static final String CREATE_USER = "insert into user(username, password, email) values(?,?,?)";

	public static final String GET_PRODUCTS = "select * from Product where name like ? or product_type like ? or description like ?";
	public static final String GET_PRODUCT_BY_NAME = "select * from Product where name = ?";
	
	public static final String GET_CART_BY_USERNAME = "select * from Cart where username = ?";
	
}
