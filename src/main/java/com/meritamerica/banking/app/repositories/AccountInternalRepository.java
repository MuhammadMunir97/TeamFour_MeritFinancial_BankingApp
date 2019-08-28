package com.meritamerica.banking.app.repositories;
import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meritamerica.banking.app.models.AccountInternal;
@Repository
public interface AccountInternalRepository extends CrudRepository<AccountInternal, Long>{

}