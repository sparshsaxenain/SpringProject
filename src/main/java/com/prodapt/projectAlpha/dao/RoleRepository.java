package com.prodapt.projectAlpha.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prodapt.projectAlpha.entity.UserRole;
@Repository
public interface RoleRepository extends CrudRepository<UserRole, Long> {

}
