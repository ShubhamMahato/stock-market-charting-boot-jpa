package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.services.StockService;
import com.example.demo.entity.Sectors;
import com.example.demo.entity.Stock;

@Controller
public class StockController 
{
	@Autowired
	public StockService stockservice;
	
	@RequestMapping("/openStockExchange")
	public ModelAndView openStock()
	{
		ModelAndView mv = new ModelAndView();
		List<Stock>list=stockservice.findAll();
		
		mv.addObject("list",list);
		mv.addObject("stock",new Stock());
		mv.setViewName("ManageExchnage");
		return mv;
	}
	
	@RequestMapping(value="/saveStock",method = RequestMethod.POST)
	public ModelAndView addCompany(@Valid @ModelAttribute("stock") Stock stock,BindingResult result)
	{
		if(result.hasErrors())
		{
			ModelAndView mv = new ModelAndView();
			List<Stock>list=stockservice.findAll();
			mv.addObject("list",list);
			mv.setViewName("ManageExchnage");
			return mv;
		}
		else 
		{
			ModelAndView mv = new ModelAndView();
			
			
			
			
			try {
				stockservice.save(stock);
				List<Stock>list=stockservice.findAll();
				mv.addObject("list",list);
				mv.setViewName("ManageExchnage");
				return mv;	
		    }
		    catch (DataIntegrityViolationException e) {
		    	List<Stock>list=stockservice.findAll();
				mv.addObject("list",list);
				mv.addObject("msg","Data exist already");
				mv.setViewName("ManageExchnage");
				return mv; 

		    }
			
		}
	}
}
