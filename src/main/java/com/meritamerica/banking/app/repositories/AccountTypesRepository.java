package com.meritamerica.banking.app.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.meritamerica.banking.app.models.AccountTypes;
public interface AccountTypesRepository extends CrudRepository<AccountTypes, Long>{

}
