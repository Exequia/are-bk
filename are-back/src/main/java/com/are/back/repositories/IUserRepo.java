package com.are.back.repositories;

import org.springframework.data.repository.CrudRepository;

import com.are.back.models.Users;

public interface IUserRepo extends CrudRepository<Users, Integer>{

}
