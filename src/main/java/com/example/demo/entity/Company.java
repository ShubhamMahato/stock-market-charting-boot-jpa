package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="company")
public class Company 
{
	public Company(){}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="companyid")
	private Integer companyId; 
	

	@Column( name="company_code")
	private String companyCode;
	
	@NotBlank
	@Column(name="company_Name")
	private String companyName;
	
	@NotNull
	@Column(name="turnover")
	private int turnover;
	
	@NotBlank
	@NotNull
	@Column(name="ceo")
	private String ceo;
	
	@NotBlank
	@NotNull
	@Column(name="boardofdirectors")
	private String boardOfDirectors;
	
	@NotNull
	@Column(name="sector_id")
	private String sectorId;
	
	@NotNull
	@Column(name="stockExchangeId")
	private String stockExchangeId;
	
	@NotBlank
	@NotNull
	@Column(name="breifwriteup")
	private String breifWriteUp;

	@ManyToOne
	@JoinColumn(name="stockId")
	private Stock stockExchangeCompany;
	
	@ManyToOne
	@JoinColumn(name="companySector")
	private Sectors sector;
	
	@OneToOne(mappedBy = "company")
	private IpoDetails ipoDetails;
	
	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getTurnover() {
		return turnover;
	}

	public void setTurnover(int turnover) {
		this.turnover = turnover;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getBoardOfDirectors() {
		return boardOfDirectors;
	}

	public void setBoardOfDirectors(String boardOfDirectors) {
		this.boardOfDirectors = boardOfDirectors;
	}

	
	public String getSectorId() {
		return sectorId;
	}

	public void setSectorId(String sectorId) {
		this.sectorId = sectorId;
	}

	public String getBreifWriteUp() {
		return breifWriteUp;
	}

	public void setBreifWriteUp(String breifWriteUp) {
		this.breifWriteUp = breifWriteUp;
	}

	
	public Stock getStockExchangeCompany() {
		return stockExchangeCompany;
	}

	public void setStockExchangeCompany(Stock stockExchangeCompany) {
		this.stockExchangeCompany = stockExchangeCompany;
	}

	public String getStockExchangeId() {
		return stockExchangeId;
	}

	public void setStockExchangeId(String stockExchangeId) {
		this.stockExchangeId = stockExchangeId;
	}

	public Sectors getSector() {
		return sector;
	}

	public void setSector(Sectors sector) {
		this.sector = sector;
	}

	public IpoDetails getIpoDetails() {
		return ipoDetails;
	}

	public void setIpoDetails(IpoDetails ipoDetails) {
		this.ipoDetails = ipoDetails;
	}
	
	
	
	
	
	
}