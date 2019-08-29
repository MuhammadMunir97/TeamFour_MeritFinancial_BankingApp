package com.meritameirca.banking.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.meritameirca.banking.app.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	public List<User> findAll();
	public Optional<User> findByUserNameAndPassword(String userName, String password);
}
