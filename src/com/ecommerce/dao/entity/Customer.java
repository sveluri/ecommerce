package com.ecommerce.dao.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Customer {

	@Column(name = "ID")
	private int id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;
	@Column(name = "birthdate")
	private Timestamp birthdate;
	@Column(name = "hobbies")
	private String hobbies;
	@Column(name = "favorite_music")
	private String favorite_music;
	@Column(name = "favorite_book")
	private String favorite_book;
	@Column(name = "favorite_tv_shows")
	private String favorite_tv_shows;
	@Column(name = "favorite_quotes")
	private String favorite_quotes;
	@Column(name = "marital_status")
	private String marital_status;
	@Column(name = "educational_status")
	private String educational_status;
	@Column(name = "created")
	private Timestamp created;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Timestamp birthdate) {
		this.birthdate = birthdate;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public String getFavorite_music() {
		return favorite_music;
	}
	public void setFavorite_music(String favorite_music) {
		this.favorite_music = favorite_music;
	}
	public String getFavorite_book() {
		return favorite_book;
	}
	public void setFavorite_book(String favorite_book) {
		this.favorite_book = favorite_book;
	}
	public String getFavorite_tv_shows() {
		return favorite_tv_shows;
	}
	public void setFavorite_tv_shows(String favorite_tv_shows) {
		this.favorite_tv_shows = favorite_tv_shows;
	}
	public String getFavorite_quotes() {
		return favorite_quotes;
	}
	public void setFavorite_quotes(String favorite_quotes) {
		this.favorite_quotes = favorite_quotes;
	}
	public String getMarital_status() {
		return marital_status;
	}
	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}
	public String getEducational_status() {
		return educational_status;
	}
	public void setEducational_status(String educational_status) {
		this.educational_status = educational_status;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
}
