package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Company;

@Repository
public interface CompanyDao extends  JpaRepository<Company,Integer>
{
	public Company findByCompanyName(String name);
	
		
	
	
}
