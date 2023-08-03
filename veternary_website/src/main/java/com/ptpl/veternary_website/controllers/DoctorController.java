package com.ptpl.veternary_website.controllers;

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
import java.util.List;

import com.ptpl.veternary_website.payloads.ApiResponse;
import com.ptpl.veternary_website.payloads.DoctorDto;
import com.ptpl.veternary_website.services.DoctorService;

@RestController
@RequestMapping("/patners/")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@PostMapping("/user/{userId}/doctor")
	public ResponseEntity<DoctorDto> createDoctor(@PathVariable Integer userId,@RequestBody DoctorDto doctorDto ) {
		DoctorDto doctorDtoResponse = this.doctorService.createDoctor(userId,doctorDto);
		return new ResponseEntity<>(doctorDtoResponse, HttpStatus.CREATED);
	}
	
	@GetMapping("/doctor/{doctorId}")
	public ResponseEntity<DoctorDto> getDoctorById(@PathVariable Integer doctorId)
	{		
		DoctorDto doctorDto=this.doctorService.getDoctorById(doctorId);
		return new ResponseEntity<DoctorDto>(doctorDto,HttpStatus.OK);
	}
	
	@PutMapping("/doctor/{doctorId}")
	public ResponseEntity<DoctorDto> updateDoctor(@PathVariable Integer doctorId,@RequestBody DoctorDto doctorDto)
	{
		DoctorDto doctorDtoUpdated=this.doctorService.updateDoctor(doctorDto, doctorId);
	return ResponseEntity.ok(doctorDtoUpdated);
	}
	
	@GetMapping("/doctors")
	public ResponseEntity<List<DoctorDto>> getAllDoctors()
	{
		return  ResponseEntity.ok(this.doctorService.getAllDoctors());
	}
	
	@GetMapping("/user/{userId}/doctor")
	public  ResponseEntity<DoctorDto>  getDoctorByUserId(@PathVariable Integer userId)
	{
		DoctorDto doctorDto=this.doctorService.getDoctorByUserId(userId);
		return new ResponseEntity<DoctorDto>(doctorDto,HttpStatus.OK);
	}
	
	@DeleteMapping("/doctor/{doctorId}")
	public ResponseEntity<ApiResponse> deleteDoctorById(@PathVariable("doctorId") Integer doctorId)
	{
		this.doctorService.deleteDoctorById(doctorId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Doctor deleted succssfully",true),HttpStatus.OK);
	}
}
