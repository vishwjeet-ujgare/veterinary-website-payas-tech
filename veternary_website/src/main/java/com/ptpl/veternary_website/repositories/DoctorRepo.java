package com.ptpl.veternary_website.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ptpl.veternary_website.entities.Doctor;
import com.ptpl.veternary_website.entities.User;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
    Doctor findByUser(User user);
   // Optional<Doctor> findById(Integer id); 
}
