package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.entity.Stock;
import com.example.demo.services.CanvasjsChartService;
import com.example.demo.services.CompanyService;
import com.example.demo.services.StockService;

@Controller
public class HomeController 
{
	
	@Autowired
	private CanvasjsChartService canvasjsChartService;
	
	@Autowired         
	private CompanyService companyServices;

	public void setCompanyServices(CompanyService companyServices) {
		this.companyServices = companyServices;
	}
	@Autowired         
	private StockService stockservice;
	
	
	
	@RequestMapping("/")
	public org.springframework.web.servlet.ModelAndView index(ModelMap modelMap)
	{
		
		 String sDate1="2017-03-25"; Date date1=null; 
		  try 
		  { 
			  date1 = new  SimpleDateFormat("yyyy-MM-dd").parse(sDate1); 
		  } 
		  catch (ParseException e) 
		  { 
			   e.printStackTrace();
		} 
		  java.sql.Date sqlDate= new java.sql.Date(date1.getTime());
		  
		  

		  List<String> al= companyServices.CompanyList(); 
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
		  
		 ////////////////////////////
		 
		 List<List<Map<Object, Object>>> canvasjsDataList =
		  canvasjsChartService.getCanvasjsChartData( sqlDate);
		  
		  
		  
		  ModelAndView mv = new ModelAndView(); mv.addObject("stock", new Stock());
		 List<Stock> stockList=stockservice.findAll();
		 modelMap.addAttribute("dataPointsList", canvasjsDataList);
		 mv.addObject("stockList",stockList);
		  
		modelMap.addAttribute("StringList",s);
		 
		
		mv.setViewName("HomePage");
		return mv;
	}
	
	
	
	
}
