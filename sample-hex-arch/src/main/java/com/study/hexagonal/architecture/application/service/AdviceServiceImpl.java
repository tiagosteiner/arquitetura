package com.study.hexagonal.architecture.application.service;

import org.springframework.stereotype.Service;

import com.study.hexagonal.architecture.application.port.out.rest.AdviceApi;
import com.study.hexagonal.architecture.application.usecase.AdviceUseCases;
import com.study.hexagonal.architecture.domain.service.AdviceDomainService;
import com.study.hexagonal.architecture.shared.dto.AdviceResponse;

@Service
public class AdviceServiceImpl implements AdviceUseCases {
    private final AdviceApi adviceApi;
    private final AdviceDomainService adviceDomainService;

    public AdviceServiceImpl(AdviceApi adviceApi, AdviceDomainService adviceDomainService) {
        this.adviceApi = adviceApi;
        this.adviceDomainService = adviceDomainService;
    }

    public AdviceResponse importAdvice(Integer adviceId) {
        return importAdviceById(adviceId);
    }

    public boolean validateRangeInterval(Integer adviceId) {
        return (0 < adviceId && adviceId < 225);
    }

    private AdviceResponse importAdviceById(Integer adviceId) {
        var adviceFromApi = adviceApi.getAdviceById(adviceId);
        adviceDomainService.persistAdvice(adviceFromApi);
        return new AdviceResponse(adviceFromApi.getSlip().getAdvice(), null);
    }
}
