package com.prodapt.projectAlpha.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodapt.projectAlpha.dao.UserDetailsRepository;
import com.prodapt.projectAlpha.entity.UserDetails;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserDetailsRepository userDetailsRepo;
	@Override
	public UserDetails addUser(UserDetails userDetails) {
		// TODO Auto-generated method stub
		return userDetailsRepo.save(userDetails);
	}

	@Override
	public UserDetails getUserById(Long id) {
		// TODO Auto-generated method stub
		Optional<UserDetails> userDetails = userDetailsRepo.findById(id);
		if(userDetails.isPresent()) {
			return userDetails.get();
		}
		return null;
	}

	@Override
	public UserDetails updateUser(UserDetails userDetails) {
		// TODO Auto-generated method stub
		if(userDetailsRepo.existsById(userDetails.getId())) {
			userDetailsRepo.save(userDetails);
		}
		return userDetails;
	}

	@Override
	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		userDetailsRepo.deleteById(id);
	}

}
