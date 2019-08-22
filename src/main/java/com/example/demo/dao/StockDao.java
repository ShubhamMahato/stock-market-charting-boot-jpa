package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Stock;
@Repository
public interface StockDao extends JpaRepository<Stock, Integer>
{

	public Stock findByStockName(String stockExchangeCompany);
}
