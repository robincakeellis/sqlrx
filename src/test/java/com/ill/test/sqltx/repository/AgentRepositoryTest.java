package com.ill.test.sqltx.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AgentRepositoryTest {

    @Autowired
    private AgentRepository repo;

    @Test
    void checkCount() {
        final long count = repo.count().block();
        assertEquals(10871L, count);
    }

    @Test
    void checkCorpFedNavy() {
        final long count = repo.findAllByCorporationId(1000120).collectList().block().size();
        assertEquals(144, count);
    }

    @Test
    void checkLocation() {
        final long count = repo.findAllByLocationId(60008368).collectList().block().size();
        assertEquals(18, count);
    }

}
