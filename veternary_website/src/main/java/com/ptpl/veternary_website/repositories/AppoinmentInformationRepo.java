package com.ptpl.veternary_website.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ptpl.veternary_website.entities.AppoinmentInformation;

public interface AppoinmentInformationRepo extends JpaRepository<AppoinmentInformation, Long> {

}
