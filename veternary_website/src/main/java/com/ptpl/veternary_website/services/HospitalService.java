package com.ptpl.veternary_website.services;

import java.util.List;

import com.ptpl.veternary_website.entities.Hospital;
import com.ptpl.veternary_website.payloads.DoctorDto;
import com.ptpl.veternary_website.payloads.HospitalDto;

public interface HospitalService {
	

	// Method to create a new hospital by providing the details in a HospitalDto object
    HospitalDto createHospital(HospitalDto hospitalDto);

    // Method to retrieve a list of all hospitals
    List<HospitalDto> getAllHospitals();

    // Method to update an existing hospital by providing updated details in a HospitalDto object
    HospitalDto updateHospital(HospitalDto hospitalDto, Integer hosId);

    // Method to delete a hospital by providing the hospital ID (hosId) of the hospital to be deleted
    void deleteHospital(Integer hosId);

	
	  // Add a doctor to a hospital
    HospitalDto addDoctorToHospital(Integer hosId, Integer docId);
    
    // Remove a doctor from a hospital
    HospitalDto removeDoctorFromHospital(Integer hosId, Integer docId);
    
    // Get all doctors associated with a hospital
    List<DoctorDto> getAllDoctorsByHospitalId(Integer hosId);
    
    // Get all hospitals associated with a doctor
    List<HospitalDto> getAllHospitalsByDoctorId(Integer docId);

}
