package com.study.hexagonal.architecture.application.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.study.hexagonal.architecture.application.port.outbound.rest.AdviceApiPort;
import com.study.hexagonal.architecture.domain.service.AdviceDomainService;
import com.study.hexagonal.architecture.shared.dto.AdviceErrorMessageDto;

@Service
@RequiredArgsConstructor
public class AdviceService {
    private final AdviceApiPort adviceApiPort;
    private final AdviceDomainService adviceDomainService;

    private static final String OUT_OF_RANGE_MESSAGE =
            "Valid values for adviceId must be between 1 and 224.";

    public ResponseEntity<Object> importAdvice(Integer adviceId) {
        if (validateRangeInterval(adviceId)) {
            return importAdviceById(adviceId);
        } else {
            return ResponseEntity.status(400).body(new AdviceErrorMessageDto(OUT_OF_RANGE_MESSAGE));
        }
    }

    private boolean validateRangeInterval(Integer adviceId) {
        return (0 < adviceId && adviceId < 225);
    }

    private ResponseEntity<Object> importAdviceById(Integer adviceId) {
        var adviceFromApi = adviceApiPort.getAdviceById(adviceId);
        adviceDomainService.persistAdvice(adviceFromApi);
        return ResponseEntity.status(201).body(adviceFromApi.getSlip());
    }
}
