package com.meritamerica.banking.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.meritamerica.banking.app.models.Users;

public interface UsersRepository extends CrudRepository<Users, Long> {
	List<Users> findAll();
}
