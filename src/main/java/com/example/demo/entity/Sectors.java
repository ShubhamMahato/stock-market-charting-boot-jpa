package com.example.demo.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="sectors")
public class Sectors {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sectorId;

	@NotBlank
	@Column(name="sector_name",unique = true)
	private String companySectorName;

	@NotBlank
	@Column(name="brief")
	private String sectorsBrief;

	@OneToMany(mappedBy = "sector",cascade = CascadeType.ALL)
	private List<Company> companyList;

	public int getSectorId() {
		return sectorId;
	}

	public void setSectorId(int sectorId) {
		this.sectorId = sectorId;
	}

	public String getCompanySectorName() {
		return companySectorName;
	}

	public void setCompanySectorName(String companySectorName) {
		this.companySectorName = companySectorName;
	}

	public String getSectorsBrief() {
		return sectorsBrief;
	}

	public void setSectorsBrief(String sectorsBrief) {
		this.sectorsBrief = sectorsBrief;
	}

	public List<Company> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}

	
	
	
	

}