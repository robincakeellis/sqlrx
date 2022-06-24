package com.ill.test.sqltx.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends CrudRepository<AgentRow, Integer> {

}
