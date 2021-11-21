package com.are.users.services.interfaces;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.are.users.models.User;


public interface IUsersService extends UserDetailsService {

	/***
	 * Get a User by email
	 * @return
	 */
	User findByEmail(String email);

	List<GrantedAuthority> getUserRoles(int userId);
}
