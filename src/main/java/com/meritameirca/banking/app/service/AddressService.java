package com.meritameirca.banking.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.meritameirca.banking.app.models.UserAddress;
import com.meritameirca.banking.app.repositories.UserAddressRepository;

@Service
public class AddressService {
	
	private final UserAddressRepository userAddressRepository;

	public AddressService(UserAddressRepository userAddressRepository) {
		this.userAddressRepository = userAddressRepository;
	}
	
	public List<UserAddress> findAll(){
		return userAddressRepository.findAll();
	}
	
	public List<UserAddress> findByUserId(Long id){
		return userAddressRepository.findByUserId(id);
	}
	
	public UserAddress findById(Long id) {
		Optional<UserAddress> userAddress = userAddressRepository.findById(id);
		if(userAddress.isPresent()) {
			return userAddress.get();
		}else {
			return null;
		}
	}
	
	public void saveAddress(UserAddress userAddress) {
		userAddressRepository.save(userAddress);
	}
	
	public void deleteAddressById(Long id) {
		userAddressRepository.deleteById(id);
	}
}
