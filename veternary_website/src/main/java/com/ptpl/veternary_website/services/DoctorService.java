package com.ptpl.veternary_website.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ptpl.veternary_website.payloads.DoctorDto;

public interface DoctorService {

	DoctorDto createDoctor(Integer userId, DoctorDto doctorDto);

	List<DoctorDto> getAllDoctors();

	DoctorDto getDoctorById(Integer docId);

	DoctorDto updateDoctor(DoctorDto doctorDto, Integer docId);

	DoctorDto getDoctorByUserId(Integer userId);
	
	void deleteDoctorById(Integer docId);

}
