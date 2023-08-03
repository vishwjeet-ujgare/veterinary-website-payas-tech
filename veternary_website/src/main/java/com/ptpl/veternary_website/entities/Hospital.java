package com.ptpl.veternary_website.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "Hospitals")
@NoArgsConstructor
@Setter
@Getter
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hosId;

	@Column(columnDefinition = "boolean default false")
	private boolean isVerified;

	@Column(columnDefinition = "varchar(255) default 'Processing'")
	private String status;

	@Column(columnDefinition = "int default 0")
	private int totalSections;
	
	private String note;

	@ManyToMany
	@JoinTable(name = "Hospitals_doctors", joinColumns = @JoinColumn(name = "hos_id"), inverseJoinColumns = @JoinColumn(name = "doc_id"))
	private List<Doctor> doctors;

	@OneToOne
	private Establishment establishment;
	
	@OneToMany(mappedBy = "hospital")
	private List<AppoinmentInformation> slotInformations;
}
