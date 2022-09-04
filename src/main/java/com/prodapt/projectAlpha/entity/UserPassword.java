package com.prodapt.projectAlpha.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class UserPassword {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String username;
	private String password;
	private boolean isActivated;
	@ManyToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "userId"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "roleId"))
	private Set<UserRole> roles;
	@OneToOne(cascade = CascadeType.ALL)
	private UserDetails userDetails;
	public UserPassword(Long userId, String username, String password, boolean isActivated, Set<UserRole> roles,
			UserDetails userDetails) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.isActivated = isActivated;
		this.roles = roles;
		this.userDetails = userDetails;
	}
	@Override
	public String toString() {
		return "UserPassword [userId=" + userId + ", username=" + username + ", password=" + password + ", isActivated="
				+ isActivated + ", roles=" + roles + ", userDetails=" + userDetails + "]";
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActivated() {
		return isActivated;
	}
	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}
	public Set<UserRole> getRoles() {
		return roles;
	}
	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public UserPassword() {
		super();
	}
	
	
}
