package com.example.demo.services;


import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EventsDaoInterface;
import com.example.demo.entity.StockPriceDetail;

@Service("eventsService")
public class EventsService {

	@Autowired
	EventsDaoInterface eventsDaoInterface;
	
	public void importData(StockPriceDetail stockPriceDetail) throws IOException, InvalidFormatException {
		try {
			eventsDaoInterface.save(stockPriceDetail);
		} catch (Exception e) {
			System.out.println("data already exist"+e.getMessage());
		}
	}
}