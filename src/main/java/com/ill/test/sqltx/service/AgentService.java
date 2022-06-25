package com.ill.test.sqltx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ill.test.sqltx.repository.AgentRepository;
import com.ill.test.sqltx.repository.AgentRow;

import reactor.core.publisher.Flux;

@Service
public class AgentService {

    @Autowired
    private AgentRepository repo;

    public Flux<AgentRow> getAll() {
        return repo.findAll();
    }

    public Flux<AgentRow> getForCorp(int id) {
        return repo.findAllByCorporationId(id);
    }

    public Flux<AgentRow> getForLocation(int id) {
        return repo.findAllByLocationId(id);
    }

}
