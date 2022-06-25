package com.ill.test.sqltx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ill.test.sqltx.repository.AgentRow;
import com.ill.test.sqltx.service.AgentService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/agents")
public class AgentController {

    @Autowired
    private AgentService service;

    @GetMapping("")
    @ResponseBody
    public Flux<AgentRow> getAll() {
        return service.getAll();
    }

    @GetMapping("/ids")
    @ResponseBody
    public Flux<String> getAllIds() {
        return service.getAll().map(agent -> String.valueOf(agent.getAgentId()) + '\n');
    }

    @GetMapping("/corp/{id}")
    @ResponseBody
    public Flux<AgentRow> getForCorp(@PathVariable int id) {
        return service.getForCorp(id);
    }

    @GetMapping("/location/{id}")
    @ResponseBody
    public Flux<AgentRow> getForLocation(@PathVariable int id) {
        return service.getForLocation(id);
    }

}
