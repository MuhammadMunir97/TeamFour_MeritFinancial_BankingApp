package com.meritameirca.banking.app.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meritameirca.banking.app.models.TransactionLog;
@Repository
public interface TransactionLogRepository extends CrudRepository<TransactionLog, Long> {
	//public List<TransactionLog> findByAccountInternalId(Long id);
}
