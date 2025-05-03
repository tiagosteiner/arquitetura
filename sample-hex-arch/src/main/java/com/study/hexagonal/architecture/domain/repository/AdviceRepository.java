package com.study.hexagonal.architecture.domain.repository;

import com.study.hexagonal.architecture.domain.entity.Advice;

public interface AdviceRepository {
    Advice save(Advice advice);
}
