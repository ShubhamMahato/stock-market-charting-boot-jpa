package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AdminDao;
import com.example.demo.entity.Admin;

@Service
public class AdminService 
{
	@Autowired
	public AdminDao admindao;
	
	public Admin findByAdminUserNameAndPasswordAdmin(String adminUserName,String passwordAdmin) {
		return admindao.findByAdminUserNameAndPasswordAdmin(adminUserName, passwordAdmin);
	}
}
