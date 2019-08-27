package com.meritamerica.banking.app.repositories;
import java.util.List;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meritamerica.banking.app.models.AccountType;
@Repository
public interface AccountTypeRepository extends CrudRepository<AccountType, Long>{

}
