package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;
@Repository
public interface UserDao extends JpaRepository<User, Integer>
{
	public User findByUserNameAndPassword(String userName,String password);
	public User findByUserNameOrEmailOrPhoneNumber(String userName,String email,String phoneNumber);
	public User findByConfirmationToken(String confirmationToken);
	public User findByUserName(String userName);
	
}
