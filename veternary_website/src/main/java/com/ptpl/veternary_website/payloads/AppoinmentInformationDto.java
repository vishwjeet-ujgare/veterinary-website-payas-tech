package com.ptpl.veternary_website.payloads;

import java.time.LocalTime;
import java.util.Date;

import com.ptpl.veternary_website.utils.AppoinmentInfoSlotData;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AppoinmentInformationDto {

	private Long appId;
	
	private Date appoinmentDate;
	
	private LocalTime startTime;
	
	private LocalTime closingTime;	

	private boolean isDoctorAvailable;

	private AppoinmentInfoSlotData slotInfoJsonData;
	
	private DoctorDto doctorDto;

	private HospitalDto hospitalDto;
}
