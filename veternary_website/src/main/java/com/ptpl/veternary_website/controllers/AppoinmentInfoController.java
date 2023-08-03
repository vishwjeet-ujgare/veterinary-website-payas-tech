package com.ptpl.veternary_website.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ptpl.veternary_website.payloads.AppoinmentInformationDto;
import com.ptpl.veternary_website.services.AppoinmentInformationService;

@RestController
@RequestMapping("/patners/appoinment/")
public class AppoinmentInfoController {

	@Autowired
	private AppoinmentInformationService appoinmentInfoService;

	@PostMapping("/doctor/{docId}/hospital/{hosId}")
	public ResponseEntity<AppoinmentInformationDto> createAnAppoinmentInfo(@RequestBody AppoinmentInformationDto appoinmentInformationDto,@PathVariable Integer docId, @PathVariable Integer hosId
			) {
		AppoinmentInformationDto appoinmentInformationDto2 = appoinmentInfoService
				.createAnAppointment(appoinmentInformationDto,docId,hosId);
		return new ResponseEntity<>(appoinmentInformationDto2, HttpStatus.CREATED);
	}

}
