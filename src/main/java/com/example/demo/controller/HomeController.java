package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Company;
import com.example.demo.entity.Stock;
import com.example.demo.services.CompanyService;
import com.example.demo.services.StockPriceServices;
import com.example.demo.services.StockService;

@Controller
public class HomeController 
{
	
	
	@Autowired         
	private CompanyService companyServices;

	public void setCompanyServices(CompanyService companyServices) {
		this.companyServices = companyServices;
	}
	@Autowired         
	private StockService stockservice;
	
	@Autowired         
	private StockPriceServices stockpriceservice;
	
	
	
	@RequestMapping("/")
	public org.springframework.web.servlet.ModelAndView index(ModelMap modelMap)
	{
		
		/* String sDate1="2017-03-25"; Date date1=null; 
		  try 
		  { 
			  date1 = new  SimpleDateFormat("yyyy-MM-dd").parse(sDate1); 
		  } 
		  catch (ParseException e) 
		  { 
			   e.printStackTrace();
		} 
		  java.sql.Date sqlDate= new java.sql.Date(date1.getTime());*/
		  
		  

		  String s= companyServices.CompanyList(); 
		 
		  
		 ////////////////////////////
		 
		 List<List<Map<Object, Object>>> canvasjsDataList =stockpriceservice.getFullCanvasjsChartData( );
		 
		  
		  ModelAndView mv = new ModelAndView(); 
		  mv.addObject("stock", new Stock());
		 List<Stock> stockList=stockservice.findAll();
		 modelMap.addAttribute("dataPointsList", canvasjsDataList);
		 mv.addObject("stockList",stockList);
		  
		modelMap.addAttribute("StringList",s);
		 
		
		mv.setViewName("HomePage");
		return mv;
	}
	
	
	@RequestMapping(value="getCompany",method=RequestMethod.GET)

	public ModelAndView getbycompay(@RequestParam("hello")String company)
	{
		
		ModelAndView mv = new ModelAndView();
		List<List<Map<Object, Object>>> canvasjsDataList =stockpriceservice.getFullCanvasjsChartData( );
		Company comp=companyServices.findByCompanyName(company);
		String s= companyServices.CompanyList(); 
		mv.addObject("companylist",comp);
	    mv.addObject("stock", new Stock());
	    List<Stock> stockList=stockservice.findAll();
	 	mv.addObject("dataPointsList", canvasjsDataList);
	 	mv.addObject("stockList",stockList);
	    mv.addObject("StringList",s);
	    mv.setViewName("HomePage");
		return mv;
		
	}
	
}
