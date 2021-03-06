package com.ill.test.sqltx.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.test.StepVerifier;

@SpringBootTest
class AgentRepositoryTest {

    @Autowired
    private AgentRepository repo;

    @Test
    void checkCount_direct() {
        StepVerifier
                .create(repo.count())
                .expectNext(10871L)
                .verifyComplete();
    }

    @Test
    void checkCount_list() {
        StepVerifier
                .create(repo.findAll().collectList())
                .expectNextMatches(list -> list.size() == 10871)
                .verifyComplete();
    }

    @Test
    void checkCorpFedNavy() {
        StepVerifier
                .create(repo.findAllByCorporationId(1000120).collectList())
                .expectNextMatches(list -> list.size() == 144)
                .verifyComplete();
    }

    @Test
    void checkLocation() {
        StepVerifier
                .create(repo.findAllByLocationId(60008368).collectList())
                .expectNextMatches(list -> list.size() == 18)
                .verifyComplete();
    }

    @Test
    void checkSingleAgent() {
        StepVerifier
                .create(repo.findById(3015958))
                .expectNextMatches(agent -> agent.getCorporationId() == 1000148 && agent.getLevel() == 4)
                .verifyComplete();
    }

}
