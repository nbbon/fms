package com.saigonese.fms.repository;

import com.saigonese.fms.domain.Airline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends CrudRepository<Airline, Long> {
	
}
