package com.ill.test.sqltx.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ill.test.sqltx.repository.AgentRepository;
import com.ill.test.sqltx.repository.AgentRow;

@Service
public class AgentService {

    @Autowired
    private AgentRepository repo;

    public List<AgentRow> getAll() {
        final List<AgentRow> agents = new ArrayList<>(10900);
        repo.findAll().forEach(agents::add);
        return agents;
    }

}
