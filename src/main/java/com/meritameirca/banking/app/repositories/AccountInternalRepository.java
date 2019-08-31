package com.meritameirca.banking.app.repositories;
import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meritameirca.banking.app.models.AccountInternal;
import com.meritameirca.banking.app.models.AccountType;
import com.meritameirca.banking.app.models.User;
@Repository
public interface AccountInternalRepository extends CrudRepository<AccountInternal, Long>{
	public List<AccountInternal> findByUser(User user);
	public List<AccountInternal> findByUserAndAccountType(User user, AccountType accountType);
}
