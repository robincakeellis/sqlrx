package com.ill.test.sqltx.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec;
import com.ill.test.sqltx.repository.AgentRow;
import com.ill.test.sqltx.service.AgentService;
import static org.mockito.Mockito.when;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@WebFluxTest(controllers = { AgentController.class })
class AgentControllerTest {

    private static final String AGENTS_URI = "http://localhost:8080/agents";
    private static final int EXPECTED_AGENT_ID = 101;

    @MockBean
    private AgentService mockAgentService;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void getAllAgents() {
        // GIVEN we have data
        final AgentRow a1 = new AgentRow();
        final AgentRow a2 = new AgentRow();
        when(mockAgentService.getAll()).thenReturn(Flux.just(a1, a2));

        // WHEN the endpoint is called
        final ResponseSpec response = webTestClient
                .get().uri(AGENTS_URI)
                .exchange();

        // THEN we get an OK response with list content
        checkAgentList(response, 2);
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
        final ResponseSpec response = webTestClient
                .get().uri(AGENTS_URI + "/ids")
                .exchange();

        // THEN we get an OK response with list content
        final Flux<Integer> flux = response
                .expectStatus().isOk()
                .returnResult(Integer.class)
                .getResponseBody();
        StepVerifier.create(flux.collectList())
                .expectNextMatches(list -> list.size() == 2)
                .verifyComplete();
    }

    @Test
    void getAgentsForCorp() {
        // GIVEN we have data
        final AgentRow a1 = new AgentRow();
        final AgentRow a2 = new AgentRow();
        when(mockAgentService.getForCorp(101)).thenReturn(Flux.just(a1, a2));

        // WHEN the endpoint is called
        final ResponseSpec response = webTestClient
                .get().uri(AGENTS_URI + "/corp/101")
                .exchange();

        // THEN we get an OK response with list content
        checkAgentList(response, 2);
    }

    @Test
    void getAgentsForLocation() {
        // GIVEN we have data
        final AgentRow a1 = new AgentRow();
        final AgentRow a2 = new AgentRow();
        when(mockAgentService.getForLocation(111)).thenReturn(Flux.just(a1, a2));

        // WHEN the endpoint is called
        final ResponseSpec response = webTestClient
                .get().uri(AGENTS_URI + "/location/111")
                .exchange();

        // THEN we get an OK response with list content
        checkAgentList(response, 2);
    }

    @Test
    void getSingleAgent() {
        // GIVEN we have data
        final AgentRow agentRow = new AgentRow();
        agentRow.setAgentId(EXPECTED_AGENT_ID);
        when(mockAgentService.getAgent(EXPECTED_AGENT_ID)).thenReturn(Mono.just(agentRow));

        // WHEN the endpoint is called
        final ResponseSpec response = webTestClient
                .get().uri(AGENTS_URI + "/" + EXPECTED_AGENT_ID)
                .exchange();

        // THEN we get the agent
        final Mono<AgentRow> mono = response
                .expectStatus().isOk()
                .returnResult(AgentRow.class)
                .getResponseBody()
                .single();
        StepVerifier.create(mono)
                .expectNextMatches(agent -> agent.getAgentId() == EXPECTED_AGENT_ID)
                .verifyComplete();
    }

    @Test
    void getUnknownAgent() {
        // GIVEN we have no data
        when(mockAgentService.getAgent(EXPECTED_AGENT_ID)).thenReturn(Mono.empty());

        // WHEN the endpoint is called
        final ResponseSpec response = webTestClient
                .get().uri(AGENTS_URI + "/" + EXPECTED_AGENT_ID)
                .exchange();

        // THEN we get a 404
        response.expectStatus().isNotFound();
    }

    private void checkAgentList(final ResponseSpec response, int expectedCount) {
        final Flux<AgentRow> flux = response
                .expectStatus().isOk()
                .returnResult(AgentRow.class)
                .getResponseBody();
        StepVerifier.create(flux.collectList())
                .expectNextMatches(list -> list.size() == expectedCount)
                .verifyComplete();
    }

}
