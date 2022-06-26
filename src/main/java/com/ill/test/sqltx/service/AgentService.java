package com.ill.test.sqltx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ill.test.sqltx.repository.AgentRepository;
import com.ill.test.sqltx.repository.AgentRow;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AgentService {

    @Autowired
    private AgentRepository repo;

    public Flux<AgentRow> getAll() {
        return repo.findAll();
    }

    public Flux<AgentRow> getForCorp(int corpId) {
        return repo.findAllByCorporationId(corpId);
    }

    public Flux<AgentRow> getForLocation(int locationId) {
        return repo.findAllByLocationId(locationId);
    }

    public Mono<AgentRow> getAgent(int agentId) {
        return repo.findById(agentId);
    }

}
