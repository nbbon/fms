package com.saigonese.fms.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author Quang Hiep Nguyen
 *
 */

@Entity
public class Booking implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull(message = "{msg.error.required}")
	private String confirmationCode;
	
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date bookingDate;

	@Valid
    @ManyToOne
    private Flight flight;
	
	@Valid
    @ManyToOne(cascade = CascadeType.ALL)
    private Passenger passenger;
    
	public Booking() {
		this.passenger = new Passenger();
		this.flight = new Flight();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getConfirmationCode() {
		return confirmationCode;
	}

	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

}
