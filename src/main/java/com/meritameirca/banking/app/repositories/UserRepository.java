package com.meritameirca.banking.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meritameirca.banking.app.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	public List<User> findAll();
	public User findByUserName(String userName);
}
