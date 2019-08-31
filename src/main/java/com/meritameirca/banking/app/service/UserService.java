package com.meritameirca.banking.app.service;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
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
	
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
	}
	
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
	
	public boolean authenticateUser(String userName, String password) {
        // first find the user by email
        User user = userRepository.findByUserName(userName);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
	
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}
}
