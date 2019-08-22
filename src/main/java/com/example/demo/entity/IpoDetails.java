package com.example.demo.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="ipoDetails")
public class IpoDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotBlank
	@Column(name="companyName",unique = true)
	private String companyName;

	@NotBlank
	private String stockExchange;

	@NotBlank
	private double pricePerShare;

	@NotBlank
	private double TotalShare;

	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@NotBlank
	private Date openingDate;

	@NotBlank
	private String remarks;

	//******************************************************
	//					Mapping
	//******************************************************

	@OneToOne
	@JoinColumn
	private Company company;

	//******************************************************
	//					!--Mapping--
	//******************************************************

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyNname(String companyName) {
		this.companyName = companyName;
	}
	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
	public double getPricePerShare() {
		return pricePerShare;
	}
	public void setPricePerShare(double pricePerShare) {
		this.pricePerShare = pricePerShare;
	}
	public double getTotalShare() {
		return TotalShare;
	}
	public void setTotalShare(double totalShare) {
		TotalShare = totalShare;
	}
	public Date getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}