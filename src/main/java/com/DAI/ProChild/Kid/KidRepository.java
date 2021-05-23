package com.DAI.ProChild.Kid;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface KidRepository extends JpaRepository<Kid, Integer> {
}
