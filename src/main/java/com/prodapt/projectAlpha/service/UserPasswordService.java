package com.prodapt.projectAlpha.service;

import java.util.List;

import com.prodapt.projectAlpha.entity.UserPassword;
import com.prodapt.projectAlpha.exceptions.InvalidCredentialException;

public interface UserPasswordService {
	
	public List<UserPassword> getAllUsers();
	
	public UserPassword addUserPassword(UserPassword userPassword);
	//Retrieve
	public UserPassword getUserPasswordById(Long id);
	public UserPassword getUserPasswordByName(String userName);
	
	//Update
	public UserPassword updateUserPassword(UserPassword userPassword);
	
	//Delete
	public void deleteUserPasswordById(Long id);
	
	public String getUserRole(UserPassword user);
	
	public UserPassword loginUser(UserPassword user) throws InvalidCredentialException;
	
	public boolean userActive(UserPassword user);
}
