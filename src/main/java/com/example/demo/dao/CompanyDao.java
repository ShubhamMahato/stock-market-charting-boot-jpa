package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Company;
import com.example.demo.entity.Sectors;

@Repository
public interface CompanyDao extends  JpaRepository<Company,Integer>
{
	public Company findByCompanyName(String name);
	
	public Company findByCompanyCode(String companyCode);	
	
	public List<Company> findBySector(Sectors sec);
	
	public Company findBySectorId(String secname);
	
	public Company findByCompanyCodeAndSector(String companycode,Sectors sector);
}
