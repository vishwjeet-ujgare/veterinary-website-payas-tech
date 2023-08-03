package com.ptpl.veternary_website.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Establishments")
@NoArgsConstructor
@Setter
@Getter
public class Establishment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int estId;
	
	@Column(nullable = false)
	private String estName;
	
	private Long registerId;
	private String EstOpeningDate;
	

	private String mblNo;
	private String email;
		
	private Date openingTime;
	private Date closingTime;

	private String DocumentationImges;
	
	
	private boolean status;

	private String owner;
	
	@OneToOne
	private Address address;

	@OneToOne(mappedBy = "establishment")
	private Hospital hospital;
	
}
