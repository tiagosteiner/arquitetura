package com.study.hexagonal.architecture.domain.service.impl;

import org.springframework.stereotype.Service;

import com.study.hexagonal.architecture.domain.repository.AdviceRepository;
import com.study.hexagonal.architecture.domain.service.AdviceDomainService;
import com.study.hexagonal.architecture.shared.dto.AdviceDto;
import com.study.hexagonal.architecture.shared.mapper.AdviceMapper;

@Service
public class AdviceDomainImplService implements AdviceDomainService {

    private final AdviceRepository adviceRepository;
    private final AdviceMapper adviceMapper;

    public AdviceDomainImplService(AdviceRepository adviceRepositoryPort, AdviceMapper adviceMapper) {
        this.adviceRepository = adviceRepositoryPort;
        this.adviceMapper = adviceMapper;
    }

    public void persistAdvice(AdviceDto adviceDto) {
        var adviceEntity = adviceMapper.dtoToEntity(adviceDto);
        adviceRepository.save(adviceEntity);
    }
}
