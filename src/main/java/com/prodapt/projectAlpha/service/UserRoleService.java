package com.prodapt.projectAlpha.service;

import com.prodapt.projectAlpha.entity.UserRole;

public interface UserRoleService {
	//Create
		public UserRole addUserRole(UserRole userRole);
		//Retrieve
		public UserRole getUserRoleById(Long id);
		
		//Update
		public UserRole updateUserRole(UserRole userRole);
		
		//Delete
		public void deleteUserRoleById(Long id);
}
