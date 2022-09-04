package com.prodapt.projectAlpha.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodapt.projectAlpha.dao.UserRepository;
import com.prodapt.projectAlpha.entity.UserPassword;
import com.prodapt.projectAlpha.entity.UserRole;
import com.prodapt.projectAlpha.exceptions.InvalidCredentialException;
@Service
public class UserPasswordServiceImpl implements UserPasswordService {

	@Autowired
	private UserRepository userRepo;
	@Override
	public UserPassword addUserPassword(UserPassword userPassword) {
		// TODO Auto-generated method stub
//		List<UserPassword> id = userRepo.getUserMaxId();
//		userRepo.setDefaultUser(id);
		
		List<UserPassword> users = getAllUsers();
		int listlen = users.size();
		UserPassword up = users.get(listlen-1);
//		Long id = up.getUserId();
		Set<UserRole> userroles = new HashSet<UserRole>();
		UserRole ur = new UserRole();
		ur.setRole("USER");
		userroles.add(ur);
		userPassword.setRoles(userroles);
		return userRepo.save(userPassword);
	}

	@Override
	public UserPassword getUserPasswordById(Long id) {
		// TODO Auto-generated method stub
		Optional<UserPassword> passwords = userRepo.findById(id);
		if (passwords.isPresent()) {
			return passwords.get();
		} else {
			return null;
		}
	}
//getUserDetails().getEmail()
	@Override
	public UserPassword updateUserPassword(UserPassword userPassword) {
		// TODO Auto-generated method stub
			UserPassword filluser = userRepo.findById(userPassword.getUserId()).get();
			if(Objects.nonNull(userPassword.getUsername()) && !"".equalsIgnoreCase(userPassword.getUsername()))
			{
				filluser.setUsername(userPassword.getUsername());
			}
			if(Objects.nonNull(userPassword.getPassword()) && !"".equalsIgnoreCase(userPassword.getPassword()))
			{
				filluser.setPassword(userPassword.getPassword());
			}
			if(Objects.nonNull(userPassword.getUserDetails().getName()) && !"".equalsIgnoreCase(userPassword.getUserDetails().getName()))
			{
				filluser.getUserDetails().setName(userPassword.getUserDetails().getName());;
			}
			if(Objects.nonNull(userPassword.getUserDetails().getEmail()) && !"".equalsIgnoreCase(userPassword.getUserDetails().getEmail()))
			{
				filluser.getUserDetails().setEmail(userPassword.getUserDetails().getEmail());;
			}
			return userRepo.save(filluser);
	}

	@Override
	public void deleteUserPasswordById(Long id) {
		// TODO Auto-generated method stub
		userRepo.deleteById(id);
	}

	@Override
	public UserPassword getUserPasswordByName(String username) {
		// TODO Auto-generated method stub
		return userRepo.findByUsername(username);
	}

	@Override
	public UserPassword loginUser(UserPassword user) throws InvalidCredentialException {
		// TODO Auto-generated method stub
		UserPassword usr = userRepo.findByUsername(user.getUsername());
		if(usr!=null)
		{
			if(usr.getPassword().equals(user.getPassword()))
			{
				return usr;
			}
			else
			{
				throw new InvalidCredentialException();
			}
		}
		else
		{
			throw new InvalidCredentialException();
		}
	}
	
	public String getUserRole(UserPassword user)
	{
		Iterator<UserRole> role = user.getRoles().iterator();
		while(role.hasNext())
		{
			UserRole ur = role.next();
			if(ur.getRole().equals("ADMIN"))
			{
				return "ADMIN";
			}
		}
		return "USER";
	}

	@Override
	public List<UserPassword> getAllUsers() {
		// TODO Auto-generated method stub
		Iterable<UserPassword> result = userRepo.findAll();
		List<UserPassword> users = new ArrayList<UserPassword>();
		
		for(UserPassword usr : result)
		{
			users.add(usr);
		}
		return users;
	}
}
