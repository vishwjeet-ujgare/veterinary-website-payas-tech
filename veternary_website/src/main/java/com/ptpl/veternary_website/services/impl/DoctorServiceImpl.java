package com.ptpl.veternary_website.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptpl.veternary_website.entities.Doctor;
import com.ptpl.veternary_website.entities.User;
import com.ptpl.veternary_website.exceptions.ResourceNotFoundException;
import com.ptpl.veternary_website.payloads.DoctorDto;
import com.ptpl.veternary_website.payloads.UserDto;
import com.ptpl.veternary_website.repositories.DoctorRepo;
import com.ptpl.veternary_website.repositories.UserRepo;
import com.ptpl.veternary_website.services.DoctorService;
import com.ptpl.veternary_website.services.UserService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepo doctorRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private UserServiceImpl userServiceImpl;

	
	
	
	@Override
	public DoctorDto createDoctor(Integer userId, DoctorDto doctorDto) {

		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));

		Doctor doctor = this.dtoToDoctor(doctorDto);
		doctor.setUser(user);

		Doctor doctorSaved = this.doctorRepo.save(doctor);

		DoctorDto doctorReturn = this.doctorToDto(doctorSaved);
		doctorReturn.setUserDto(this.userServiceImpl.userToDto(doctorSaved.getUser()));
		return doctorReturn;

	}

	@Override
	public DoctorDto getDoctorById(Integer docId) {
		Doctor doctor = this.doctorRepo.findById(docId)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor", "Doctor Id", docId));
		return this.doctorToDto(doctor);
	}

	@Override
	public List<DoctorDto> getAllDoctors() {
		List<Doctor> doctors = this.doctorRepo.findAll();

		List<DoctorDto> doctorDtos = doctors.stream().map(doctor -> this.doctorToDto(doctor))
				.collect(Collectors.toList());

		return doctorDtos;
	}

	public DoctorDto doctorToDto(Doctor doctor) {
		
		User user=this.userRepo.findById(doctor.getUser().getUserId()).orElseThrow(()->new ResourceNotFoundException("User", "UserId", doctor.getUser().getUserId()));
		UserDto userDto = this.userServiceImpl.userToDto(user);
		DoctorDto doctorDto = this.modelMapper.map(doctor, DoctorDto.class);
		doctorDto.setUserDto(userDto);
		return doctorDto;

	}

	public Doctor dtoToDoctor(DoctorDto doctorDto) {
		Doctor doctor = new Doctor();
		doctor.setMiddleName(doctorDto.getMiddleName());
		doctor.setSpecialization(doctorDto.getSpecialization());
		doctor.setGender(doctorDto.getGender());
		doctor.setRegistrationNumber(doctorDto.getRegistrationNumber());
		doctor.setYearOfExperience(doctorDto.getYearOfExperience());
		doctor.setDegree(doctorDto.getDegree());
		doctor.setCollege(doctorDto.getCollege());
		doctor.setYearOfCompletion(doctorDto.getYearOfCompletion());

//		    doctor.setUser(this.userServiceImpl.dtoToUser(doctorDto.getUserDto()));

		return doctor;
	}

	@Override
	public DoctorDto updateDoctor(DoctorDto doctorDto, Integer docId) {
		Doctor doctor = this.doctorRepo.findById(docId)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor", "Doctor Id", docId));
		doctor.setMiddleName(doctorDto.getMiddleName());
		doctor.setSpecialization(doctorDto.getSpecialization());
		doctor.setGender(doctorDto.getGender());
		doctor.setRegistrationNumber(doctorDto.getRegistrationNumber());
		doctor.setYearOfExperience(doctorDto.getYearOfExperience());
		doctor.setDegree(doctorDto.getDegree());
		doctor.setCollege(doctorDto.getCollege());
		doctor.setYearOfCompletion(doctorDto.getYearOfCompletion());
		return this.doctorToDto(this.doctorRepo.save(doctor));
	}

	@Override
	public DoctorDto getDoctorByUserId(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));
		Doctor doctor = this.doctorRepo.findByUser(user);	    
		    if (doctor == null) {
		        // User exists but is not associated with a doctor
		        throw new ResourceNotFoundException("Doctor", "User Id (this user is not a Doctor)", userId);
		        // or return an appropriate response, such as null or an error message
		    }
		    
		return this.doctorToDto(doctor);
	}

	@Override
	public void deleteDoctorById(Integer docId) {
	Doctor doctor= this.doctorRepo.findById(docId).orElseThrow(()->new ResourceNotFoundException("Doctor", "Doctor Id",docId ));
//	doctor.setUser(null);
	this.doctorRepo.delete(doctor);
	}
}
