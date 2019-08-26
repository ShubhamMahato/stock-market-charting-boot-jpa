package com.example.demo.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name="stock_price")



public class StockPriceDetail 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private int stockPriceID;
	
	private String companyCode;
	
	private int stockExchange;
	
	private float currentPrice;
	
	@Column(name="date")
	private Date date;
	
	private Time time;
	
	
	
	
	
	
	
	
	

	//******************************************************
	//					Mapping
	//******************************************************
	@ManyToOne
	@JoinColumn
	private Company company;
	
	//******************************************************
	//					!--Mapping--
	//******************************************************
	
	public int getStockPriceID() {
		return stockPriceID;
	}

	public void setStockPriceID(int stockPriceID) {
		this.stockPriceID = stockPriceID;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public int getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(int stockExchange) {
		this.stockExchange = stockExchange;
	}

	public float getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		
		this.date = date;
	}

	
	

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	

}
