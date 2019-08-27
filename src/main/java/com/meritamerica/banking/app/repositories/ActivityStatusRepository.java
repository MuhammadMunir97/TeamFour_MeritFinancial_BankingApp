package com.meritamerica.banking.app.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.meritamerica.banking.app.models.ActivityStatus;
public interface ActivityStatusRepository extends CrudRepository<ActivityStatus, Long>{

}
