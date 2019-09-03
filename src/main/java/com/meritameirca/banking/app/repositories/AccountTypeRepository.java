package com.meritameirca.banking.app.repositories;
import java.util.List;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meritameirca.banking.app.models.AccountType;
@Repository
public interface AccountTypeRepository extends CrudRepository<AccountType, Long>{
	public List<AccountType> findAll();
}
