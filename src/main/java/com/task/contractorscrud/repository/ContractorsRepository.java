package com.task.contractorscrud.repository;

import org.springframework.data.repository.CrudRepository;
import com.task.contractorscrud.model.Contractor;  

public interface ContractorsRepository extends CrudRepository<Contractor, Integer> {

}
