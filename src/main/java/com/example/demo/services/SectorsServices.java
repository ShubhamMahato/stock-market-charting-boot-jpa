package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SectorsDao;
import com.example.demo.entity.Sectors;

@Service
public class SectorsServices 
{
	@Autowired
	private SectorsDao sectorsdao;
	public static List<String>al=new ArrayList<String>();
	public Sectors save(Sectors sectors)
	{
		return sectorsdao.save(sectors);
	}
	public List<Sectors> findAll()
	{
		return sectorsdao.findAll();
	}
	public Sectors findByCompanySectorName(String companySectorName)
	{
		return sectorsdao.findByCompanySectorName(companySectorName);
	}
	
	public String SectorsList()
	{
		List<Sectors>al1=sectorsdao.findAll();
		for(int i=0;i<al1.size();i++)
		{
			if(!(al.contains(al1.get(i).getCompanySectorName())))
					{
			
				al.add(al1.get(i).getCompanySectorName());
		
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
}
