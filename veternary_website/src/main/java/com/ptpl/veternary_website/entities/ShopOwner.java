package com.ptpl.veternary_website.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ShopOwner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int shopId;
	private String services;
	private String empNumber;
	private String Dof;
}
