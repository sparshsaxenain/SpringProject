package com.prodapt.projectAlpha.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodapt.projectAlpha.dao.RoleRepository;
import com.prodapt.projectAlpha.entity.UserRole;
@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private RoleRepository roleRepo;
	@Override
	public UserRole addUserRole(UserRole userRole) {
		// TODO Auto-generated method stub
		return roleRepo.save(userRole);
	}

	@Override
	public UserRole getUserRoleById(Long id) {
		// TODO Auto-generated method stub
		Optional<UserRole> roles = roleRepo.findById(id);
		if (roles.isPresent()) {
			return roles.get();
		} else {
			return null;
		}
	}

	@Override
	public UserRole updateUserRole(UserRole userRole) {
		// TODO Auto-generated method stub
		if (roleRepo.existsById(userRole.getRoleId())) {
			return roleRepo.save(userRole);
		} else {
			return null;
		}
	}

	@Override
	public void deleteUserRoleById(Long id) {
		// TODO Auto-generated method stub
		roleRepo.deleteById(id);
	}

}
