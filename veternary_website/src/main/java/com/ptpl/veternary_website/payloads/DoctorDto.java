package com.ptpl.veternary_website.payloads;

import java.util.List;

import com.ptpl.veternary_website.entities.AppoinmentInformation;
import com.ptpl.veternary_website.entities.Hospital;
import com.ptpl.veternary_website.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class DoctorDto {

	private int docId;
	
	private String middleName;

	private String specialization;

	private String Gender;

//		Medical Registration
	private String RegistrationNumber;

	private int yearOfExperience;

//Educational Qualification
	private String degree;
	
	private String college;
	
	private int yearOfCompletion;
	
	private UserDto userDto;

	//doctor statuc and verification
	private boolean isVerified;

	private String status;
}
