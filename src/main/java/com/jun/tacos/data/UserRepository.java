package com.jun.tacos.data;

import org.springframework.data.repository.CrudRepository;

import com.jun.tacos.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(String username);
}
