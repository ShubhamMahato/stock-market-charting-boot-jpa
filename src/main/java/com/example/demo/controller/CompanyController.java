package com.example.demo.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Company;
import com.example.demo.entity.Stock;
import com.example.demo.services.CompanyService;
import com.example.demo.services.StockService;


@Controller
public class CompanyController 
{
	@Autowired
	private  CompanyService companyservice;
	
	@Autowired
	private StockService stockservice;
	
	@RequestMapping("/openManageCompany")
	public ModelAndView openStock()
	{
		ModelAndView mv = new ModelAndView();
		List<Company>list=companyservice.findAll();
		mv.addObject("list",list);
		mv.addObject("company",new Company());
		mv.setViewName("ManageCompany");
		return mv;
	}
	
    @RequestMapping(value="/saveCompany",method = RequestMethod.POST)
	public ModelAndView addCompany(Model model,@RequestParam("companyName")String companyName,@Valid @ModelAttribute("company") Company company,BindingResult result,Model mc,@RequestParam String action)
	{
	
		
		      
		   
		if(result.hasErrors())
		{
			ModelAndView mv = new ModelAndView();
			List<Company>list=companyservice.findAll();
			mv.addObject("list",list);
			mv.setViewName("ManageCompany");
			return mv;
		}
		else if(companyservice.findByCompanyName(companyName)!=null)
		{
			ModelAndView mv = new ModelAndView();
			List<Company> list=companyservice.findAll();
		    mv.addObject("list",list);
			mv.addObject("company",new Company());
			companyservice.save(company);
			mv.addObject("msg","Company exist already updating that data");
			mv.setViewName("ManageCompany");
			return mv;
		}
		else 
		{
			
			ModelAndView mv = new ModelAndView();
			companyservice.save(company);
			List<Stock>list=stockservice.findAll();
			mv.addObject("list",list);
			mv.addObject("stock",new Stock());
			mv.setViewName("ManageExchnage");
			return mv;
				
		}
	}
}
