package com.saigonese.fms.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Airline implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty(message = "{msg.error.string.empty}")
	private String airlineName;
	@OneToMany(mappedBy = "airline")
	@OrderBy("departureDate, departureTime")
	private List<Flight> flights;

	/* Constructors */
	public Airline() {
	}

	public Airline(String airlineName) {
		this.airlineName = airlineName;
	}

	/* Getters & Setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	/* Collections Methods */
	public boolean addFlight(Flight flight) {
		boolean success = false;
		if (flights.add(flight)) {
			flight.setAirline(this);
			success = true;
		}
		return success;
	}

	public boolean removeFlight(Flight flight) {
		boolean success = false;
		if (flights.remove(flight)) {
			flight.setAirline(null);
			success = true;
		}
		return success;
	}
}
