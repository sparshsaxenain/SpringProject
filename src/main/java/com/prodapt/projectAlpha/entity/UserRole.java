package com.prodapt.projectAlpha.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Component
@Entity
public class UserRole {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long roleId;
	private String role;
	public UserRole(Long roleId, String role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}
	public UserRole() {
		super();
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserRole [roleId=" + roleId + ", role=" + role + "]";
	}
	
}
