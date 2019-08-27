package com.meritamerica.banking.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meritamerica.banking.app.models.UserAddress;
@Repository
public interface UserAddressRepository extends CrudRepository<UserAddress, Long> {

}
