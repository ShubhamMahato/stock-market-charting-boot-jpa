package com.example.demo.services;

import java.util.List;
import java.util.Map;
 
public interface CanvasjsChartService {
 
	List<List<Map<Object, Object>>> getCanvasjsChartData(java.sql.Date date);
	List<List<Map<Object, Object>>> getFullCanvasjsChartData();
 
}