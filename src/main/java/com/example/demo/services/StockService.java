package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StockDao;
import com.example.demo.entity.Stock;

@Service
public class StockService 
{
	@Autowired
	public StockDao stockdao;
	
	public Stock save(Stock save)
	{
		return stockdao.save(save);
	}
	
	public List<Stock> findAll()
	{
		
		return stockdao.findAll();
		
	}
}
