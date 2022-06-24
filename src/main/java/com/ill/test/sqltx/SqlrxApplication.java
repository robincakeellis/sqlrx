package com.ill.test.sqltx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SqlrxApplication {

    public static void main(String[] args) {
        SpringApplication.run(SqlrxApplication.class, args);
    }

}
