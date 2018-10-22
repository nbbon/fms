package com.saigonese.fms.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Airport {
	@Id
	@GeneratedValue
	private int id;
	@NotEmpty(message = "{msg.error.string.empty}")
	private String airportcode;
	@NotEmpty(message = "{msg.error.string.empty}")
	private String airportName;
	@NotEmpty(message = "{msg.error.string.empty}")
	private String city;
	@NotEmpty(message = "{msg.error.string.empty}")
	private String country;
	@OneToMany(mappedBy = "destination")
	@OrderBy("arrivalDate, arrivalTime")
	private List<Flight> arrivals;
	@OneToMany(mappedBy = "origin")
	@OrderBy("departureDate, departureTime")
	private List<Flight> departures;

	/* Constructors */
	public Airport() {
	}

	public Airport(String airportcode, String airportName, String city, String country) {
		this.airportcode = airportcode;
		this.airportName = airportName;
		this.city = city;
		this.country = country;
	}

	/* Getters & Setters */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAirportcode() {
		return airportcode;
	}

	public void setAirportcode(String airportcode) {
		this.airportcode = airportcode;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Flight> getArrivals() {
		return arrivals;
	}

	public void setArrivals(List<Flight> arrivals) {
		this.arrivals = arrivals;
	}

	public List<Flight> getDepartures() {
		return departures;
	}

	public void setDepartures(List<Flight> departures) {
		this.departures = departures;
	}

	/* Collection methods */
	public boolean addArrival(Flight flight) {
		boolean success = false;
		if (arrivals.add(flight)) {
			flight.setDestination(this);
			success = true;
		}
		return success;
	}

	public boolean removeArrival(Flight flight) {
		boolean success = false;
		if (arrivals.remove(flight)) {
			flight.setDestination(null);
			success = true;
		}
		return success;
	}

	public boolean addDeparture(Flight flight) {
		boolean success = false;
		if (departures.add(flight)) {
			flight.setOrigin(this);
			success = true;
		}
		return success;
	}

	public boolean removeDeparture(Flight flight) {
		boolean success = false;
		if (departures.remove(flight)) {
			flight.setOrigin(null);
			success = true;
		}
		return success;
	}
}