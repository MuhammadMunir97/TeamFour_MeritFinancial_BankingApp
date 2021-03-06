package com.meritameirca.banking.app.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meritameirca.banking.app.models.AccountInternal;
import com.meritameirca.banking.app.models.AccountType;
import com.meritameirca.banking.app.models.User;
@Repository
public interface AccountInternalRepository extends CrudRepository<AccountInternal, Long>{
	public List<AccountInternal> findByUser(User user);
	public List<AccountInternal> findByUserAndAccountType(User user, AccountType accountType);
	public AccountInternal findTopByOrderByIdDesc();
	public Optional<AccountInternal> findByAccountNumber(Long accountNumber);
	public List<AccountInternal> findByUserAndAccountTypeId(User user, Long id);
}
