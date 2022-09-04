package com.prodapt.projectAlpha.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prodapt.projectAlpha.entity.UserPassword;
@Repository
public interface UserRepository extends CrudRepository<UserPassword, Long> {
	UserPassword findByUsername(String username);
	
//	@Query("from UserPassword where UserPassword.userId = (Select MAX(UserPassword.userId) from UserPassword)")
//	List<UserPassword> getUserMaxId();
	
//	@Query("insert into UserRole values(?1 , 2)")
//	void setDefaultUser(Long id);
	
	
}
