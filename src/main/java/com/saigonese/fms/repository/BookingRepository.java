package com.saigonese.fms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saigonese.fms.domain.Booking;

/**
 * 
 * @author Quang Hiep Nguyen
 *
 */
@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {

}
