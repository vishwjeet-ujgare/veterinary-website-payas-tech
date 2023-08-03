package com.ptpl.veternary_website.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptpl.veternary_website.entities.Doctor;
import com.ptpl.veternary_website.entities.Hospital;
import com.ptpl.veternary_website.exceptions.ResourceNotFoundException;
import com.ptpl.veternary_website.payloads.DoctorDto;
import com.ptpl.veternary_website.payloads.HospitalDto;
import com.ptpl.veternary_website.repositories.DoctorRepo;
import com.ptpl.veternary_website.repositories.HospitalRepo;
import com.ptpl.veternary_website.services.HospitalService;

@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	private HospitalRepo hospitalRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private DoctorRepo doctorRepo;

	@Autowired
	private DoctorServiceImpl doctorServiceImpl;

	@Override
	public HospitalDto createHospital(HospitalDto hospitalDto) {
		HospitalDto hospitalSaved = this.hospitalToDto(this.hospitalRepo.save(this.dtoToHospital(hospitalDto)));
		return hospitalSaved;
	}

	@Override
	public List<HospitalDto> getAllHospitals() {
		List<Hospital> hospitals = this.hospitalRepo.findAll();
		List<HospitalDto> hospitalDtos = hospitals.stream().map(hospital -> this.hospitalToDto(hospital))
				.collect(Collectors.toList());
		return hospitalDtos;
	}

	@Override
	public HospitalDto updateHospital(HospitalDto hospitalDto, Integer hosId) {
		Hospital hospital = hospitalRepo.findById(hosId)
				.orElseThrow(() -> new ResourceNotFoundException("Hospital", "Hospital Id", hosId));
		HospitalDto hospitalDto2 = this.hospitalToDto(hospital);

		if (hospitalDto.isVerified() == false && hospitalDto.isVerified() == true) {
			hospitalDto2.setVerified(hospitalDto.isVerified());
		}

		if (hospitalDto.getStatus() != null && !hospitalDto.getStatus().isEmpty()) {
			hospitalDto2.setStatus(hospitalDto.getStatus());
		}
		if (hospitalDto.getTotalSections() > 0) {
			hospitalDto2.setTotalSections(hospitalDto.getTotalSections());
		}
		if (hospitalDto.getNote() != null && !hospitalDto.getNote().isEmpty()) {
			hospitalDto2.setNote(hospitalDto.getNote());
		}

		return this.hospitalToDto(this.hospitalRepo.save(this.dtoToHospital(hospitalDto2)));
	}

	@Override
	public void deleteHospital(Integer hosId) {
		Hospital hospital = this.hospitalRepo.findById(hosId)
				.orElseThrow(() -> new ResourceNotFoundException("Hospital", "Hopital Id", hosId));
		this.hospitalRepo.delete(hospital);
	}

	@Override
	public HospitalDto addDoctorToHospital(Integer hosId, Integer docId) {
		Hospital hospital = this.hospitalRepo.findById(hosId)
				.orElseThrow(() -> new ResourceNotFoundException("Hospital", "Hopital Id", hosId));

		Doctor doctor = this.doctorRepo.findById(docId)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor", "Doctor Id", docId));

		hospital.getDoctors().add(doctor);
		Hospital updatedHospital = this.hospitalRepo.save(hospital);
		return this.hospitalToDto(updatedHospital);
	}

	@Override
	public HospitalDto removeDoctorFromHospital(Integer hosId, Integer docId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DoctorDto> getAllDoctorsByHospitalId(Integer hosId) {
		Hospital hospital = hospitalRepo.findById(hosId)
				.orElseThrow(() -> new ResourceNotFoundException("Hospital", "Hospital Id ", hosId));
		List<Doctor> doctors = hospital.getDoctors();
		List<DoctorDto> doctorDtos = doctors.stream().map(doctor -> this.doctorServiceImpl.doctorToDto(doctor))
				.collect(Collectors.toList());
		return doctorDtos;
	}

	@Override
	public List<HospitalDto> getAllHospitalsByDoctorId(Integer doctorId) {
		Doctor doctor = doctorRepo.findById(doctorId)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor", "Doctor Id", doctorId));

		List<Hospital> hospitals = doctor.getHospitals();

		List<HospitalDto> hospitalDtos = hospitals.stream().map(hospital -> this.hospitalToDto(hospital))
				.collect(Collectors.toList());
		return hospitalDtos;
	}

	public Hospital dtoToHospital(HospitalDto hospitalDto) {
		return this.modelMapper.map(hospitalDto, Hospital.class);
	}

	public HospitalDto hospitalToDto(Hospital hospital) {

		return this.modelMapper.map(hospital, HospitalDto.class);

	}
}
