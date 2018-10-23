package com.saigonese.fms.serviceimpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.packt.webstore.domain.Cart;
import com.packt.webstore.exception.InvalidCartException;
import com.saigonese.fms.domain.Flight;
import com.saigonese.fms.repository.FlightRepository;
import com.saigonese.fms.repository.FlightSpecification;
import com.saigonese.fms.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Override
    public List<Flight> findAll() {
        return (List<Flight>) flightRepository.findAll();
    }

    @Override
    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Flight findOne(Long id) {
        return flightRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        flightRepository.delete(id);
    }

    @Override
    public List<Flight> search(String criteria) {
        String[] str = criteria.split(";");

        Specification<Flight> flightSpec = null;

        for (String c : str) {
            if (c.isEmpty() || c.length() <= 3) continue;
            ;
            String code = c.substring(0, 2);
            String opt = c.substring(2, 3);
            String value = c.substring(3);
            System.out.println(code + " " + opt + " " + value);
            switch (code) {
                case "FN": {
                    if (!value.isEmpty()) {
                        if (flightSpec == null) {
                            flightSpec = FlightSpecification.flightNrLike(value);
                        } else {
                            flightSpec = Specifications.where(flightSpec).or(FlightSpecification.flightNrLike(value));
                        }
                    }
                    break;
                }
                case "DD": {
                    if (value != null) {
                        if (flightSpec == null) {
                            flightSpec = FlightSpecification.departureDate(parseDate(value));
                        } else {
                            flightSpec = Specifications.where(flightSpec).and(FlightSpecification.departureDate(parseDate(value)));
                        }
                    }
                    break;
                }
                case "DT": {
                    if (value != null) {
                        if (flightSpec == null) {
                            flightSpec = FlightSpecification.departureTime(parseTime(value));
                        } else {
                            flightSpec = Specifications.where(flightSpec).and(FlightSpecification.departureTime(parseTime(value)));
                        }
                    }
                    break;
                }
                case "AD": {
                    if (value != null) {
                        if (flightSpec == null) {
                            flightSpec = FlightSpecification.arrivalDate(parseDate(value));
                        } else {
                            flightSpec = Specifications.where(flightSpec).and(FlightSpecification.arrivalDate(parseDate(value)));
                        }
                    }
                    break;
                }
                case "AT": {
                    if (value != null) {
                        if (flightSpec == null) {
                            flightSpec = FlightSpecification.arrivalTime(parseTime(value));
                        } else {
                            flightSpec = Specifications.where(flightSpec).and(FlightSpecification.arrivalTime(parseTime(value)));
                        }
                    }
                    break;
                }
                case "DC": {
                    if (value != null) {
                        if (flightSpec == null) {
                            flightSpec = FlightSpecification.originCity(value);
                        } else {
                            flightSpec = Specifications.where(flightSpec).and(FlightSpecification.originCity(value));
                        }
                    }
                    break;
                }
                case "AC": {
                    if (value != null) {
                        if (flightSpec == null) {
                            flightSpec = FlightSpecification.destinationCity(value);
                        } else {
                            flightSpec = Specifications.where(flightSpec).and(FlightSpecification.destinationCity(value));
                        }
                    }
                    break;
                }
                default:
            }
        }

        return (List<Flight>) flightRepository.findAll();
    }

    private DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); //DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
    private DateFormat tf = new SimpleDateFormat("HH:mm"); //DateFormat.getTimeInstance(DateFormat.SHORT, Locale.US);


    private Date parseDate(String strDate) {
        Date result = null;
        try {
            result = df.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

    private Date parseTime(String strTime) {
        Date result = null;
        try {
            result = tf.parse(strTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

}
