package com.ill.test.sqltx.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec;

import com.ill.test.sqltx.repository.AgentRow;
import com.ill.test.sqltx.service.AgentService;

import reactor.core.publisher.Flux;

@WebFluxTest(controllers = { AgentController.class })
class AgentControllerTest {

    @MockBean
    private AgentService mockAgentService;

    @Autowired
    private WebTestClient webClient;

    @Test
    void getAllAgents() {
        // GIVEN we have data
        final AgentRow a1 = new AgentRow();
        final AgentRow a2 = new AgentRow();
        when(mockAgentService.getAll()).thenReturn(Flux.just(a1, a2));

        // WHEN the endpoint is called
        final ResponseSpec response = webClient
                .get().uri("http://localhost:8080/agents")
                .exchange();

        // THEN we get an OK response with list content
        checkAgentList(response);
    }

    @Test
    void getAllAgentsIds() {
        // GIVEN we have data
        final AgentRow a1 = new AgentRow();
        a1.setAgentId(303);
        final AgentRow a2 = new AgentRow();
        a2.setAgentId(808);
        when(mockAgentService.getAll()).thenReturn(Flux.just(a1, a2));

        // WHEN the endpoint is called
        final ResponseSpec response = webClient
                .get().uri("http://localhost:8080/agents/ids")
                .exchange();

        // THEN we get an OK response with list content
        response
                .expectStatus().isOk()
                .expectBodyList(Integer.class);
    }

    @Test
    void getAgentsForCorp() {
        // GIVEN we have data
        final AgentRow a1 = new AgentRow();
        final AgentRow a2 = new AgentRow();
        when(mockAgentService.getForCorp(101)).thenReturn(Flux.just(a1, a2));

        // WHEN the endpoint is called
        final ResponseSpec response = webClient
                .get().uri("http://localhost:8080/agents/corp/101")
                .exchange();

        // THEN we get an OK response with list content
        checkAgentList(response);
    }

    @Test
    void getAgentsForLocation() {
        // GIVEN we have data
        final AgentRow a1 = new AgentRow();
        final AgentRow a2 = new AgentRow();
        when(mockAgentService.getForLocation(111)).thenReturn(Flux.just(a1, a2));

        // WHEN the endpoint is called
        final ResponseSpec response = webClient
                .get().uri("http://localhost:8080/agents/location/111")
                .exchange();

        // THEN we get an OK response with list content
        checkAgentList(response);
    }

    private void checkAgentList(final ResponseSpec response) {
        response
                .expectStatus().isOk()
                .expectBodyList(AgentRow.class);
    }

}
