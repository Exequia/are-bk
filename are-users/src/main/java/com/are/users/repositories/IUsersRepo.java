package com.are.users.repositories;

import org.springframework.data.repository.CrudRepository;

import com.are.users.models.User;

public interface IUsersRepo extends CrudRepository<User, Integer>{

	User findByEmail(String email);

}
