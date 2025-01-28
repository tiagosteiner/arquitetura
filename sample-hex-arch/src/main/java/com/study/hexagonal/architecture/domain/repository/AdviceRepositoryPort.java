package com.study.hexagonal.architecture.domain.repository;

import com.study.hexagonal.architecture.domain.model.Advice;

public interface AdviceRepositoryPort {
    Advice save(Advice advice);
}
