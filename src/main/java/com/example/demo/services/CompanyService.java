package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.CompanyDao;
import com.example.demo.entity.Company;
import com.example.demo.entity.Sectors;
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
	public String CompanyList()
	{
		List<Company>al1=companydao.findAll();
		for(int i=0;i<al1.size();i++)
		{
			if(!(al.contains(al1.get(i).getCompanyName())))
					{
			
				al.add(al1.get(i).getCompanyName());
		
					}
		}
		StringBuffer sb = new StringBuffer(); 
		  sb.append("["); 
		  for(int i=0;i<al.size(); i++)
		  { 
			  sb.append("\"").append(al.get(i)).append("\""); 
			  if(i+1 <al.size())
			  { 
				  sb.append(","); 
			  } 
		  } 
		  sb.append("]");
		  String s= sb.toString();
		return s;
	}
	
	public Company  findByCompanyName(String name) {
		return companydao.findByCompanyName(name);
	}
	
	public Company checkCompany(String companyCode)
	{
		return companydao.findByCompanyCode(companyCode);
	}
	
	
	public List<Company> findBySector(Sectors sec)
	{
		return companydao.findBySector(sec);
	}
	
	public Company findBySectorId(String secname)
	{
		return companydao.findBySectorId(secname);
	}
	
	public Company findByCompanyCodeAndSector(String companycode,Sectors sector)
	{
		return companydao.findByCompanyCodeAndSector(companycode, sector);
	}
	
}
