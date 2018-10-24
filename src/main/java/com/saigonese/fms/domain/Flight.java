package com.saigonese.fms.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.saigonese.fms.validator.TimeFieldFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Entity
public class Flight implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotEmpty(message = "{msg.error.string.empty}")
    private String flightnr;
    
    @NotNull(message = "{msg.error.required}")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "{msg.error.date.future}")
    private Date departureDate;
    
    @NotNull(message = "{msg.error.required}")
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date departureTime;
    
    @NotNull(message = "{msg.error.required}")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date arrivalDate;
    
    @NotNull(message = "{msg.error.required}")
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date arrivalTime;
   
    @ManyToOne
    private Airline airline;
    
    @ManyToOne
    private Airport origin;
    
    @ManyToOne
    private Airport destination;
    
    @ManyToOne    
    private Airplane airplane;
    
    @OneToMany
    private List<Booking> bookings;

    private static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
            Locale.US);
    private static DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT,
            Locale.US);

    /* Constructors */
    public Flight() {
    }

    /* Getters & Setters */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFlightnr() {
        return flightnr;
    }

    public void setFlightnr(String flightnr) {
        this.flightnr = flightnr;
    }

	/*public String getDepartureDate() {
		return df.format(departureDate);
	}

	public void setDepartureDate(String departureDate) {
		try {
			this.departureDate = df.parse(departureDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

	/*public String getDepartureTime() {
		return tf.format(departureTime);
	}

	public void setDepartureTime(String departureTime) {
		try {
			this.departureTime = tf.parse(departureTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

	/*public String getArrivalDate() {
		return df.format(arrivalDate);
	}

	public void setArrivalDate(String arrivalDate) {
		try {
			this.arrivalDate = df.parse(arrivalDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

	/*public String getArrivalTime() {
		return tf.format(arrivalTime);
	}

	public void setArrivalTime(String arrivalTime) {
		try {
			this.arrivalTime = tf.parse(arrivalTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
    public String toString() {
        return "Flight{" +
                "flightnr='" + flightnr + '\'' +
                ", departureDate=" + departureDate +
                ", departureTime=" + departureTime +
                ", arrivalDate=" + arrivalDate +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}
