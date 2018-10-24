package com.saigonese.fms.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.saigonese.fms.domain.Booking;

/**
 * 
 * @author Quang Hiep Nguyen
 *
 */
@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
	@Query("SELECT b FROM Booking b WHERE confirmationCode = :cCode")
	public Booking findBookingByConfirmationCode(@Param(value = "cCode") String cCode);
}
