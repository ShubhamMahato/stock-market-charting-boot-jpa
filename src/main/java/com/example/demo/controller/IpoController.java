package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Company;
import com.example.demo.entity.IpoDetails;
import com.example.demo.entity.Sectors;
import com.example.demo.services.CompanyService;
import com.example.demo.services.IpoServices;

@Controller
public class IpoController 
{
	@Autowired
	private IpoServices iposervice;
	
	@Autowired
	private CompanyService companyService;
	
	
	@RequestMapping("openipo")
	public ModelAndView openipopage()
	{
		ModelAndView mv=new ModelAndView();
		String s= companyService.CompanyList(); 
		mv.addObject("ipo",new IpoDetails());
		List<IpoDetails> list=iposervice.findAll();
		mv.addObject("list",list);
		mv.addObject("StringList",s);
		mv.setViewName("ipo");
		return mv;
		
	}
	
	@RequestMapping(value="/saveIpo",method=RequestMethod.POST)
	public ModelAndView saveSector(@Valid @ModelAttribute("ipo") IpoDetails ipo,BindingResult result,@RequestParam("companyName")String company)
	{
		if(result.hasErrors())
		{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("ipo");
			return mv;
		}
		else
		{
			ModelAndView mv=new ModelAndView();
			if(companyService.findByCompanyName(company)!=null)
			{
			Company comp=companyService.findByCompanyName(company);
			mv.addObject("ipo",new IpoDetails());
			ipo.setStockExchange(comp.getStockExchangeId());
			ipo.setCompany(comp);
			iposervice.save(ipo);
			List<IpoDetails> list=iposervice.findAll();
			String s= companyService.CompanyList(); 
			mv.addObject("list",list);
			

			mv.addObject("StringList",s);
			mv.setViewName("ipo");
			return mv;
			}
			else
			{
				mv.addObject("ipo",new IpoDetails());
				List<IpoDetails> list=iposervice.findAll();
				String s= companyService.CompanyList(); 
				mv.addObject("list",list);
			
				mv.addObject("msg","Please select company name from list");
				mv.addObject("StringList",s);
				mv.setViewName("ipo");
				return mv;
			}
		}
	}
}
