package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;

@Service
public class UserServices 
{
	@Autowired
	private UserDao userdao;
	
	public User save(User user)
	{
		return userdao.save(user);
	}
	
	public User findByUserNameAndPassword(String userName,String password)
	{
		return userdao.findByUserNameAndPassword(userName, password);
	}
	public User findByUserNameOrEmailOrPhoneNumber(String userName,String email,String phoneNumber) {
		return userdao.findByUserNameOrEmailOrPhoneNumber(userName, email, phoneNumber);
	}
	public User findByConfirmationToken(String confirmationToken){
		return userdao.findByConfirmationToken(confirmationToken);
	}
	public User findByUserName(String userName)
	{
		return userdao.findByUserName(userName);
	}
}
