package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="stock")
public class Stock 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="stock_id")
	private int stockId;
	
	@NotBlank
	@NotNull
	@Column(unique=true,name="stock_name")
	private String stockName;
	
	@NotBlank
	@NotNull
	@Column(name="contact_address")
	private String contactAddress;
	
	@NotBlank
	@NotNull
	@Column(name="brief")
	private String brief;
	
	
	@NotBlank
	@NotNull
	@Column(name="remarks")
	private String remarks;
	
	@OneToMany(mappedBy = "stockExchangeCompany")
	private List<Company> company;


	public int getStockId() {
		return stockId;
	}


	public void setStockId(int stockId) {
		this.stockId = stockId;
	}


	public String getStockName() {
		return stockName;
	}


	public void setStockName(String stockName) {
		this.stockName = stockName;
	}


	public String getContactAddress() {
		return contactAddress;
	}


	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}


	public String getBrief() {
		return brief;
	}


	public void setBrief(String brief) {
		this.brief = brief;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	

	public List<Company> getCompany() {
		return company;
	}


	public void setCompany(List<Company> company) {
		this.company = company;
	}


	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", stockName=" + stockName + ", contactAddress=" + contactAddress
				+ ", brief=" + brief + ", remarks=" + remarks + "]";
	}
	
	public Stock(){}
	
}