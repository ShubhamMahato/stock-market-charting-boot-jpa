package com.example.demo.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.entity.User;
import com.example.demo.services.EmailService;
import com.example.demo.services.UserServices;

@Controller 
public class UserController {
	
	@Autowired
	
	private UserServices userService;

   
	@RequestMapping("/openUserLogin")
	public ModelAndView demo()
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("user",new User());
		mv.setViewName("UserLoginoreRegister");
		return mv;
		
	}
	
	
	
	
	@RequestMapping("/saveUser")
	public ModelAndView adduser(@Valid @ModelAttribute("user") User user,BindingResult result,HttpServletRequest request)
	{
		if(!result.hasErrors()) {
		if(!existingUser(user)) {
			user.setConfirmationToken(UUID.randomUUID().toString());
			String appUrl = request.getScheme() + "://" + request.getServerName()+":"+request.getLocalPort();
			userRegistrationEmail(user, appUrl);
			userService.save(user);
			return new ModelAndView("NewFile","message","Please confirm your email and login");
		}else {
			result.reject("email");
			return new ModelAndView("UserLoginoreRegister","message","User credentials already exist");
		}
		
	}
	return new ModelAndView("UserLoginoreRegister","message","Enter valid credentials");
	 
}
	
	
	
	@RequestMapping(value="userlogin", method = RequestMethod.GET)
	public ModelAndView loginAuth(Model model,@RequestParam("userName") String userName, @RequestParam("password") String password,Model  modell) 
	{  
		User user = userService.findByUserNameAndPassword(userName, password);
		if(user!=null&&user.isConfirmed())
		{
			ModelAndView mc=new ModelAndView();
			
			mc.setViewName("NewFile");
			return mc; 
		}
		else
		{
			ModelAndView mc=new ModelAndView();
			modell.addAttribute("line","Username and Password are incorrect");
			mc.addObject("user",new User());
			mc.setViewName("UserLoginoreRegister");
			
			return mc;
		}
		
	}
	
	 public Boolean existingUser(User user) {
		if(userService.findByUserNameAndEmailAndPhoneNumber(user.getUserName(), user.getEmail(), user.getPhoneNumber())!=null)
				return true;
		else
			return false;
	 }
	 
	 public void userRegistrationEmail(User userData,String appUrl) {
		 SimpleMailMessage registrationEmail = new SimpleMailMessage();
		 registrationEmail.setTo(userData.getEmail());
		 registrationEmail.setSubject("Confirm your email for Stock Market Charting");
		 registrationEmail.setText("To confirm your email please click the link below\n"+appUrl + "/confirm?token=" + userData.getConfirmationToken());
		 registrationEmail.setFrom("noreply@smc.com");
		 EmailService.sendEmail(registrationEmail);
	 }
	 
	 @RequestMapping("/confirm")
	 public ModelAndView confirmEmail(@RequestParam("token") String token) {
		 User userData = userService.findByConfirmationToken(token);
		 if(userData==null) {
			 return new ModelAndView("NewFile","message","Don't play with us");
		 }
		 userData.setConfirmed(true);
		 userService.save(userData);
		 return new ModelAndView("NewFile","message","Email is confirmed! Login");
	 }
	
	
}

