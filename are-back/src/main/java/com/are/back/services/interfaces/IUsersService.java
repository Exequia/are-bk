package com.are.back.services.interfaces;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.are.back.models.User;


public interface IUsersService extends UserDetailsService {

	/***
	 * Get a User by email
	 * @return
	 */
	User getByEmail(String email);

	List<GrantedAuthority> getUserRoles(int userId);

}
