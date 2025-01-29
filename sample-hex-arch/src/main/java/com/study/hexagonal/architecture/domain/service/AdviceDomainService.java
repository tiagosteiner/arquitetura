package com.study.hexagonal.architecture.domain.service;

import com.study.hexagonal.architecture.shared.dto.AdviceDto;

public interface AdviceDomainService {
    void persistAdvice(AdviceDto adviceDto);
}
