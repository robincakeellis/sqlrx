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
    void test() {
        final long count = repo.count().block();
        assertEquals(10871L, count);
    }

}
