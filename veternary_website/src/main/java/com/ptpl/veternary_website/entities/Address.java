package com.ptpl.veternary_website.entities;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="addresses")
@NoArgsConstructor
@Setter
@Getter
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addrId;
	
	
	private String houseName;
	private String laneNo;
	private String locality;
	private String village;
	private String city;
	private String state;
	private String nation;
	private int pincode;
	private  String landmark;
	private String note;
	
	@OneToOne(mappedBy = "address")
	private Establishment establishment;
//	@OneToOne(mappedBy = "address",cascade = CascadeType.ALL)
//	private Hospital hospital;
//	
//	@OneToOne(mappedBy = "address",cascade = CascadeType.ALL)
//	private User user;
//
	
}
