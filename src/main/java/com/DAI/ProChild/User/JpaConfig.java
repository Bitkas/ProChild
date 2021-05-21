package com.DAI.ProChild.User;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class JpaConfig {

    @PersistenceContext
    EntityManager entityManager;
}
