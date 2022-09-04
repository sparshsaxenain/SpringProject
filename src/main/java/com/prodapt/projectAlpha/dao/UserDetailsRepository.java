package com.prodapt.projectAlpha.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prodapt.projectAlpha.entity.UserDetails;
@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails, Long> {

}
