package com.ptpl.veternary_website.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doctors")
@NoArgsConstructor
@Setter
@Getter
public class Doctor {

	// doctor basic information
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer docId;

//	profile details
	private String middleName;

	private String specialization;

	private String gender;

//	Medical Registration
	private String registrationNumber;

	private int yearOfExperience;

//Educational Qualification
	private String degree;

	private String college;

	private int yearOfCompletion;

//	status
	private boolean isVerified;

//	Active ,	Inactive,	Suspended,	Revoked,	On Leave,	Retired,	Deceased
	private String status;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToMany(mappedBy = "doctors")
	private List<Hospital> hospitals;

	@OneToMany(mappedBy = "doctor")
	private List<AppoinmentInformation> slotInformations;

}
