package com.saigonese.fms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Address {
	@Id
	@GeneratedValue
	@Column(name = "ADDRESS_ID")
	private int id;
	
	@NotEmpty(message = "{String.empty}")
	@Column(name = "STREET")
	private String street;

	@NotEmpty(message = "{String.empty}")
	@Column(name = "CITY")
	private String city;

	@Column(name = "STATE")
	@Size(min = 2, max = 2, message = "{error.state}")
	private String state;

	@Column(name = "ZIP_CODE")
	@Pattern(regexp = "\\d{5}", message = "{error.zip}")
	private String zip;
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}
