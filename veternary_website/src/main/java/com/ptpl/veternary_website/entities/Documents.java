package com.ptpl.veternary_website.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Documents {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int docId ;
	private String addharPhoto;
	private String panPhoto;
	private String profilePhoto;
	private String establishmentRegDocument;
	private String degreeCertificateImg;
}
