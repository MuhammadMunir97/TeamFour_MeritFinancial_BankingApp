package com.meritameirca.banking.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meritameirca.banking.app.models.AddressType;
import com.meritameirca.banking.app.models.UserAddress;
import com.meritameirca.banking.app.repositories.AddressTypeRepository;

@Service
public class AddressTypeService {
	
	private final AddressTypeRepository addressTypeRepository;

	public AddressTypeService(AddressTypeRepository addressTypeRepository) {
		this.addressTypeRepository = addressTypeRepository;
	}
	
	public List<AddressType> findAllAddressTypes(){
		return addressTypeRepository.findAll();
	}
	
	public List<AddressType> findByAddressNotContains(UserAddress userAddress){
		return addressTypeRepository.findByUserAddressNotContains(userAddress);
	}
	
}
