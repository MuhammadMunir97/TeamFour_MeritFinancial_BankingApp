package com.meritameirca.banking.app.repositories;
import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meritameirca.banking.app.models.AddressType;
import com.meritameirca.banking.app.models.UserAddress;
@Repository
public interface AddressTypeRepository extends CrudRepository<AddressType, Long> {
	public List<AddressType> findAll();
	public List<AddressType> findByUserAddressNotContains(UserAddress userAddress);
}
