package com.saigonese.fms.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Passenger {
	@Id
	@GeneratedValue
	private long id;
	
	@NotEmpty(message = "{msg.error.required}")
	private String firstName;
	@NotEmpty(message = "{msg.error.required}")
	private String lastName;
	@NotEmpty(message = "{msg.error.required}")
	private String passportNumber;
	
	@OneToMany
	private List<Booking> bookings;
	
	public Passenger() {
		
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPassportNumber() {
		return passportNumber;
	}
	
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setPassenger(List<Booking> bookings) {
		this.bookings = bookings;
	}
	
}
