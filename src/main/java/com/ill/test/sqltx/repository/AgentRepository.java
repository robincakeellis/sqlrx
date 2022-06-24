package com.ill.test.sqltx.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

@Repository
public interface AgentRepository extends R2dbcRepository<AgentRow, Integer> {

    Flux<AgentRow> findAllByCorporationId(int corpId);

    Flux<AgentRow> findAllByLocationId(int locationId);

}
