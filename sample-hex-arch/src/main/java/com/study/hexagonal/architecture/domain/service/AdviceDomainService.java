package com.study.hexagonal.architecture.domain.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.study.hexagonal.architecture.domain.model.Advice;
import com.study.hexagonal.architecture.domain.repository.AdviceRepositoryPort;
import com.study.hexagonal.architecture.shared.dto.AdviceDto;

@Service
@RequiredArgsConstructor
public class AdviceDomainService {
    private final AdviceRepositoryPort adviceRepositoryPort;

    public void persistAdvice(AdviceDto adviceDto) {
        var adviceEntity =
                Advice.builder()
                        .id(adviceDto.getSlip().getId())
                        .adviceText(adviceDto.getSlip().getAdvice())
                        .build();
        adviceRepositoryPort.save(adviceEntity);
    }
}
