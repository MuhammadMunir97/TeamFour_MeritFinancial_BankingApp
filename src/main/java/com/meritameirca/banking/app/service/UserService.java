package com.meritameirca.banking.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.meritameirca.banking.app.models.User;
import com.meritameirca.banking.app.repositories.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}
	
	public User findUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}else {
			return null;
		}
	}
	
	public User loginUserThroughUserNameAndPass(String userName , String password) {
		Optional<User> user = userRepository.findByUserNameAndPassword(userName, password);
		if(user.isPresent()) {
			return user.get();
		}else {
			return null;
		}
	}
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}
}
