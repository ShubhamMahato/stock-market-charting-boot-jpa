package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.CompanyDao;
import com.example.demo.entity.Company;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service


public class CompanyService 
{
	
	@Autowired
	public CompanyDao companydao;
	
	public static List<String>al=new ArrayList<String>();
	
	public ObjectMapper mapper = new ObjectMapper();
	public Company save(Company company)
	{
		return companydao.save(company);
		
	}
	public List<Company> findAll()
	{
		
		return companydao.findAll();
		
	}
	public List<String>CompanyList()
	{
		List<Company>al1=companydao.findAll();
		for(int i=0;i<al1.size();i++)
		{
			al.add(al1.get(i).getCompanyName());
		}
		System.out.println(al);
		return al;
	}
	
	public Company  findByCompanyName(String name) {
		return companydao.findByCompanyName(name);
	}
}
