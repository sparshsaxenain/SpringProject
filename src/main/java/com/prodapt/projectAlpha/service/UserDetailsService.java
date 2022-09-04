package com.prodapt.projectAlpha.service;

import com.prodapt.projectAlpha.entity.UserDetails;

public interface UserDetailsService {
	public UserDetails addUser(UserDetails userDetails);
	//Retrieve
	public UserDetails getUserById(Long id);
	
	//Update
	public UserDetails updateUser(UserDetails userDetails);
	
	//Delete
	public void deleteUserById(Long id);
}
