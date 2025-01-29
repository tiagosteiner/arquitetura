package com.study.hexagonal.architecture.adapter.outbound.persistence.advice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.hexagonal.architecture.domain.model.Advice;

@Repository
public interface AdviceJPARepository extends JpaRepository<Advice, Integer> {}
