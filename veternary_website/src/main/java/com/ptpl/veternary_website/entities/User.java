package com.ptpl.veternary_website.entities;

import com.ptpl.veternary_website.utils.UserType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "users")
@NoArgsConstructor
@Setter
@Getter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String mblNo;

	private String nation;
	
	private String emailId;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String userType;

	@OneToOne(optional = true)
	private Address address;
	
	@OneToOne(mappedBy = "user")
	private Doctor doctor;


}
