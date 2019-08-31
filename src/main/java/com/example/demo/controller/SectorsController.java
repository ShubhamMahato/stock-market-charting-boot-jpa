package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
import com.example.demo.services.SectorsServices;

@Controller
public class SectorsController 
{
	@Autowired
	private SectorsServices sectorservice;
	@RequestMapping("/openSector")
	public ModelAndView viewPage()
	{
		ModelAndView mv=new ModelAndView();
		List<Sectors>list=sectorservice.findAll();
		mv.addObject("list",list);
		mv.addObject("sector",new Sectors());
		mv.setViewName("ManageSectors");
		return mv;
	}
	
	@RequestMapping(value="/saveSectors",method=RequestMethod.POST)
	public ModelAndView saveSector(@Valid @ModelAttribute("sector") Sectors sector,BindingResult result)
	{
		if(result.hasErrors())
		{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("NewFile");
			return mv;
		}
		else
		{
		ModelAndView mv=new ModelAndView();
		try {
			sectorservice.save(sector);
			List<Sectors>list=sectorservice.findAll();
			mv.addObject("list",list);
			mv.addObject("sector",new Sectors());
			mv.setViewName("ManageSectors");
			return mv;
	    }
	    catch (DataIntegrityViolationException e) {
	    	List<Sectors>list=sectorservice.findAll();
			mv.addObject("list",list);
			mv.addObject("msg","Data exist already");
			mv.addObject("sector",new Sectors());
			mv.setViewName("ManageSectors");
			return mv;
	    }
		
		
		
		}
	}
}
