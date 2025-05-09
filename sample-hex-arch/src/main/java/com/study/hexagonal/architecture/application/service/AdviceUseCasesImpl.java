package com.study.hexagonal.architecture.application.service;

import com.study.hexagonal.architecture.application.port.in.usecase.AdviceUseCases;
import com.study.hexagonal.architecture.application.port.out.rest.AdviceApi;
import com.study.hexagonal.architecture.domain.service.AdviceDomainService;
import com.study.hexagonal.architecture.shared.dto.AdviceResponse;

public class AdviceUseCasesImpl implements AdviceUseCases {
    private final AdviceApi adviceApi;
    private final AdviceDomainService adviceDomainService;

    public AdviceUseCasesImpl(AdviceApi adviceApiPort, AdviceDomainService adviceDomainServicePort) {
        this.adviceApi = adviceApiPort;
        this.adviceDomainService = adviceDomainServicePort;
    }

    @Override
    public AdviceResponse importAdvice(Integer adviceId) {
        return importAdviceById(adviceId);
    }

    @Override
    public boolean validateRangeInterval(Integer adviceId) {
        return (0 < adviceId && adviceId < 225);
    }

    private AdviceResponse importAdviceById(Integer adviceId) {
        var adviceFromApi = adviceApi.getAdviceById(adviceId);
        adviceDomainService.persistAdvice(adviceFromApi);
        return new AdviceResponse(adviceFromApi.getSlip().getAdvice(), null);
    }
}
