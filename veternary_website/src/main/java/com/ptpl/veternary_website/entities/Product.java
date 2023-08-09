package com.ptpl.veternary_website.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int proId;
private String pname;
private String pcat;
private  int shopId;
private int quantity;
private Date stockDate;
private String productImgUrl;


}
