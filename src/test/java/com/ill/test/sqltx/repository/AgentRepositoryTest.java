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
        // maybe ok to use
        // final long count = repo.count().block();
        // assertEquals(10871L, count);

        // definitely ok to use
        StepVerifier
                .create(repo.count())
                .expectNext(10871L)
                .expectComplete()
                .verify();
    }

    @Test
    void checkCount_list() {
        // maybe ok to use
        // final int count = repo.findAll().collectList().block().size();
        // assertEquals(10871, count);

        // definitely ok to use
        StepVerifier
                .create(repo.findAll().collectList())
                .expectNextMatches(list -> list.size() == 10871)
                .expectComplete()
                .verify();
    }

    @Test
    void checkCorpFedNavy() {
        // maybe ok to use
        // final long count = repo.findAllByCorporationId(1000120).collectList().block().size();
        // assertEquals(144, count);

        // definitely ok to use
        StepVerifier
                .create(repo.findAllByCorporationId(1000120).collectList())
                .expectNextMatches(list -> list.size() == 144)
                .expectComplete()
                .verify();
    }

    @Test
    void checkLocation() {
        // maybe ok to use
        // final long count = repo.findAllByLocationId(60008368).collectList().block().size();
        // assertEquals(18, count);

        // definitely ok to use
        StepVerifier
                .create(repo.findAllByLocationId(60008368).collectList())
                .expectNextMatches(list -> list.size() == 18)
                .expectComplete()
                .verify();
    }

}
