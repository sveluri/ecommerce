package com.ecommerce.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Product {

	@Column(name = "ID")
	private String id;
	@Column(name = "Company_ID")
	private String companyId;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "product_type")
	private String productType;
	@Column(name = "available_quantity")
	private int availableQuantity;
	@Column(name = "price")
	private int price;

	@Column(name = "priceType")
	private String priceType;

	public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", companyId=" + companyId + ", name="
				+ name + ", description=" + description + ", productType="
				+ productType + ", availableQuantity=" + availableQuantity
				+ ", price=" + price + ", priceType=" + priceType + "]";
	}

}
