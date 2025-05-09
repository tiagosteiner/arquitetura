package com.study.hexagonal.architecture.domain.service.impl;

import com.study.hexagonal.architecture.domain.repository.AdviceRepository;
import com.study.hexagonal.architecture.domain.service.AdviceDomainService;
import com.study.hexagonal.architecture.shared.dto.AdviceDto;
import com.study.hexagonal.architecture.shared.mapper.AdviceMapper;

public class AdviceDomainImplService implements AdviceDomainService {

    private final AdviceRepository adviceRepository;
    private final AdviceMapper adviceMapper;

    public AdviceDomainImplService(
            AdviceRepository adviceRepositoryPort, AdviceMapper adviceMapperPort) {
        this.adviceRepository = adviceRepositoryPort;
        this.adviceMapper = adviceMapperPort;
    }

    public void persistAdvice(AdviceDto adviceDto) {
        var adviceEntity = adviceMapper.dtoToEntity(adviceDto);
        adviceRepository.save(adviceEntity);
    }
}
