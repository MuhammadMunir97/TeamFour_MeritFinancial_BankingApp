package com.meritamerica.banking.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.meritamerica.banking.app.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();
}
