package com.ecommerce.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class OrderItem {

	@Column(name = "ID")
	private int id;
	@Column(name = "order_ID")
	private int orderId;
	@Column(name = "productName")
	private String productName;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "price")
	private int price;
	
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return this.orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
