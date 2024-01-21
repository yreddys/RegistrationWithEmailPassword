package com.Yarraneella.Hotel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;
	private String email;
	private String password; // Encrypted password after the user changes it

	private String generatedPassword; // Generated password for the first login
	private boolean firstLogin;

	@ManyToOne
	@JoinColumn(name = "user_country_id")
	private Country userCountry;

	@ManyToOne
	@JoinColumn(name = "user_state_id")
	private State userState;

	@ManyToOne
	@JoinColumn(name = "user_city_id")
	private City userCity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGeneratedPassword() {
		return generatedPassword;
	}

	public void setGeneratedPassword(String generatedPassword) {
		this.generatedPassword = generatedPassword;
	}

	public boolean isFirstLogin() {
		return firstLogin;
	}

	public void setFirstLogin(boolean firstLogin) {
		this.firstLogin = firstLogin;
	}

	public Country getUserCountry() {
		return userCountry;
	}

	public void setUserCountry(Country userCountry) {
		this.userCountry = userCountry;
	}

	public State getUserState() {
		return userState;
	}

	public void setUserState(State userState) {
		this.userState = userState;
	}

	public City getUserCity() {
		return userCity;
	}

	public void setUserCity(City userCity) {
		this.userCity = userCity;
	}

	public User(Long id, String username, String email, String password, String generatedPassword, boolean firstLogin,
			Country userCountry, State userState, City userCity) {

		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.generatedPassword = generatedPassword;
		this.firstLogin = firstLogin;
		this.userCountry = userCountry;
		this.userState = userState;
		this.userCity = userCity;
	}

	public User() {
	}
}
