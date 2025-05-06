package com.study.hexagonal.architecture.domain.service.impl;

import org.springframework.stereotype.Service;

import com.study.hexagonal.architecture.domain.entity.Advice;
import com.study.hexagonal.architecture.domain.repository.AdviceRepository;
import com.study.hexagonal.architecture.domain.service.AdviceDomainService;
import com.study.hexagonal.architecture.shared.dto.AdviceDto;

@Service
public class AdviceDomainImplService implements AdviceDomainService {

    private final AdviceRepository adviceRepository;

    public AdviceDomainImplService(AdviceRepository adviceRepositoryPort) {
        this.adviceRepository = adviceRepositoryPort;
    }

    public void persistAdvice(AdviceDto adviceDto) {
        var adviceEntity = new Advice(adviceDto.getSlip().getId(), adviceDto.getSlip().getAdvice());
        adviceRepository.save(adviceEntity);
    }
}
