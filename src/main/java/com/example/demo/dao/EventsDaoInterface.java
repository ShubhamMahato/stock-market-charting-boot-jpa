package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.StockPriceDetail;



@Repository("eventsDaoInterface")
public interface EventsDaoInterface extends JpaRepository<StockPriceDetail, Integer>{

}