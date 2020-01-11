package com.are.users.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.are.users.models.User;
import com.are.users.repositories.IUsersRepo;
import com.are.users.services.interfaces.IUsersService;

@Service
public class UsersService implements IUsersService {

	@Autowired
	private IUsersRepo userRepo;

	@Override
	public User findByEmail(String email) {
		return this.userRepo.findByEmail(email);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(email);
		
		List<GrantedAuthority> rols = this.getUserRoles(user.getId());
		
		UserDetails userDet = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), rols);
		
		return userDet;
	}

	@Override
	public List<GrantedAuthority> getUserRoles(int userId){
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		return roles;
	}

}
