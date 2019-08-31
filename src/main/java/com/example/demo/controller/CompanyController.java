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
import com.example.demo.entity.Sectors;
import com.example.demo.entity.Stock;
import com.example.demo.services.CompanyService;
import com.example.demo.services.SectorsServices;
import com.example.demo.services.StockService;


@Controller
public class CompanyController 
{
	@Autowired
	private  CompanyService companyservice;
	
	@Autowired
	private StockService stockservice;
	
	@Autowired
	private SectorsServices sectorservice;
	
	@RequestMapping("/openManageCompany")
	public ModelAndView openStock()
	{
		ModelAndView mv = new ModelAndView();
		List<Company>list=companyservice.findAll();
		mv.addObject("list",list);
		String s=stockservice.StockList();
		mv.addObject("StringList",s);
		String s1=sectorservice.SectorsList();
		mv.addObject("StringList1",s1);
		mv.addObject("company",new Company());
		mv.setViewName("ManageCompany");
		return mv;
	}
	
    @RequestMapping(value="/saveCompany",method = RequestMethod.POST)
	public ModelAndView addCompany(Model model,@RequestParam("sectorId")String companySectorName,@RequestParam("stockExchangeId")String stockExchangeId,@RequestParam("companyName")String companyName,@Valid @ModelAttribute("company") Company company,BindingResult result,Model mc,@RequestParam String action)
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
			if((stockservice.findByStockName(stockExchangeId))!=null && (sectorservice.findByCompanySectorName(companySectorName))!=null )
			{
			ModelAndView mv = new ModelAndView();
			List<Company> list=companyservice.findAll();
		    mv.addObject("list",list);
			mv.addObject("company",new Company());
			Stock stock=stockservice.findByStockName(stockExchangeId);
			company.setStockExchangeCompany(stock);
			Sectors sector=sectorservice.findByCompanySectorName(companySectorName);
			company.setSector(sector);
			companyservice.save(company);
			mv.addObject("msg","Company exist already updating that data");
			mv.setViewName("ManageCompany");
			return mv;
			}
			else
			{
				ModelAndView mv = new ModelAndView();
				mv.addObject("message","Sector Doesn't If you want to add one go to Manage Sector");
				mv.setViewName("NewFile");
				return mv;
			}
		}
		else if(stockservice.findByStockName(stockExchangeId)!=null && sectorservice.findByCompanySectorName(companySectorName)!=null)
		{
			
			Stock stock=stockservice.findByStockName(stockExchangeId);
			company.setStockExchangeCompany(stock);
			Sectors sector=sectorservice.findByCompanySectorName(companySectorName);
			company.setSector(sector);
			System.out.println(sector.getSectorId());
			ModelAndView mv = new ModelAndView();
			companyservice.save(company);
			List<Stock>list=stockservice.findAll();
			mv.addObject("list",list);
			mv.addObject("stock",new Stock());
			mv.setViewName("ManageExchnage");
			return mv;
			
				
		}
		else
		{
			ModelAndView mv = new ModelAndView();
			mv.addObject("message","Stock Exchange Doesn't If you want to add one go to Manage Exchange");
			mv.setViewName("NewFile");
			return mv;
		}
	}
}
