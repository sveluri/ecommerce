package com.ecommerce.dao;

public final class Queries {

	public static final String GET_USER = "select * from user where username = ? and password = ?";
	public static final String CREATE_USER = "insert into user(username, password, email) values(?,?,?)";

	public static final String GET_PRODUCTS = "select * from Product where name like ? or product_type like ? or description like ?";
	public static final String REDUCE_QUANTITY = "update Product set available_quantity = ? where name = ?";
	public static final String GET_PRODUCT_BY_NAME = "select * from Product where name = ?";

	public static final String GET_CART_BY_USERNAME = "select distinct * from Cart where username = ?";
	public static final String INSERT_INTO_CART_BY_USERNAME = "insert into cart(username, name) values( ?, ?)";
	public static final String REMOVE_FROM_CART = "delete from cart where username = ? AND name = ?";
	
	public static final String CREATE_ORDER = "insert into ecommorder(username) values(?)";
	public static final String CREATE_ORDER_ITEM = "insert into orderitem(order_ID, productName, quantity, price) values(?, ?, ?, ?)";
	public static final String GET_ORDER = "select distinct * from ecommorder where username = ? order by created DESC";
	public static final String GET_ORDER_ITEMS = "select * from orderitem where order_ID = ?";
	
	public static final String REMOVE_CART = "delete from cart where username = ? ";

}
