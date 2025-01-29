package com.study.hexagonal.architecture.adapter.outbound.persistence.advice;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

import com.study.hexagonal.architecture.domain.model.Advice;
import com.study.hexagonal.architecture.domain.repository.AdviceRepositoryPort;

@Component
@RequiredArgsConstructor
public class AdviceRepositoryAdapter implements AdviceRepositoryPort {

    private final AdviceJPARepository adviceJPARepository;

    @Override
    public Advice save(Advice advice) {
        return adviceJPARepository.save(advice);
    }
}
