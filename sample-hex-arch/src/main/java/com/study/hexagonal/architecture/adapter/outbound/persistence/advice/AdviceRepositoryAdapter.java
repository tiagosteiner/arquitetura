package com.study.hexagonal.architecture.adapter.outbound.persistence.advice;

import com.study.hexagonal.architecture.domain.model.Advice;
import com.study.hexagonal.architecture.domain.repository.AdviceRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdviceRepositoryAdapter implements AdviceRepositoryPort {

    private final AdviceJPARepository adviceJPARepository;

    @Override
    public Advice save(Advice advice) {
        return adviceJPARepository.save(advice);
    }
}
