package com.ill.test.sqltx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ill.test.sqltx.repository.AgentRow;
import com.ill.test.sqltx.service.AgentService;

@Controller
public class AgentController {

    @Autowired
    private AgentService service;

    @GetMapping("/agents")
    public ResponseEntity<String> getAll() {
        final List<AgentRow> agents = service.getAll();
        final StringBuilder sb = new StringBuilder();
        agents.forEach(a -> sb.append(a.getAgentId()).append('\n'));
        return new ResponseEntity<>(sb.toString(), HttpStatus.OK);
    }

}
