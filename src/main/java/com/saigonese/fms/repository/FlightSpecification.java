package com.saigonese.fms.repository;

import com.saigonese.fms.domain.Airport;
import com.saigonese.fms.domain.Flight;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

import java.util.Date;

public final class FlightSpecification {
    public static Specification<Flight> flightNr(String flightnr) {
        return new Specification<Flight>() {
            public Predicate toPredicate(Root<Flight> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("flightnr"), flightnr);
            }
        };
    }

    public static Specification<Flight> flightNrLike(String flightnr) {
        return new Specification<Flight>() {
            public Predicate toPredicate(Root<Flight> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                if(flightnr.contains("%")) {
                    return cb.like(root.get("flightnr"), flightnr);
                } else {
                    return cb.like(root.get("flightnr"), flightnr + "%");
                }
            }
        };
    }

    public static Specification<Flight> departureDate(Date departure) {
        return new Specification<Flight>() {
            public Predicate toPredicate(Root<Flight> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("departureDate"), departure);
            }
        };
    }

    public static Specification<Flight> arrivalDate(Date arrival) {
        return new Specification<Flight>() {
            public Predicate toPredicate(Root<Flight> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("arrivalDate"), arrival);
            }
        };
    }

    public static Specification<Flight> departureTime(Date departureTime) {
        return new Specification<Flight>() {
            public Predicate toPredicate(Root<Flight> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("departureTime"), departureTime);
            }
        };
    }

    public static Specification<Flight> arrivalTime(Date arrivalTime) {
        return new Specification<Flight>() {
            public Predicate toPredicate(Root<Flight> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("arrivalTime"), arrivalTime);
            }
        };
    }

    public static Specification<Flight> originCity(String value) {
        return new Specification<Flight>() {
            public Predicate toPredicate(Root<Flight> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Join<Flight, Airport> originJoin = root.join("origin");
                return cb.equal(cb.lower(originJoin.get("city")), value);
            }
        };
    }

    public static Specification<Flight> destinationCity(String value) {
        return new Specification<Flight>() {
            public Predicate toPredicate(Root<Flight> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Join<Flight, Airport> originJoin = root.join("destination");
                return cb.equal(cb.lower(originJoin.get("city")), value);
            }
        };
    }
}
