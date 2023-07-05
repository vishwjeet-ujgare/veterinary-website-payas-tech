package com.ptpl.veternary_website.entities;

import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Table(name ="Hospitals")
@Setter
@Getter
public class Hospital {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long hosId;
	

 
@Column(nullable = false)
	private String name ;
	//may hava multiple mobile numbers
	private String mblNo;
	private String email;
	private String website;
	private String hosOpeningDate;
	
	private Date openingTime;
	private Date closingTime ;

	private Date hosRegisterId;
	//may have multiple owners
	private String owner;
	private String addr;
	
	private boolean isVerified;
	private String status;
	
}
