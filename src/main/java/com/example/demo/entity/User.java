package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@javax.persistence.Table(name="user")
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private int userId;
	
	@NotBlank
	@NotNull
	@Column(unique = true,name="user_name")
	private String userName;
	
	@NotBlank
	@NotNull
	@Column(name="password")
	private String password;
	
	@NotBlank
	@NotNull
	@Column(name="user_type")
	private String userType="user";
	
	
	@Email
	@Column(unique=true,name="email")
	private String email;
	
	@Pattern(regexp="(^$|[0-9]{10})")
	@Column(unique=true,name="phone_number")
	private String phoneNumber;
	
	

@	Column(columnDefinition="tinyint(1) default 1")
	private boolean confirmed=false;
	
	@Column(name="cofirmaationToken")
	private String confirmationToken;
	
	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	public User()
	{
		this.confirmed=false;
		this.userType="USER";
	}
	


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	

}