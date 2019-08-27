package com.meritamerica.banking.app.repositories;
import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meritamerica.banking.app.models.AddressType;
@Repository
public interface AddressTypeRepository extends CrudRepository<AddressType, Long> {

}
