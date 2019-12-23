package com.are.back.repositories;

import org.springframework.data.repository.CrudRepository;

import com.are.back.models.User;

public interface IUsersRepo extends CrudRepository<User, Integer>{

	User findByEmail(String email);

}
