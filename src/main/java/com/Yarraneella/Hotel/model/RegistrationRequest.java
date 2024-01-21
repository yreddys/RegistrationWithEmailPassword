package com.Yarraneella.Hotel.model;

public class RegistrationRequest {
	private String username;
	private String email;
	private Long countryId;
	private Long stateId;
	private Long cityId;

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

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public RegistrationRequest(String username, String email, Long countryId, Long stateId, Long cityId) {

		this.username = username;
		this.email = email;
		this.countryId = countryId;
		this.stateId = stateId;
		this.cityId = cityId;
	}

	RegistrationRequest() {

	}
}
