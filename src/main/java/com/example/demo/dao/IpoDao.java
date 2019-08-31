package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.IpoDetails;

public interface IpoDao extends JpaRepository<IpoDetails, Integer> {
	
	public IpoDetails findByCompanyName(String companyName);

}
