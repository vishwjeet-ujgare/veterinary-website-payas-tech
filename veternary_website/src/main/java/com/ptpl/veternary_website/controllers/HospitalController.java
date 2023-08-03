package com.ptpl.veternary_website.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ptpl.veternary_website.payloads.ApiResponse;
import com.ptpl.veternary_website.payloads.DoctorDto;
import com.ptpl.veternary_website.payloads.HospitalDto;
import com.ptpl.veternary_website.payloads.UserDto;
import com.ptpl.veternary_website.services.HospitalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/patners/")
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;

	//POST -> create hospital
	@PostMapping("/hospital")
	public ResponseEntity<HospitalDto> createHospital(@RequestBody HospitalDto hospitalDto) {
		HospitalDto hospitalSaved = this.hospitalService.createHospital(hospitalDto);
		return new ResponseEntity<>(hospitalSaved, HttpStatus.CREATED);
	}

	// PUT -> Update user
	@PutMapping("/hospital/{hosId}")
	public ResponseEntity<HospitalDto> updateHospital(@RequestBody HospitalDto hospitalDto,
			@PathVariable Integer hosId) {
		HospitalDto updatedHospital = this.hospitalService.updateHospital(hospitalDto, hosId);
		return ResponseEntity.ok(updatedHospital);
	}

	//Delete user
	@DeleteMapping("/hospital/{hosId}")
	public ResponseEntity<ApiResponse> deleteHospital(@PathVariable("hosId") Integer hosId) {
		this.hospitalService.deleteHospital(hosId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Hospital deleted succssfully", true), HttpStatus.OK);
	}

	//get all user
	@GetMapping("/hospitals")
	public ResponseEntity<List<HospitalDto>> getAllHospitals() {
		return ResponseEntity.ok(this.hospitalService.getAllHospitals());
	}

	@PostMapping("/{docId}/add-doctor-to/{hosId}/hospital")
	public ResponseEntity<HospitalDto> addDoctorToHospital(@PathVariable Integer hosId, @PathVariable Integer docId) {
		HospitalDto updatedHospital = hospitalService.addDoctorToHospital(hosId, docId);
		return ResponseEntity.ok(updatedHospital);
	}

	@GetMapping("hospitals/by-doctorId/{doctorId}")
	public ResponseEntity<List<HospitalDto>> getAllHospitalsByDoctorId(@PathVariable("doctorId") Integer docId) {
		List<HospitalDto> hospitalDtos = hospitalService.getAllHospitalsByDoctorId(docId);
		return ResponseEntity.ok(hospitalDtos);
	}

	@GetMapping("doctors/by-hospitalId/{hospitalId}")
	public ResponseEntity<List<DoctorDto>> getAllDoctorsByHospitalId(@PathVariable("hospitalId") Integer hosId) {
		List<DoctorDto> doctorDtos = hospitalService.getAllDoctorsByHospitalId(hosId);
		return ResponseEntity.ok(doctorDtos);
	}

}
