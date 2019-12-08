package com.are.back.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

}
