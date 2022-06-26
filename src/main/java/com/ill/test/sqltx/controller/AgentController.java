package com.ill.test.sqltx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ill.test.sqltx.repository.AgentRow;
import com.ill.test.sqltx.service.AgentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/agents")
public class AgentController {

    @Autowired
    private AgentService service;

    @GetMapping("")
    public Flux<AgentRow> getAll() {
        return service.getAll();
    }

    @GetMapping("/ids")
    public Flux<Integer> getAllIds() {
        return service.getAll().map(AgentRow::getAgentId);
    }

    @GetMapping("/corp/{corpId}")
    public Flux<AgentRow> getForCorp(@PathVariable int corpId) {
        return service.getForCorp(corpId);
    }

    @GetMapping("/location/{locationId}")
    public Flux<AgentRow> getForLocation(@PathVariable int locationId) {
        return service.getForLocation(locationId);
    }

    @GetMapping("/{agentId}")
    public Mono<AgentRow> getAgent(@PathVariable int agentId) {
        return service.getAgent(agentId);
    }

}
