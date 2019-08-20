package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Admin;
@Repository
public interface AdminDao extends JpaRepository<Admin,Integer> 
{
	public Admin findByAdminUserNameAndPasswordAdmin(String adminUserName,String passwordAdmin);
}
