package com.ecommerce.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Cart {

	@Column(name = "ID")
	private String id;

	@Column(name = "username")
	private String username;
	@Column(name = "name")
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cart(String username, String name) {
		super();
		this.username = username;
		this.name = name;
	}

	public Cart() {
		super();
	}

}
