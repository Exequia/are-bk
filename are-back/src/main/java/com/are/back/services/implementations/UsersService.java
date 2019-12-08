package com.are.back.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.are.back.models.Users;
import com.are.back.repositories.IUsersRepo;
import com.are.back.services.interfaces.IUsersService;

@Service
public class UsersService implements IUsersService {

	@Autowired
	private IUsersRepo userRepo;

	@Override
	public List<Users> getAll() {
		return (List<Users>) userRepo.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepo.findByEmail(username);
		
		List<GrantedAuthority> rols = new ArrayList<GrantedAuthority>();
		rols.add(new SimpleGrantedAuthority("ADMIN"));
		
		UserDetails userDet = new User(user.getEmail(), user.getPassword(), rols);
		
		return userDet;
	}

}
