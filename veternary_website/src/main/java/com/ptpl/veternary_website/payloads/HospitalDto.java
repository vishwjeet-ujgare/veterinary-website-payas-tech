package com.ptpl.veternary_website.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class HospitalDto {
	
	private int hosId;
	
	private boolean isVerified=false;

	private String status="Processing";

	private int totalSections;

	private String note;
	
	private List<DoctorDto> doctorDtos;
}
