/**
 * 
 */
package com.saigonese.fms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.saigonese.fms.domain.Doctor;

/**
 * @author Cong Khanh Tran - trancongkhanh@gmail.com
 *
 * 
 */
@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {

	@Query ("SELECT d FROM Doctor d WHERE doctorCategory.id = :categoryId")
	List<Doctor> findByCategoryId(@Param("categoryId") int categoryId);
	
}
