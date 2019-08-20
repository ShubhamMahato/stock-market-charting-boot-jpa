package com.example.demo.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CanvasjsChartDao;
@Service
public class CanvasjsChartServiceImpl implements CanvasjsChartService {

	@Autowired
	private CanvasjsChartDao canvasjsChartDao;

	public void setCanvasjsChartDao(CanvasjsChartDao canvasjsChartDao) {
		this.canvasjsChartDao = canvasjsChartDao;
	}

	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartData(java.sql.Date date) {
		return canvasjsChartDao.getCanvasjsChartData(date);
	}

	@Override
	public List<List<Map<Object, Object>>> getFullCanvasjsChartData() {
		
		return  canvasjsChartDao.getFullCanvasjsChartData();
	}
	
	

}