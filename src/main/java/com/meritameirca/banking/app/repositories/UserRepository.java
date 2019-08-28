package com.meritameirca.banking.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.meritameirca.banking.app.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();
}
