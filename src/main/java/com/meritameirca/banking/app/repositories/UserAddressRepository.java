package com.meritameirca.banking.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meritameirca.banking.app.models.UserAddress;
@Repository
public interface UserAddressRepository extends CrudRepository<UserAddress, Long> {
	
	public List<UserAddress> findAll();
	public List<UserAddress> findByUserId(Long id);
}
