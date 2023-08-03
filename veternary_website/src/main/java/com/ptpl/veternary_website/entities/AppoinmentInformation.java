package com.ptpl.veternary_website.entities;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.annotation.processing.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "AppoinmentInformations")
//uniqueConstraints = {
//		@UniqueConstraint(columnNames = { "doctor_id", "hospital_id" }) }
@NoArgsConstructor
@Setter
@Getter
public class AppoinmentInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long appId;
	
	private Date appoinmentDate;
	
	private LocalTime startTime;
	
	private LocalTime closingTime;	
	
	private boolean isDoctorAvailable;

	@Column(columnDefinition = "JSON")
	private String slotInfoJsonData;

	// Many appointments can be associated with one doctor
	@ManyToOne
	@JoinColumn(name = "doctor_id", referencedColumnName = "docId")
	private Doctor doctor;

	// Many appointments can be associated with one hospital
	@ManyToOne
	@JoinColumn(name = "hospital_id", referencedColumnName = "hosId")
	private Hospital hospital;

}
