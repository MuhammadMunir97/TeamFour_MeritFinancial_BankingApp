package com.meritamerica.banking.app.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meritamerica.banking.app.models.ActivityStatus;
@Repository
public interface ActivityStatusRepository extends CrudRepository<ActivityStatus, Long>{

}
