package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IpoDao;
import com.example.demo.entity.IpoDetails;

@Service
public class IpoServices {

	@Autowired
	private IpoDao ipodao;
	
	public IpoDetails save(IpoDetails ipo)
	{
		return ipodao.save(ipo);
	}
	public List<IpoDetails> findAll()
	{
		return ipodao.findAll();
	}
	public IpoDetails findByCompanyName(String companyName)
	{
		return ipodao.findByCompanyName(companyName);
	}
	
}
