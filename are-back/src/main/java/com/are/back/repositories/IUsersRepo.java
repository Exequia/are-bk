package com.are.back.repositories;

import org.springframework.data.repository.CrudRepository;

import com.are.back.models.Users;

public interface IUsersRepo extends CrudRepository<Users, Integer>{

}
