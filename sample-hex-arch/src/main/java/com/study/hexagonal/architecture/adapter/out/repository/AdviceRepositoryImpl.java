package com.study.hexagonal.architecture.adapter.out.repository;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

import com.study.hexagonal.architecture.domain.entity.Advice;
import com.study.hexagonal.architecture.domain.repository.AdviceRepository;
import com.study.hexagonal.architecture.shared.mapper.AdviceMapper;

@Component
@RequiredArgsConstructor
public class AdviceRepositoryImpl implements AdviceRepository {

    private final JpaAdviceRepository jpaAdviceRepository;
    private final AdviceMapper adviceMapper;

    @Override
    public Advice save(Advice advice) {
        var jpaEntity = adviceMapper.domainToJpa(advice);
        var savedAdvice = jpaAdviceRepository.save(jpaEntity);
        return adviceMapper.jpaToDomain(savedAdvice);
    }
}
