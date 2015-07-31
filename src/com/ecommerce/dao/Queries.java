package com.ecommerce.dao;

public final class Queries {

	public static final String GET_USER = "select * from user where username = ? and password = ?";
	public static final String CREATE_USER = "insert into user(username, password, email) values(?,?,?)";

}
