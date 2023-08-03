package com.ptpl.veternary_website.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptpl.veternary_website.entities.Doctor;
import com.ptpl.veternary_website.entities.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital, Integer>{
	List<Hospital> findByDoctors(Doctor doctor);
	List<Hospital> findByIsVerified(boolean isVerified);
	List<Hospital> findByStatus(String status);
	
}
 