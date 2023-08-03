package com.ptpl.veternary_website.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptpl.veternary_website.entities.AppoinmentInformation;
import com.ptpl.veternary_website.entities.Doctor;
import com.ptpl.veternary_website.entities.Hospital;
import com.ptpl.veternary_website.exceptions.DoctorNotAssociatedException;
import com.ptpl.veternary_website.exceptions.ResourceNotFoundException;
import com.ptpl.veternary_website.payloads.AppoinmentInformationDto;
import com.ptpl.veternary_website.repositories.AppoinmentInformationRepo;
import com.ptpl.veternary_website.repositories.DoctorRepo;
import com.ptpl.veternary_website.repositories.HospitalRepo;
import com.ptpl.veternary_website.services.AppoinmentInformationService;

@Service
public class AppoinmentInformationImpl implements AppoinmentInformationService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private DoctorRepo doctorRepo;
	
	@Autowired
	private HospitalRepo hospitalRepo;
	
	@Autowired
	private AppoinmentInformationRepo appoinmentInformationRepo;
	
	
	@Override
	public AppoinmentInformationDto createAnAppointment(AppoinmentInformationDto appoinmentInformationDto,	Integer docId, Integer hosId) {
		
		// Check if the hosId and docId are not null
	    if (hosId == null ) {
	   
	        throw new IllegalArgumentException("Hospital must not be null.");
	    }
	    
	    if (docId == null ) {
	        throw new IllegalArgumentException("Doctor ID must not be null.");
	    }
	    
	    
		// Fetch the Doctor and Hospital entities using their IDs
	    Doctor doctor = doctorRepo.findById(docId)
	            .orElseThrow(() -> new ResourceNotFoundException("Doctor", "Doctor Id", docId));

	    Hospital hospital = hospitalRepo.findById(hosId)
	            .orElseThrow(() -> new ResourceNotFoundException("Hospital", "Hospital Id", hosId));

	    // Check if the doctor is associated with the hospital
	    if (!hospital.getDoctors().contains(doctor)) {
	        throw new DoctorNotAssociatedException(docId, hosId);
	    }
	    
	    // If doctor is associated with hospital, create and save the appointment
        AppoinmentInformation appointment = this.DtoToAppoinmentInfo(appoinmentInformationDto);
        appointment.setDoctor(doctor);
        appointment.setHospital(hospital);
        
        // Save the appointment
        AppoinmentInformation appointment1 = appoinmentInformationRepo.save(appointment);
		AppoinmentInformationDto appInfoDto=this.AppoinmentInfoTODto(appointment1);
		
		return appInfoDto;
	}

	public AppoinmentInformationDto AppoinmentInfoTODto(AppoinmentInformation appoinmentInformation )
	{
		return modelMapper.map(appoinmentInformation, AppoinmentInformationDto.class);
	}	
	
	public AppoinmentInformation DtoToAppoinmentInfo(AppoinmentInformationDto appoinmentInformationDto )
	{
		return modelMapper.map(appoinmentInformationDto, AppoinmentInformation.class);
	}
}
