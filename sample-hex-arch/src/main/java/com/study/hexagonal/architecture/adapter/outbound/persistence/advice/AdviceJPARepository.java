package com.study.hexagonal.architecture.adapter.outbound.persistence.advice;

import com.study.hexagonal.architecture.domain.model.Advice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdviceJPARepository extends JpaRepository<Advice, Integer> {
}
