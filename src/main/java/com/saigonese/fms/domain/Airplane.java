package com.saigonese.fms.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Airplane implements Serializable {
	@Id
	@GeneratedValue
	private long id;
	@NotEmpty(message = "{msg.error.string.empty}")
	private String serialNumber;
	@NotEmpty(message = "{msg.error.string.empty}")
	private String model;
	@Range(min = 0,max = 853, message="{msg.error.range}")
	private int capacity;
	@OneToMany(mappedBy="airplane")
	@OrderBy("departureDate, departureTime")
	private List<Flight> flights;

	/* Constructors */
	public Airplane() {
	}

	public Airplane(String serialNumber, String model, int capacity) {
		this.serialNumber = serialNumber;
		this.model = model;
		this.capacity = capacity;
	}

	/* Getters and Setters */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	/* Collection Methods */
	public boolean addFlight(Flight flight) {
		boolean success = false;
		if (flights.add(flight)) { 
			flight.setAirplane(this);
			success = true;
		}
		return success;
	}
	
	public boolean removeFlight(Flight flight) {
		boolean success = false;
		if (flights.remove(flight)) {
			flight.setAirplane(null);
			success = true;
		}
		return success;
	}
	
	public String getSerialModel() {
		return serialNumber + " - " + model;
	}
}
