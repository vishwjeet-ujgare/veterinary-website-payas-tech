package com.ptpl.veternary_website.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DoctorNotAssociatedException extends RuntimeException {
	public DoctorNotAssociatedException(Integer doctorId, Integer hospitalId) {
        super(String.format("Doctor with ID %d is not associated with Hospital with ID %d", doctorId, hospitalId));
    }
}
