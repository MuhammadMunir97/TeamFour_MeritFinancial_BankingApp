package com.meritamerica.banking.app.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meritamerica.banking.app.models.TransactionType;
@Repository
public interface TransactionTypeRepository extends CrudRepository<TransactionType, Long> {

}
