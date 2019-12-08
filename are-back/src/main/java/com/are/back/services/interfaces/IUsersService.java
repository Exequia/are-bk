package com.are.back.services.interfaces;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.are.back.models.Users;

public interface IUsersService extends UserDetailsService {

	List<Users> getAll();

}
