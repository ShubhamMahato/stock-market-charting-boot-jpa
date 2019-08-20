package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Company;
import com.example.demo.services.AdminService;
import com.example.demo.services.CompanyService;

@Controller
public class AdminController 
{
	@Autowired(required=true)
	private AdminService adminservice; 

	
	@Autowired         
	private CompanyService companyservice;

	
	
	@RequestMapping("/openPage")
	public String demo(Model model)
	{
		Admin admin=new Admin();
		model.addAttribute("admin",admin);
		return "AdminLogin";
		
	}
	
	@RequestMapping(value="adminlogin", method = RequestMethod.GET)
	public ModelAndView loginAuth(Model model,@RequestParam("adminUserName") String adminUserName, @RequestParam("passwordAdmin") String passwordAdmin,Model  modell) 
	{  
		if(adminservice.findByAdminUserNameAndPasswordAdmin(adminUserName,passwordAdmin)!=null)
		{
			ModelAndView mc=new ModelAndView();
			mc.addObject("company",new Company());
			List<Company>list=companyservice.findAll();
			modell.addAttribute("list",list);
			mc.setViewName("ManageCompany");
			return mc; 
		}
		else
		{
			ModelAndView mc=new ModelAndView();
			model.addAttribute("admin",new Admin());
			model.addAttribute("msg","Invalid Login Credentials");
			mc.setViewName("AdminLogin");
			return mc;
		}
		
	}
	
}
